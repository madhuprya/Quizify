import { Admin } from './admin';
export class Topic {

     name: string;
     imageUrl: string;
    timeStamp: string;
      subTopics: Topic[];
      admin: Admin;
}
