import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BngRestapiConfigService } from 'base-angular';

@Injectable()
export class RestapiConfigService extends BngRestapiConfigService {

	getServerUrl(): string {
		return undefined;
	}

	getContextPath(): string {
		return "/cecocloud/api";
	}

	constructor(http: HttpClient) {
		super(http);
	}

}
