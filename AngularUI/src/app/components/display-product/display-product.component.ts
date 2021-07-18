import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { FlashMessagesService } from 'angular2-flash-messages'; 
import { ProductService } from 'src/app/product/product.service';
import { Product } from 'src/app/product/product.model';


@Component({
  selector: 'app-display-product',
  templateUrl: './display-product.component.html',
  styleUrls: ['./display-product.component.css']
})
export class DisplayProductComponent implements OnInit {

  constructor(private router: Router,
    private flashMessagesService: FlashMessagesService,
    public productService: ProductService) { }

  ngOnInit(): void {
    if(localStorage.getItem("authValue")=='0'){
      this.router.navigate(['/login']);
      this.flashMessagesService.show("Please login to view All Listing",{cssClass: 'alert-danger', timeout: 3000});
    }
    this.productService.getAllProducts().subscribe((res)=>{
      this.productService.products = res as Product[];
    })
  }

  onBuy(pro:Product){
    if (confirm("Are you sure to Buy "+pro.title+" for "+pro.price+" ?")==true){
      this.flashMessagesService.show("Successful Purchase! check your orders!",{cssClass: 'alert-success', timeout: 3000});
    }
  }
}
