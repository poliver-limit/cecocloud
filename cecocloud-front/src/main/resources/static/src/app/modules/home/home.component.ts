import { Component, OnInit } from '@angular/core';


//import { RestapiService } from '../../shared/restapi/restapi.service';
//import { RestapiResource } from '../../shared/restapi/restapi-resource';

@Component({
  template: `
    <div mdcHeadline3>Home</div>
`
})
export class HomeComponent implements OnInit {

  ngOnInit() {
    /*this.restapiService.configure( '' ).subscribe(( restapiResource: RestapiResource ) => {
        console.log( '>>> restapiResource', restapiResource )
    } );*/
  }

  /*constructor(
      private restapiService: RestapiService ) { }*/

}