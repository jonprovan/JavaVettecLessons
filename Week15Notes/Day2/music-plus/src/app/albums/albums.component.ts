import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Album } from '../models/album';
import { Artist } from '../models/artist';
// this imports the elements we need for reactive forms
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent {

  // creating a place to hold our downloaded album data
  localAlbums: any = [];

  // injecting our backend service
  // also injecting the FormBuilder for our reactive form group
  constructor(private backendService: BackendService,
              private fb: FormBuilder) {

    this.getAllAlbums();

  }

  // creating a form group for our reactive form

  addForm = this.fb.group(
    {
      title: ['', Validators.compose([Validators.required,
                                      Validators.minLength(1),
                                      Validators.maxLength(60)])],
      artist: [''],
      genre: ['', Validators.compose([Validators.required,
                                      Validators.minLength(2),
                                      Validators.maxLength(45)])],
      label: ['', Validators.compose([Validators.required,
                                      Validators.minLength(1),
                                      Validators.maxLength(45)])],
      trackCount: ['', Validators.compose([Validators.required,
                                           Validators.min(1),
                                           Validators.max(50)])],
      imageUrl: ['', Validators.compose([Validators.required,
                                         Validators.minLength(1),
                                         Validators.maxLength(500)])],
    }
  );

  get title() {
    return this.addForm.get('title');
  }

  get genre() {
    return this.addForm.get('genre');
  }
  get label() {
    return this.addForm.get('label');
  }

  get trackCount() {
    return this.addForm.get('trackCount');
  }

  get imageUrl() {
    return this.addForm.get('imageUrl');
  }


  getAllAlbums(): void {
    this.localAlbums = [];
    this.backendService.getAllAlbums().subscribe(data => {
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
                                        album.trackCount,
                                        album.imageUrl));
      }

      // to see what we're actually storing in our local array
      console.log(this.localAlbums);

    });
  }

  // to delete an individual album
  // supposed to refresh the page with the updated list
  // TODO: debug the refresh
  deleteAlbum(album: Album): void {
    this.backendService.deleteAlbumInBody(album).subscribe(() => this.getAllAlbums());
  }
    
  
}
