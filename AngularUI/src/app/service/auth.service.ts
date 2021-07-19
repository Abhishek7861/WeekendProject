import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { Observable, EMPTY, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { FlashMessagesService } from 'angular2-flash-messages'; 


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authToken:any;
  user:any;

  constructor(private http: HttpClient,
    private flashMessagesService: FlashMessagesService,) { }

  registerUser(user:any){
    return this.http.post('http://localhost:8080/api/register',user).pipe(
      catchError(error =>{
        this.flashMessagesService.show("Email and username already registered",{cssClass: 'alert-danger', timeout: 3000});
        return EMPTY;
      })
    );
  }

  loginUser(user:any){
    return this.http.post('http://localhost:8080/api/login',user).pipe(
      catchError(error =>{
        this.flashMessagesService.show("Incorrect Email or Password",{cssClass: 'alert-danger', timeout: 3000});
        return EMPTY;
      })
    );
  }

  getUser(){
    let authValue:any = localStorage.getItem("authValue");
    let headers = new HttpHeaders({'Authorization':authValue});
    return this.http.get('http://localhost:8080/api/getUser',{headers:headers});
  }

  updateUser(user:any){
    return this.http.put('http://localhost:8080/api/update',user).pipe(
      catchError(error =>{
        this.flashMessagesService.show("Email or username already taken",{cssClass: 'alert-danger', timeout: 3000});
        return EMPTY;
      }),
    );
  }
}
