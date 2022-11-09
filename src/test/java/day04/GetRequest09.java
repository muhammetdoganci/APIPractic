package day04;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseURL;

import utilities.JsonUtil;


import java.lang.reflect.AccessibleObject;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends GMIBankBaseURL {
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
    “accounts”: []
}
     */
    @Test
    public void get09(){
        // set the url
        spec01.pathParams("first","tp-customers","second",59511);

        // set the expected data
        User user = new User(58645,"ismail16","LadyGaga","TeamTryCatch","ismailoezkan93@gmail.com",true,"en",null,null);
        System.out.println("user = " + user);

        //Country country = new Country(3,"USA",null);

       // Account account = new Account(107250, "New Account_6thGenQA_",11190,"CHECKING",
         //       "ACTIVE","2021-11-24T23:00:00Z","2022-11-24T23:00:00Z",null,null);


        Customer expectedData = new Customer(59511,"ismail","özk","a",
                "ismailoezkan93@gmail.com","111-111-1115","123-456-7891","16",
                "schweiz","adana","398-56-4356","2020-10-20T22:00:00Z",
                true,null,"",user);
        System.out.println("expectedData = " + expectedData);

        //  send the request and get the result
        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken()).
                            when().get("/{first}/{second}");

        //response.prettyPrint();


        // Do assertion
       Customer actualData = response.as(Customer.class);
       System.out.println("actualData = " + actualData);

       //Object Mapper ile
       Customer actualData2 = JsonUtil.convertJsonToJava(response.asString(), Customer.class);
        System.out.println("actualData2 = " + actualData2);

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(),actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(),actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(),actualData.getZipCode());
        assertEquals(expectedData.getAddress(),actualData.getAddress());
        assertEquals(expectedData.getCity(),actualData.getCity());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getCreateDate(),actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(),actualData.isZelleEnrolled());
        assertEquals(expectedData.getCountry(),actualData.getCountry());
        assertEquals(expectedData.getState(),actualData.getState());
        assertEquals(expectedData.getUser().getId(),actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(),actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(),actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(),actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(),actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().isActivated(),actualData.getUser().isActivated());
        assertEquals(expectedData.getUser().getLangKey(),actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(),actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(),actualData.getUser().getResetDate());













    }


}
