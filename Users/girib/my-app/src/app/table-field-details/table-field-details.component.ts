import { Component, OnInit } from '@angular/core';
import { TableDetailsService } from '../table-details.service';
import { ActivatedRoute,Router } from '@angular/router';
import { NgForm, FormGroup ,} from '@angular/forms';


@Component({
  selector: 'app-table-field-details',
  templateUrl: './table-field-details.component.html',
  styleUrls: ['./table-field-details.component.css']
})
export class TableFieldDetailsComponent implements OnInit {
  title:String;
  columns:Array<any>;
  tablename:String;

  
  constructor(private tableDetailsService :TableDetailsService,private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
      this.tablename =this.router.snapshot.paramMap.get('table');
      this.title = this.tablename+ ' DETAILS'; 
      this.tableDetailsService.getColumnNames(this.tablename).subscribe(result=>{
      this.columns =result;
      }),error=>console.error(error);
    
  }

 

  createNew(form:NgForm):void{
     
    this.tableDetailsService.insert(this.columns,this.tablename).subscribe(result=>{
      if(result == 'Success'){
        alert(result + " : Inserted Successfully");
      }else{
        alert(result + " : Already Existing Record");
     }
     this.route.navigate(['/tables']);
    }),error=>console.error(error);
  }

}
