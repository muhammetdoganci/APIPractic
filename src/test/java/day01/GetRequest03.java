package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {
    /* Matchers ile dataları doğrulayınız
    {
            "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
        },
        {
            "id": 3,
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
            "avatar": "https://reqres.in/img/faces/3-image.jpg"
        },
        {
            "id": 4,
            "email": "eve.holt@reqres.in",
            "first_name": "Eve",
            "last_name": "Holt",
            "avatar": "https://reqres.in/img/faces/4-image.jpg"
        },
        {
            "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
         },
        {
            "id": 6,
            "email": "tracey.ramos@reqres.in",
            "first_name": "Tracey",
            "last_name": "Ramos",
            "avatar": "https://reqres.in/img/faces/6-image.jpg"
        }
     */
    @Test
    public void get03(){
        String url = "https://reqres.in/api/users";

        Response response = given().when().get(url);

        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        response.then().body("data[1].email", Matchers.equalTo("janet.weaver@reqres.in"),
                        "data[1].first_name", Matchers.equalTo("Janet"),
                                "data[1].last_name", Matchers.equalTo("Weaver"),
                                "data[1].avatar", Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"));

        response.then().body("data[2].email", Matchers.equalTo("emma.wong@reqres.in"),
                    "data[2].first_name", Matchers.equalTo("Emma"),
                     "data[2].last_name", Matchers.equalTo("Wong"),
                     "data[2].avatar", Matchers.equalTo("https://reqres.in/img/faces/3-image.jpg"));

        response.then().body("data[3].email", Matchers.equalTo("eve.holt@reqres.in"),
                     "data[3].first_name", Matchers.equalTo("Eve"),
                     "data[3].last_name", Matchers.equalTo("Holt"),
                     "data[3].avatar", Matchers.equalTo("https://reqres.in/img/faces/4-image.jpg"));

        response.then().body("data[4].email", Matchers.equalTo("charles.morris@reqres.in"),
                "data[4].first_name", Matchers.equalTo("Charles"),
                         "data[4].last_name", Matchers.equalTo("Morris"),
                         "data[4].avatar", Matchers.equalTo("https://reqres.in/img/faces/5-image.jpg"));

        response.then().body("data[5].email", Matchers.equalTo("tracey.ramos@reqres.in"),
                        "data[5].first_name", Matchers.equalTo("Tracey"),
                        "data[5].last_name", Matchers.equalTo("Ramos"),
                        "data[5].avatar", Matchers.equalTo("https://reqres.in/img/faces/6-image.jpg"));


    }


}
