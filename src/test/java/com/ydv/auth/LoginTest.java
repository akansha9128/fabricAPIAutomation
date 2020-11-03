package com.ydv.auth;

import com.ydv.BaseTest;
import com.ydv.login.Login;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Parameters({"userId", "emailId", "password"})
    @Test
    public void loginCopilot(String userId, String emailId, String password) throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY()+"/auth/local/login") ;
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json = "{\"username\" :\""+emailId+"\", \"password\" :\""+password+"\", \"accountId\" :\""+userId+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Login l = ResponseUtils.unmarshallGeneric(response, Login.class);
        l.getAccessToken();
        Credentials.TOKEN = l.getAccessToken();
        assertEquals(response.getStatusLine().getStatusCode(),200);
        System.out.println("We have logged in successfully");
    }
}
