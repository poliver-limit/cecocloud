
export class RestapiProfile {
    alps: any;
    resource: any;
    _links: {
        self: {
            href: string;
        };
        api: {
            href: string;
        }
    };
}

export class RestapiResource {
    name: string;
    translateKey?: string;
    translateKeyPlural?: string;
    descriptionField?: string;
    quickFilterAvailable?: boolean;
    fields: RestapiResourceField[];
    grids?: RestapiResourceGrid[];
}

export class RestapiResourceField {
    name: string;
    type: string;
    translateKey?: string;
    required?: boolean;
    multiple?: boolean;
    minLength?: number;
    maxLength?: number;
    decimalMinLength?: number;
    decimalMaxLength?: number;
    disabledForCreate?: boolean;
    disabledForUpdate?: boolean;
    hiddenInGrid?: boolean;
    hiddenInForm?: boolean;
    hiddenInLov?: boolean;
    toUpperCase?: boolean;
    enumValues?: string[];
    enumDescriptions?: string;
    enumTranslateKeyPrefix?: string;
    lovResourceName?: string;
    lovDescriptionField?: string;
    lovDescriptionFieldInFront?: string;
    lovParentField?: string;
    lovWithDescriptionInput?: boolean;
    width?: number;
}

export class RestapiResourceGrid {
    name: string;
    translateKey: string;
    resourceName: string;
}