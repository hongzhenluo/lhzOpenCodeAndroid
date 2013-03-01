package org.igeek.android.pluginframework.demo.plus2;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * 
 * 插件所提供的功能，必须是Activity的子类
 *
 * @author hangxin1940@gmail.com
 *
 */
public class PlugActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void callPhone(Context context){
    	Uri uri = Uri.parse("tel:10086");
    	Intent it = new Intent(Intent.ACTION_DIAL, uri);  
    	context.startActivity(it);
    }
    
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void callWeb(Context context){
    	Uri uri = Uri.parse("http://hangxin1940.cnblogs.com");
    	Intent it  = new Intent(Intent.ACTION_VIEW,uri);
    	context.startActivity(it);
    }
    
}