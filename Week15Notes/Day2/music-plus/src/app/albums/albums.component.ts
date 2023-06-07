import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Album } from '../models/album';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent {

  // creating a place to hold our downloaded album data
  localAlbums: any = [];

  constructor(private backendService: BackendService) {

    backendService.getAllAlbums().subscribe(data => {
      // to see what we're getting back
      // data.body contains the array of items we're looking for
      console.log(data.body);

      // enhanced for loop to access each item
      // for each iteration, we create a new Album with those props
      // we also need to create artist objects
      for (let album of data.body) {
        this.localAlbums.push(new Album(album.albumId,
                                        album.title,
                                        new Artist(album.artist.artistId,
                                                   album.artist.name,
                                                   album.artist.type,
                                                   album.artist.founded),
                                        album.genre,
                                        album.label,
                                        album.trackCount));
      }

      // to see what we're actually storing in our local array
      console.log(this.localAlbums);

    });

  }

  getAllAlbums() {
    this.localAlbums = [];
    this.backendService.getAllAlbums().subscribe(data => {
      for (let album of data.body) {
        this.localAlbums.push(new Album(album.albumId,
                                        album.title,
                                        new Artist(album.artist.artistId,
                                                   album.artist.name,
                                                   album.artist.type,
                                                   album.artist.founded),
                                        album.genre,
                                        album.label,
                                        album.trackCount));
      }
    });
  }

  // to delete an individual album
  // supposed to refresh the page with the updated list
  // TODO: debug the refresh
  deleteAlbum(album: Album): void {
    this.backendService.deleteAlbumById(album).subscribe();
    this.getAllAlbums();
  }
    
  
}
