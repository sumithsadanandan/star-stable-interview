package starstable.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AlertObjects extends DriverConfigurations{

    public AlertObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using= "/html/body/div/div/div/div[5]/div[2]/form/div[6]")
    private WebElement alert;

    public void isAlerted() {
        alert.isDisplayed();
    }

    public String getAlertText() {
        String alertText = alert.getText();
        System.out.println(alertText);
        return alertText;
    }


        @FindBy(how = How.XPATH, using= "/html/body/div/div/div/div[4]/div/div[2]/div[3]/div[5]")
        private WebElement alertBooking;

        public void isAlertedBooking() {
            alertBooking.isDisplayed();
        }

        public String getAlertTextBooking() {
            String alertText = alertBooking.getText();
            System.out.println(alertText);
            return alertText;
        }
}
