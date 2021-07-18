import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Order } from './order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  order: Order;
  orders: Order[];

  constructor(private http: HttpClient) { }

  postOrder(order: any){
    let authValue:any = localStorage.getItem("authValue");
    let headers = new HttpHeaders({'Authorization':authValue});
    return this.http.post("http://localhost:8080/api/order",order,{headers:headers});
  }

  getOrder(){
    let authValue:any = localStorage.getItem("authValue");
    let headers = new HttpHeaders({'Authorization':authValue});
    return this.http.get("http://localhost:8080/api/orders",{headers:headers});
  }

}
