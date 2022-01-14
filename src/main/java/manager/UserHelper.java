package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillPogonForm();
}
