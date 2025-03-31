import { IClienteService } from "./api-client/clients/iclients.service";
import { InjectionToken } from '@angular/core'
import { ISnackbarManagerService } from "./isnackbar-manager.service";

export const SERVICES_TOKEN = {
    HTTP: {
        CLIENT: new InjectionToken<IClienteService>('SERVICES_TOKEN.HTTP.CLIENT'),
        //SCHEDULE: new InjectionToken<IScheduleService>('SERVICES_TOKEN.HTTP.CLIENT')
    },
    
        SNACKBAR: new InjectionToken<ISnackbarManagerService>('SERVICES_TOKEN.SNACKBAR')
    
}