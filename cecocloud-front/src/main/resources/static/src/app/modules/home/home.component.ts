import { Component } from '@angular/core';

@Component( {
    template: `
    <div class="centered" style="text-align: center">
        <div><mdc-icon style="font-size:200px">cloud_queue</mdc-icon></div>
        <div mdcHeadline2>{{'home.salutacio'|translate}}</div>
    </div>
`
} )
export class HomeComponent {

}