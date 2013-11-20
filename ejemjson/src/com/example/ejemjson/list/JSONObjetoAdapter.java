package com.example.ejemjson.list;

import java.util.ArrayList;

import com.example.ejemjson.R;
import com.example.ejemjson.model.JSONObjeto;
import com.example.ejemjson.utils.BitmapManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JSONObjetoAdapter extends ArrayAdapter<JSONObjeto> {

	private Context context;
	private ArrayList<JSONObjeto> objetos;

	public JSONObjetoAdapter(Context context, int textViewResourceId,
			ArrayList<JSONObjeto> objetos) {
		super(context, textViewResourceId, objetos);
		this.context = context;
		this.objetos = objetos;
	}

	static class ViewHolder {
		// public TextView id;
		public TextView title;
		public TextView excerpt;
		public ImageView imgThumbnail;
		// public ImageView imgFull;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.rowobjeto, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.title = (TextView) convertView.findViewById(R.id.title);
			viewHolder.imgThumbnail = (ImageView) convertView
					.findViewById(R.id.imgThumbnail);
			viewHolder.excerpt = (TextView) convertView
					.findViewById(R.id.excerpt);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.title.setText(objetos.get(position).getTitle());
		holder.excerpt.setText(objetos.get(position).getExcerpt());
		BitmapManager.getInstance()
				.loadBitmap(objetos.get(position).getUrlImgThumbnail(),
						holder.imgThumbnail);

		return convertView;
	}

}
