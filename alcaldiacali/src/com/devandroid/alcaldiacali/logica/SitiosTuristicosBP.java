package com.devandroid.alcaldiacali.logica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import com.devandroid.alcaldiacali.modelo.Lugar;
import com.google.gson.Gson;

public class SitiosTuristicosBP {

	private static final String LUGARES_TURISTICOS = "lugaresTuristicos.json";

	public ArrayList<Lugar> getLugaresTuristicos(Activity activity) throws Exception {

		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();

		try {

			reader = new BufferedReader(new InputStreamReader(activity
					.getAssets().open(LUGARES_TURISTICOS)));

			String line = "";
			
			while ((line = reader.readLine()) != null) {
				builder.append(line);				
			}
			
			reader.close();
			
		} catch (Exception e) {
			throw e;
		}
		
		String json = builder.toString();
		Gson objGson = new Gson();
		return new ArrayList<Lugar>(Arrays.asList(objGson.fromJson(json, Lugar[].class)));

	}
}
