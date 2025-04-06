import { Observable } from "rxjs";
import { DetailClientResponse, ListClientResponse, SaveClientRequest, UpdateClientRequest, UpdateClientResponse } from "./client.model";

export interface IClienteService {

    save(request: SaveClientRequest): Observable<SaveClientRequest>;

    update(id: number, request: UpdateClientRequest): Observable<UpdateClientResponse>;

    delete(id: number): Observable<void>;

    list(): Observable<ListClientResponse[]>;

    findById(id: number): Observable<DetailClientResponse>;
}