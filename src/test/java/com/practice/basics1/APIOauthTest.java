package com.practice.basics1;

import com.practice.basics1.pojo.GetCourse;
import com.practice.basics1.pojo.WebAutomation;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIOauthTest {

    public static void main (String[] args)
    {

        String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};


        String responseForToken = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        System.out.println("Following is the response for token ===>>> " +responseForToken);

        JsonPath jsonResponse = new JsonPath(responseForToken);

        String accessToken = jsonResponse.getString("access_token");

        System.out.println("Following is the access token ===>>> " +accessToken);

        String responseFinal1 = given().queryParam("access_token",accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();


//        System.out.println("Following is the final response ===>>> " +responseFinal1);

        GetCourse gc = given().queryParam("access_token", accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());
        System.out.println(gc.getCourses().getApi().get(0).getCourseTitle());
        List<WebAutomation> webAuto = gc.getCourses().getWebAutomation();
        ArrayList<String> actualList = new ArrayList<String>();
        for (WebAutomation webAutomation : webAuto)
        {
            System.out.println(webAutomation.getCourseTitle());
        }
        for (WebAutomation webAutomation : webAuto)
        {
            actualList.add(webAutomation.getCourseTitle());
        }

        List<String> expectedList = Arrays.asList(courseTitles);  // Converts array to Array list
        Assert.assertEquals(expectedList, actualList);



    }


}
