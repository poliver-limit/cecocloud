import { Component, OnInit } from '@angular/core';

import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';
import { MenuService, MenuItem } from '../../shared/menu.service';

@Component( {
    template: `
    <div *ngIf="!mobileScreen" class="centered" style="text-align: center">
        <div><mdc-icon style="font-size:200px">cloud_queue</mdc-icon></div>
        <div mdcHeadline2>{{'home.salutacio'|translate}}</div>
    </div>
    <ng-container *ngIf="mobileScreen">
        <p *ngFor="let item of allowedMenuItems" style="text-align:center">
            <a mdc-button [routerLink]="item.route" style="margin:1em; width:200px">
                <mdc-icon>{{item.icon}}</mdc-icon>{{item.label}}
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
        private screenSizeService: ScreenSizeService,
        private menuService: MenuService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        // Es subscriu al subject de canvi de tamany de la pantalla
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}