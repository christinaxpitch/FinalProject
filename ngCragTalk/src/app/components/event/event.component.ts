import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Event } from 'src/app/models/event';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {
  selected: Event = null;
  newEvent: Event = new Event();
  editEvent: Event = null;
  events: Event[] = [];
  display = true;


  constructor(private eventService: EventService,
    private currentRoute: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe) { }

  ngOnInit(): void {
      const idStr = this.currentRoute.snapshot.paramMap.get('eventId');
      if(idStr){
        const id: number = Number.parseInt(idStr);
        if(!isNaN(id)){
          this.eventService.show(id).subscribe(
            (event) => {
              this.selected = event;
              this.reload();
            },
            (fail) =>{
              this.router.navigateByUrl('**');
            }
            );
          }
          else {
            this.router.navigateByUrl('**');
          }
        }
        else {
          this.reload();
        }
      }
      reload(): void{
        this.eventService.index().subscribe(
          data => {
            this.events = data;
          },
          fail => {
            console.error("TodoListComponent.reload(): error getting events");
            console.error(fail);
          }
          );
        }
        displayEvent(event: Event): void{
          this.display = false;
          this.selected = event;
        }
        displayTable(): void{
          this.display = true;
          this.selected = null;
          this.router.navigateByUrl('event');
    }

  setEditEvent(){
    this.editEvent = Object.assign({}, this.selected);
  }
  }
