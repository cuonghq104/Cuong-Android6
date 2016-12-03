package hq.cuong.quote;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import hq.cuong.quote.managers.Preferences;

/**
 * Created by Cuong on 12/2/2016.
 */
public class QuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(this);

        initImageLoader();

    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
