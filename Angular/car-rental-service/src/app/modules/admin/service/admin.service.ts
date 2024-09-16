import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from 'src/app/auth/service/storage/storage.service';

const BASE_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(
    private http: HttpClient,
  ) { }

  postCar(carDto: any): Observable<any> {
    return this.http.post(`${BASE_URL}/api/admin/car`, carDto, {
      headers: this.createAuthorization()
    });
  }

  getAllCars(): Observable<any> {
    return this.http.get(`${BASE_URL}/api/admin/cars`, {
      headers: this.createAuthorization()
    });
  }

  deleteCar(id: number): Observable<any> {
    return this.http.delete(`${BASE_URL}/api/admin/car/${id}`, {
      headers: this.createAuthorization()
    });
  }

  getCarById(id: number): Observable<any> {
    return this.http.get(`${BASE_URL}/api/admin/car/${id}`, {
      headers: this.createAuthorization()
    });
  }

  updateCar(carId: number,carDto: any): Observable<any> {
    return this.http.put(`${BASE_URL}/api/admin/car/${carId}`, carDto, {
      headers: this.createAuthorization()
    });
  }

  createAuthorization(): HttpHeaders{
    let authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization',
      'Bearer ' + StorageService.getToken()
    );
  }
}
