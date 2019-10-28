import { NgModule } from '@angular/core';
import {
	MatFormFieldModule,
	MatInputModule,
	MatSelectModule,
	MatCheckboxModule,
	MatButtonModule,
	MatIconModule,
	MatDatepickerModule,
	MatProgressSpinnerModule,
	MatAutocompleteModule,
	MAT_DATE_FORMATS
} from '@angular/material';
import {
	MdcButtonModule,
	MdcDialogModule,
	MdcIconModule,
	MdcIconButtonModule,
	MdcListModule,
	MdcSnackbarModule,
	MdcTabBarModule,
    MdcTopAppBarModule,
	MdcDrawerModule,
	MdcMenuModule,
	MdcTextFieldModule,
	MdcTypographyModule
} from '@angular-mdc/web';

import { MomentDateModule } from '@angular/material-moment-adapter';

@NgModule( {
    exports: [
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatCheckboxModule,
        MatButtonModule,
        MatIconModule,
        MatDatepickerModule,
        MatProgressSpinnerModule,
        MatAutocompleteModule,
		MdcButtonModule,
		MdcDialogModule,
		MdcIconModule,
		MdcIconButtonModule,
		MdcListModule,
		MdcSnackbarModule,
		MdcTabBarModule,
		MdcTopAppBarModule,
		MdcDrawerModule,
		MdcMenuModule,
		MdcTextFieldModule,
		MdcTypographyModule,
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
export class MaterialModule { }