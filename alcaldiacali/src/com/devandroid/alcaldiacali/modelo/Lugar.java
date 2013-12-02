package com.devandroid.alcaldiacali.modelo;

import com.devandroid.alcaldiacali.R;
import com.google.android.gms.maps.model.LatLng;

public class Lugar {

	private int tipo;
	private String titulo;
	private double[] ubicacion;
	private String descripcion;

	public final static int TIPO_MUSEO = 0;
	public final static int TIPO_HISTORICO = 1;
	public final static int TIPO_CULTURAL = 2;

	public int getRecursoTipoMarker() {
		int recurso = 0;

		switch (tipo) {
		case TIPO_MUSEO:
			recurso = R.drawable.marker_museo;
			break;
		case TIPO_HISTORICO:
			recurso = R.drawable.marker_historico;
			break;
		case TIPO_CULTURAL:
			recurso = R.drawable.marker_cultural;
			break;
		}

		return recurso;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double[] getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(double[] ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescription() {
		return descripcion;
	}

	public void setDescription(String description) {
		this.descripcion = description;
	}

	public LatLng getLatLng() {
		return new LatLng(ubicacion[0], ubicacion[1]);
	}

}
