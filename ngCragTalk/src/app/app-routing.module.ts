import { MessageComponent } from './components/message/message.component';
import { ClimbingAreaComponent } from './components/climbing-area/climbing-area.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventComponent } from './components/event/event.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { DiscoveryComponent } from './components/discovery/discovery.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'message', component: MessageComponent },
  { path: 'user', component: ProfileComponent },
  { path: 'user/:userId', component: ProfileComponent },
  { path: 'user/update/:userId', component: EventComponent },
  { path: 'event', component: EventComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'event/:eventId', component: EventComponent },
  { path: 'climbingArea', component: ClimbingAreaComponent },
  { path: 'discovery', component: DiscoveryComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
