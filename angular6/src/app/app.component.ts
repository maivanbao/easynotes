import { Component } from '@angular/core';
import { RouterModule, Routes, RouterLink } from '@angular/router';
import * as constants from './constants';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';
  // constructor(public routerLink:RouterLink){}
}
