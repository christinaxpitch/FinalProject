import { ClimbingArea } from './../../models/climbing-area';
import { HttpClient } from '@angular/common/http';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { ActivatedRoute, Router } from '@angular/router';
import { Gear } from 'src/app/models/gear';
import { ClimbType } from 'src/app/models/climb-type';
import { UserClimbType } from 'src/app/models/user-climb-type';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router, private datePipe: DatePipe) { }

  selectedUser: User = null;
  gearList: Gear[] = [];
  userClimbTypes: UserClimbType[] = [];
  favoriteClimbingAreas: ClimbingArea [] = [];
  today: Date = new Date();
  updateUserProfile: User;




  // will need to add an array for a users gear list and use the controller path and the method to get a users gear list



  ngOnInit(): void {
    const idStr = this.route.snapshot.paramMap.get('userId');

      if (idStr) {

        const id: number = Number.parseInt(idStr, 10);
        if (!isNaN(id)) {
          this.userService.show(id).subscribe(
            (data) => {
              console.log('profile retrieved');
              this.selectedUser = data;
              this.gearList = data.gearList;
              this.userClimbTypes = data.userClimbTypes;
              this.favoriteClimbingAreas = data.favoriteAreaList;



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


  updateProfile(user: User): void {
    this.userService.update(user.id, user).subscribe(
      data=>{
        user = data;
        console.log('retrieved');
        this.router.navigateByUrl('update/' + user.id);
        // this.reload();
      },
      err=>{
      console.error('retrieved failed')
      console.error(err);
      }
    );
    // window.location.reload();
  }

  setUpdateUser() {
    this.updateUserProfile = Object.assign({}, this.selectedUser);
  }


  age(user: User): number {

    const birthYear = user.birthdate.toString().substring(0,5);
    const currentYear = this.today.getFullYear();
    const age = currentYear - parseInt(birthYear);
    return age;
  }

  showProfile(userId: number) {

          this.userService.show(userId).subscribe(
            (data) => {
              console.log('profile retrieved');
              this.selectedUser = data;
              this.gearList = data.gearList;
              this.userClimbTypes = data.userClimbTypes;
              this.favoriteClimbingAreas = data.favoriteAreaList;



            },
            (err) => {
              console.log('User ' + userId + ' not found.');
              this.router.navigateByUrl('notFound');
            }
            );
          }






}
