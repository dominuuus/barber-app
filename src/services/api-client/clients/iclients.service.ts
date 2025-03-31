import { Observable } from "rxjs";
import { DetailClientResponse, ListClientResponse, SaveClientRequest, UpdateClientResponse } from "./client.model";

export interface IClienteService {

    save(request: SaveClientRequest): Observable<SaveClientRequest>;

    updade(id: number, request: UpdateClientResponse): Observable<UpdateClientResponse>;

    delete(id: number): Observable<void>;

    list(): Observable<ListClientResponse[]>;

    findById(id: number): Observable<DetailClientResponse>;
}