export class RestapiConfig {

    private serverUrl = location.protocol + '//' + location.host;
    private contextPath = '/cecocloud';

    public getServerUrl() {
        return this.serverUrl;
    }
    public getContextPath() {
        return this.contextPath;
    }
    public getServerUrlAmbContext() {
        return this.serverUrl + this.contextPath;
    }
    public getApiServiceUrl( contextRelativeUri: string ) {
        return this.getServerUrlAmbContext() + contextRelativeUri;
    }

}
