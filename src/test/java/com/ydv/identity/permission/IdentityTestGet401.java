package com.ydv.identity.permission;

import com.ydv.BaseTest;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;
import static org.testng.Assert.assertNotEquals;

public class IdentityTestGet401 extends BaseTest {


    @Test(dataProvider = "endpoints")
    public void identityGet401(String endpoint) throws IOException {

        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + endpoint);

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertNotEquals(actualStatus, 401);

    }
}
