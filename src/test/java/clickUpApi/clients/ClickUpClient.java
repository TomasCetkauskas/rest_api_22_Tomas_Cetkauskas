package clickUpApi.clients;

import clickUpApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static clickUpApi.constants.ProjectConstants.API_TOKEN;
import static clickUpApi.constants.ProjectConstants.SPACE_ID;
public class ClickUpClient {
    public static Response createFolder( JSONObject obj ) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response createNewList( JSONObject obj ) {

        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getFolder().getId() + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();

    }

    public static Response ceateNewTask( JSONObject obj ) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + TestCaseContext.getList().getId() + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response removeTask() {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTask().getId())
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
    public static Response CheckTaskDeleted (){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTask().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}