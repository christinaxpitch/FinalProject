import { UserService } from './../../services/user.service';
import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event';
import { User } from 'src/app/models/user';
import {IvyCarouselModule} from 'angular-responsive-carousel';
import { Media } from 'src/app/models/media';
import { IndexService } from 'src/app/services/index.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  recentClimbs: Event[] = [];
  groupClimbs: Event[]=[];
  userClimbers: User[] = [];
  media: Media[] = [];
  constructor(private eventService: EventService, private userService: UserService, private indexService: IndexService) { }

  ngOnInit(): void {
    this.loadRecentClimbEvents();
    this.loadUsers();
    this.loadGroupClimbEvents();
    this.loadMedia();
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

  loadMedia(): void{
    this.indexService.index().subscribe(
      data=>{this.media=data;
        console.log(this.media);

        console.log('Home.components loadMedia(): retrieve succeeded');},
      err=>{
        console.error('Home.components loadMedia(): retrieve failed');
        console.error(err);
      });
  }

}
