package com.ydv.regions;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class createRegionTest extends BaseTest {


    @Test
    public void createCityRegionWithoutParent() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_REGIONS() + "/admin/region/");
        String json = "{\"name\":\"City Test\",\"regionCode\":\"T1\",\"kind\": \""+RegionKind.City.toString()+"\",\"currencyCode\":\"INR\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Region region = ResponseUtils.unmarshallGeneric(response, Region.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(region.getName(), "City Test");
        assertEquals(region.getCurrencyCode(), "INR");
        assertEquals(region.getRegionCode(), "T1");
        assertEquals(region.getKind().toString(), "City");
        assertEquals(region.getParent(), null);
    }

    @Test
    public void createStateRegionWithoutParent() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_REGIONS() + "/admin/region/");
        String json = "{\"name\":\"State Test\",\"regionCode\":\"T2\",\"kind\": \""+RegionKind.State.toString()+"\",\"currencyCode\":\"INR\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Region region = ResponseUtils.unmarshallGeneric(response, Region.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(region.getName(), "State Test");
        assertEquals(region.getCurrencyCode(), "INR");
        assertEquals(region.getRegionCode(), "T2");
        assertEquals(region.getKind().toString(), "State");
        assertEquals(region.getParent(), null);
    }
    @Test
    public void createCountryRegionWithoutParent() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_REGIONS() + "/admin/region/");
        String json = "{\"name\":\"Country Test\",\"regionCode\":\"T3\",\"kind\": \""+RegionKind.Country.toString()+"\",\"currencyCode\":\"INR\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Region region = ResponseUtils.unmarshallGeneric(response, Region.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(region.getName(), "Country Test");
        assertEquals(region.getCurrencyCode(), "INR");
        assertEquals(region.getRegionCode(), "T3");
        assertEquals(region.getKind().toString(), "Country");
        assertEquals(region.getParent(), null);
    }

}
