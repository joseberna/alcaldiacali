package com.devandroid.alcaldiacali.fragmentos;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.widget.Toast;

import com.devandroid.alcaldiacali.logica.SitiosTuristicosBP;
import com.devandroid.alcaldiacali.modelo.Lugar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaCaliFragment extends SupportMapFragment {

	private GoogleMap map;
	private HashMap<String, Marker> places_marker_map = new HashMap<String, Marker>();

	public static final LatLng APTO = new LatLng(3.454779,-76.532914);
	public static final String PLACES_FILE_NAME = "hotels.json";

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		SitiosTuristicosBP objSitiosTuristicosBP = new SitiosTuristicosBP();

		try {

			map = getMap();
			map.setMyLocationEnabled(true);
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(APTO, 16));
			map.getUiSettings().setZoomControlsEnabled(false);
			ArrayList<Lugar> lugares = objSitiosTuristicosBP
					.getLugaresTuristicos(getActivity());
			for (Lugar lugar : lugares) {
				Marker marker = map.addMarker(new MarkerOptions()
						.position(lugar.getLatLng())
						.title(lugar.getTitulo())
						.snippet(lugar.getDescription())
						.icon(BitmapDescriptorFactory.fromResource(lugar
								.getRecursoTipoMarker())));

				places_marker_map.put(lugar.getTitulo(), marker);
			}

			Toast.makeText(getActivity().getApplicationContext(),
					"Lugares Turisticos de la Ciudad de Cali",
					Toast.LENGTH_SHORT).show();

		} catch (Exception e) {
			Toast.makeText(getActivity().getApplicationContext(),
					e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}

}
