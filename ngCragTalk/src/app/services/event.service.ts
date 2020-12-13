import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Event } from 'src/app/models/event';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  //when we change the environment to production: comment out baseUrl and change this.baseUrl to environment.baseUrl
  private baseUrl = 'http://localhost:8090/';
  private url = this.baseUrl + 'api/event';

  constructor(private http: HttpClient, private authSvc: AuthService, private datePipe: DatePipe) { }

  index(): Observable<Event []>{
    const httpOptions = this.getHttpOptions();
    return this.http.get<Event []>(this.url, httpOptions)
    .pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError('Event list not found.')
      })
    );
  }

  show(eventId: Number): Observable<Event>{
    const httpOptions = this.getHttpOptions();
     return this.http.get<Event>(`${this.url}/${eventId}`, httpOptions)
     .pipe(
       catchError((err:any)=>{
         console.log(err);
         return throwError('EventService,show(): Error retrieving event' + eventId)
       })
       );
   }
   create(event: Event, id: number): Observable<Event>{
     let httpOptions = this.getHttpOptions();
    return this.http.post<Event>(this.url + "/" + id, event, httpOptions).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('EventService.create(): Error creating event.')
      })
    );
  }
  update(event: Event): Observable<Event>{
    const httpOptions = this.getHttpOptions();
    return this.http.put<Event>(`${this.url}/${event.id}`, event, httpOptions).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError('EventService.update(): Error updating event.')
      })
      );
    }

    destroy(id: Number): Observable<boolean>{
      const httpOptions = this.getHttpOptions();
      return this.http.delete<boolean>(`${this.url}/${id}`, httpOptions).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('EventService.destory(): Error deleting event.');
        })
        );
      }

  getHttpOptions(): object{
    // Get credentials
const credentials = this.authSvc.getCredentials();
// Send credentials as Authorization header (this is spring security convention for basic auth)
let httpOptions;
if (credentials){
httpOptions = {
headers: new HttpHeaders({
Authorization: `Basic ${credentials}`,
'X-Requested-With': 'XMLHttpRequest'
})
};}
else{
  httpOptions = {
    headers: new HttpHeaders({
    'X-Requested-With': 'XMLHttpRequest'
    })
    };
}

return httpOptions;
}
}
