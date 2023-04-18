import io.restassured.RestAssured;

public class Utils {

    public static void setBaseURI (){
        RestAssured.baseURI = "https://reqres.in/api/";
    }

}
