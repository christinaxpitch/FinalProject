import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private authSvc: AuthService, private router: Router) { }

  ngOnInit(): void {
  }
  register(form: NgForm){
    const user = form.value;
    this.authSvc.register(user).subscribe(
      (data) => {
        this.authSvc.login(user.username, user.password).subscribe(
          (success) => {
            this.router.navigateByUrl('user');
          },
          (fail) => {
            console.error('RegistrationComponent.register()login(): error logging in user after registration');
            console.error(fail);
          }
        );
      },
      (err) => {
        console.error('RegisterComponent.register(): error registering user');
        console.error(err);
      }
    );
  }
}
