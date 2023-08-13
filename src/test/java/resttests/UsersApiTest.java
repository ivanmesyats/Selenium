package resttests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.maven.surefire.shared.lang3.ObjectUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersApiTest {

    public static String userId;

    @Test

    public void usersTest () {
        BaseApiTest.setBaseRestAssuredSpec();
        List<UsersObject> users = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("data", UsersObject.class);

        Assertions.assertTrue(users.stream().allMatch(e-> e.getFirst_name().length() > 0 & e.getLast_name().length() > 0));

    }

    @Test
    public void userRegesterTest () {
//        BaseApiTest.setBaseRestAssuredSpec();
        RegesterObj newUser  = new RegesterObj("ivan", "none");
        userId = given()
                .when()
                .body(newUser)
                .post("/api/users")
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .get("id");

        Assertions.assertTrue(userId != null);


    }

    @Test
    public void userUpdateTest () {
//        BaseApiTest.setBaseRestAssuredSpec();
        RegesterObj updateUser  = new RegesterObj("Ivan", "some jobe tittle");
        given()
                .when()
                .body(updateUser)
                .put("/api/users/{userid}", userId)
                .then()
                .body("updatedAt", Matchers.notNullValue())
                .statusCode(200)
                .log()
                .all();

    }

    @Test
    public void userDelete () {
        RestAssured.requestSpecification= BaseApiTest.getRequestSpec();
        RestAssured.responseSpecification = BaseApiTest.forDeletion();
        given()
                .when()
                .delete("/api/users/{userid}", userId)
                .then()
                .log()
                .all();
        BaseApiTest.setBaseRestAssuredSpec();
    }

    @Test
    public void loginTest () throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        File loginJSON = new File("src/test/java/resttests/LoginJSON");
        LoginObject credtentials = mapper.readValue(loginJSON, LoginObject.class);

        var login = given()
                .when()
                .body(credtentials)
                .contentType(ContentType.JSON)
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .get("token");

        Assertions.assertEquals( "QpwL5tke4Pnpja7X4", login);

    }
}
