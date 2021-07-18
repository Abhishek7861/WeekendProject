import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { FlashMessagesService } from 'angular2-flash-messages'; 

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private router: Router,
    private flashMessagesService: FlashMessagesService) { }

  ngOnInit(): void {
    if(localStorage.getItem("authValue")=='0'){
      this.router.navigate(['/login']);
      this.flashMessagesService.show("Please login to view Orders",{cssClass: 'alert-danger', timeout: 3000});
    }
  }
}
