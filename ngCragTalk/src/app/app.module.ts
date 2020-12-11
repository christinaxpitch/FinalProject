import { UserService } from './services/user.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './components/profile/profile.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { EventComponent } from './components/event/event.component';
import { MessageComponent } from './components/message/message.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthService } from './services/auth.service';
import { IndexService } from './services/index.service';
import { EventService } from './services/event.service';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {IvyCarouselModule} from 'angular-responsive-carousel';
import { DatePipe } from '@angular/common';
import { ClimbingAreaComponent } from './components/climbing-area/climbing-area.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    HomeComponent,
    EventComponent,
    MessageComponent,
    LogoutComponent,
    NotFoundComponent,
    ClimbingAreaComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    IvyCarouselModule
  ],
  providers: [AuthService, EventService, IndexService, UserService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
