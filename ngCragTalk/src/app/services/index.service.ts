import { Media } from './../models/media';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class IndexService {

  constructor(private http: HttpClient, private auth: AuthService) { }
  private  baseUrl = 'http://localhost:8090/';
  private url = this.baseUrl + 'api/media';

  getHttpOptions() {
    const credentials = this.auth.getCredentials();
    const httpOptions = {
     headers: new HttpHeaders({ Authorization: `Basic ${credentials}`,
     'X-Requested-With': 'XMLHttpRequest'
    })
    };
    return httpOptions;
  }

  index(): Observable<Media[]> {
    const httpOptions=this.getHttpOptions();

    return this.http.get<Media[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('MediaService.index(): Error retrieving todo list');
      })
    );
  }

}

