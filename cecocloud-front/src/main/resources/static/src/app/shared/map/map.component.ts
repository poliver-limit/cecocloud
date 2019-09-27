import { Component, Input, OnInit, AfterViewInit } from '@angular/core';

import OlMap from 'ol/Map';
import OlXYZ from 'ol/source/XYZ';
import OlTileLayer from 'ol/layer/Tile';
import OlView from 'ol/View';
import { fromLonLat } from 'ol/proj';
import OlVectorLayer from 'ol/layer/Vector';
import OlFeature from 'ol/Feature';
import OlPoint from 'ol/geom/Point';
import OlVector from 'ol/source/Vector';
import OlStyle from 'ol/style/Style';
import OlIcon from 'ol/style/Icon';

@Component({
	selector: 'map',
	template: `
<div id="map" class="map" [ngStyle]="{ 'width' : width, 'height' : height }" style="margin: 1em 2em"></div>
`
})
export class MapComponent implements OnInit, AfterViewInit {

	@Input() longitude: number;
	@Input() latitude: number;
	@Input() width: string;
	@Input() height: string;

	map: OlMap;
	source: OlXYZ;
	layer: OlTileLayer;
	view: OlView;

	ngAfterViewInit() {
		this.map.setTarget('map');
	}

	ngOnInit() {
		this.source = new OlXYZ({
			url: 'http://tile.osm.org/{z}/{x}/{y}.png'
		});
		this.layer = new OlTileLayer({
			source: this.source
		});
		this.view = new OlView({
			center: fromLonLat([this.longitude, this.latitude]),
			zoom: 17
		});
		this.map = new OlMap({
			layers: [this.layer],
			view: this.view
		});
		this.addMarker(this.longitude, this.latitude);
	}

	addMarker(longitude: number, latitude: number) {
		let marker = new OlFeature({
			geometry: new OlPoint(fromLonLat([longitude, latitude]))
		});
		let iconStyle = new OlStyle({
			image: new OlIcon(({
				anchor: [0.5, 1],
				src: "http://cdn.mapmarker.io/api/v1/pin?size=50&hoffset=1"
			}))
		});
		marker.setStyle(iconStyle);
		let vectorSource = new OlVector({
			features: [marker]
		});
		let markerVectorLayer = new OlVectorLayer({
			source: vectorSource,
		});
		this.map.addLayer(markerVectorLayer);
	}

}