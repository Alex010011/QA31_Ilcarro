package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

   @BeforeMethod
   public void preCondition(){

      if(app.getUserHelper().isLogoutPresent()){
         app.getUserHelper().logout();
      }
   }

   @Test
   public void registrationSuccess(){

      int index=(int)(System.currentTimeMillis()/1000%3600);
      System.out.println(index);
      app.getUserHelper().openRegistrationForm();
      app.getUserHelper().fillRegistrationForm("Misterr","Tvisterr","tvistermister"+index+"@gmail.com","Jj12345$");
      //app.getUserHelper().checkPolicy();
      app.getUserHelper().checkPolicyByXY();
      app.getUserHelper().submitForm();

      app.getUserHelper().pause(5000);
      Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

   }

   @Test
   public void registrationSuccessModel(){

      int index=(int)(System.currentTimeMillis()/1000%3600);
      System.out.println(index);

      User user = new User().withName("Mister1").withLastName("Tvister1").witnEmail("tvistermister"+index+"@gmail.com").withPassword("Jj12345$");

      app.getUserHelper().openRegistrationForm();
      app.getUserHelper().fillRegistrationForm(user);
      app.getUserHelper().checkPolicy();
      app.getUserHelper().submitForm();

      //app.getUserHelper().pause(5000);
      Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

   }
    //open browser
    //open www

    //open form registration
    //fill form-----> type()
    //button register ----->click()
    @AfterMethod
    public void postCondition(){
       app.getUserHelper().clickOkButton();
    }


}
