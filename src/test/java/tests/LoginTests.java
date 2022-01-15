package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm ("lenastep@gmail.com", "12345nnnN");
        app.getUserHelper().submitForm();

        //Assert
    }


}


