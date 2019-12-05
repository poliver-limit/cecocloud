import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="operarisService">
		<div style="display: flex">
			<div style="width: 50%; padding-right: 1em">
				<bng-custom-field name="codi"></bng-custom-field>
				<bng-custom-field name="empresa"></bng-custom-field>
				<bng-custom-field name="usuari"></bng-custom-field>
			</div>
			<div style="width: 50%; padding-left: 1em">
				<bng-custom-field name="dataInici"></bng-custom-field>
				<bng-custom-field name="dataFi"></bng-custom-field>
				<bng-custom-field name="codi"></bng-custom-field>
			</div>
		</div>
	</bng-form>
`
} )
export class OperarisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public operarisService: OperarisService ) { }

}