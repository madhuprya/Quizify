import { Component, OnInit } from '@angular/core';
import { Admin } from '../../tsclasses/admin';
import { Category } from '../../tsclasses/category';
import { Topic } from '../../tsclasses/topic';
import { Question } from '../../tsclasses/question';
import { MatSnackBar } from '@angular/material/snack-bar';
import { QuestionService } from '../../services/question.service';

export interface Type {
  value: string;
  viewValue: string;
}

export interface Level {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-question-generator',
  templateUrl: './question-generator.component.html',
  styleUrls: ['./question-generator.component.css']
})
export class QuestionGeneratorComponent implements OnInit {
  private admin: Admin;
  private category: Category;
  private topic1: Topic;
  private topic2: Topic;
  private currentTopic: Topic;
  private questionGenre: string;
  private question: Question;
  private questions: Question[];

  private types: Type[];
  private levels: Level[];

  private selectedType = '';

  private tfStatement = '';
  private tfselectedOption = '';
  private tfselectedLevel = '';

  private mcqStatement = '';
  private mcqOption1 = '';
  private mcqOption2 = '';
  private mcqOption3 = '';
  private mcqOption4 = '';
  private mcqSelectedOption = '';
  private mcqSelectedLevel = '';

  private statusCode: number;


  constructor(private questionService: QuestionService, private snackBar: MatSnackBar) {
        // Dummy Data For Admin Class
        this.admin = new Admin();
        this.admin.name = 'Dummy_Admin';
        this.admin.id = '123ABC';
        // Dummy Data For Category Class
        this.category = new Category();
        this.category.name = 'Entertainment';
        this.category.imageUrl = 'https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg';
        this.category.admin = this.admin;
        this.category.timeStamp = '' + Date.now();

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

        this.types = [
          {value: 'mcq', viewValue: 'Multiple Choice'},
          {value: 't/f', viewValue: 'True / False'}
        ];

        this.levels = [
          {value: 'easy', viewValue: 'Easy'},
          {value: 'medium', viewValue: 'Medium'},
          {value: 'hard', viewValue: 'Hard'}
        ];
  }

  ngOnInit() {
  }

  saveTFQuestion() {
    if (
      this.tfStatement === '' ||
      this.tfselectedOption === '' ||
      this.tfselectedLevel === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 1500});
     } else {
      this.question = new Question();
      this.question.id = '' + Date.now();
      this.question.category = this.category;
      this.question.topic = this.currentTopic;
      this.question.level = this.tfselectedLevel;
      this.question.type = this.selectedType;
      this.question.statement = this.tfStatement;
      this.question.genre = this.questionGenre;
      this.question.options = new Array();
      this.question.options[0] = 'true';
      this.question.options[1] = 'false';
      this.question.answer = this.tfselectedOption;
      this.question.admin = this.admin;
      console.log(this.question);
      this.saveQuestion(this.question);
     }
  }

  saveMcqQuestion() {
    if (
      this.mcqStatement === '' ||
      this.mcqOption1 === '' ||
      this.mcqOption2 === '' ||
      this.mcqOption3 === '' ||
      this.mcqOption4 === '' ||
      this.mcqSelectedOption === '' ||
      this.mcqSelectedLevel === ''
      ) {
        this.snackBar.open('Please Fill All The Fields!', '', {duration: 1500});
     } else {
      this.question = new Question();
      this.question.id = '' + Date.now();
      this.question.category = this.category;
      this.question.genre = this.questionGenre;
      this.question.topic = this.currentTopic;
      this.question.level = this.mcqSelectedLevel;
      this.question.type = this.selectedType;
      this.question.statement = this.mcqStatement;
      this.question.options = new Array();
      this.question.options[0] = this.mcqOption1;
      this.question.options[1] = this.mcqOption2;
      this.question.options[2] = this.mcqOption3;
      this.question.options[3] = this.mcqOption4;
      if (this.mcqSelectedOption === 'mcqOption1') {
        this.question.answer = this.mcqOption1;
      } else if (this.mcqSelectedOption === 'mcqOption2') {
        this.question.answer = this.mcqOption2;
      } else if (this.mcqSelectedOption === 'mcqOption3') {
        this.question.answer = this.mcqOption3;
      } else {
        this.question.answer = this.mcqOption4;
      }
      this.question.admin = this.admin;
      console.log(this.question);
      this.saveQuestion(this.question);
     }
  }


  saveQuestion(question: Question) {
    this.questionService.saveQestion(question).subscribe(
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

    console.log(this.questionService.fetchAllQuestions(this.category.name, this.currentTopic.name));

  }

}
