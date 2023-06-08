import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.css']
})
export class ArtistsComponent {

  // to store a local copy of the DB information
  localArtists: any = [];

  chosenArtistId: number = 0;
  formName: string = '';
  formType: string = '';
  formFounded: string = '';

  canDelete: boolean = false;

  constructor(private backendService: BackendService) {
    this.getAllArtists();
  }

  // this includes error handling for unsuccessful requests
  getAllArtists(): void {
    this.localArtists = [];
    this.backendService.getAllArtists().subscribe(
        // these are observer arguments
        // they dictate different responses based on success/failure
      {  
        // success MUST use next
        // value is a lambda for what to do with the data
        next: data => {

          for (let artist of data.body) {
            this.localArtists.push(new Artist(artist.artistId,
                                              artist.name,
                                              artist.type,
                                              artist.founded));
          }
        },

        // failure MUST use error
        // value is a lambda for what to do with the error data 
        error: errData => {
          console.log(errData)
        },

        // for void-return transactions like delete
        // you MUST use complete to generate a response
        // since no data will return to fill the next
        // also executes after the successful response
        // NOT after the error
        complete: () => console.log('Complete! All artists returned.')
      
      }
    
    );
  }

  // this calls to the service to add a new artist to the database
  addNewArtist(): void {
    this.backendService
        .addNewArtist(new Artist(0, this.formName, this.formType, Number(this.formFounded)))
        .subscribe(() => this.getAllArtists());
    this.clearForm();
  }

  updateArtist(): void {
    this.backendService.updateArtist(new Artist(this.chosenArtistId, 
                                                this.formName,
                                                this.formType,
                                                Number(this.formFounded)))
                       .subscribe(() => this.getAllArtists());

    this.clearForm();
  }

  // deletes an individual artist when we click the delete button
  deleteArtist(): void {
    // set a temp artist value
    // by filtering our local array for the one whose ID matches
    const artistToDelete: Artist = 
        this.localArtists.filter((artist: Artist) => {
          return artist.artistId === this.chosenArtistId;
        } )[0];

    // call the service to delete the one we selected
    this.backendService.deleteArtistInBody(artistToDelete)
        .subscribe(() => this.getAllArtists());

    this.clearForm();
  }

  // function when we click on a row to select an artist
  // this also disables the delete button
  // for any artist who has an associated album
  chooseArtist(artist: Artist): void {
    this.backendService.getAllAlbums().subscribe(data => {
      for (let album of data.body) {
        if (album.artist.artistId === artist.artistId) {
          this.canDelete = false;
          break;
        } else {
          this.canDelete = true;
        }
      }
    });


    this.chosenArtistId = artist.artistId;
    this.formName = artist.name;
    this.formType = artist.type;
    this.formFounded = String(artist.founded);
  }

  clearForm(): void {
    this.chosenArtistId = 0;
    this.formName = '';
    this.formType = '';
    this.formFounded = '';
  }

}
