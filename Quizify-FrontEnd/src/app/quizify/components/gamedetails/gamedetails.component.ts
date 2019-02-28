import { Component, OnInit } from '@angular/core';
import { GamedetailsService } from '../../services/gamedetails.service';
import { SinglePlayer } from '../../tsclasses/single-player';
import { Game } from '../../tsclasses/game';
import { GameEngineService } from '../../services/game-engine.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-gamedetails',
  templateUrl: './gamedetails.component.html',
  styleUrls: ['./gamedetails.component.scss']
})

export class GamedetailsComponent implements OnInit {

  private singleplayer: SinglePlayer;
  private game: Game;
  private statusCode: number;


  method: any;
  constructor(private gameengine: GameEngineService, private snackBar: MatSnackBar) { }
  quiz: any;
  ngOnInit() {
 }

//  fetchGameId(gameId: string) {
//   this.game.name = gameId;
//   this.singleplayer.game = this.game;
//   this.savePlayer(this.singleplayer);
// }


}
