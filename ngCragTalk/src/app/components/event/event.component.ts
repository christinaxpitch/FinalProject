import { ClimbingArea } from './../../models/climbing-area';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from './../../services/user.service';
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Event } from 'src/app/models/event';
import { User } from 'src/app/models/user';
import { EventService } from 'src/app/services/event.service';
import { CommonModule } from '@angular/common';
import { ClimbingAreaService } from 'src/app/services/climbing-area.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css'],
})
export class EventComponent implements OnInit {
  selected: Event = null;
  newEvent: Event = new Event();
  editEvent: Event = null;
  events: Event[] = [];
  displayTable = true;
  showAddForm = false;
  showAuthorizedStuff = false;
  loggedInUserIsEventCreator = false;
  user: User = null;
  pageTitle: string = 'Come Climb with Us!';
  climbingAreas: ClimbingArea [];
  climbingAreaId: number;

  constructor(
    private eventService: EventService,
    private currentRoute: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe,
    private userSvc: UserService,
    private authSvc: AuthService,
    private climbAreaSrv: ClimbingAreaService
  ) {}

  ngOnInit(): void {
    const idStr = this.currentRoute.snapshot.paramMap.get('eventId');
    if (idStr) {
      const id: number = Number.parseInt(idStr);
      if (!isNaN(id)) {
        this.eventService.show(id).subscribe(
          (event) => {
            this.selected = event;
            this.reload();
          },
          (fail) => {
            this.router.navigateByUrl('**');
          }
        );
      } else {
        this.router.navigateByUrl('**');
      }
    } else {
      this.reload();
    }
  }
  reload(): void {
    this.eventService.index().subscribe(
      (data) => {
        if (this.authSvc.checkLogin()) {
          this.showAuthorizedStuff = true;
        }
        this.events = data;
      },
      (fail) => {
        console.error('EventComponent.reload(): error getting events');
        console.error(fail);
      }
    );
  }
  displayEvent(event: Event): void {
    if (this.authSvc.checkLogin()) {
      if (this.authSvc.getCurrentUserId() == event.createdBy.id) {
        this.loggedInUserIsEventCreator = true;
      }
      this.displayTable = false;
      this.selected = event;
    } else {
      this.router.navigateByUrl('login');
    }
  }
  showTable(): void {
    this.displayTable = true;
    this.selected = null;
    this.loggedInUserIsEventCreator = false;
    this.router.navigateByUrl('event');
  }

  setEditEvent() {
    this.editEvent = Object.assign({}, this.selected);
  }
  updateEvent(event) {
    this.eventService.update(event).subscribe(
      (data) => {
        this.selected = data;
        this.editEvent = null;
        this.reload();
      },
      (fail) => {
        console.error('EventComponent.updateEvent(): error updating event');
        console.error(fail);
      }
    );
  }
  showProfile(createdById: number) {
    this.userSvc.show(createdById);
    this.router.navigateByUrl('user/' + createdById);
  }
  showAddEventForm() {
    this.showAuthorizedStuff = false;
    this.climbAreaSrv.index().subscribe(
      (climbAreas) => {
        this.climbingAreas = climbAreas;
        this.displayTable = false;
        this.selected = null;
        this.showAddForm = true;
      },
      (error) =>{
        console.error('EventComponent.showAddEventForm().climbAreaSvc.index(): error getting climbing areas');
        console.error(error);
      }
      );
  }
  addEvent(): void {
    this.eventService.create(this.newEvent, this.climbingAreaId).subscribe(
      (newdata) => {
        this.newEvent = new Event();
        this.displayTable = true;
        this.selected = null;
        this.showAddForm = false;
        this.reload();
      },
      (fail) => {
        console.error('EventComponent.addEvent(): error adding event');
        console.error(fail);
      }
    );
  }
  deleteEvent(eventId: number): void {
    this.eventService.destroy(eventId).subscribe(
      (deleteData) => {
          this.selected = null;
          this.displayTable = true;
          this.reload();
      },
      (err) =>{
        console.error('EventComponent.deleteEvent(): error deleting event');
        console.error(err);
      }
    )
  }
}
