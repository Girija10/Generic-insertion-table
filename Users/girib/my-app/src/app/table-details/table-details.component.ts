import { Component, OnInit } from '@angular/core';
import {TableDetailsService} from '../table-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table-details',
  templateUrl: './table-details.component.html',
  styleUrls: ['./table-details.component.css']
})
export class TableDetailsComponent implements OnInit {
title = 'TABLES LIST';

tables : Array<String>;
  constructor(private tableDetailsService :TableDetailsService,private router:Router) { }

  ngOnInit(): void {
    this.tableDetailsService.getTableName().subscribe(data=>{
     this.tables = data;
    })
  }

  onSelect(table: String): void {
    this.router.navigate(['/table-fields/'+table]);
  }

}
