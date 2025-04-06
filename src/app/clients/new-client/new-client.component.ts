import { Component, Inject, OnDestroy } from '@angular/core';
import { IClienteService } from '../../../services/api-client/clients/iclients.service';
import { SERVICES_TOKEN } from '../../../services/service.tokes';
import { ClientsService } from '../../../services/api-client/clients/clients.service';
import { ClientFormComponent } from "../components/client-form/client-form.component";
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { ClientModelForm } from '../client.model';
import { ISnackbarManagerService } from '../../../services/isnackbar-manager.service';
import { SnackbarManagerService } from '../../../services/snackbar-manager.service';

@Component({
  selector: 'app-new-client',
  imports: [ClientFormComponent],
  templateUrl: './new-client.component.html',
  styleUrl: './new-client.component.scss',
  providers: [
    {provide: SERVICES_TOKEN.HTTP.CLIENT, useClass: ClientsService},
    {provide: SERVICES_TOKEN.SNACKBAR, useClass: SnackbarManagerService}
  ]
})
export class NewClientComponent implements OnDestroy {

  private HttpSubscription?: Subscription

  constructor(@Inject(SERVICES_TOKEN.HTTP.CLIENT) private readonly httpService: IClienteService,
              @Inject(SERVICES_TOKEN.SNACKBAR) private readonly snackBarManager: ISnackbarManagerService,
              private readonly router: Router) {}

  ngOnDestroy(): void {
    if(this.HttpSubscription) {
      this.HttpSubscription.unsubscribe()
    }
  }

  onSubmitClient(value: ClientModelForm) {
    const { id, ...request } = value
    this.httpService.save(request).subscribe(_ => {
      this.snackBarManager.show("Usuário cadastrado com sucesso")
      this.router.navigate(['clients/list'])
    })
  }
}
