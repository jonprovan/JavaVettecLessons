import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Album } from '../models/album';
import { Artist } from '../models/artist';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent {

  // this will hold the album we get via ID, so we can display it
  localAlbum: Album = new Album(0, '', new Artist(0, '', '', 0), '', '', 0, '');

  // injecting our backend service
  constructor(private backendService: BackendService,
              private activatedRoute: ActivatedRoute) {

    // getting a single album via ID and storing it in localAlbum
    this.backendService.getAlbumById(this.activatedRoute.snapshot.params['id']).subscribe(data => {
      this.localAlbum = new Album(data.body.albumId,
                                  data.body.title,
                                  new Artist(data.body.artist.artistId,
                                             data.body.artist.name,
                                             data.body.artist.type,
                                             data.body.artist.founded),
                                  data.body.genre,
                                  data.body.label,
                                  data.body.trackCount,
                                  data.body.imageUrl);
    })

  }

}
