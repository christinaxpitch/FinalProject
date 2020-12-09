import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  recentClimbs: Event[] = [];
  groupClimbs=null;
  constructor(private eventService: EventService) { }



  ngOnInit(): void {
  }

}
