package day04;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseUrl;
import utilities.ObjectMapperUtils;

import java.lang.reflect.AccessibleObject;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends GMIBankBaseUrl {
    /*
    https://www.gmibank.com/api/tp-customers/59511
    {
    "id": 59511,
    "firstName": "ismail",
    "lastName": "özk",
    "middleInitial": "a",
    "email": "ismailoezkan93@gmail.com",
    "mobilePhoneNumber": "111-111-1115",
    "phoneNumber": "123-456-7891",
    "zipCode": "16",
    "address": "schweiz",
    "city": "adana",
    "ssn": "398-56-4356",
    "createDate": "2020-10-20T22:00:00Z",
    "zelleEnrolled": true,
    "country": null,
    "state": "",
    "user": {
        "id": 58645,
        "login": "ismail16",
        "firstName": "LadyGaga",
        "lastName": "TeamTryCatch",
        "email": "ismailoezkan93@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
    "accounts": []
}
     */
    @Test
    public void get09(){
        // set the url
        spec.pathParams("first","tp-customers","second",59511);

        // set the expected data
        User user = new User(58645,"ismail16","LadyGaga","TeamTryCatch","ismailoezkan93@gmail.com",true,"en",null,null);
        System.out.println("user = " + user);


        Customer expectedData = new Customer(59511,"ismail","özk","a","ismailoezkan93@gmail.com","111-111-1115","123-456-7891","16",
                "schweiz","adana","398-56-4356","2020-10-20T22:00:00Z",true,null,"",user, null);
        System.out.println("expectedData = " + expectedData);

        //  send the request and get the result
        Response response = given().spec(spec).headers("Authorization", "Bearer " + generateToken()).
                            when().get("/{first}/{second}");
        //response.prettyPrint();
        //assertEquals(2,response.asString().replaceAll("\\s","").length());
        response.prettyPrint();


        // Do assertion
       // Customer actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Customer.class);
        //System.out.println("actualData = " + actualData);

    }


}
