import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core' ;

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {


  constructor(private cardService: CardService) { }
  method: any;
  quiz: any;

  ngOnInit() {
    for (let i = 0; i < 2; i++) {
    this.cardService.getquiz().subscribe(resposeQuiz => this.quiz = resposeQuiz);
    }
  }

}
