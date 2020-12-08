import { User } from './user';

export class Gear {
  id: number;
  name: string;
  user: User;



  constructor(
    id?: number,
    name?: string,
    user?: User,

  ) {
    this.id = id;
  this.name = name;
  this.user = user;
  }

}
