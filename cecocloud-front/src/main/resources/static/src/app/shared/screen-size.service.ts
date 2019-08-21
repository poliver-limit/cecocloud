import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export class ScreenSizeChangeEvent {
    width: number;
    mobile: boolean;
}

@Injectable( {
    providedIn: 'root'
} )
export class ScreenSizeService {

    private static readonly SMALL_SCREEN_WIDTH: number = 900;
    private screenSizeChangeSubject = new Subject<ScreenSizeChangeEvent>();
    public mobile: boolean = false;

    public isMobile() {
        return this.mobile;
    }

    public onWindowResize( windowWidth: number ) {
        this.mobile = windowWidth <= ScreenSizeService.SMALL_SCREEN_WIDTH;
        this.screenSizeChangeSubject.next( {
            width: windowWidth,
            mobile: this.mobile
        } );
    }

    public getScreenSizeChangeSubject(): Subject<ScreenSizeChangeEvent> {
        return this.screenSizeChangeSubject;
    }

}
