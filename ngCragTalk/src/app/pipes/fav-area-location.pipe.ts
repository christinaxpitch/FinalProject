import { ClimbingArea } from './../models/climbing-area';
import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';

@Pipe({
  name: 'favAreaLocation'
})
export class FavAreaLocationPipe implements PipeTransform {

  transform(users: User[], loggedInUser: User): User[] {
    let results = [];
    // console.log(users);
    // console.log(loggedInUser);

    let loggedInUserFavAreaIds = [];
    loggedInUser.favoriteAreaList.forEach((area)=> {
        loggedInUserFavAreaIds.push(area.id);
    });

    // console.log(loggedInUserFavAreaIds);

    let loggedInUserFavUsers = [];
    loggedInUser.myListOfFavoriteUsers.forEach((fav)=> {
      loggedInUserFavUsers.push(fav.id);
    });
    // console.log(loggedInUserFavAreaIds);

    if(users !== null && loggedInUser !== null){
      users.forEach((user)=> {
        if(user.id !== loggedInUser.id){
          user.favoriteAreaList.forEach((climbingArea) => {
            // console.log(user);
            // console.log(climbingArea);

              if(loggedInUserFavAreaIds.indexOf(climbingArea.id) !== -1 && loggedInUserFavUsers.indexOf(user.id) < 0){
                results.push(user);
              }
              results = results.reduce((accumalator, current) => {
                if(!accumalator.some(item => item.id === current.id && item.name === current.name)){
                  accumalator.push(current);
                }
                return accumalator;
              }, []);

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
