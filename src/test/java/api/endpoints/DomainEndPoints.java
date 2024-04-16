package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//import org.apache.http.conn.util.DomainType;

import api.payload.Domain;

public class DomainEndPoints {
    public static Response createDomain(Domain payload) {
        Response res = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
        return res;
    }
    
    public static Response readDomain(String string) {
        Response res = given()
               .pathParam("id", string)
                .when()
                .get(Routes.get_url);
        return res;
    }
    
    public static Response updateDomain(int id, Domain payload) {
        Response res = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam("id", id)
                .when()
                .put(Routes.update_url);
        return res;
    }
    
    public static Response deleteDomain(int id) {
        Response res = given()
               .pathParam("id", id)
                .when()
                .delete(Routes.delete_url);
        return res;
    }
}

