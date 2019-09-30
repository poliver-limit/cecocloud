import { AfterViewInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { Resource } from 'angular4-hal';
import * as textMask from "vanilla-text-mask/dist/vanillaTextMask.js";

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

export abstract class RestapiBaseFieldComponent implements AfterViewInit, OnDestroy {

	@Input() fieldName: string;
	@Input()
	set formGroup(formGroup: FormGroup) {
		this.internalFormGroup = formGroup;
		this.formControl = <FormControl>this.internalFormGroup.get(this.fieldName);
	}
	@Input()
	set restapiResource(restapiResource: RestapiResource) {
		this.internalRestapiResource = restapiResource;
		restapiResource.fields.forEach((field: RestapiResourceField) => {
			if (field.name == this.fieldName) {
				this.field = field;
			}
		});
		this.label = (this.field.translateKey) ? this.translateKey(this.field.translateKey, {}, this.fieldName) : this.fieldName;
	}
	@Input() resourceInstance: Resource;
	@Input() hideLabel: boolean;

	@Output() click: EventEmitter<Event> = new EventEmitter();
	@Output() input: EventEmitter<Event> = new EventEmitter();
	@Output() change: EventEmitter<Event> = new EventEmitter();

	internalFormGroup: FormGroup;
	internalRestapiResource: RestapiResource;
	formControl: FormControl;
	field: RestapiResourceField;
	label: string;
	translate: TranslateService;
	maskedInputController: any;

	ngAfterViewInit() {
		if (this.getMask()) {
			let nativeElement: any = this.getFieldComponent()['_elementRef'].nativeElement;
			setTimeout(() => {
				this.maskedInputController = textMask.maskInput({
					inputElement: nativeElement,
					mask: this.getMask()
				});
			});
		}
	}
	ngOnDestroy() {
		if (this.getMask()) {
			this.maskedInputController.destroy();
		}
	}

	onFieldClick(event: Event) {
		this.click.emit(event);
	}
	onFieldInput(event: Event) {
		this.input.emit(event);
	}
	onFieldChange(event: Event) {
		this.change.emit(event);
	}

	getMask(): any {
		return undefined;
	}

	focus() {
		if (this.getFieldComponent() && this.getFieldComponent()['focus']) {
			this.getFieldComponent()['focus']();
		}
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		let translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	public abstract setErrors(errors?: any): void;
	public abstract getFieldComponent(): any;

	constructor(
		translate: TranslateService) {
		this.translate = translate;
	}

}
