import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { DatePipe } from '@angular/common';
import { environment } from './../../environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private datePipe: DatePipe, private auth: AuthService) { }
  private  baseUrl = 'http://localhost:8090/';
  private url = this.baseUrl + 'api/user';


  getHttpOptions() {
    const credentials = this.auth.getCredentials();
    const httpOptions = {
     headers: new HttpHeaders({ Authorization: `Basic ${credentials}`,
     'X-Requested-With': 'XMLHttpRequest'
    })
    };
    return httpOptions;
  }


  show(userId: number): Observable <User> {
    const httpOptions = this.getHttpOptions();
    return this.http.get<User>(this.url +'/' + userId, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.show(): Error retrieving user profile ' + userId);
      })
    );
  }


}
