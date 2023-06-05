import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent {

  heroes: any = [
    {
      heroName: 'Deadpool',
      power: 'Regeneration',
      suitColor: '#ff0000'
    },
    {
      heroName: 'Batman',
      power: 'Intelligence',
      suitColor: '#000000'
    },
    {
      heroName: 'Anthony\'s Mom',
      power: 'TLC',
      suitColor: '#25a4c4'
    },
    {
      heroName: 'Ms. Marvel',
      power: 'Stretchiness',
      suitColor: '#8a2be2'
    },
    {
      heroName: 'Nick The Pizza Guy',
      power: 'Ovening',
      suitColor: '#d42323'
    },
    {
      heroName: 'Stephen Sondheim',
      power: 'Lyrics',
      suitColor: '#9a9292'
    }

  ]

}
