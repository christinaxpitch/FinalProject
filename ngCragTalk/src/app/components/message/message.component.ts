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
    today: Date = new Date();




  ngOnInit(): void {

  }

  showProfile(userId: number) {

    this.userService.show(userId).subscribe(
      (data) => {
        console.log('profile retrieved');
        this.selectedUser = data;
        this.messages = data.myListOfReceivedMessages;



      },
      (err) => {
        console.log('User ' + userId + ' not found.');
        this.router.navigateByUrl('notFound');
      }
      );
    }
}
