import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private Configs conf = new Configs();
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = conf.getBaseURI();
    }

    @AfterTest
    public void tearDown(){
        conf.close();
    }
}
