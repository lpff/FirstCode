package com.example.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

//������ע�������
/*
public class MainActivity extends Activity {
	
	private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		//����
        		Toast.makeText(MainActivity.this, "You clicked button", Toast.LENGTH_SHORT).show();
        	}
        });
    }
}
*/

//�ӿ�ע�������
///*
public class MainActivity extends Activity implements OnClickListener{
	
	private Button button;
	private EditText edittext;
	private ImageView imageview;
	private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        edittext = (EditText)findViewById(R.id.edit_text);
        imageview = (ImageView)findViewById(R.id.image_view);
        progressbar = (ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.button:
    		//button��ʾedittext����
    		/*
    		String inputText = edittext.getText().toString();
    		Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
    		*/
    		
    		//button�л�imageview
    		/*
    		imageview.setImageResource(R.drawable.aa1234);
    		*/
    		
    		//Բ�ν�����
    		/*
    		if(progressbar.getVisibility() == View.GONE){
    			progressbar.setVisibility(View.VISIBLE);
    		}else{
    			progressbar.setVisibility(View.GONE);
    		}
    		*/
    		
    		//ˮƽ������
    		/*
    		int progress = progressbar.getProgress();
    		progress = progress + 10;
    		progressbar.setProgress(progress);
    		*/
    		
    		//alertdialog
    		/*
    		AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
    		dialog.setTitle("This is Dialog");
    		dialog.setMessage("Something important");
    		dialog.setCancelable(false);
    		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
    			@Override
    			public void onClick(DialogInterface dialog,int which){
    			}
    		});
    		dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
    			@Override
    			public void onClick(DialogInterface dialog,int which){
    			}
    		});
    		dialog.show();
    		*/
    		
    		//progressdialog
    		///*
    		ProgressDialog progressdialog = new ProgressDialog(MainActivity.this);
    		progressdialog.setTitle("This is ProgressDialog");
    		progressdialog.setMessage("Loading...");
    		progressdialog.setCancelable(true);
    		progressdialog.show();
    		//*/

    		break;
    	default:
    		break;
    	}
    }
}
//*/