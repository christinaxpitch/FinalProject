import { Message } from 'src/app/models/message';
import { Gear } from './../models/gear';
import { UserClimbType } from 'src/app/models/user-climb-type';
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

  constructor(private http: HttpClient, private auth: AuthService) { }
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

  index(): Observable<User[]> {
    const httpOptions=this.getHttpOptions();

    return this.http.get<User[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.index(): Error retrieving todo list');
      })
    );
  }

  update(id: number, user: User) {
    const httpOptions = this.getHttpOptions();
    return this.http.put<User>(this.url + '/' + id, user, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  updateGear(id: number, gear: Gear) {
    const httpOptions = this.getHttpOptions();
    return this.http.put<Gear>(this.baseUrl + 'api/gear' + '/' + id, gear, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('service failed to update gearList');
      })
    );
  }

  updateUserClimbType(id: number, climb: UserClimbType) {
    const httpOptions = this.getHttpOptions();
    return this.http.put<UserClimbType>('userClimbType' + '/' + id, climb, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  disableUser(id: number, user: User) {
    const httpOptions = this.getHttpOptions();
    return this.http.put<User>(this.url + '/' + id, user, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );

  }

  createMessage(message: Message, receiverId: number) {
    const httpOptions = this.getHttpOptions();
    console.log(message);
    return this.http.post<Message>(this.baseUrl + 'api/user/message' + '/' + receiverId, message, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  addUserToFavorites(user: User, isFavorited: boolean) {
    const httpOptions = this.getHttpOptions();
    return this.http.put<User>(this.url + '/' + user.id + '/' + isFavorited, user, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );


  }


}
