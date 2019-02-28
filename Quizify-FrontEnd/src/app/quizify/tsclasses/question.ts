import { Category } from './category';
import { Admin } from './admin';
import { Topic } from './topic';


export class Question {

     id: string;
     category: Category;
     genre: string;
     topic: Topic;
     level: string;
     type: string;
     statement: string;
     options: string[];
    answer: string;
     admin: Admin;

}
