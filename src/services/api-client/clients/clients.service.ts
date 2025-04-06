import { Injectable } from "@angular/core";
import { IClienteService } from "./iclients.service";
import { Observable } from "rxjs";
import { SaveClientRequest, UpdateClientResponse, ListClientResponse, DetailClientResponse, SaveClientResponse } from "./client.model";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../../environment/environment";

@Injectable({
    providedIn: 'root'
})

export class ClientsService implements IClienteService {

    private readonly basePath = environment.apiUrl

    constructor(private http: HttpClient) {}

    save(request: SaveClientRequest): Observable<SaveClientRequest> {
        return this.http.post<SaveClientResponse>(`${this.basePath}clients`, request);
    }
    update(id: number, request: UpdateClientResponse): Observable<UpdateClientResponse> {
        return this.http.put<UpdateClientResponse>(`${this.basePath}clients/${id}`, request);
    }
    delete(id: number): Observable<void> {
        return this.http.delete<void>(`${this.basePath}clients/${id}`);
    }
    list(): Observable<ListClientResponse[]> {
        return this.http.get<ListClientResponse[]>(`${this.basePath}clients`);
    }
    findById(id: number): Observable<DetailClientResponse> {
        return this.http.get<DetailClientResponse>(`${this.basePath}clients/${id}`);
    }


}