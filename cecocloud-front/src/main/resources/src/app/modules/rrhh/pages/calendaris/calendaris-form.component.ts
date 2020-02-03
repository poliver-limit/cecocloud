import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { CalendarisService } from './calendaris.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="calendarisService"></bng-form>
`
} )
export class CalendarisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public calendarisService: CalendarisService ) { }

}