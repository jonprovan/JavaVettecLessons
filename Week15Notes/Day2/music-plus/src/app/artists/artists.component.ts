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

  formName: string = '';
  formType: string = '';
  formFounded: string = '';

  constructor(private backendService: BackendService) {
    this.getAllArtists();
  }

  getAllArtists(): void {
    this.localArtists = [];
    this.backendService.getAllArtists().subscribe(data => {
      for (let artist of data.body) {
        this.localArtists.push(new Artist(artist.artistId,
                                          artist.name,
                                          artist.type,
                                          artist.founded));
      }
    });
  }

  // this calls to the service to add a new artist to the database
  addNewArtist(): void {
    this.backendService
        .addNewArtist(new Artist(0, this.formName, this.formType, Number(this.formFounded)))
        .subscribe(() => this.getAllArtists());
  }

}
