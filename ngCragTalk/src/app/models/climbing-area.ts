import { Event } from 'src/app/models/event';
import { User } from './user';

export class ClimbingArea {
  id: number;
  name: string;
  description: string;
  imgUrl: string;
  users: User[];
  location: Location;
  events: Event[];


  constructor(
    id?: number,
    name?: string,
    description?: string,
    imgUrl?: string,
    users?: User[],
    location?: Location,
    events?: Event[]
  ) {
    this.id = id;
  this.name = name;
  this.description = description;
  this.imgUrl = imgUrl;
  this.users = users;
  this.location = location;
  this.events=events;
  }

}
