import { Component, OnInit } from '@angular/core';
import { TramsService } from './_services/trams.service';
import { Tram } from './_dtos/Tram';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  model: any = {};
  trams: Tram[];
  tramsByLine: any[];
  lines: number;

  lat = 52.229676;
  lon = 21.012229;
  latitude: any;
  longitude: any;

  constructor(private tramsService: TramsService) {}

  ngOnInit() {
    this.tramsService.getAll().subscribe((trams: Tram[]) => {
      this.trams = trams;
    });
  }
  assignTram(nr: number) {
    this.lines = nr;
  }

  showTram() {
    setInterval(() => {
      this.tramsService.getLines(this.lines).subscribe((data: any[]) => {
        this.tramsByLine = data;
      });
    }, 25000);
  }
}
