import { Component } from '@angular/core';
import { Customer } from './model/Customer';

@Component({
  selector: 'app-template-form',
  standalone: true,
  imports: [],
  templateUrl: './template-form.component.html',
  styleUrl: './template-form.component.css'
})
export class TemplateFormComponent {

  customer:Customer;

  constructor(){
    this.customer=new Customer();
  }

}
