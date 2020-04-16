import { FormGroup, ValidatorFn } from '@angular/forms';

export function nifValidator(fieldName: string): ValidatorFn {
  return (group: FormGroup): {[key: string]: any} => {
	const valueField = group.controls[fieldName];	
	var dni = valueField.value;
	if (dni!=undefined && dni!="") {
		var lockup = 'TRWAGMYFPDXBNJZSQVHLCKE';
		var valueDni:any = dni.substr(0,dni.length-1);
		var letra = dni.substr(dni.length-1,1).toUpperCase(); 
		if(lockup.charAt(valueDni % 23)!=letra) {
			valueField.setErrors({nifValidatorError: fieldName});		
			return {'nifValidator': ''};
		} else {
			valueField.setErrors(null);
		}
	} else {
		valueField.setErrors(null);
	}
	return null;		
  };
}