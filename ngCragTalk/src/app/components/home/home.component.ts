import { UserService } from './../../services/user.service';
import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event';
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
    this.loadRecentClimbEvents();
    this.loadUsers();
    this.loadGroupClimbEvents();
  }
  loadUsers(): void{
    this.userService.index().subscribe(
      data=>{this.userClimbers=data;
        console.log('Home.components loadUsers(): retrieve succeeded');},
      err=>{
        console.error('Home.components loadUsers(): retrieve failed');
        console.error(err);
      });
  }

  loadRecentClimbEvents(): void{
    this.eventService.index().subscribe(
      data=>{this.recentClimbs=data;
        console.log('Home.components loadEvent(): retrieve succeeded');},
      err=>{
        console.error('Home.components loadEvent(): retrieve failed');
        console.error(err);
      });
  }

  loadGroupClimbEvents(): void{
    this.eventService.index().subscribe(
      data=>{this.groupClimbs=data;
        console.log('Home.components loadEvent(): retrieve succeeded');},
      err=>{
        console.error('Home.components loadEvent(): retrieve failed');
        console.error(err);
      });
  }

}
