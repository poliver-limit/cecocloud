import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BngRestapiConfigService } from '@programari-limit/bang';

@Injectable()
export class RestapiConfigService extends BngRestapiConfigService {

	getContextPath() {
		return "/cecocloud/api";
	}

	constructor(http: HttpClient) {
		super(http);
	}

}
