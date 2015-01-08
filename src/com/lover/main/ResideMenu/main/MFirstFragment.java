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
 
public class MFirstFragment extends Fragment{

    private Button SetFragment_button1,SetFragment_button2;
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        
        
        
        
        
        
        
        
        
        init();
        setListener();
        
        
        
        
        
        
        
        
        
    }

    private void setListener() {
        // TODO Auto-generated method stub
       
    }

    private void init() {
        // TODO Auto-generated method stub
        
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.firstfragment, container, false);
    }

    
    
    
    
    /**
     * 刷新页面
     */
    public void refresh() {
//        conversationList.clear();
//        conversationList.addAll(loadConversationsWithRecentChat());
//        adapter.notifyDataSetChanged();
    }
}
