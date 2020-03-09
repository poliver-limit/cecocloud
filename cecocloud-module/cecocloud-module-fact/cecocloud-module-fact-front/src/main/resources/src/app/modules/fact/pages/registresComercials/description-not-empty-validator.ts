import { FormGroup, ValidatorFn } from '@angular/forms';

export function descriptionNotEmptyValidator(fieldName: string, descriptionFieldName: string): ValidatorFn {
  return (group: FormGroup): {[key: string]: any} => {
	const valueField = group.controls[fieldName];
	const descriptionField = group.controls[descriptionFieldName];
	
    if 	(
			(valueField.value == 'CERCADOR') ||
			(valueField.value == 'CONEGUT') ||
			(valueField.value == 'FIRA') ||
			(valueField.value == 'PUBLICITAT') ||
			(valueField.value == 'VISITA_COMERCIAL') ||
			(valueField.value == 'REUNIO_DE_TREBALL') ||
			(valueField.value == 'FORMACIO') ||
			(valueField.value == 'ALTRES')
		) {
			if (!descriptionField.value) {				
				descriptionField.setErrors({descriptionNotEmpty: fieldName});							
				return {'descriptionNotEmpty': ''};
			} else {
				descriptionField.setErrors(null);
			}
		} else {
			descriptionField.setErrors(null);
		}
			
		return null;
		
  };
}