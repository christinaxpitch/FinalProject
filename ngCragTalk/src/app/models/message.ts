import { ClimbingArea } from './climbing-area';
import { User } from './user';

export class Message {
  id            : number;
  createdAt: Date;
  senderId: number;
  receiverId: number;
  messageBody: string;


constructor(
  id?: number,
  createdAt?: Date,
  senderId?: number,
  receiverId?: number,
  messageBody?: string

){
  this.id = id;
  this.createdAt = createdAt;
  this.senderId = senderId;
  this.receiverId = receiverId;
  this.messageBody = messageBody;
}
}
