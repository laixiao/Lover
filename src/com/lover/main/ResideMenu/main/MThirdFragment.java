package com.lover.main.ResideMenu.main;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.ChatActivity;
 

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
 
public class MThirdFragment extends Fragment{

  
    private RelativeLayout MThirdFragment_layout1,MThirdFragment_layout2;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        
 
        
        init();
        setListener();

    }
    private void init() {
        // TODO Auto-generated method stub
        MThirdFragment_layout1=(RelativeLayout) getView().findViewById(R.id.MThirdFragment_layout1);
        MThirdFragment_layout2=(RelativeLayout) getView().findViewById(R.id.MThirdFragment_layout2);
        
        
        
    }
 
    private void setListener() {
        // TODO Auto-generated method stub
        
        
        MThirdFragment_layout1.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "1", Toast.LENGTH_LONG).show();
            }
        });
        
        MThirdFragment_layout2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "2", Toast.LENGTH_LONG).show();
            }
        });
    }

   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.thridfragment, container, false);
    }

}
