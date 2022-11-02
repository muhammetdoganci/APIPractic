package day02;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {

    @Test
        public void test05() {

        String url = "https://www.gmibank.com/api/tp-customers";

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2NjcwNjYxMjB9.0PGZYnj1UKSPxJqvYVOIpWLLBTnrAVyKn-vNlRq_JXu8r3B9UqPMtVkF0RkXi12i2XPhuDyGIRNY8H9_hxAoPw";


         Response response = given().headers("Authorization","Bearer " + token).when().get(url);
         response.prettyPrint();


    }

}
