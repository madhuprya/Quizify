import { Component, OnInit } from '@angular/core';
import { Admin } from '../../tsclasses/admin';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { MatSnackBar } from '@angular/material/snack-bar';
import { GameserviceService } from '../../services/gameservice.service';
import { Game } from '../../tsclasses/game';
// import { Topic } from '../pclasses/topic';
// import { GameserviceService } from './gameservice.service';
// import { Router } from '@angular/router';

export interface Type {
  value: string;
  viewValue: string;
}

export interface Level {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {

  // topic: Topic[] = [
  //   {value: 'Java', viewValue: 'Java'},
  //   {value: 'Python', viewValue: 'Python'},
  //   {value: 'C++', viewValue: 'C++'}
  // ];

    private admin: Admin;
    private game: Game;
    private category: Category;
    private gamecategory: Category;
    private topic1: Topic;
    private topic2: Topic;
    private currentTopic: Topic;
    private levels: Level[];
    private selectedLevel = '';
    private questionNumber = '';
    private statusCode: number;
    private gameName: string;
    private gameId: number;
    private gameGenre: string;


  constructor(private gameService: GameserviceService, private snackBar: MatSnackBar) {
      // Dummy Data For Admin Class
      this.admin = new Admin();
      this.admin.name = 'Dummy_VINGU';
      this.admin.id = 'VINGU';

      // Dummy Data For Category Class
      this.gamecategory = new Category();
      this.gamecategory.name = 'Entertainment';
      this.gamecategory.imageUrl = 'https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg';
      this.gamecategory.admin = this.admin;
      this.gamecategory.timeStamp = '' + Date.now();

      // Dummy Data For Topic1
      this.topic1 = new Topic();
      this.topic1.name = 'Movies';
      this.topic1.imageUrl = 'https://boyslifeorg.files.wordpress.com/2011/04/movies-featured.jpg';
      this.topic1.admin = this.admin;
      this.topic1.timeStamp = '' + Date.now();

      // Dummy Data For Topic2
      this.topic2 = new Topic();
      this.topic2.name = 'TV Shows';
      // tslint:disable-next-line:max-line-length
      this.topic2.imageUrl = 'https://media.gqindia.com/wp-content/uploads/2018/12/netflix-shows-amazon-prime-series-best-shows-on-hotstar-premium-sonlyliv1-866x487.jpg';
      this.topic2.admin = this.admin;
      this.topic2.timeStamp = '' + Date.now();

      this.currentTopic = this.topic2;
      this.category = this.gamecategory;


      this.levels = [
        {value: 'easy', viewValue: 'Easy'},
        {value: 'medium', viewValue: 'Medium'},
        {value: 'hard', viewValue: 'Hard'}
      ];
   }

  ngOnInit() {
  }


  saveGames() {
    if (
      this.selectedLevel === '' ||
      this.questionNumber === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 500});
     } else {
      this.game = new Game();
      this.game.id = this.gameId;
      this.game.name =  this.gameName;
      this.game.topic = this.currentTopic;
      this.game.category = this.gamecategory;
      this.game.level = this.selectedLevel;
      this.game.numOfQuestion = Number(this.questionNumber);
      this.game.playcount = 0;
      this.game.genre = this.gameGenre;
      this.game.admin = this.admin;
      console.log(this.game);
      this.addGame(this.game);
     }
  }
  addGame(game: Game) {
    this.gameService.addGame(game).subscribe(
      response => {
        this.statusCode = response.status;
        if (this.statusCode === 200) {
          console.log('Success', this.statusCode);
          this.snackBar.open('Question Successfully Saved !!!', '', {
            duration: 1500
          });
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 409) {
          this.snackBar.open('Question Already Saved !!!', '', {
            duration: 1500
          });
          this.statusCode = 0;
        }
    });

    // console.log(this.gameService.fetchAllGames(this.gamecategory.name, this.currentTopic.name));

  }

}
