import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EventService {
baseUrl='http://localhost:8090/'
private url = this.baseUrl + 'api/user';
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


}
