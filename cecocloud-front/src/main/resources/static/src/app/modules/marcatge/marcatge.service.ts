import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class MarcatgeService {

    consultarEmpresas(): Observable<any> {
        const headers = new HttpHeaders().
            append('Authorization', 'Bearer' + localStorage.getItem("token"));

        return this.http.get('api/mobile/marcatges/empreses', { headers: headers });
    }

    //-------------------------------

    consultarMarcatges(empresaId: string, data: string) {
        const headers = new HttpHeaders().
            append('Authorization', 'Bearer' + localStorage.getItem("token"));
        let params = new HttpParams().
        append('empresaId', empresaId).
        append('data', data);        

        return this.http.get('api/mobile/marcatges', { headers: headers,params});
    }

    //-------------------------------

    createMarcatge(data: string, id: string) {
        const headers = new HttpHeaders().
            append('Authorization', 'Bearer' + localStorage.getItem("token"));
        let json = { 'data': data, 'empresa': { 'id': id } };
        let params = json;


        return this.http.post('api/mobile/marcatges', params, { headers: headers });
    }

    //-------------------------------

    constructor(
        private http: HttpClient) { }

}
