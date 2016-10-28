package com.example.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	//private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
	private List<Fruit> fruitlist = new ArrayList<Fruit>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //自定义子项布局
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitlist);
        
        //子项布局为android.R.layout.simple_list_item_1
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        
        //子项item注册监听器
        listview.setOnItemClickListener(new OnItemClickListener(){
        	@Override
        	public void onItemClick(AdapterView<?> parent,View view,int position,long id){
        		Fruit fruit = fruitlist.get(position);
        		Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
        	}
        });
    }
    private void initFruits(){
    	Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
    	fruitlist.add(apple);
    	
    	Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
    	fruitlist.add(banana);
    	
    	Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
    	fruitlist.add(orange);
    	
    	Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_pic);
    	fruitlist.add(watermelon);
    	
    	Fruit pear = new Fruit("Pear",R.drawable.pear_pic);
    	fruitlist.add(pear);
    	
    	Fruit grape = new Fruit("Grape",R.drawable.grape_pic);
    	fruitlist.add(grape);
    	
    	Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple_pic);
    	fruitlist.add(pineapple);
    	
    	Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_pic);
    	fruitlist.add(strawberry);
    	
    	Fruit cherry = new Fruit("Cherry",R.drawable.chcerry_pic);
    	fruitlist.add(cherry);
    	
    	Fruit mango = new Fruit("Mango",R.drawable.mango_pic);
    	fruitlist.add(mango);
    }


}
