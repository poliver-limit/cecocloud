import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BngRestapiConfigService } from 'base-angular';

@Injectable( {
    providedIn: 'root'
} )
export class RestapiConfigService extends BngRestapiConfigService {

	contextPath: string;

	getServerUrl() {
        return "http://localhost:8080";
	}
	getContextPath() {
		return "/api";
	}

	constructor(http: HttpClient) {
		super(http);
	}

}
