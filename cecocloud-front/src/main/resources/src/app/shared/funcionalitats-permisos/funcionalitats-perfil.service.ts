import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FuncionalitatPerfil extends Resource { }

@Injectable()
export class FuncionalitatsPerfilService extends BngRestapiService<FuncionalitatPerfil> {

    constructor(injector: Injector) {
        super(FuncionalitatPerfil, 'funcionalitatPerfil', injector);
    }

}