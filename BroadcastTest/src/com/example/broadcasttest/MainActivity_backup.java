package com.example.broadcasttest;

//系统全局广播实现，备份MainActivity.java代码

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity_backup extends Activity {//修改类名
	private IntentFilter intentFilter;
	private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //动态注册监听网络变化
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        
        //发送标准广播
        /*
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
        		sendBroadcast(intent);
        	}
        });*/
        
        //发送有序广播
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
        		sendOrderedBroadcast(intent,null);
        	}
        });
    }
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	unregisterReceiver(networkChangeReceiver);
    }
    
    class NetworkChangeReceiver extends BroadcastReceiver{
    	@Override
    	public void onReceive(Context context,Intent intent){
    		//仅提示网络变化
    		//Toast.makeText(context, "newwork changes", Toast.LENGTH_SHORT).show();
    		
    		//网络变化提示+判断开关
    		ConnectivityManager connectionManager =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    		NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
    		
    		if(networkInfo != null && networkInfo.isAvailable()){
    			Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
    		}else{
    			Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
    		}
    	}
    }


}