import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// additional components for routes must be imported here
import { HomeComponent } from './home/home.component';
import { TargetComponent } from './target/target.component';
import { HeroesComponent } from './heroes/heroes.component';

// this is an array of objects
// each object corresponds to a routing path
// each object contains two properties: path (url extension)
//                                      component (what component to load)
const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'target',
    component: TargetComponent
  },
  {
    path: 'heroes',
    component: HeroesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
