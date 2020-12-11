import { AuthService } from './../../services/auth.service';
import { ClimbType } from './../../models/climb-type';
import { UserService } from './../../services/user.service';
import { EventService } from './../../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event';
import { User } from 'src/app/models/user';
import {IvyCarouselModule} from 'angular-responsive-carousel';
import { Media } from 'src/app/models/media';
import { IndexService } from 'src/app/services/index.service';
import { DatePipe } from '@angular/common';
import { UserClimbType } from 'src/app/models/user-climb-type';
import { ActivatedRoute, Router } from '@angular/router';


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

  constructor(private datePipe: DatePipe,
     private eventService: EventService,
     private userService: UserService,
     private indexService: IndexService,
     private route: ActivatedRoute,
     private auth: AuthService,
     private router: Router)  { }

  ngOnInit(): void {
    this.loadRecentClimbEvents();
    this.loadGroupClimbEvents();
    this.loadMedia();
  }

  eventClick() {
    console.log(this.auth.checkLogin());
    console.log(this.auth.getCredentials());

    if(this.auth.checkLogin()){
      this.router.navigateByUrl('event');
    }
    else{
      this.router.navigateByUrl('login');}
  };


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
