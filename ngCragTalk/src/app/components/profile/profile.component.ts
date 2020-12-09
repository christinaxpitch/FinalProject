import { HttpClient } from '@angular/common/http';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

  selectedUser: User = null;



  ngOnInit(): void {
    const idStr = this.route.snapshot.paramMap.get('userId');

      if (idStr) {

        const id: number = Number.parseInt(idStr, 10);
        if (!isNaN(id)) {
          this.userService.show(id).subscribe(
            (data) => {
              console.log('Todo retrieved, setting selected');
              this.selectedUser = data;
              // this.reload();
            },
            (err) => {
              console.log('User ' + id + ' not found.');
              this.router.navigateByUrl('notFound');
            }
            );
          }
          else {
            this.router.navigateByUrl('invalidId');
        }
      }
      else {
        this.router.navigateByUrl('notFound');
      }
  }




}
