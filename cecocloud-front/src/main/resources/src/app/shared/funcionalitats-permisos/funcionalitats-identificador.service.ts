import { Injectable, Injector } from '@angular/core';
import { Resource, HalParam } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';
import { Observable } from 'rxjs';

export class FuncionalitatIdentificador extends Resource { }

@Injectable()
export class FuncionalitatsIdentificadorService extends BngRestapiService<FuncionalitatIdentificador> {

    constructor(injector: Injector) {
        super(FuncionalitatIdentificador, 'funcionalitatIdentificador', injector);
    }

    // public getFuncionalitatsByModul(modul: string): Observable<FuncionalitatIdentificador[]> {
    //     let requestParams: HalParam[] = [];
    //     requestParams.push({
    //         key: 'query',
    //         value: 'funcionalitat.modul==' + modul
    //     });

    //     return this.getAll({ params: requestParams });
    //     // return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadors' + codi);
    // }
}