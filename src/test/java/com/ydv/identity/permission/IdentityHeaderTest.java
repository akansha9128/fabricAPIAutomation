package com.ydv.identity.permission;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.*;


import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class IdentityHeaderTest extends BaseTest {


    @Test(dataProvider = "endpoints")
    public void getTansferEncoding(String endpoints) throws IOException {
        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + endpoints);
        response = client.execute(get);
        String encoding = ResponseUtils.getHeader(response, "Transfer-Encoding");
        assertEquals(encoding, "chunked");
    }

    @Test(dataProvider = "endpoints")
    public void contentTypeIsJson(String endpoints) throws IOException {
        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + endpoints);
        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");

    }
}
