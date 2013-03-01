package org.igeek.android.pluginframework.demo.plus1;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 
 * 插件所提供的功能，必须是Activity的子类
 *
 * @author hangxin1940@gmail.com
 *
 */
public class OtherPlugActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void toast(Context context){
    	//土司一下
    	Toast.makeText(context, "插件1的吐司", 1).show();
    }
    
    
}