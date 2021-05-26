package TestScripts;

import org.testng.Assert;
import org.testng.annotations.*;

@Test()
public class testng {
    @DataProvider
    public Object[][] data() {
        return new String[][] {new String[] {"data1"}, new String[] {"data2"}};
    }

    @Test(dataProvider = "data")
    public void test(String d) {
        System.out.println("Pass");
        Assert.assertEquals("First Line>\nSecond Line", "Third Line\nFourth Line");
    }
}