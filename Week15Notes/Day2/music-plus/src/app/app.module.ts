import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// this imports functionality for making HTTP requests
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavComponent } from './nav/nav.component';
import { AlbumsComponent } from './albums/albums.component';
import { AlbumComponent } from './album/album.component';
import { ArtistsComponent } from './artists/artists.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    AlbumsComponent,
    AlbumComponent,
    ArtistsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // must include it here also
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
