import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { AuthService } from './auth.service';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EventService {
baseUrl='http://localhost:8090/'
private url = this.baseUrl + 'api/event';
constructor(private http: HttpClient, private authService: AuthService) { }

getHttpOptions(){
const credentials=this.authService.getCredentials();

const httpOptions= {
  headers: new HttpHeaders({
    Authorization: `Basic ${credentials}`,
    'X-Requested-With':'XMLHttpRequest'})
  };
  return httpOptions;
}

index(): Observable<Event[]> {
  const httpOptions=this.getHttpOptions();

  return this.http.get<Event[]>(this.url, httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('EventService.index(): Error retrieving todo list');
    })
  );
}


}
