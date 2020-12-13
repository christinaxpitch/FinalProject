import { Event } from 'src/app/models/event';
import { IndexService } from './../../services/index.service';
import { ClimbingArea } from './../../models/climbing-area';
import { Component, OnInit, ɵclearResolutionOfComponentResourcesQueue } from '@angular/core';
import { Message } from 'src/app/models/message';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-discovery',
  templateUrl: './discovery.component.html',
  styleUrls: ['./discovery.component.css']
})
export class DiscoveryComponent implements OnInit {
  pageTitle: string = 'Discovery';
  messages: Message[] = [];
  events: Event[] = [];
  users: User[] = [];
  filteredUsers: User[] = [];
  selectedUser: User = null;
  loggedInUser: User = null;
  showEventList: boolean = false;
  showMessageList: boolean = false;




  constructor(private userSvc: UserService,
    private currentRoute: ActivatedRoute,
    private router: Router,
    private authSvc: AuthService,
    private eventSvc: EventService
    ) { }

  ngOnInit(): void {
    const idStr = this.currentRoute.snapshot.paramMap.get('userId');
    if (idStr) {
      const id: number = Number.parseInt(idStr);
      if (!isNaN(id)) {
        this.userSvc.show(id).subscribe(
          (user) => {
            this.selectedUser = user;
            this.loggedInUser = user;
            this.reload();
          },
          (fail) => {
            this.router.navigateByUrl('**');
          }
        );
      } else {
        this.router.navigateByUrl('**');
      }
    } else {
      this.reload();
    }
  }

  reload(): void {
    if (this.authSvc.checkLogin()) {
      const loggedInUserId = this.authSvc.getCurrentUserId();
      this.userSvc.show(loggedInUserId).subscribe(
        (data) => {
          this.loggedInUser = data;
        },
        (error) => {
          console.error('DiscoveryComponent.reload(): error getting logged in user');
          console.error(error);
        }
      )
    this.userSvc.index().subscribe(
      (data) => {
        this.users = data.filter(user => (user.id !== loggedInUserId));
        // this.filteredUsers = data.filter(user => (!this.loggedInUser.myListOfFavoriteUsers.includes(user)));
        // console.log(this.filteredUsers);
        // this.showRecommendedUsers(this.users, this.loggedInUser);
        this.showNewMessages();
        this.showUpcomingEvents();
      },
      (fail) => {
        console.error('DiscoveryComponent.reload(): error getting users');
        console.error(fail);
      }
      );
    }
    else {
      this.router.navigateByUrl('login');
    }
  }

  showNewMessages(){
    // this.messages = this.loggedInUser.myListOfReceivedMessages.filter(message => (message.createdAt > this.loggedInUser.lastLogin));
    this.messages = this.loggedInUser.myListOfReceivedMessages;
    this.showMessageList = true;
  }

  showUpcomingEvents(){
    this.eventSvc.index().subscribe(
      (events) => {
        this.events = events.filter(event =>(event.eventDate > this.loggedInUser.lastLogin));
      },
      (err) => {
        console.error('DiscoveryComponent.showUpcomingEvents().index():  error getting events');
        console.error(err);


      }
    )};

  showRecommendedUsers(users: User[], currentUser: User){
    console.log(users);
    console.log(currentUser);
    console.log(currentUser.favoriteAreaList);
    let loggedInUserFavAreaIds = [];
    let loggedInUserFavClimbers = [];
    if(users != null && currentUser != null){
     currentUser.favoriteAreaList.forEach((climbingArea)=> {
       loggedInUserFavAreaIds.push(climbingArea.id);
     });
       currentUser.myListOfFavoriteUsers.forEach((fav)=> {
        loggedInUserFavClimbers.push(fav.id);
      }),
      console.log(loggedInUserFavAreaIds);
      console.log(loggedInUserFavClimbers);

            for (let i =0; i<users.length; i++){
              console.log(users[i]);
              for(let j = 0; j < loggedInUserFavClimbers.length; j++){
                console.log(loggedInUserFavClimbers[i]);
                if(users[i].id == loggedInUserFavClimbers[j]){
                      // users.splice(i, 1);
                      continue;
                }
                else{
                  if(this.filteredUsers.indexOf(users[i]) < 0){
                    this.filteredUsers.push(users[i]);
                }
              }
            }
          }

            //  users.forEach((user)=> {
            //      loggedInUserFavClimbers.forEach((favClimberId)=>{
            //        console.log(user);
            //        console.log(favClimberId);
            //         if(favClimberId != user.id){
            //           user.favoriteAreaList.forEach((climbingArea) => {
            //               if(loggedInUserFavAreaIds.indexOf(climbingArea.id) > -1 && user.location.city === currentUser.location.city){
            //                if(this.filteredUsers.indexOf(user) < 0){
            //                  this.filteredUsers.push(user);
            //                }
            //               }
            //           });
            //         }
            //      });
            //  });
           }
           console.log(this.filteredUsers);
  }


  showProfile(userId: number) {
    this.userSvc.show(userId);
    this.router.navigateByUrl('user/' + userId);
  }

}
