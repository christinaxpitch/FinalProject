import { ClimbingArea } from './climbing-area';
import { User } from './user';
export class Event {
  id: number;
  eventName: string;
  description: string;
  imgUrl: string;
  climbingAreaId: number;
  eventDate: string;
  createdBy: User[];
  attendedUsers: User[];

constructor (
  id?: number,
  eventName?: string,
  description?: string,
  imgUrl?: string,
  climbingAreaId?: number,
  eventDate?: string,
  createdBy?: User[],
  attendedUsers?: User[]
){
  this.id = id;
  this.eventName = eventName;
  this.description = description;
  this.imgUrl = imgUrl;
  this.climbingAreaId = climbingAreaId;
  this.eventDate = eventDate;
  this.createdBy = createdBy;
  this.attendedUsers = attendedUsers;
}}
