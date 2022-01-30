package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {

        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom,dateTo);
    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    private void selectPeriodCurrentMonth(String dateFrom, String dateTo) {

        click(By.id("dates"));

        String[]dataF = dateFrom.split("/");
        String[]dataT = dateTo.split("/");

        String locator = "//div[text()=' "+dataF[1]+" ']";

        String loc = String.format("//div[text()=' %s ']",dataF[1]);


        click(By.xpath(locator));

        String locator2="//div[text()=' "+dataT[1]+" ']";
        click(By.xpath(locator2));
        pause(5000);

    }

    public boolean isListOfCarsAppeared(){
        return isElementPresent(By.cssSelector(".search-results"));
    }


}
