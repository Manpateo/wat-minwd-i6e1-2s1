import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tram } from '../_dtos/Tram';

@Injectable({
  providedIn: 'root'
})
export class TramsService {

  baseUrl = 'http://localhost:8080/trams/';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Tram[]> {
    return this.http.get<Tram[]>(this.baseUrl + 'all');
  }

  getLines(id: number): Observable<Tram[]> {
    return this.http.get<Tram[]>(this.baseUrl + 'line/' + id);
  }

}
