import { ClimbingArea } from './../models/climbing-area';
import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';

@Pipe({
  name: 'favAreaLocation'
})
export class FavAreaLocationPipe implements PipeTransform {

  transform(users: User[], loggedInUser: User): User[] {
    const results = [];
    console.log(users);
    console.log(loggedInUser);

    let loggedInUserFavAreaIds = [];
    loggedInUser.favoriteAreaList.forEach((area)=> {
        loggedInUserFavAreaIds.push(area.id);
    });

    console.log(loggedInUserFavAreaIds);


    if(users !== null && loggedInUser !== null){
      users.forEach((user)=> {
        if(user.id !== loggedInUser.id){
          user.favoriteAreaList.forEach((climbingArea) => {
            console.log(user);
            console.log(climbingArea);

              if(loggedInUserFavAreaIds.indexOf(climbingArea.id) !== -1){
                results.push(user);
              }
          });
        }
      });
    }
    else {
      return users;
    }
    return results;
  }

}
