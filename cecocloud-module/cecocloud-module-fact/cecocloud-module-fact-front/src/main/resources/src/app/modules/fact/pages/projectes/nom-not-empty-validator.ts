import { FormGroup, ValidatorFn } from '@angular/forms';

export function nomNotEmptyValidator(fieldName: string, nomFieldName: string): ValidatorFn {
  return (group: FormGroup): {[key: string]: any} => {
	const valueField = group.controls[fieldName];
	const nomField = group.controls[nomFieldName];    
	if ((!nomField.value)||(nomField.value=="")) {				
		nomField.setErrors({nomNotEmpty: fieldName});							
		return {'nomNotEmpty': ''};
	} else {
		nomField.setErrors(null);
	}		
	return null;		
  };
}