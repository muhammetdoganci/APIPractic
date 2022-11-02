package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class GetRequest01 {
    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        // given().when().get(url); en pointe gondermek icin request olusturduk
        // Response response -> api tarafından bana donen cevap (response)

        //Response response = given().auth().basic("user", "password").when().get(url);
        // basic auth ile request gondermek icin

        //response.prettyPrint();// responsdaki bodyi yazdirir

        //response.prettyPeek(); // responstaki herşeyi yazdirir

        //response.peek();

        //response.print(); // respons u string olarak yazdirir
        //[{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747}.......]

        //System.out.println("response.statusCode() = " + response.statusCode());
        //System.out.println("response.statusLine() = " + response.statusLine());
        //System.out.println("response.contentType() = " + response.contentType());

        // 1 ) JUnit Assert leri ile API testi yapabiliriz
        Assert.assertEquals("Status kod hatali",200,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        // 2 ) assertThat ile
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

    }


}
