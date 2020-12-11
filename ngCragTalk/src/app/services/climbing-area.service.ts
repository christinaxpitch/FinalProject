import { ClimbingArea } from './../models/climbing-area';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Media } from '../models/media';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ClimbingAreaService {
  constructor(private http: HttpClient, private auth: AuthService) { }
  private  baseUrl = 'http://localhost:8090/';
  private url = this.baseUrl + 'api/climbingAreas';

  getHttpOptions(): object{
    // Get credentials
const credentials = this.auth.getCredentials();
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

  index(): Observable<ClimbingArea[]> {
    const httpOptions=this.getHttpOptions();

    return this.http.get<ClimbingArea[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ClimbingAreaService.index(): Error retrieving ClimbingArea list');
      })
    );
  }
}
