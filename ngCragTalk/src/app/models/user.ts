import { Message } from './message';
import { Media } from './media';
import { Gear } from './gear';
import { ClimbingArea } from './climbing-area';
import { ClimbType } from './climb-type';
export class User {

  id: number;
  firstName: string;
  lastName: string;
  username: string;
  favoriteBeer: string;
  hasDog: boolean;
  profilePic: string;
  climbingSince: number;
  goals: string;
  availability: string;
  role: string;
  createdAt: string;
  lastLogin: string;
  otherHobbies: string;
  birthdate: string;
  password: string;
  climbTypes: ClimbType[];
  favoriteAreaList: ClimbingArea[];
  location: Location;
  createdEvents: Event[];
  attendedEvents: Event[];
  gearList: Gear[];
  myListOfFavoriteUsers: User[];
  listOfUsersWhoHaveFavoritedMe: User[];
  mediaList: Media[];
  myListOfReceivedMessages: Message[];
  myListOfSentMessages: Message[];
  enabled: boolean;
  userClimbTypes: ClimbType[];


  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
    username?: string,
    favoriteBeer?: string,
    hasDog?: boolean,
    profilePic?: string,
    climbingSince?: number,
    goals?: string,
    availability?: string,
    role?: string,
    createdAt?: string,
    lastLogin?: string,
    otherHobbies?: string,
    birthdate?: string,
    password?: string,
    climbTypes?: ClimbType[],
    favoriteAreaList?: ClimbingArea[],
    location?: Location,
    createdEvents?: Event[],
    attendedEvents?: Event[],
    gearList?: Gear[],
    myListOfFavoriteUsers?: User[],
    listOfUsersWhoHaveFavoritedMe?: User[],
    mediaList?: Media[],
    myListOfReceivedMessages?: Message[],
    myListOfSentMessages?: Message[],
    enabled?: boolean,
    userClimbTypes?: ClimbType[],

  ){
    this.id=id;
    this.firstName=firstName;
    this.lastName=lastName;
    this.username=username;
    this.favoriteBeer=favoriteBeer;
    this.hasDog=hasDog;
    this.profilePic=profilePic;
    this.climbingSince=climbingSince;
    this.goals=goals;
    this.availability=availability;
    this.role=role;
    this.createdAt=createdAt;
    this.lastLogin=lastLogin;
    this.otherHobbies=otherHobbies;
    this.birthdate=birthdate;
    this.password=password;
    this.climbTypes=climbTypes,
    this.favoriteAreaList=favoriteAreaList,
    this.location=location,
    this.createdEvents=createdEvents,
    this.attendedEvents=attendedEvents,
    this.gearList=gearList,
    this.myListOfFavoriteUsers=myListOfFavoriteUsers,
    this.listOfUsersWhoHaveFavoritedMe=listOfUsersWhoHaveFavoritedMe,
    this.mediaList=mediaList,
    this.myListOfReceivedMessages=myListOfReceivedMessages,
    this.myListOfSentMessages=myListOfSentMessages,
    this.enabled=enabled,
    this.userClimbTypes = userClimbTypes
  }
}
