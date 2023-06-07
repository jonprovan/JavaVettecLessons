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

  tempVariable: number = 1;

  constructor(private backendService: BackendService) {
    backendService.getAllArtists().subscribe(data => {
      console.log(data.body);

      for (let artist of data.body) {
        this.localArtists.push(new Artist(artist.artistId,
                                          artist.name,
                                          artist.type,
                                          artist.founded));
      }

      console.log(this.localArtists);

    });
  }

}
