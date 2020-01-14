import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RolsService } from './rols.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="rolsService">
        <ng-container *ngIf="id">
            <cec-recursos
                [rol] = "id">
            </cec-recursos>
        </ng-container>
    </bng-form>
`
})
export class RolsFormComponent { //implements OnInit {

	id: any;
	formConfig: BngFormConfig = {}
	recursos: any;

	// ngOnInit(): void {
	//     this.recursosSetvice.getRecursosByRol(this.id).subscribe((recursos) => {
	//         console.log("RecursosRol: ", recursos);
	//         this.recursos = recursos;
	//     });
	// }

	constructor(
		activatedRoute: ActivatedRoute,
		public rolsService: RolsService) {
		// public recursosSetvice: RecursosService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
		});
	}

}