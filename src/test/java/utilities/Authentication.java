package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {
        String gunceltoken = generateToken();
        System.out.println("gunceltoken = " + gunceltoken);
    }
    public static String generateToken(){

        String usernName = "Batch81";
        String passWord = "Batch81+";

        /*
        {
            "password": "string",
            "rememberMe": true,
            "username": "string"
           }
         */
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("username", usernName);
        postBody.put("password", passWord);
        postBody.put("rememberMe", true);

        //"password": "Batch81+",
        //"rememberMe": true,
        //"username": "Batch81"

        String endPoint = "https://www.gmibank.com/api/authenticate";

        Response response = given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);

        JsonPath token = response.jsonPath();
        return token.getString("id_token");



    }
}
