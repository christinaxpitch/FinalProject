import { User } from './user';

export class ClimbingArea {
  id: number;
  name: string;
  description: string;
  imgUrl: string;
  users: User[];
  location: Location;


  constructor(
    id?: number,
    name?: string,
    description?: string,
    imgUrl?: string,
    users?: User[],
    location?: Location
  ) {
    this.id = id;
  this.name = name;
  this.description = description;
  this.imgUrl = imgUrl;
  this.users = users;
  this.location = location;
  }

}
