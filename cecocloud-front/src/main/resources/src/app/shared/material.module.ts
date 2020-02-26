import { NgModule } from '@angular/core';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatBadgeModule } from '@angular/material/badge';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';

import { MomentDateModule } from '@angular/material-moment-adapter';

@NgModule( {
    exports: [
		MatToolbarModule,
		MatSidenavModule,
		MatMenuModule,
		MatListModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatCheckboxModule,
        MatButtonModule,
        MatIconModule,
        MatDatepickerModule,
		MatSnackBarModule,
        MatProgressSpinnerModule,
        MatAutocompleteModule,
		MatDialogModule,
		MatCardModule,
		MatTabsModule,
		MatBadgeModule,
		MatExpansionModule,
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