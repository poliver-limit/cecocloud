import { Component, OnInit } from '@angular/core';
import { BngScreenSizeService, BngScreenSizeChangeEvent } from 'base-angular';

import { MenuService, MenuItem } from '../../shared/menu.service';

@Component( {
    template: `
    <div *ngIf="!mobileScreen" class="mat-display-3 centered" style="text-align: center">
        <p><mat-icon>cloud_queue</mat-icon></p>
        <p>{{'home.salutacio'|translate}}</p>
    </div>
    <ng-container *ngIf="mobileScreen">
        <p *ngFor="let item of allowedMenuItems" style="text-align:center">
            <a mat-stroked-button [routerLink]="item.route" color="primary" style="margin:1em; width:200px">
                <mat-icon>{{item.icon}}</mat-icon>{{item.label}}
            </a>
        </p>
    </ng-container>
`
} )
export class HomeComponent implements OnInit {

    mobileScreen: boolean;
    allowedMenuItems: MenuItem[];

    ngOnInit() {
        this.allowedMenuItems = this.menuService.getAllowedMenuItems();
    }

    constructor(
        private screenSizeService: BngScreenSizeService,
        private menuService: MenuService ) {
        // Es subscriu al subject de canvi de tamany de la pantalla
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: BngScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}