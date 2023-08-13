package resttests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiTest {

    public static final String URL = "https://reqres.in";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

    }
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
//                .expectStatusCode(200)
                .build();

    }

    public static ResponseSpecification forDeletion() {
        return new ResponseSpecBuilder()
//                .expectContentType(ContentType.JSON)
                .expectStatusCode(204)
                .build();
    }

    public static void setBaseRestAssuredSpec () {
        RestAssured.requestSpecification= getRequestSpec();
        RestAssured.responseSpecification = getResponseSpec();

    }

}
