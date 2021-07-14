package PAges;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPAge extends PageObject {
//    @FindBy (xpath = "//*[@type=\"email\"]//following-sibling::div")
//    WebElement element;
//    @FindBy (xpath = "//*[@type=\"email\"]")
    WebElement box;
    WebElement next;
    WebElement pass;
    WebElement mesagefrombrowser;
    List<WebElement> email=new ArrayList<>();
    public void openLoginPage(){
    openAt("https://accounts.google.com/");
    }


    public void login(String username,String password,String message) throws InterruptedException {
        box=getDriver().findElement(By.xpath("//*[@type=\"email\"]"));
        next=getDriver().findElement(By.xpath("//*[text()=\"Next\"]"));
        box.click();
        box.sendKeys(username);
        next.click();
        checkforvaliduser();
        pass=getDriver().findElement(By.xpath("//*[@type=\"password\"]"));
        pass.click();
        pass.sendKeys(password);
        next.click();
        email=getDriver().findElements(By.xpath("//*[@id=\":om\"]/tbody/tr"));
        if (email.size()!=0){
            checkforstring(message);

        }
        else {
            System.out.println("no Message found");}

    }

    private void checkforstring(String message) {
        Assert.assertEquals(true,mesagefrombrowser.getText().contains(message));
        System.out.println("message found");

    }

    private void checkforvaliduser() {
        Assert.assertEquals(null,getDriver().findElement(By.xpath("(//*[contains(text(),\"Couldn't find your Google Account\")])[2]")));
    }
}
