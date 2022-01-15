package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

   @Test
   public void registrationSuccess(){

      app.getUserHelper().openRegistrationForm();
      app.getUserHelper().fillRegistrationForm("Misterr","Tvisterr","tvistermister1@gmail.com","Jj12345$");
      app.getUserHelper().checkPolicy();
      app.getUserHelper().submitForm();

   }
    //open browser
    //open www

    //open form registration
    //fill form-----> type()
    //button register ----->click()


}
