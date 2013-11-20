package com.example.ejemjson;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemjson.list.JSONObjetoAdapter;
import com.example.ejemjson.model.JSONObjeto;
import com.example.ejemjson.utils.JSONObjetoUtils;

public class MainActivity extends Activity {

	// private PullToRefreshAttacher pull_to_refresh_attacher;

	private ListView listView;
	private JSONObjetoAdapter adapter;

	// private IntentFilter filter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list);
		new PostSearchTask().execute();

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	private void updateListView(ArrayList<JSONObjeto> objList) {
		adapter = new JSONObjetoAdapter(this, R.layout.rowobjeto, objList);
		listView.setAdapter(adapter);
	}

	private class PostSearchTask extends
			AsyncTask<Object, Void, ArrayList<JSONObjeto>> {
		private ProgressDialog progressDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setMessage("Cargando Post...");
			progressDialog.show();
		}

		@Override
		protected ArrayList<JSONObjeto> doInBackground(Object... params) {
			// TODO Auto-generated method stub
			ArrayList<JSONObjeto> objetosPost = JSONObjetoUtils
					.getPostContent();
			return objetosPost;
		}

		@Override
		protected void onPostExecute(ArrayList<JSONObjeto> result) {
			// TODO Auto-generated method stub
			progressDialog.dismiss();
			if (result.isEmpty()) {
				Toast.makeText(MainActivity.this, "No hay post a mostrar",
						Toast.LENGTH_SHORT).show();
			} else {

				Toast.makeText(MainActivity.this, "Post encontrados",
						Toast.LENGTH_SHORT).show();
				updateListView(result);

			}

		}
	}

}
