package Test;

import PAges.LoginPAge;
import org.testng.annotations.Test;

public class Test_Steps {
    LoginPAge loginPAge = new LoginPAge();
    @Test(priority = 1)
    public void navigateToLoginPage(){
        loginPAge.openLoginPage();

    }
    @Test(dataProvider = "users",dataProviderClass = Data.dataProvider.class,priority = 2)
    public void loginwithcredentials(String username,String password,String message) throws InterruptedException {
        loginPAge.login(username, password,message);
    }
}
