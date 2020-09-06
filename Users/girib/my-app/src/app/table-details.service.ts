import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TableDetailsService {
 
  

  constructor(private http:HttpClient) { }

  getTableName():Observable<any> {
    return this.http.get('//localhost:8085/tables')
  }

  getColumnNames(table:String):Observable<any> {
    return this.http.get('//localhost:8085/getColumns/'+table);
  }

  insert(columns: any[],tableName:String):Observable<any> {
    return this.http.post('//localhost:8085/insert/'+tableName,columns,{responseType: 'text'});
  }

}
