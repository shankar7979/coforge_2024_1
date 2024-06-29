import { Component, Input } from '@angular/core';
import { PersonService } from '../person-app/service/person.service';
import { Observable } from 'rxjs';
import { Person } from '../person-app/model/person';


@Component({
  selector: 'app-addperson',
  standalone: true,
  imports: [],
  templateUrl: './addperson.component.html',
  styleUrl: './addperson.component.css'
})
export class AddpersonComponent {

  msg: string = '';
  @Input() person: Person;

  constructor(private service: PersonService) {
    this.person = new Person();
  }

  savePerson() {
    this.service.addPerson(this.person).subscribe(data => this.msg = "Record Added", error => this.msg = error.error);
  }
}
