package Data;

import org.testng.annotations.DataProvider;


public class dataProvider {
    @DataProvider(name = "users")
    public Object[][] user(){
        return new Object[][]{
                {"username","password","message"},
                {"abc","def","message"}
        };
    }
}
