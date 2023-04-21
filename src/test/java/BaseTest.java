import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void setUp(){
        Utils.setBaseURI();
    }
}
