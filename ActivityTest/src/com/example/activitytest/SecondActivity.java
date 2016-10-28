package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		//����first����
		/*
		Intent intent = getIntent();
		String data = intent.getStringExtra("extra_data");
		Log.d("SecondActivity",data);
		*/
		
		//�������ݸ���һ����������ذ�ť
		///*
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity-button");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		//*/
		
		
	}
	//�������ݸ���һ�������back��
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity-back");
		setResult(RESULT_OK,intent);
		finish();
	}
}
