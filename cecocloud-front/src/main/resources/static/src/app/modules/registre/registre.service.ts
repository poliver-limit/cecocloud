import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable( {
    providedIn: 'root',
} )
export class RegistreService {

    constructor(
        private http: HttpClient) { }

}
