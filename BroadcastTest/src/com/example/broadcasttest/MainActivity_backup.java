package com.example.broadcasttest;

//ϵͳȫ�ֹ㲥ʵ�֣�����MainActivity.java����

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


public class MainActivity_backup extends Activity {//�޸�����
	private IntentFilter intentFilter;
	private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��̬ע���������仯
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        
        //���ͱ�׼�㲥
        /*
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
        		sendBroadcast(intent);
        	}
        });*/
        
        //��������㲥
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
    		//����ʾ����仯
    		//Toast.makeText(context, "newwork changes", Toast.LENGTH_SHORT).show();
    		
    		//����仯��ʾ+�жϿ���
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