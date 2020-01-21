import { Component, OnInit } from '@angular/core';
import { BngScreenSizeService, BngScreenSizeChangeEvent } from 'base-angular';

@Component({
	template: `
<div *ngIf="!mobileScreen" class="mat-display-3 centered" style="text-align: center">
	<p style="margin:0"><mat-icon inline="true" style="font-size:100px;">cloud_queue</mat-icon></p>
    <p style="margin:.4em">{{'home.salutacio'|translate}}</p>
	<!--div class="example-button-row">
		<button mat-raised-button>Basic</button>&nbsp;
		<button mat-raised-button color="primary">Primary</button>&nbsp;
		<button mat-raised-button color="accent">Accent</button>&nbsp;
		<button mat-raised-button color="warn">Warn</button>&nbsp;
		<button mat-raised-button disabled>Disabled</button>&nbsp;
		<a mat-raised-button routerLink=".">Link</a>
	</div-->
</div>`
})
export class HomeComponent implements OnInit {

	mobileScreen: boolean;

	ngOnInit() {
	}

	constructor(
		private screenSizeService: BngScreenSizeService) {
		// Es subscriu al subject de canvi de tamany de la pantalla
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
	}

}