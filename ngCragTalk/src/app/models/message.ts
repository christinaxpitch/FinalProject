import { ClimbingArea } from './climbing-area';
import { User } from './user';

export class Message {
  id            : number;
  city          : string;
  state         : string;
  zip           : number;
  users         : User [];
  streetAddress : string;
  climbingAreas : ClimbingArea []


constructor(
  id?             : number,
  city?           : string,
  state?          : string,
  zip?            : number,
  users?          : User [],
  streetAddress?  : string,
  climbingAreas?  : ClimbingArea []

){
  this.id            = id;
  this.city          = city;
  this.state         = state;
  this.zip           = zip;
  this.users         = users;
  this.streetAddress = streetAddress;
  this.climbingAreas = climbingAreas;
}
};
