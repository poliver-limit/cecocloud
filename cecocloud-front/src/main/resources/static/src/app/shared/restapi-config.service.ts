import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BngRestapiConfigService } from 'base-angular';

@Injectable()
export class RestapiConfigService extends BngRestapiConfigService {

	getContextPath() {
		return "/cecocloud/api";
	}

	constructor(http: HttpClient) {
		super(http);
	}

}
