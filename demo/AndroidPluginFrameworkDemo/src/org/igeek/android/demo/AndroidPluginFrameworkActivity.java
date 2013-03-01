package org.igeek.android.demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.igeek.android.pluginframework.PluginBuilder;
import org.igeek.android.pluginframework.PluginDescription;
import org.igeek.android.pluginframework.PluginInvoke;
import org.igeek.android.pluginframework.PluginSearch;
import org.igeek.android.pluginframework.R;
import org.igeek.android.pluginframework.beans.Plugin;
import org.igeek.android.pluginframework.beans.PluginFeature;
import org.igeek.android.pluginframework.beans.PluginFeatureMethod;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class AndroidPluginFrameworkActivity extends Activity {
	private LinearLayout llPluginList;
	private Button btnSearch;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        llPluginList=(LinearLayout) findViewById(R.id.main_llPluginList);
        btnSearch=(Button) findViewById(R.id.main_btnSearch);
        
        
        btnSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 //附加插件
		        try {
					findMyPlugin();
					btnSearch.setVisibility(View.GONE);
				} catch (NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
        
       
    }
    
    
    
    
    
    /**
     * 这里程序查找扩展
     * @throws NameNotFoundException 
     * @throws XmlPullParserException 
     * @throws IOException 
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     * @throws ClassNotFoundException 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     */
    private void findMyPlugin() throws NameNotFoundException, IOException, XmlPullParserException, ClassNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException, SecurityException, NoSuchFieldException{
    	
    	//首先，就是查找插件
    	PluginSearch psearch=new PluginSearch();
    	List<Plugin>  plugins=psearch.getPlugins(this);
    	
    	//然后将插件再组装一下
    	PluginBuilder pbuilder=new PluginBuilder(this);
    	plugins=pbuilder.buildPluginsDescrition(plugins);
    	
    	//显示出所有插件
    	flateUI(plugins);
    }
    
    /**
     * 将所有插件列出来
     * @param plugins
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     * @throws ClassNotFoundException 
     * @throws NameNotFoundException 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalArgumentException 
     */
    private void flateUI(List<Plugin> plugins) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NameNotFoundException, IllegalArgumentException, SecurityException, NoSuchFieldException{
    	
    	for(final Plugin plug:plugins){
    		//加入插件
    		PluginItem item=new PluginItem(this);
    		
    		//获取插件的描述对象
    		PluginDescription<MainDescript> pdes=new PluginDescription<MainDescript>(MainDescript.class);
    		
    		
    		MainDescript des=pdes.getDescription(this, plug);
    		
    		//设置插件item的描述信息
    		item.setDes(des.getDescription());
    		item.setSubTit(des.getSubTitle()); 
    		
    		Drawable d=plug.getContext().getResources().getDrawable(des.getIconResId());
    		item.setLogoImage(d);
    		
    		//获得当前插件的功能
    		List<PluginFeature> features=plug.getFeatures();
    		
    		//遍历功能
    		for(final PluginFeature pf:features){
    			
    			for(final PluginFeatureMethod fm:pf.getMethods()){
    			
    				
	    			//添加插件，并且设置执行事件
	    			item.addPluginMethod(fm, new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							PluginInvoke pi=new PluginInvoke(AndroidPluginFrameworkActivity.this);
						
							try {
								pi.invoke(plug, pf, fm);
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NameNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
    			}
    		}
    		
    		//将插件加入到ui
    		llPluginList.addView(item);
    	}
    }
}