// to create a service, use -- ng g service <serviceName>

// a service in Angular is any centralized functionality you need
// here, we're using it for all our backend calls
// BUT, you can also use one to hold centrally-required data

import { Injectable } from '@angular/core';
// must import HTTP functionality here in the service
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, ObservedValueOf } from 'rxjs';
import { Album } from '../models/album';
import { Artist } from '../models/artist';

// the @Injectable decorator enables this to be injected wherever
// we need it, much like the beans in Spring Boot with @Autowired
@Injectable({
  providedIn: 'root'
})
export class BackendService {

  // this injects the HttpClient functionality wherever we need it
  constructor(private http: HttpClient) { }

  // this function makes a get request for all albums
  // it returns an Observable of the HttpResponse
  // an Observable is a watchable object
  // anything "subscribing" to the Observable will update its view
  // if anything inside the object changes
  getAllAlbums(): Observable<HttpResponse<any>> {
    return this.http.get<any>('http://localhost:8080/album',
                              { observe: 'response' });
    // takes two params: the URL of the endpoint
    //                   what portion of the response we want to observe
  }

  // getting all artists from the DB
  getAllArtists(): Observable<HttpResponse<any>> {
    return this.http.get<any>('http://localhost:8080/artist',
                              { observe: 'response' });
  }

  // deleting an album using its ID
  deleteAlbumById(album: Album): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`http://localhost:8080/album/${album.albumId}`, 
                                 { observe: 'response' });
  }

  // deleting an album in the request body
  deleteAlbumInBody(album: Album): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`http://localhost:8080/album/`, 
                                 { observe: 'response', body: album });
  }

  // adding an artist
  addNewArtist(artist: Artist): Observable<HttpResponse<any>> {
    // three args = URL, body, options
    // TODO: figure out why the Artist object must be deconstructed
    console.log(artist);
    return this.http.post<any>('http://localhost:8080/artist', artist, { observe: 'response' });
  }

}