import { UserService } from './../../services/user.service';
import { AuthService } from 'src/app/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { Message } from 'src/app/models/message';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  constructor(
    private auth: AuthService,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe,
    ) { }

    selectedUser: User = null;
    messages: Message[] = [];
    sentMessages: Message [] = [];
    today: Date = new Date();
    showInbox: boolean = true;
    showMessageBody: boolean = false;
    messageBody: string;
    showReplyBox: boolean = false;
    newMessage: Message = new Message();
    managedMessage: Message;




  ngOnInit(): void {
    // const idStr = this.route.snapshot.paramMap.get('userId');
    const id = this.auth.getCurrentUserId();

    if (id) {


      if (!isNaN(id)) {
        this.userService.show(id).subscribe(
          (data) => {
            console.log('profile retrieved');
            this.selectedUser = data;
            this.messages = data.myListOfReceivedMessages;
            this.sentMessages = data.myListOfSentMessages;
          },
          (err) => {
            console.log('User ' + id + ' not found.');
            this.router.navigateByUrl('notFound');
          }
          );
        }
        else {
          this.router.navigateByUrl('invalidId');
      }
    }
    else {
      this.router.navigateByUrl('notFound');
    }
  }

  displayMessageBody(message: Message) {
      this.setShowMessageBody();
      this.messageBody = message.messageBody;

  }

  setShowMessageBody() {
    this.showMessageBody = !this.showMessageBody;
  }
  backToInbox() {
    this.showInbox = true;
    this.showMessageBody = false;
    this.showReplyBox = false;
  }

  setShowReplyBox() {
    this.showReplyBox = !this.showReplyBox;
    this.showInbox = !this.showInbox;
  }

  setReplyDiv(message: Message) {
    this.setShowReplyBox();

    this.newMessage.sender = message.receiver;
    this.newMessage.receiver = message.sender;
    this.managedMessage = message;
  }

  reply(message: Message) {
    this.userService.createMessage(message, message.receiver.id).subscribe(
          (data) => {
            console.log('message sent succesfully');
            this.router.navigateByUrl('message');

          },
          (err) => {
            console.log('message reply failed');

          }
          );
  }
  // showProfile(userId: number) {

  //   this.userService.show(userId).subscribe(
  //     (data) => {
  //       console.log('profile retrieved');
  //       this.selectedUser = data;
  //       this.messages = data.myListOfReceivedMessages;



  //     },
  //     (err) => {
  //       console.log('User ' + userId + ' not found.');
  //       this.router.navigateByUrl('notFound');
  //     }
  //     );
  //   }
}
