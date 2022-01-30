package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    HelperSearch search;

    public void init(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        search = new HelperSearch(wd);
    }

    public void stop(){

        wd.quit();//close all tabs (wd.close() - close only one tab)

    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCarHelper() {
        return carHelper;
    }

    public HelperSearch search(){
        return search;
    }
}
