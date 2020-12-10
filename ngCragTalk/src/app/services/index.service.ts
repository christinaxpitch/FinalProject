import { Media } from './../models/media';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ClimbType } from '../models/climb-type';
@Injectable({
  providedIn: 'root'
})
export class IndexService {

  constructor(private http: HttpClient, private auth: AuthService) { }
  private  baseUrl = 'http://localhost:8090/';
  private url = this.baseUrl + 'api/media';

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

  index(): Observable<Media[]> {
    const httpOptions=this.getHttpOptions();

    return this.http.get<Media[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('MediaService.index(): Error retrieving Media list');
      })
    );
  }

  indexClimbType(): Observable<ClimbType[]> {
    const httpOptions=this.getHttpOptions();

    return this.http.get<ClimbType[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('MediaService.indexClimbType(): Error retrieving ClimbType list');
      })
    );
  }

}

