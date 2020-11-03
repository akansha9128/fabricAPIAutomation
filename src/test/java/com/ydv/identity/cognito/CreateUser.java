package com.ydv.identity.cognito;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CreateUser extends BaseTest {
    String userID = "";

    @Test(priority = 1)
    public void createCognitoUser() throws IOException {

        HttpPost request = new HttpPost("http://localhost:4031/User/cognito");
        // Define Json to Post and set as Entity
        String json = "{\"User\": {\"registrationSite\": \"ydvtest.io\",\"email\":\"shivam.gupta@ydv.io\"},\"provider\":{\"username\": \"test1322313\",\"password\":\"Testing@123\"}}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        User user = ResponseUtils.unmarshallGeneric(response, User.class);
        userID = user.getUser();
        System.out.println(userID);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void validateCognitoUserDetails() throws IOException {
        HttpGet request = new HttpGet("http://localhost:4031/User/"+userID);
        response = client.execute(request);
        User user =  ResponseUtils.unmarshallGeneric(response, User.class);
        assertEquals(user.getEmail(), "shivam.gupta@ydv.io" );
        assertEquals(user.getRegistrationSite(), "ydvtest.io");
        assertEquals(user.getProvider()[0].getName(), "COGNITO-LOCAL");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
     }

     @Test(priority = 4)
    public void createDeletedUser() throws IOException {
         HttpDelete request = new HttpDelete("http://localhost:4031/User/"+userID);
         response = client.execute(request);
         assertEquals(response.getStatusLine().getStatusCode(),200);
     }

     //TODO Invalid Status Code
     @Test(priority = 3)
    public void createDuplicateUser() throws IOException {
         HttpPost request = new HttpPost("http://localhost:4031/User/cognito");
         // Define Json to Post and set as Entity
         String json = "{\"User\": {\"registrationSite\": \"ydvtest.io\",\"email\":\"shivam.gupta@ydv.io\"},\"provider\":{\"username\": \"test1322313\",\"password\":\"Testing@123\"}}";

         request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
         // Send
         response = client.execute(request);

         User user = ResponseUtils.unmarshallGeneric(response, User.class);

         assertEquals(response.getStatusLine().getStatusCode(), 500);
     }
    }

