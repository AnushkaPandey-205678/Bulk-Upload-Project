import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {
  file: any;
  fileUploadUrl = "http://localhost:8080/booking/upload";

  constructor(private _http: HttpClient) { }

  onFileChange(event: any): void {
    this.file = event.target.files[0];
  }

  uploadFile(): void {
    let formData = new FormData();
    formData.append("File", this.file);
  
    this._http.post(this.fileUploadUrl, formData).subscribe(
      (res: any) => {
        if (res) {
          console.log("response data: ", res);
          alert("File is uploaded successfully");
        }
      },
      (error: any) => {
        if (error.status === 400 && error.error) {
          // Handle validation errors
          const validationErrors = error.error;
          Object.keys(validationErrors).forEach(fieldName => {
            alert(`${fieldName}: ${validationErrors[fieldName]}`);
          });
        } else {
          // Handle other types of errors
          alert("An unexpected error occurred: " + JSON.stringify(error));
        }
      }
    );
  }

  
}  