import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export class ScreenSizeChangeEvent {
    width: number;
    small: boolean;
}

@Injectable( {
    providedIn: 'root'
} )
export class ScreenSizeService {

    private static readonly SMALL_SCREEN_WIDTH: number = 900;
    private screenSizeChangeSubject = new Subject<ScreenSizeChangeEvent>();
    public small: boolean = false;

    public isSmall() {
        return this.small;
    }

    public onWindowResize( windowWidth: number ) {
        this.small = windowWidth <= ScreenSizeService.SMALL_SCREEN_WIDTH;
        this.screenSizeChangeSubject.next( {
            width: windowWidth,
            small: this.small
        } );
    }

    public getScreenSizeChangeSubject(): Subject<ScreenSizeChangeEvent> {
        return this.screenSizeChangeSubject;
    }

}
