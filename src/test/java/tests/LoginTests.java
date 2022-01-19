package tests;

import models.User;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm ("lenastep@gmail.com", "12345nnnN");
        app.getUserHelper().submitForm();

        //Assert
    }

    @Test
    public void loginSuccessModel() {

        User user = new User().witnEmail("lenastep@gmail.com").withPassword("12345nnnN");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();

        //Assert
    }
}


