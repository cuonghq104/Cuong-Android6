package hq.cuong.companyrecyclerview.models;

import java.io.Serializable;

/**
 * Created by Cuong on 12/13/2016.
 */
public class Company implements Serializable{

    public static String COMPANY_KEY = "company";

    private String name;

    private String imageUrl;

    public Company(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public static final Company[] COMPANIES = new Company[]{
        new Company("Techkids", "http://techkids.vn/register-page/static/img/big_banner.png\n"),
        new Company("Eway", "https://e27.co/img/startups/6595/logo-1443495246.png\n"),
        new Company("BraveBit", "http://i.imgur.com/8ONaQnl.png\n"),
        new Company("Google", "https://www.gstatic.com/images/branding/googlelogo/2x/googlelogo_color_284x96dp.png\n"),
        new Company("FPT", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/LogoFSO1.jpg/220px-LogoFSO1.jpg\n"),
        new Company("Oracle", "http://assets1.csc.com/global_alliances/images/Oracle.jpg\n"),
        new Company("Asus", "http://dlcdnimgs.asus.com/20160129_cosmo/cosmo/images/asus_logo.jpg\n"),
        new Company("Sony", "http://guias.orange.es/content/images/manufacturers/sony.png\n"),
        new Company("Samsung", "http://www.samsung.com/common/img/logo-square-letter.png\n"),
        new Company("Microsoft", "https://mran.revolutionanalytics.com/assets/img/MSFT_logo_rgb_C-Gray.3b156229.png\n"),
        new Company("Apple", "https://www.freeflyvr.com/wp-content/uploads/2016/02/Apple_logo_black.svg.png\n"),
        new Company("LG", "http://logok.org/wp-content/uploads/2014/06/LG-logo.png\n"),
//        new Company("Audi", "http://thenewswheel.com/wp-content/uploads/2015/05/2009-current-Audi-logo-emblem.jpg\n"),
//        new Company("Ferrari", "https://stocklogos.com/sites/default/files/ferrari-logo_0.jpg\n"),
//        new Company("Lamborghini", "http://teamspeed.com/forums/attachment.php?attachmentid=130958&stc=1&d=1466941810\n"),
//        new Company("Bentley", "http://www.hdwallpaper.nu/wp-content/uploads/2015/07/bentley-logo-black.jpg\n"),
//        new Company("Mazda", "https://upload.wikimedia.org/wikipedia/en/thumb/1/18/Mazda_logo_with_emblem.svg/969px-Mazda_logo_with_emblem.svg.png\n"),
//        new Company("Nissan", "http://seeklogo.com/images/N/Nissan-logo-CCA990D6E0-seeklogo.com.gif\n"),
//        new Company("Aston Martin", "http://hqpictures.net/wp-content/uploads/2015/09/Aston-Martin-HD-Logo.jpg\n"),
//        new Company("Cadillac", "http://www.zeroto60times.com/logos/cadillac-cars-logo-emblem.jpg\n"),
//        new Company("Alfa Romeo", "http://www.logospike.com/wp-content/uploads/2014/11/Alfa_romeo_logo-3.png\n"),
    };

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
