import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { User } from '../models/user';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8090/'
  constructor(private http: HttpClient) { }

  login(username, password): Observable<User> {
    // Make credentials
    const credentials = this.generateBasicAuthCredentials(username, password);
    // Send credentials as Authorization header (this is spring security convention for basic auth)
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    // create request to authenticate credentials
    return this.http
      .get<User>(this.baseUrl + 'authenticate', httpOptions)
      .pipe(
        tap((res) => {
          localStorage.setItem('credentials' , credentials);
          localStorage.setItem('username', username);
          return res;
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError('AuthService.login(): Error logging in.');
        })
      );
  }
  register(user): Observable<User> {
    // create request to register a new account
    return this.http.post<User>(this.baseUrl + 'register', user)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AuthService.register(): error registering user.');
      })
    );
  }
  logout(): void {
    // localStorage.removeItem('credentials');
    console.log("logging out");

    localStorage.clear();
  }
  checkLogin(): boolean {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }
  generateBasicAuthCredentials(username, password): string {
    return btoa(`${username}:${password}`);
  }
  getCredentials(): string {
    return localStorage.getItem('credentials');
  }

  checkIfCurrentUser(username: string): boolean {

    return username === localStorage.getItem('username');
  }
  getCurrentUserId(): number {

    const id = parseInt(localStorage.getItem('id'));
    return id;
  }
}
