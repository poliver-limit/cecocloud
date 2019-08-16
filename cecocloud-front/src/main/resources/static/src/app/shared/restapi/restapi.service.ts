import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Observable, EMPTY, of } from 'rxjs';
import { RestService, Resource, HalParam } from 'angular4-hal';

import { RestapiConfigService } from './restapi-config.service';
import { RestapiProfile, RestapiResourceInfo } from './restapi-profile';

@Injectable()
export class RestapiService<T extends Resource> extends RestService<T> {

    private profile: RestapiProfile;
    private profileObservable: Observable<RestapiProfile>

    private restapiConfigService: RestapiConfigService;
    private httpClient: HttpClient;
    private formBuilder: FormBuilder;

    public getProfile(): Observable<RestapiProfile> {
        if ( this.profile ) {
            return new Observable(( observer ) => {
                observer.next( this.profile );
                observer.complete();
            } );
        } else {
            return this.profileObservable;
        }
    }
    public whenReady(): Observable<RestapiProfile> {
        return this.getProfile();
    }

    public static transformToHalParams( paramsObject: any ): HalParam[] {
        let halParams: HalParam[] = [];
        for ( var property in paramsObject ) {
            if ( paramsObject.hasOwnProperty( property ) ) {
                halParams.push( { key: property, value: paramsObject[property] } );
            }
        }
        return halParams;
    }

    public createFormGroup( resourceInstance: any, resourceInfo: RestapiResourceInfo, isCreate: boolean ): FormGroup {
        let formControls = {};
        for ( let field of resourceInfo.fields ) {
            let value;
            if ( resourceInstance ) {
                value = resourceInstance[field.name];
            }
            if ( value && field.type == 'DATE' ) {
                value = this.formatDateForFormGroup( value );
            }
            if ( value && field.type == 'DATETIME' ) {
                value = this.formatDateForFormGroup( value, true );
            }
            let validators = [];
            if ( field.minLength ) {
                validators.push( Validators.minLength( field.minLength ) );
            }
            if ( field.maxLength ) {
                validators.push( Validators.maxLength( field.maxLength ) );
            }
            if ( field.required ) {
                validators.push( Validators.required );
            }
            let fieldDisabled = ( isCreate ) ? field.disabledForCreate : field.disabledForUpdate;
            formControls[field.name] = [{ value: value, disabled: fieldDisabled }, validators];
        }
        return this.formBuilder.group( formControls );
    }

    public generateGetParamsWithParent( id: any, parent?: any ): string {
        let urlParams = '';
        if ( parent ) {
            urlParams = '?' + JSON.stringify( parent ).replace( /\"|\}|\{/g, '' ).replace( /\:/g, '=' ).replace( /\,/g, '&' );
        }
        return id + urlParams;
    }

    public configureWithResourceName( resourceName: string ) {
        if ( resourceName ) {
            this.profileObservable = new Observable(( observer ) => {
                this.httpClient.get( this.restapiConfigService.getContextRelativeUrl( '/profiles/' + resourceName ) ).subscribe(( profile: RestapiProfile ) => {
                    this.profile = profile;
                    let apiHref = profile._links.api.href;
                    let keyIndex = apiHref.lastIndexOf( '{' )
                    if ( keyIndex != -1 ) {
                        apiHref = apiHref.substring( 0, keyIndex );
                    }
                    let apiResource = apiHref.substring( apiHref.lastIndexOf( '/' ) + 1 );
                    this['resource'] = apiResource;
                    observer.next( this.profile );
                    observer.complete();
                } );
            } );
        }
    }

    public formatDateForFormGroup( value: string, isTimestamp?: boolean ) {
        let dateSeparator = '-';
        let timeSeparator = ':';
        let dateValue = new Date( value );
        let dateStr = dateValue.getFullYear() + dateSeparator +
            ( this.numberWithPadding( dateValue.getMonth() + 1, 2 ) ) + dateSeparator +
            this.numberWithPadding( dateValue.getDate(), 2 );
        if ( isTimestamp ) {
            return dateStr + 'T' +
                this.numberWithPadding( dateValue.getHours(), 2 ) + timeSeparator +
                this.numberWithPadding( dateValue.getMinutes(), 2 ) + timeSeparator +
                this.numberWithPadding( dateValue.getSeconds(), 2 );
        } else {
            return dateStr;
        }
    }
    private numberWithPadding( n, width, z?) {
        z = z || '0';
        n = n + '';
        return n.length >= width ? n : new Array( width - n.length + 1 ).join( z ) + n;
    }

    constructor(
        type: { new(): T; },
        resourceName: string,
        injector: Injector ) {
        super( type, 'unknown', injector );
        this.restapiConfigService = <RestapiConfigService>injector.get( RestapiConfigService );
        this.httpClient = <HttpClient>injector.get( HttpClient );
        this.formBuilder = <FormBuilder>injector.get( FormBuilder );
        this.configureWithResourceName( resourceName );
    }

}