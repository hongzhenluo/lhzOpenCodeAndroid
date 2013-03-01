package org.igeek.android.pluginframework.demo.plus1;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
    public void showDialog1(Context context){
    	//这里显示一个对话框
    	ProgressDialog pgdialog = new ProgressDialog(context);
    	pgdialog.setTitle("插件1");
		pgdialog.setMessage("来自插件1的问候");
		pgdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pgdialog.setCancelable(true);
		pgdialog.show();
    }
    
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void showDialog2(Context context){
    	//这里显示一个对话框
    	ProgressDialog pgdialog = new ProgressDialog(context);
    	pgdialog.setTitle("插件1");
    	pgdialog.setMessage("再次问候");
    	pgdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    	pgdialog.setCancelable(true);
    	pgdialog.show();
    }
}