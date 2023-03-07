package starstable.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverConfigurations {
    protected WebDriver driver;

    public DriverConfigurations(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
