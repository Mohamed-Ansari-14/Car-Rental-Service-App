import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from 'src/app/auth/service/storage/storage.service';

const BASE_URL = ["http://localhost:8080"];

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(
    private http: HttpClient,
  ) { }

  getAllCars(): Observable<any> {
    return this.http.get(`${BASE_URL}/api/customer/cars`, {
      headers: this.createAuthorization()
    });
  }

  getCarById(carId: number): Observable<any> {
    return this.http.get(`${BASE_URL}/api/customer/car/${carId}`, {
      headers: this.createAuthorization()
    });
  }

  bookACar(bookACarDto: any): Observable<any> {
    return this.http.post(`${BASE_URL}/api/customer/car/book`, bookACarDto, {
      headers: this.createAuthorization()
    });
  }

  getBookingsByUserId(): Observable<any> {
    const userId = StorageService.getUserId();
    return this.http.get(`${BASE_URL}/api/customer/car/bookings/${userId}`, {
      headers: this.createAuthorization()
    });
  }

  searchCar(SearchCarDto: any): Observable<any> {
    return this.http.post(`${BASE_URL}/api/customer/car/search`, SearchCarDto, {
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
