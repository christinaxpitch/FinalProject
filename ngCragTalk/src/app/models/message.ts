import { ClimbingArea } from './climbing-area';
import { User } from './user';

export class Message {
  id            : number;
  createdAt: string;
  sender: User;
  receiver: User;
  messageBody: string;


constructor(
  id?: number,
  createdAt?: string,
  senderId?: User,
  receiverId?: User,
  messageBody?: string

){
  this.id = id;
  this.createdAt = createdAt;
  this.sender = senderId;
  this.receiver = receiverId;
  this.messageBody = messageBody;
}
}
