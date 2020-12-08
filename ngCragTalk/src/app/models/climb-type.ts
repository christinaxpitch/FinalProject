import { User } from './user';

export class ClimbType {
  id: number;
  name: string;
  description: string;
  imgUrl: string;
  userList: User[];



  constructor(
    id?: number,
    name?: string,
    description?: string,
    imgUrl?: string,
    users?: User[],
  ) {
    this.id = id;
  this.name = name;
  this.description = description;
  this.imgUrl = imgUrl;
  this.userList = users;
  }

}
