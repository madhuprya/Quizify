import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../tsclasses/register';


@Injectable({
   providedIn: 'root'
})
export class RegisterService {
      url: string;
      topicUrl: string;
      genreUrl: string;
      response: any;
      get: any;
   constructor(private http: HttpClient) { }

   // addUser(register: Register) {
   //    this.url = 'http://localhost:8899/api/v1/user';
   //    return this.http.get(this.url).subscribe(resp => {
   //       console.log(resp);
   //       this. response = resp;
   //        return this.http.post(this.url + '' , register, {observe: 'response', responseType: 'text'});
   //    });
   //  }

   addUser(register: Register) {
      this.url = 'http://13.232.243.68:8999/api/v1/user/';
         this. http.get(this.url).subscribe(resp => {
            this.response = resp;
         });
         return this.http.post(this.url + '' , register, {observe: 'response', responseType: 'text' });
   }

   getTopic() {
      this.topicUrl = 'http://13.232.243.68:8104/rest/neo4j/topic/0';
      return this.http.get(this.topicUrl);
}

   getGenre() {
      this.genreUrl = 'http://13.232.243.68:8104/rest/neo4j/genre/';
      return this.http.get(this.genreUrl);
   }

}


//   addUser(searchText: string) {
//      console.log('hi');
//    this.http.get('https://localhost:8899/api/v1/user').subscribe(resp => {
//        console.log(resp);
//    this.response = resp;
//        });
//    return this.response;
//    }


