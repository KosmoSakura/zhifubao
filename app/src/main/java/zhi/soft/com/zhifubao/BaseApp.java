package zhi.soft.com.zhifubao;

import android.app.Application;

/**
 * Description:
 * <p>
 * Author: Kosmos
 * Time: 2017/4/7 000710:13
 * Email:ZeroProject@foxmail.com
 * Events:
 */
public class BaseApp extends Application {
    private static BaseApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static BaseApp getInstance() {
        return instance;
    }
}
