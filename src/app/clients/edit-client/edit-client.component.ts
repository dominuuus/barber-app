import { Component, Inject } from '@angular/core';
import { IClienteService } from '../../../services/api-client/clients/iclients.service';
import { SERVICES_TOKEN } from '../../../services/service.tokes';
import { ClientService } from '../../../services/api-client/clients/clients.service';


@Component({
  selector: 'app-edit-client',
  imports: [],
  templateUrl: './edit-client.component.html',
  styleUrl: './edit-client.component.scss',
  providers: [
    {provide: SERVICES_TOKEN.HTTP.CLIENT, useClass: ClientService}
  ]
})
export class EditClientComponent {
  constructor(@Inject(SERVICES_TOKEN.HTTP.CLIENT) private readonly httpService: IClienteService) {}
}
