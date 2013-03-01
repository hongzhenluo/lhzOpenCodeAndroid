package org.igeek.android.pluginframework.demo.plus1;



import org.igeek.android.demo.GenDescript;

import android.util.Log;

/**
 * @author 作者 E-mail:hangxin1940@gmail.com
 * @version 创建时间：2011-12-16 下午01:50:50
 * 插件说明
 */
public class PlugDescription extends GenDescript{
	
	/**
	 * 首先，这个无参数的构造方法是必须有的
	 * 其次，接口是主程序自己定义的，可自行定义并扩展
	 * 最后，assets/plugin.xml 中必须定义这个类
	 */
	public PlugDescription() {
		 Log.i("org.igeek.android-plugin", "插件1实例化");  
		 iconResId=R.drawable.a1_00;
		 subTitle="插件1--窗口演示";
		 description="这个插件将弹出对话框与吐司";
	}
	


}
