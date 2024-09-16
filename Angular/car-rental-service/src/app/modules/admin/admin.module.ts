import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { PostCarComponent } from './components/post-car/post-car.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgZorroImportsModule } from 'src/app/NgZorroImportsModule';
import { UpdateCarComponent } from './components/update-car/update-car.component';


@NgModule({
  declarations: [
    AdminDashboardComponent,
    PostCarComponent,
    UpdateCarComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgZorroImportsModule,
  ]
})
export class AdminModule { }
