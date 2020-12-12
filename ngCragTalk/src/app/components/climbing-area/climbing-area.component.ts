import { EventComponent } from './../event/event.component';
import { ClimbType } from './../../models/climb-type';
import { Event } from './../../models/event';
import { ClimbingAreaService } from './../../services/climbing-area.service';
import { ClimbingArea } from './../../models/climbing-area';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { EventService } from 'src/app/services/event.service';
import { User } from 'src/app/models/user';



@Component({
  selector: 'app-climbing-area',
  templateUrl: './climbing-area.component.html',
  styleUrls: ['./climbing-area.component.css']

})
export class ClimbingAreaComponent implements OnInit {

  @Output() clickedEvent = new EventEmitter<Event>();

  climbingAreas: ClimbingArea[] = [];
  climbType: ClimbType[]=[];

  constructor(private datePipe: DatePipe,
    private eventService: EventService,
    private climbAreaService: ClimbingAreaService,
    private route: ActivatedRoute,
    private auth: AuthService,
    private router: Router)  { }

    eventRoute(event: Event): void{
      if(this.auth.checkLogin()){
        this.router.navigateByUrl('event/'
        +event.id
        );

      }
      else {
        this.router.navigateByUrl('login');
      }
    }


    userRoute(user: User): void{
      if(this.auth.checkLogin()){
        this.router.navigateByUrl('user/');


      }
      else {
        this.router.navigateByUrl('login');
      }
    }

    loadClimbEvents(): void{
      this.climbAreaService.index().subscribe(
        data=>{this.climbingAreas=data;
          console.log(data);

          console.log('Home.components loadClimbingArea(): retrieve succeeded');},
        err=>{
          console.error('Home.components loadClimbingArea(): retrieve failed');
          console.error(err);
        });
    }
  ngOnInit(): void {
    this.loadClimbEvents();
    console.log("in init");

  }

}
