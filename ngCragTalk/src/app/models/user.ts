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
    this.password=password;}
}
