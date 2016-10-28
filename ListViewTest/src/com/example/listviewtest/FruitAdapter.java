package com.example.listviewtest;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	
	private int resourceid;
	
	public FruitAdapter(Context context,int textViewResourceId,List<Fruit> objects){
		super(context, textViewResourceId,objects);
		resourceid = textViewResourceId;
	}
	
	//getView()ÿ�ζ����¼��ز���
	/*
	@SuppressLint("ViewHolder") @Override
	public View getView(int position,View convertView,ViewGroup parent){
		Fruit fruit = getItem(position);
		
		View view = LayoutInflater.from(getContext()).inflate(resourceid, null);
		
		ImageView fruitimage = (ImageView)view.findViewById(R.id.fruit_image);
		TextView fruitname = (TextView)view.findViewById(R.id.fruit_name);
		fruitimage.setImageResource(fruit.getImageId());
		fruitname.setText(fruit.getName());
		
		return view;
	}
	*/
	
	//getView()�ж�convertViewΪ��ʱ�ż��ز���
	/*
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		Fruit fruit = getItem(position);
		
		//�ж�
		View view;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceid, null);
		}else{
			view = convertView;
		}
			
		ImageView fruitimage=(ImageView)view.findViewById(R.id.fruit_image);
		TextView fruitname=(TextView)view.findViewById(R.id.fruit_name);
		fruitimage.setImageResource(fruit.getImageId());
		fruitname.setText(fruit.getName());
		return view;
	}
	*/
	
	//getView()�ж�convertViewΪ��ʱ�ż��ز���+���ֿؼ�View
		///*
		@Override
		public View getView(int position,View convertView,ViewGroup parent){
			Fruit fruit = getItem(position);
			View view;
			ViewHolder viewholder;
			if(convertView == null){
				view = LayoutInflater.from(getContext()).inflate(resourceid, null);
				viewholder = new ViewHolder();
				viewholder.fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
				viewholder.fruitName=(TextView)view.findViewById(R.id.fruit_name);
				view.setTag(viewholder);
			}else{
				view = convertView;
				viewholder = (ViewHolder)view.getTag();
			}
				
			viewholder.fruitImage.setImageResource(fruit.getImageId());
			viewholder.fruitName.setText(fruit.getName());
			return view;
		}
		class ViewHolder{
			ImageView fruitImage;
			TextView fruitName;
		}
		//*/

}
