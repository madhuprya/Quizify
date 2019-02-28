import { Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { Gamesearch } from '../../tsclasses/gamesearch';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  Gamesearch: any;
  private games: Gamesearch[];
  
  constructor(private router: Router, private searchService: SearchService) { }

  ngOnInit() {

  }

  search(value) {
    this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
      this.games = res.body[0].game;
      console.log(this.games);
    });
  }
  // search(value) {
  //   this.searchService.searchByTopicStartsWith(value).subscribe((res: any) => {
  //     this.games = res.body[0].game;
  //     console.log(this.games);
  //   });


}
