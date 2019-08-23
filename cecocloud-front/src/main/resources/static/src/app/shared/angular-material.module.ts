import { NgModule } from '@angular/core';
import {
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    MatIconModule,
    MatDatepickerModule,
    MAT_DATE_FORMATS
} from '@angular/material';

import { MomentDateModule } from '@angular/material-moment-adapter';

@NgModule( {
    exports: [
        MatFormFieldModule,
        MatInputModule,
        MatCheckboxModule,
        MatButtonModule,
        MatIconModule,
        MatDatepickerModule,
        MomentDateModule
    ],
    providers: [
        { provide: MAT_DATE_FORMATS, useValue: {
                parse: {
                    dateInput: ['l', 'LL'],
                }, display: {
                    dateInput: 'L',
                    monthYearLabel: 'MMM YYYY',
                    dateA11yLabel: 'LL',
                    monthYearA11yLabel: 'MMMM YYYY',
                }
            }
        }
    ]
} )
export class AngularMaterialModule { }