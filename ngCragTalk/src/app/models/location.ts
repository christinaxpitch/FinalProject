export class Location {
  id         : number;
  senderId   : number;
  receiverId : number;
  messageBody: string;

  constructor(
    id?          : number,
    senderId?    : number,
    receiverId?  :  number,
    messageBody? : string

  ){
    this.id          = id;
    this.senderId    = senderId;
    this.receiverId  = receiverId;
    this.messageBody = messageBody;
  }
};
