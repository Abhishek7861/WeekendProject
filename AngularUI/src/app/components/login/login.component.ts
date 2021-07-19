import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { ValidateService } from '../../service/validate.service';
import { FlashMessagesService } from 'angular2-flash-messages'; 
import { AuthService } from '../../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  email: string;
  password: string;
  @Output() toggleLogin: EventEmitter<boolean> = new EventEmitter();

  
  constructor(private validateService: ValidateService,
    private flashMessagesService: FlashMessagesService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem("authValue")!='0'){
      this.router.navigate(['/dashboard']);
    }
    const user = {
      email:"",
      password:""
    }
  }

  onSubmit():void {
    const user = {
      email:this.email,
      password:this.password
    }

    if(!this.validateService.validateLogin(user)){
      this.flashMessagesService.show("Please fill in all fields",{cssClass: 'alert-danger', timeout: 3000});
      return;
    }
    else if(!this.validateService.validateEmail(user.email)){
      this.flashMessagesService.show("Please fill in valid email",{cssClass: 'alert-danger', timeout: 3000});
      return;
    }

    this.authService.loginUser(user).subscribe((data)=>{
      let responseData:any = data
      localStorage.setItem("authValue",responseData.data.id.toString());
      this.toggleLogin.emit(true);
      this.router.navigate(['/dashboard']);
    });
  }

}
