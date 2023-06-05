// these are imports like in Java
// any external resources we need must be imported here
import { Component } from '@angular/core';

// this is a decorator
// it designates what sort of object this file is
@Component({
  // what name we use to place our component into an HTML page
  selector: 'app-root',
  // where is the HTML for this component?
  templateUrl: './app.component.html',
  // where is the stylesheet for this component?
  // can also add extra ones, if you like
  styleUrls: ['./app.component.css']
})

// here's the name of the component
// we export it so it's available elsewhere
export class AppComponent {
  title = 'angular-project';
}
