import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class RegistreService {

    create(codi: string, email: string, nom: string): Observable<any> {
        const params = new HttpParams().
            append('codi', codi).
            append('email', email).
            append('nom', nom);

        const jsn = { 'codi': codi, 'email': email, 'nom': nom };

        return this.http.post('api/registres/create', jsn);
    }

    contrasenyaRecover(email: string): Observable<any> {
        const params = new HttpParams().
            append('email', email);

        return this.http.post('api/registres/' + email + '/reset', params);
    }

    validate(contrasenya: string, contrasenya2: string, token: string): Observable<any> {

        const params = new HttpParams().
            append('contrasenya', contrasenya).
            append('repeticio', contrasenya2).
            append('token', token);


        const jsn = { 'contrasenya': contrasenya, 'repeticio': contrasenya2, 'token': token };

        return this.http.post('api/registres/validate', jsn);

    }

    constructor(
        private http: HttpClient) { }

}
