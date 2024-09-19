import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerDashboardComponent } from './component/customer-dashboard/customer-dashboard.component';
import { BookCarComponent } from './component/book-car/book-car.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgZorroImportsModule } from 'src/app/NgZorroImportsModule';
import { MyBookingsComponent } from './component/my-bookings/my-bookings.component';
import { SearchCarComponent } from './component/search-car/search-car.component';


@NgModule({
  declarations: [
    CustomerDashboardComponent,
    BookCarComponent,
    MyBookingsComponent,
    SearchCarComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgZorroImportsModule
  ]
})
export class CustomerModule { }
