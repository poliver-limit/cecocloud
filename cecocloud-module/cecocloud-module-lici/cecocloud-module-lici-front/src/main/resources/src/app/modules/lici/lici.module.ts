import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { BngAuthGuard, BngModuleService } from "base-angular";

import { SelectedEmpresaGuard } from "../../shared/selected-empresa.guard";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
      {
        path: "lici",
        canActivate: [BngAuthGuard, SelectedEmpresaGuard],
        children: [
          {
            path: "",
            loadChildren: () =>
              import("./pages/index/index-lici.module").then(
                m => m.IndexLiciModule
              )
          },
          {
            path: "configuracions",
            loadChildren: () =>
              import("./pages/configuracions/configuracions.module").then(
                m => m.ConfiguracionsModule
              )
          },
          {
            path: "licitacions",
            loadChildren: () =>
              import("./pages/licitacions/licitacions.module").then(
                m => m.LicitacionsModule
              )
          },
          {
            path: "**",
            redirectTo: ""
          }
        ]
      }
    ])
  ]
})
export class LiciModule {
  constructor(moduleService: BngModuleService) {
    moduleService.register({
      code: "lici",
      icon: "folder_special",
      label: "Licitacions",
      menuItems: [
        {
          icon: "room",
          label: "Configuracions",
          labelKey: "app.menu.lici.configuracions",
          route: "/lici/configuracions",
          resource: 'LIC_CONFIG'
        },
        {
          icon: "room",
          label: "Licitacions",
          labelKey: "app.menu.lici.licitacions",
          route: "/lici/licitacions",
          resource: 'LIC_LICITA'
        }
      ]
    });
  }
}
