import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FileUploadComponent } from './component/file-upload/file-upload.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from  '@angular/common/http';@NgModule({
  declarations: [
    AppComponent,
    FileUploadComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [FileUploadComponent]
})
export class AppModule { }
