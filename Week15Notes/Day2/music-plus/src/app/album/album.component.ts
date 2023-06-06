// need to add Input here to accept data from a parent component
import { Component, Input } from '@angular/core';
import { Album } from '../models/album';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent {

  // use the @Input decorator to set up the input type
  // syntax = @Input() variableName: variableType = initialValue;
  @Input() album: Album = new Album(0, '', new Artist(0, '', '', 0), '', '', 0);

}
