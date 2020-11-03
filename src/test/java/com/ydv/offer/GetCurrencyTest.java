package com.ydv.offer;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class GetCurrencyTest extends BaseTest {

    @Test
    public void getCurrency() throws IOException {
    HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_OFFER() + "/get-currency");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response = client.execute(request);
        GetCurrency getCurrency = ResponseUtils.unmarshallGeneric(response, GetCurrency.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(getCurrency.getName(), "US Web");
        assertEquals(getCurrency.getChannelId(), 12);
        assertEquals(getCurrency.getCurrencyCode(), "USD");
        assertEquals(getCurrency.getKind(), "Regional");
        assertEquals(getCurrency.getChannelCode(), "USA");
    }

}

