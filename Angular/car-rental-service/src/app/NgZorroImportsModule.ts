import { NgModule } from "@angular/core";
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzMessageModule  } from 'ng-zorro-antd/message';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';

@NgModule({
    exports: [
        NzSpinModule,
        NzInputModule,
        NzButtonModule,
        NzLayoutModule,
        NzFormModule,
        NzMessageModule,
        NzSelectModule, 
        NzDatePickerModule,
    ]
})

export class NgZorroImportsModule { }