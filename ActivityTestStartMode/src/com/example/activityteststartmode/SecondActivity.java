package com.example.activityteststartmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity","Task id is "+getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});		
		
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		Log.d("SecondActivity","onDestroy");
	}
	
}
