package com.lover.main.ResideMenu.reside.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.easemob.chatuidemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class PersonActivity extends Activity{

    SimpleAdapter simpleAdapter;
    List<Map<String, Object>> list;
    private ListView PersonActivity_listView1;
    private ImageButton PersonActivity_imageButton1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personactivity);
		
		
		
		init();
		setListener();
	}

	
	 


    private void init() {
        // TODO Auto-generated method stub
        
        PersonActivity_listView1=(ListView) this.findViewById(R.id.PersonActivity_listView1);   
        PersonActivity_imageButton1=(ImageButton) this.findViewById(R.id.PersonActivity_imageButton1);
        
        list=getData(); 
        simpleAdapter=new SimpleAdapter(this, list, R.layout.personactivity_item1,
                new String[]{"bindactivity_item1imageView1","bindactivity_item1textView1","bindactivity_item1imageView2"},
                new int[]{R.id.bindactivity_item1imageView1,R.id.bindactivity_item1textView1,R.id.bindactivity_item1imageView2});
        PersonActivity_listView1.setAdapter(simpleAdapter);
        
        
        
    }
    private void setListener() {
        // TODO Auto-generated method stub
        
        PersonActivity_listView1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                // TODO Auto-generated method stub
                switch (position) {
                case 0:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(PersonActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    break;
               

                default:
                    break;
                }
                
                
            }
        });
        
        PersonActivity_imageButton1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                    finish();
            }
        });
        
        
        
    }

    private List<Map<String, Object>> getData() {
	        // TODO Auto-generated method stub
	        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	            Map<String, Object> map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1", R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "账号");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);
	            
	            map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1", R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "个性签名");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);
	            
	            map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1",  R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "性别");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);
	            
	            map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1",  R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "生日");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);

	            map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1",  R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "手机");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);
	            
	            map=new HashMap<String, Object>();
	            map.put("bindactivity_item1imageView1",  R.drawable.residesetting);
	            map.put("bindactivity_item1textView1", "邮箱");
	            map.put("bindactivity_item1imageView2", R.drawable.back3);
	            list.add(map);
	    
	            map=new HashMap<String, Object>();
                map.put("bindactivity_item1imageView1",  R.drawable.residesetting);
                map.put("bindactivity_item1textView1", "更多信息");
                map.put("bindactivity_item1imageView2", R.drawable.back3);
                list.add(map);
                
	            return list;
	    }
}
