package com.example.administrator.studyvitamio;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;
/**
 * Vitamio学习使用
 * */
public class MainActivity extends Activity {
    private VideoView vitamio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        vitamio = (VideoView) findViewById(R.id.vitamioview);
        final Button bt_play= (Button) findViewById(R.id.bt_play);
        //初始化加载库文件
        Vitamio.isInitialized(this);
        /*初始化数据*/
        initData();
       bt_play.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(vitamio.isPlaying()){
                   bt_play.setText("播放");
                   vitamio.pause();
               }else {
                   vitamio.start();
                   bt_play.setText("暂停");
               }
           }
       });
    }

    private void initData() {
        Uri uri= android.net.Uri.parse("http://baobab.wdjcdn.com/145076769089714.mp4");
        vitamio.setVideoURI(uri);//读取地址
        vitamio.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置为高画质
        vitamio.requestFocus();//视频请求
    }

}
