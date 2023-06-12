// to create a service, use -- ng g service <serviceName>

// a service in Angular is any centralized functionality you need
// here, we're using it for all our backend calls
// BUT, you can also use one to hold centrally-required data

import { Injectable } from '@angular/core';
// must import HTTP functionality here in the service
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, subscribeOn } from 'rxjs';
// importing the environment object for use here
import { environment } from 'src/environments/environment';
import { Album } from '../models/album';
import { Artist } from '../models/artist';

// the @Injectable decorator enables this to be injected wherever
// we need it, much like the beans in Spring Boot with @Autowired
@Injectable({
  providedIn: 'root'
})
export class BackendService {
  // this doesn't work to update values in dependent components
  // because it doesn't let those components know
  // it has changed value
  // user: string = "Genevieve McDaniels";

  // this creates a BehaviorSubject of type string with an initial value in the ()
  // this has the ability to take on a new state
  // and indicate that it has done so
  private rawUser = new BehaviorSubject<string>('Genevieve McDaniels');

  // this turns the above into an observable to which we can subscribe
  user = this.rawUser.asObservable();

  // this method changes the state of the BehaviorSubject
  // which causes its Observable to update subscribers with the new value
  changeName(name: string): void {
    this.rawUser.next(name);
  }

  // taking the URL out of the environment and putting it into a variable
  url: string = environment.backendURL;

  // this injects the HttpClient functionality wherever we need it
  constructor(private http: HttpClient) { }


  // ALBUM METHODS

  // this function makes a get request for all albums
  // it returns an Observable of the HttpResponse
  // an Observable is a watchable object
  // anything "subscribing" to the Observable will update its view
  // if anything inside the object changes
  getAllAlbums(): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url + 'album',
                              { observe: 'response' });
    // takes two params: the URL of the endpoint
    //                   what portion of the response we want to observe
  }

  // deleting an album using its ID
  deleteAlbumById(album: Album): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.url}album/${album.albumId}`, 
                                 { observe: 'response' });
  }

  // deleting an album in the request body
  deleteAlbumInBody(album: Album): Observable<HttpResponse<any>> {
    return this.http.delete<any>(this.url + 'album', 
                                 { observe: 'response', body: album });
  }

  // getting a single album via id
  // GET to http://localhost:8080/album/id is the endpoint
  getAlbumById(albumId: number): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url + 'album/' + albumId,
                              { observe: 'response' });
  }

  // posting a new album
  addAlbumInBody(album: Album): Observable<HttpResponse<any>> {
    return this.http.post<any>(this.url + 'album', album, { observe: 'response' });
  }

  updateAlbumWithParams(album: Album): Observable<HttpResponse<any>> {

    // creating an object to hold our HTTP request parameters
    let parameters = new HttpParams().set('title', album.title)
                                     .set('artist', album.artist.artistId)
                                     .set('genre', album.genre)
                                     .set('label', album.label)
                                     .set('trackCount', album.trackCount)
                                     .set('imageUrl', album.imageUrl);

    return this.http.put<any>(this.url + 'album/' + album.albumId, {}, { observe: 'response',
                                                                  params: parameters });
  }




  // ARTIST METHODS

  // getting all artists from the DB
  getAllArtists(): Observable<any> {
    return this.http.get<any>(this.url + 'artist',
                              { observe: 'response' });
  }

  // adding an artist
  addNewArtist(artist: Artist): Observable<HttpResponse<any>> {
    // three args = URL, body, options
    return this.http.post<any>(this.url + 'artist', artist, { observe: 'response' });
  }

  // deleting an artist in the request body
  deleteArtistInBody(artist: Artist): Observable<HttpResponse<any>> {
    return this.http.delete<any>(this.url + 'artist', 
                                 { observe: 'response', body: artist });
  }

  // updating an artist
  updateArtist(artist: Artist): Observable<HttpResponse<any>> {
    // three args = URL, body, options
    return this.http.put<any>(this.url + 'artist', artist, { observe: 'response' });
  }

}