package tests;

import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){

        if(app.getUserHelper().isLogoutPresent()){
            app.getUserHelper().logout();
        }
    }


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

    @AfterMethod
    public void postCondition(){
        app.getUserHelper().clickOkButton();
    }
}


