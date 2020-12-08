import { User } from './user';

export class Media {
  id: number;
  mediaUrl: string;
  user: User;



  constructor(
    id?: number,
    mediaUrl?: string,
    user?: User,
  ) {
    this.id = id;
    this.mediaUrl = mediaUrl;
    this.user = user;
  }
}
