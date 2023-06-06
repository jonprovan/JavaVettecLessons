// to create a service, use -- ng g service <serviceName>

// a service in Angular is any centralized functionality you need
// here, we're using it for all our backend calls
// BUT, you can also use one to hold centrally-required data

import { Injectable } from '@angular/core';

// the @Injectable decorator enables this to be injected wherever
// we need it, much like the beans in Spring Boot with @Autowired
@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor() { }
}
