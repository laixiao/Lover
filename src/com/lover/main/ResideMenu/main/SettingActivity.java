package com.lover.main.ResideMenu.main;
 
import com.easemob.EMCallBack;
import com.easemob.applib.controller.HXSDKHelper;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMChatOptions;
import com.easemob.chatuidemo.DemoApplication;
import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.BlacklistActivity;
import com.easemob.chatuidemo.activity.DiagnoseActivity;
import com.easemob.chatuidemo.activity.LoginActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingActivity extends Activity implements OnClickListener{
    /**
     * 设置新消息通知布局
     */
    private RelativeLayout rl_switch_notification;
    /**
     * 设置声音布局
     */
    private RelativeLayout rl_switch_sound;
    /**
     * 设置震动布局
     */
    private RelativeLayout rl_switch_vibrate;
    /**
     * 设置扬声器布局
     */
    private RelativeLayout rl_switch_speaker;

    /**
     * 打开新消息通知imageView
     */
    private ImageView iv_switch_open_notification;
    /**
     * 关闭新消息通知imageview
     */
    private ImageView iv_switch_close_notification;
    /**
     * 打开声音提示imageview
     */
    private ImageView iv_switch_open_sound;
    /**
     * 关闭声音提示imageview
     */
    private ImageView iv_switch_close_sound;
    /**
     * 打开消息震动提示
     */
    private ImageView iv_switch_open_vibrate;
    /**
     * 关闭消息震动提示
     */
    private ImageView iv_switch_close_vibrate;
    /**
     * 打开扬声器播放语音
     */
    private ImageView iv_switch_open_speaker;
    /**
     * 关闭扬声器播放语音
     */
    private ImageView iv_switch_close_speaker;

    /**
     * 声音和震动中间的那条线
     */
    private TextView textview1, textview2;

    private LinearLayout blacklistContainer;
    
    /**
     * 退出按钮
     */
    private Button logoutBtn;

    private EMChatOptions chatOptions;
 
    /**
     * 诊断
     */
    private LinearLayout llDiagnose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        setContentView(R.layout.fragment_conversation_settings);
        
        
        
        init();
    }
    private void init() {
        // TODO Auto-generated method stub
        rl_switch_notification = (RelativeLayout)this.findViewById(R.id.rl_switch_notification);
        rl_switch_sound = (RelativeLayout)this.findViewById(R.id.rl_switch_sound);
        rl_switch_vibrate = (RelativeLayout)this.findViewById(R.id.rl_switch_vibrate);
        rl_switch_speaker = (RelativeLayout)this.findViewById(R.id.rl_switch_speaker);

        iv_switch_open_notification = (ImageView)this.findViewById(R.id.iv_switch_open_notification);
        iv_switch_close_notification = (ImageView)this.findViewById(R.id.iv_switch_close_notification);
        iv_switch_open_sound = (ImageView)this.findViewById(R.id.iv_switch_open_sound);
        iv_switch_close_sound = (ImageView)this.findViewById(R.id.iv_switch_close_sound);
        iv_switch_open_vibrate = (ImageView)this.findViewById(R.id.iv_switch_open_vibrate);
        iv_switch_close_vibrate = (ImageView)this.findViewById(R.id.iv_switch_close_vibrate);
        iv_switch_open_speaker = (ImageView)this.findViewById(R.id.iv_switch_open_speaker);
        iv_switch_close_speaker = (ImageView)this.findViewById(R.id.iv_switch_close_speaker);
        logoutBtn = (Button)this.findViewById(R.id.btn_logout);
        if(!TextUtils.isEmpty(EMChatManager.getInstance().getCurrentUser())){
            logoutBtn.setText(getString(R.string.button_logout) + "(" + EMChatManager.getInstance().getCurrentUser() + ")");
        }

        textview1 = (TextView)this.findViewById(R.id.textview1);
        textview2 = (TextView)this.findViewById(R.id.textview2);
        
        blacklistContainer = (LinearLayout)this.findViewById(R.id.ll_black_list);
        llDiagnose=(LinearLayout)this.findViewById(R.id.ll_diagnose);
        blacklistContainer.setOnClickListener(this);
        rl_switch_notification.setOnClickListener(this);
        rl_switch_sound.setOnClickListener(this);
        rl_switch_vibrate.setOnClickListener(this);
        rl_switch_speaker.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        llDiagnose.setOnClickListener(this);
        chatOptions = EMChatManager.getInstance().getChatOptions();
        if (chatOptions.getNotificationEnable()) {
            iv_switch_open_notification.setVisibility(View.VISIBLE);
            iv_switch_close_notification.setVisibility(View.INVISIBLE);
        } else {
            iv_switch_open_notification.setVisibility(View.INVISIBLE);
            iv_switch_close_notification.setVisibility(View.VISIBLE);
        }
        if (chatOptions.getNoticedBySound()) {
            iv_switch_open_sound.setVisibility(View.VISIBLE);
            iv_switch_close_sound.setVisibility(View.INVISIBLE);
        } else {
            iv_switch_open_sound.setVisibility(View.INVISIBLE);
            iv_switch_close_sound.setVisibility(View.VISIBLE);
        }
        if (chatOptions.getNoticedByVibrate()) {
            iv_switch_open_vibrate.setVisibility(View.VISIBLE);
            iv_switch_close_vibrate.setVisibility(View.INVISIBLE);
        } else {
            iv_switch_open_vibrate.setVisibility(View.INVISIBLE);
            iv_switch_close_vibrate.setVisibility(View.VISIBLE);
        }

        if (chatOptions.getUseSpeaker()) {
            iv_switch_open_speaker.setVisibility(View.VISIBLE);
            iv_switch_close_speaker.setVisibility(View.INVISIBLE);
        } else {
            iv_switch_open_speaker.setVisibility(View.INVISIBLE);
            iv_switch_close_speaker.setVisibility(View.VISIBLE);
        }
    }
    
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.rl_switch_notification:
            if (iv_switch_open_notification.getVisibility() == View.VISIBLE) {
                iv_switch_open_notification.setVisibility(View.INVISIBLE);
                iv_switch_close_notification.setVisibility(View.VISIBLE);
                rl_switch_sound.setVisibility(View.GONE);
                rl_switch_vibrate.setVisibility(View.GONE);
                textview1.setVisibility(View.GONE);
                textview2.setVisibility(View.GONE);
                chatOptions.setNotificationEnable(false);
                EMChatManager.getInstance().setChatOptions(chatOptions);

                HXSDKHelper.getInstance().getModel().setSettingMsgNotification(false);
            } else {
                iv_switch_open_notification.setVisibility(View.VISIBLE);
                iv_switch_close_notification.setVisibility(View.INVISIBLE);
                rl_switch_sound.setVisibility(View.VISIBLE);
                rl_switch_vibrate.setVisibility(View.VISIBLE);
                textview1.setVisibility(View.VISIBLE);
                textview2.setVisibility(View.VISIBLE);
                chatOptions.setNotificationEnable(true);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgNotification(true);
            }
            break;
        case R.id.rl_switch_sound:
            if (iv_switch_open_sound.getVisibility() == View.VISIBLE) {
                iv_switch_open_sound.setVisibility(View.INVISIBLE);
                iv_switch_close_sound.setVisibility(View.VISIBLE);
                chatOptions.setNoticeBySound(false);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgSound(false);
            } else {
                iv_switch_open_sound.setVisibility(View.VISIBLE);
                iv_switch_close_sound.setVisibility(View.INVISIBLE);
                chatOptions.setNoticeBySound(true);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgSound(true);
            }
            break;
        case R.id.rl_switch_vibrate:
            if (iv_switch_open_vibrate.getVisibility() == View.VISIBLE) {
                iv_switch_open_vibrate.setVisibility(View.INVISIBLE);
                iv_switch_close_vibrate.setVisibility(View.VISIBLE);
                chatOptions.setNoticedByVibrate(false);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgVibrate(false);
            } else {
                iv_switch_open_vibrate.setVisibility(View.VISIBLE);
                iv_switch_close_vibrate.setVisibility(View.INVISIBLE);
                chatOptions.setNoticedByVibrate(true);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgVibrate(true);
            }
            break;
        case R.id.rl_switch_speaker:
            if (iv_switch_open_speaker.getVisibility() == View.VISIBLE) {
                iv_switch_open_speaker.setVisibility(View.INVISIBLE);
                iv_switch_close_speaker.setVisibility(View.VISIBLE);
                chatOptions.setUseSpeaker(false);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgSpeaker(false);
            } else {
                iv_switch_open_speaker.setVisibility(View.VISIBLE);
                iv_switch_close_speaker.setVisibility(View.INVISIBLE);
                chatOptions.setUseSpeaker(true);
                EMChatManager.getInstance().setChatOptions(chatOptions);
                HXSDKHelper.getInstance().getModel().setSettingMsgVibrate(true);
            }
            break;
        case R.id.btn_logout: //退出登陆
            logout();
            break;
        case R.id.ll_black_list:
            startActivity(new Intent(SettingActivity.this, BlacklistActivity.class));
            break;
        case R.id.ll_diagnose:
            startActivity(new Intent(SettingActivity.this, DiagnoseActivity.class));
            break;
        default:
            break;
        }

    }
   
    void logout() {
        final ProgressDialog pd = new ProgressDialog(SettingActivity.this);
        pd.setMessage("正在退出登陆..");
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        DemoApplication.getInstance().logout(new EMCallBack() {
            
            @Override
            public void onSuccess() {
               runOnUiThread(new Runnable() {
                    public void run() {
                        pd.dismiss();
                        // 重新显示登陆页面
                        finish();
                        startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                        
                    }
                });
            }
            
            @Override
            public void onProgress(int progress, String status) {
                
            }
            
            @Override
            public void onError(int code, String message) {
                
            }
        });
    }
    
    
}
