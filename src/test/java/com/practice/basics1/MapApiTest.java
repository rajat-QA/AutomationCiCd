package com.practice.basics1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.basics1.pojo.Location;
import com.practice.basics1.pojo.MapApiBody;
import com.practice.basics1.pojo.MapApiResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class MapApiTest {

    public static void main (String[] args) throws JsonProcessingException {

//        RestAssured.baseURI = "https://rahulshettyacademy.com";

        MapApiBody mb = new MapApiBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Location l = new Location("-38.383494","33.427362");

//        System.out.println(l.getLat()+" - "+l.getLng());              // We can set data with constructor and without constructor both
//        l.setLat("-18.383494");
//        l.setLng("22.427000");
//        System.out.println(l.getLat()+" - "+l.getLng());

        mb.setLocation(l);
        mb.setAccuracy("50");
        mb.setName("Frontline house");
        mb.setPhone_number("(+91) 983 893 3937");
        mb.setAddress("29, side layout, cohen 09");
        String[] types  = {"shoe park","shop"};
        mb.setTypes(Arrays.asList(types));
        mb.setWebsite("http://google.com");
        mb.setLanguage("French-IN");

        String body = objectMapper.writeValueAsString(mb);  // Using Object Mapper we can write json with control over accuracy

        String response = given().queryParam("key","qaclick123").body(body)
                .when().log().all()
                .post("https://rahulshettyacademy.com/maps/api/place/add/json").
                then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("API Response ==> "+response);

        // Use jackson lib (ObjectMapper Class) to deserialize the Response


        MapApiResponse mbResponse = objectMapper.readValue(response, MapApiResponse.class);
        System.out.println("Following is Place ID generated => "+mbResponse.getPlace_id());

        // For Deserialization there are 2 approaches
        // 1. Using Object Mapper Class (Jackson lib)
        // 2. Using as(PojoClassName.class) method to get response in class variable using restAssured


    }


}
