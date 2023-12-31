import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumsComponent } from './albums/albums.component';
import { ArtistsComponent } from './artists/artists.component';
import { AlbumDetailsComponent } from './album-details/album-details.component';

// to load different components into router-outlet
const routes: Routes = [
  {
    // what URL suffix will place this component in router-outlet
    // if you use an empty string for the path,
    // this route will load by default or when the user navigates
    // to the root URL
    path: '',
    // what component to load
    component: AlbumsComponent
  },
  {
    path: 'artists',
    component: ArtistsComponent
  },
  // {
  //   path: 'details',
  //   component: AlbumDetailsComponent
  // },
  {
    path: 'album/details/:id',
    component: AlbumDetailsComponent
  },
  // this is a default route that will load our AlbumsComponent if someone navigates
  // to a bogus URL at the root level
  {
    path: '**',
    component: AlbumsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
