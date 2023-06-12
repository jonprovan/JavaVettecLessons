import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  localUser: string = '';

  constructor(private backendService: BackendService) {

    this.backendService.user.subscribe(data => {
      this.localUser = data;
    })

  }

  // don't need this anymore, since we're subscribing to the value
  // user = this.backendService.user;

  fieldName: string = '';

  changeName() {  
    this.backendService.changeName(this.fieldName);
  }

}
