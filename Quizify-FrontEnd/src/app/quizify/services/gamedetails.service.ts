import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable()
export class GamedetailsService {
  url: any;
  response: any;

  constructor(private http: HttpClient) {   }

  getDetails() {
      this.url = 'http://localhost:3001/game';
      return this.http.get(this.url);
  }
}
