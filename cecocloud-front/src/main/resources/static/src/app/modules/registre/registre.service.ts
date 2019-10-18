import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class RegistreService {

	create(formGroup: FormGroup): Observable<any> {
		return this.http.post(
			'api/registres/create', {
				nom: formGroup.value.nom,
				email: formGroup.value.email
			}
		);
	}

	validate(token: string, formGroup: FormGroup): Observable<any> {
		return this.http.post(
			'api/registres/validate', {
				token: token,
				contrasenya: formGroup.value.contrasenya,
				repeticio: formGroup.value.repeticio
			}
		);
	}

	recover(email: string): Observable<any> {
		return this.http.post(
			'api/registres/' + email + '/reset',
			new HttpParams().append('email', email));
	}

	constructor(
	    private http: HttpClient) {
	}

}