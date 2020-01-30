import { Component } from "@angular/core";
import { BngFormConfig } from "base-angular";

import { ProjectesService } from "./projectes.service";

@Component({
  templateUrl: 'temp02.html'
})
export class ProjectesFormComponent {
  formConfig: BngFormConfig = {};

  // projecteId: number;

  // onResourceChange(projecte: any) {
  // 	this.projecteId = projecte.codi;
  // }
  constructor(public projectesService: ProjectesService) {}
}
