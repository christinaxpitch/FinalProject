import { UserService } from './../../services/user.service';
import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from './../../models/event';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  recentClimbs: Event[] = [];
  groupClimbs: Event[]=[];
  userClimbers: User[] = [];
  constructor(private eventService: EventService, private userService: UserService) { }



  ngOnInit(): void {
  }

}
