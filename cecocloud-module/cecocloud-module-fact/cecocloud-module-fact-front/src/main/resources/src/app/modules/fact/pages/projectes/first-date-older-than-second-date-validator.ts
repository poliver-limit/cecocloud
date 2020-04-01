import { FormGroup, ValidatorFn } from '@angular/forms';

export function firstDateOlderThanSecondDate(firstDateFieldName: string, secondDateFieldName: string): ValidatorFn {
  return (group: FormGroup): {[key: string]: any} => {
	const firstDate = group.controls[firstDateFieldName];
	const secondDate = group.controls[secondDateFieldName];	
	
    if 	(new Date(firstDate.value) > new Date(secondDate.value)) {			
			firstDate.setErrors({secondDateOlder: firstDateFieldName});	
			secondDate.setErrors({secondDateOlder: secondDateFieldName});							
			return {'secondDateOlder': ''};			
		} else {			
			firstDate.setErrors(null);
			secondDate.setErrors(null);
			return null;					
		}	
		
  };
}