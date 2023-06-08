// need to add Input here to accept data from a parent component
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Album } from '../models/album';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent {

  // this creates an EventEmitter
  // it can be called whatever you want
  // the type is whatever data you want to pass to the parent
  // the @Output() decorator indicates we're sending this upward
  @Output() deleteAlbumEvent = new EventEmitter<Album>();

  // use the @Input decorator to set up the input type
  // syntax = @Input() variableName: variableType = initialValue;
  @Input() album: Album = new Album(0, '', new Artist(0, '', '', 0), '', '', 0, '');

  deleteAlbum(): void {
    this.deleteAlbumEvent.emit(this.album);
  }

}
