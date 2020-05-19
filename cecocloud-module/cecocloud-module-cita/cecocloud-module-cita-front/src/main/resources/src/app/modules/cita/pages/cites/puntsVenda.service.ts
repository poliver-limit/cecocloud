import { Injectable, Injector } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestapiResource, BngRestapiService } from 'base-angular';

export class PuntVenda extends RestapiResource {}

@Injectable()
export class PuntsVendaService extends BngRestapiService<PuntVenda> {

	rangHorari(id: any, dataInici: Date, dataFi: Date): Observable<Object> {
		let params: HttpParams = new HttpParams().
			set('dataInici', this.dateAsStr(dataInici)).
			set('dataFi', this.dateAsStr(dataFi));
		return this.getHttpClient().get(this.getApiBaseUrl('/' + id + '/rangHorari'), { params: params });
	}

	private dateAsStr(date: Date) {
		return date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');
	}

    constructor( injector: Injector ) {
        super( PuntVenda, 'puntVenda', injector, 'cita' );
    }

}