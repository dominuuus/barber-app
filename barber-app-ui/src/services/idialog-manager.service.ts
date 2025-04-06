import { ComponentType } from "@angular/cdk/portal";
import { Observable } from "rxjs";
import { ConfirmDialogComponent } from "../app/commons/components/confirm-dialog/confirm-dialog.component";


export interface IDialogManagerService {

    showYesNoDialog(component: ComponentType<ConfirmDialogComponent>, data: { title: string, content: string }): Observable<any>

}