import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authSvc: AuthService, private router: Router) { }

  ngOnInit(): void {
  }
  login(form: NgForm){
    const userName = form.value.username;
    const password = form.value.password;
    console.log(userName);
    console.log(password);


   this.authSvc.login(userName, password).subscribe(
     (data) => {
        this.router.navigateByUrl('user');
     },
     (err) => {
        console.error('LoginComponent.login():  error logging in user');
        console.error(err);
     }
   );
}
}
