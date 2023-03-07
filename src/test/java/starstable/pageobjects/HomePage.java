package starstable.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends DriverConfigurations {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.NAME, using = "firstname")
    private WebElement booking_firstName;

    @FindBy(how = How.NAME, using = "lastname")
    private WebElement booking_lastname;

    @FindBy(how = How.NAME, using = "email")
    private WebElement booking_email;

    @FindBy(how = How.NAME, using = "phone")
    private WebElement booking_phone;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[4]/div/div[2]/div[3]/button[2]")
    private WebElement booking_submit;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[4]/div/div/div[3]/button")
    private WebElement book_room;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailID;

    @FindBy(how = How.ID, using = "phone")
    private WebElement phoneNo;

    @FindBy(how = How.ID, using = "subject")
    private WebElement email_subject;

    @FindBy(how = How.ID, using = "description")
    private WebElement message;

    @FindBy(how = How.ID, using = "submitContact")
    private WebElement submitButton;


    public void populateContactName(String firstname) throws InterruptedException {
        name.sendKeys(firstname);
        Thread.sleep(200);
    }

    public void populateEmail(String email) throws InterruptedException {
        emailID.sendKeys(email);
        Thread.sleep(200);
    }

    public void populatePhoneNumber(String phone) throws InterruptedException {
        phoneNo.sendKeys(phone);
        Thread.sleep(200);
    }

    public void populateSubject(String subject) throws InterruptedException {
        email_subject.sendKeys(subject);
        Thread.sleep(200);
    }

    public void populateDescription(String description) throws InterruptedException {
        message.sendKeys(description);
        Thread.sleep(200);
    }

    public void clickSubmit() throws InterruptedException {
        submitButton.click();
        Thread.sleep(200);
    }


    public void bookRoom_populateName(String firstName) throws InterruptedException {
        booking_firstName.sendKeys(firstName);
        Thread.sleep(200);
    }

    public void bookRoom_populateLastName(String lastName) throws InterruptedException {
        booking_lastname.sendKeys(lastName);
        Thread.sleep(200);
    }

    public void bookRoom_populateEmail(String email) throws InterruptedException {
        booking_email.sendKeys(email);
        Thread.sleep(200);
    }

    public void bookRoom_populatePhone(String phone) throws InterruptedException {
        booking_phone.sendKeys(phone);
        Thread.sleep(200);
    }

    public void bookRoom() throws InterruptedException {
        book_room.click();
        Thread.sleep(200);
    }

    public void bookRoom_submit() throws InterruptedException {
        booking_submit.click();
        Thread.sleep(200);
    }
    public void getElementForCalendar() throws InterruptedException
    {
        WebElement From=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div/div[4]/button"));
        WebElement To=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div/div[5]/button"));
        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //Dragged and dropped.
        //act.dragAndDrop(From, To).build().perform();
        act.clickAndHold(From).build().perform();
        Thread.sleep(500);
        act.moveToElement(To).build().perform();
        Thread.sleep(500);
        act.release(To).build().perform();
        Thread.sleep(1000);
        }


}