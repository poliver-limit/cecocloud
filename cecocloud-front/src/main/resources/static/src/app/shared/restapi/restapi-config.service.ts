import { Injectable } from '@angular/core';
import { ExternalConfigurationHandlerInterface, ExternalConfiguration } from 'angular4-hal';
import { HttpClient } from '@angular/common/http';

import { RestapiConfig } from './restapi-config';

@Injectable()
export class RestapiConfigService implements ExternalConfigurationHandlerInterface {

    private serverUrl = location.protocol + '//' + location.host;
    private contextPath = '/cecocloud/api';

    getContextRelativeUrl( contextRelativeUri: string ) {
        return this.serverUrl + this.contextPath + contextRelativeUri;
    }

    getProxyUri(): string {
        return '';
    }

    getRootUri(): string {
        return this.serverUrl + this.contextPath;
    }

    getHttp(): HttpClient {
        return this.http;
    }

    getExternalConfiguration(): ExternalConfiguration {
        return null;
    }

    setExternalConfiguration( externalConfiguration: ExternalConfiguration ) {
    }

    deserialize() { }
    serialize() { }

    constructor( private http: HttpClient ) { }

}