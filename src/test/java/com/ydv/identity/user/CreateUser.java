package com.ydv.identity.user;

import com.ydv.BaseTest;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CreateUser extends BaseTest {

    @Test
    public void createUser() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/User/local/");

        String json = "{\"User\": {\"registrationSite\": \"ydv.com\"},\"provider\": {\"username\": \"testing\",\"password\": \"automation\"}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);


    }
}
