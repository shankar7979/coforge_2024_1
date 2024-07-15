import { Component, OnInit } from '@angular/core';
import { JwtclientService } from '../jwtclient.service';



@Component({
  selector: 'app-security',
  standalone: true,
  imports: [],
  templateUrl: './security.component.html',
  styleUrl: './security.component.css'
})
export class SecurityComponent {
  authRequest: any = {
    "userName": "javatechie",
    "password": "password"
  };

  response: any;

  constructor(private service: JwtclientService) { }

  ngOnInit() {
    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest: any) {
    let resp = this.service.generateToken(authRequest);
    resp.subscribe((data: any) => this.accessApi(data));
  }


  public accessApi(token: any) {
    let resp = this.service.welcome(token);
    resp.subscribe((data: any) => this.response = data);
  }
}
