package helpers;

import config.GetConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(GetConfig.getUser(), GetConfig.getKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
