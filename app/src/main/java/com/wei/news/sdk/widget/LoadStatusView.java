package com.wei.news.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wei.news.R;

public class LoadStatusView extends RelativeLayout {

    private Button btn_reload;
    private onReloadClickListener reloadClickListener;
    private ImageView iv_statusPicture;
    private TextView tv_message;

    public LoadStatusView(Context context) {
        this(context,null);
    }

    public LoadStatusView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(context, R.layout.widget_load_status, this);
        btn_reload = view.findViewById(R.id.btn_reload);
        tv_message = view.findViewById(R.id.tv_message);
        iv_statusPicture = view.findViewById(R.id.iv_statusPicture);
        btn_reload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reloadClickListener !=null){
                    reloadClickListener.OnReloadClick();
                }
            }
        });

        hideLoadStatus();
    }


    public void hideLoadStatus(){
       setVisibility(View.GONE);
    }
    public void showReload(){
        btn_reload.setVisibility(View.VISIBLE);
        iv_statusPicture.setBackgroundResource(R.drawable.ic_load_error);
        tv_message.setText(R.string.load_error);
        setVisibility(View.VISIBLE);
    }

    public void showLoading(){
        btn_reload.setVisibility(View.GONE);
        iv_statusPicture.setBackgroundResource(R.drawable.ic_loading_status);
        tv_message.setText(R.string.loading_tip);
        setVisibility(View.VISIBLE);
    }



    public void setonReloadClickListener(onReloadClickListener listener){
        this.reloadClickListener =listener;
    }

    public  interface onReloadClickListener {
        void OnReloadClick();
    }


}
