package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(String email, Srting password);
        type(By.id("email"), "lenastep@gmail.com");
        type(By.id("Password"), "12345nnnN");
        click(By.cssSelector("[type='submit']"));


    }


}


