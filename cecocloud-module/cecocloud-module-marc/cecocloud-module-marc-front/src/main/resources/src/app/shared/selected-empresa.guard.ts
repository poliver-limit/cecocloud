import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
	providedIn: 'root',
})
export class SelectedEmpresaGuard implements CanActivate {

	canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
		return true;
	}

}
