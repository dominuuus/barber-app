import { Component, EventEmitter, Inject, Input, Output, ViewChild, SimpleChanges } from '@angular/core';
import { ClientModelTable } from '../../client.model';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorIntl, MatPaginatorModule } from '@angular/material/paginator';
import { MatTooltipModule } from '@angular/material/tooltip';
import { SERVICES_TOKEN } from '../../../../services/service.tokes';
import { DialogManagerService } from '../../../../services/dialog-manager.service';
import { CustomPaginator } from './custom-paginator'; 
import { IDialogManagerService } from '../../../../services/idialog-manager.service';
import { Subscription } from 'rxjs';
import { ConfirmDialogComponent } from '../../../commons/components/confirm-dialog/confirm-dialog.component';



@Component({
  selector: 'app-client-table',
  imports: [MatTableModule, MatButtonModule, MatIconModule, MatPaginatorModule, MatTooltipModule],
  templateUrl: './client-table.component.html',
  styleUrl: './client-table.component.scss',
  providers: [
    { provide: SERVICES_TOKEN.DIALOG, useClass: DialogManagerService },
    { provide: MatPaginatorIntl, useClass: CustomPaginator }
  ]
})
export class ClientTableComponent {

  @Input() clients: ClientModelTable[] = [];

  dataSource!: MatTableDataSource<ClientModelTable>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = ['name', 'email', 'phone', 'actions'];
  private dialogManagerServiceSubscriptions?: Subscription;

  @Output() onConfirmDelete = new EventEmitter<ClientModelTable>()

  @Output() onRequestUpdate = new EventEmitter<ClientModelTable>()

  constructor(
    @Inject(SERVICES_TOKEN.DIALOG) private readonly dialogManagerService: IDialogManagerService,
  ) { }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator
  }
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['clients'] && this.clients) {
      this.dataSource = new MatTableDataSource<ClientModelTable>(this.clients)
      if (this.paginator) {
        this.dataSource.paginator = this.paginator
      }
    }
  }
  ngOnDestroy(): void {
    if (this.dialogManagerServiceSubscriptions) {
      this.dialogManagerServiceSubscriptions.unsubscribe()
    }
  }

  formatPhone(phone: string) {
    return `( ${phone.substring(0, 2)} ) ${phone.substring(2, 7)} - ${phone.substring(7)}`
  }

  update(client: ClientModelTable) {
    this.onRequestUpdate.emit(client)
  }

  delete(client: ClientModelTable) {
    this.dialogManagerService.showYesNoDialog(
      ConfirmDialogComponent,
      { title: 'Exclusão de cliente', content: `Confirma a exclusão do cliente ${client.name}` }
    )
      .subscribe(result => {
        if (result) {
          this.onConfirmDelete.emit(client)
          const updatedList = this.dataSource.data.filter(c => c.id !== client.id)
          this.dataSource = new MatTableDataSource<ClientModelTable>(updatedList)
        }
      })
  }

}
