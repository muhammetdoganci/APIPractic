import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class GetRequest02 {
    @Test
    public void get02(){
        String url = "https://reqres.in/api/users";

        Response response = given().when().get(url);

        //given().when().get(url); --> request istek gönderdik
        //Response response --> response cevap aldık

        // header test

        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        //Body test
        /* idsi 1 olanin datalarinin asagidaki gibi oldugunu test ediniz
            "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",

         */
        response.then().body("data[0].email", Matchers.equalTo("george.bluth@reqres.in"),
                        "data[0].first_name", Matchers.equalTo("George"),
                        "data[0].last_name", Matchers.equalTo("Bluth"));



    }



}
