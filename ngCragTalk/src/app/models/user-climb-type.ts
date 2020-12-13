import { ClimbType } from './climb-type';
import { User } from './user';

export class UserClimbType {
  id: number;
  recentGrade: string;
  leadClimb: boolean;
  user: User;
  climbType: ClimbType;





  constructor(
    id?: number,
    recentGrade?: string,
    leadClimb?: boolean,
    user?: User,
    climbType?: ClimbType,
  ) {
    this.id = id;
    this.recentGrade = recentGrade;
    this.leadClimb = leadClimb;
    this.user = user;
    this.climbType = climbType;
  }
}
