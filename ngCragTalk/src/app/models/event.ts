import { ClimbingArea } from './climbing-area';
import { User } from './user';

export class Event {
  id: number;
  eventName: string;
  description: string;
  imgUrl: string;
  climbingArea: ClimbingArea;
  eventDate: string;
  createdBy: User;
  attendedUsers: User[];

constructor (
  id?: number,
  eventName?: string,
  description?: string,
  imgUrl?: string,
  climbingArea?: ClimbingArea,
  eventDate?: string,
  createdBy?: User,
  attendedUsers?: User[]
){
  this.id = id;
  this.eventName = eventName;
  this.description = description;
  this.imgUrl = imgUrl;
  this.climbingArea = climbingArea;
  this.eventDate = eventDate;
  this.createdBy = createdBy;
  this.attendedUsers = attendedUsers;
}}
