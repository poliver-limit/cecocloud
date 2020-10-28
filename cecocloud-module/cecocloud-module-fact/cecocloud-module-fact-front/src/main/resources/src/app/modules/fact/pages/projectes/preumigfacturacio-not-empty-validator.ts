import { FormGroup, ValidatorFn } from '@angular/forms';

export function preumigfacturacioNotEmptyValidator(fieldName: string, preumigfacturacioFieldName: string): ValidatorFn {
  return (group: FormGroup): {[key: string]: any} => {
	const valueField = group.controls[fieldName];
	const preumigfacturacioField = group.controls[preumigfacturacioFieldName];	
    if 	(
			(valueField.value == 'IMPUTA')
		) {
			if ((!preumigfacturacioField.value)||(preumigfacturacioField.value==0)) {				
				preumigfacturacioField.setErrors({preumigfacturacioNotEmpty: fieldName});							
				return {'preumigfacturacioNotEmpty': ''};
			} else {
				preumigfacturacioField.setErrors(null);
			}
		} else {
			preumigfacturacioField.setErrors(null);
		}
			
		return null;
		
  };
}