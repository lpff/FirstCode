package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button) findViewById(R.id.button_1);
		//��������ʾ��ť����
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
			}
		});
		*/
		
		//����button�����ٻ
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				finish();
			}
		});
		*/
		
		//��ť�����ڶ����������ʽintent
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				startActivity(intent);
			}
		});
		*/
		
		//��ť�����ڶ����������ʽintent
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent("com.example.activitytest.ACTION_START");
				startActivity(intent);
			}
		});
		*/
		
		//��ť�����ڶ����������ʽintent����ָ��category
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");
				startActivity(intent);
			}
		});
		*/
		
		//��ť������������������ʽintent
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});
		*/		
		
		//����ϵͳ���Ž���
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10000"));
				startActivity(intent);
			}
		});
		*/
		
		//����һ�����������
		/*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String data = "Hello SecondActivity";
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				intent.putExtra("extra_data", data);
				startActivity(intent);
			}
		});
		*/
		
		//�������ݸ���һ���
		///*
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				startActivityForResult(intent,1);
			}
		});
		//*/
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	//�˵�
	///*
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}
	//*/
	
	//�������ݸ���һ���
	///*
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		switch(requestCode){
		case 1:
			if(resultCode == RESULT_OK){
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity",returnedData);
			}
			break;
		default:
		}
	}
	//*/
}
