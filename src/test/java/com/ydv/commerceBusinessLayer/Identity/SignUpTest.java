package com.ydv.commerceBusinessLayer.Identity;

import com.ydv.BaseTest;
import com.ydv.CBL.auth.Login;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    @Test
    public void createUser() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "user/local");
        String xsite = "{\"site\": \"abchome.com\"}";
        System.out.println(xsite);
        request.setHeader("x-site-context",xsite);
        String email = GenerateXSiteContext.getEmailId();
        String json = "{\"user\":{\"name\":{\"first\":\"Shivam\",\"last\":\"Gupta\"},\"email\":\""+email+"\",\"extra\":{\"phone\":\"\"}},\"provider\":{\"username\":\""+email+"\",\"password\":\"shivam3112\"}}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Login login = ResponseUtils.unmarshallGeneric(response, Login.class);
       // Credentials.TOKEN= login.getAccessToken();
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        userMap.put("userMId", login.get_id());
        userMap.put("userEmail", email);
        userMap.put("userPassword", "shivam3112");
        userMap.put("userId", login.getUserId());
        userMap.put("userRoleId", login.getRoles()[0].getId());
        userMap.put("userFName", login.getName().getFirst());
        userMap.put("userLName", login.getName().getLast());
    }

    @Test
    public void loginWithCreatedUser() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "auth/local/login");
      //  request.setHeader("x-site-context","{\"site\": \"abchome.com\"}");
//        String json =" {\"username\":\""+userMap.get("userEmail")+"\",\"password\":\""+userMap.get("userPassword")+"\"}";
        String json = " {\"username\":\"abcdtest@gmail.com\",\"password\":\"shivam3112\"}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Login login = ResponseUtils.unmarshallGeneric(response, Login.class);
        Credentials.TOKEN= login.getAccessToken();
        assertEquals(response.getStatusLine().getStatusCode(), 200);
      //  assertEquals(login.get_id(), userMap.get("userMId"));
       // assertEquals(login.getName().getFirst(), userMap.get("userFName"));
       // assertEquals(login.getName().getLast(), userMap.get("userLName"));
        userMap.put("userMId", login.get_id());
        userMap.put("userEmail", "abcdtest@gmail.com");
        userMap.put("userPassword", "shivam3112");
        userMap.put("userId", login.getUserId());
        userMap.put("userRoleId", login.getRoles()[0].getId());
        userMap.put("userFName", login.getName().getFirst());
        userMap.put("userLName", login.getName().getLast());

    }

}
