package com.example.ejemjson.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.ejemjson.model.JSONObjeto;

public class JSONObjetoUtils {
	private static String ULR_PAGE = "http://www.tuzonaelite.com/?json=get_recent_posts";

	public static ArrayList<JSONObjeto> getPostContent() {
		ArrayList<JSONObjeto> objetosList = new ArrayList<JSONObjeto>();
		final String url = ULR_PAGE;
		try {

			BufferedReader bufferedReader = null;
			StringBuilder response = new StringBuilder();
			HttpURLConnection httpConnection = null;
			URL urlIn = new URL(url);
			httpConnection = (HttpURLConnection) urlIn.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}
			JSONObject jsonResponse = new JSONObject(response.toString());

			if (jsonResponse != null)
				System.out.println(jsonResponse.toString());
			JSONArray jsonArray = jsonResponse.getJSONArray("posts");
			JSONObject jsonObj;

			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObj = (JSONObject) jsonArray.get(i);
				JSONObjeto objeto = new JSONObjeto();
				objeto.setId(jsonObj.getString("id"));
				objeto.setTitle(jsonObj.getString("title"));
				objeto.setExcerpt(jsonObj.getString("excerpt"));
				objeto.setUrlImgThumbnail(jsonObj.getString("thumbnail"));
				objetosList.add(objeto);
				

			}

		} catch (Exception ex) {
			// Log.e(TAG, "POST error: " + Log.getStackTraceString(ex));
			System.out.println("Error " + ex.getCause());
		}
		return objetosList;
	}
}
