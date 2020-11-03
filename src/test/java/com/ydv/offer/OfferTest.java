package com.ydv.offer;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class OfferTest extends BaseTest {

    @Test
    public void searchCreatedItem() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_OFFER()+"/items/search");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        System.out.println(GenerateXSiteContext.xSiteContext());
        String json = "{\"limit\":20,\"offset\":0,\"keyword\":\""+itemMap.get("itemSku")+"\",\"sku\":true}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response.getEntity());
        Search search = ResponseUtils.unmarshallGeneric(response, Search.class);
        //for debugging
        assertEquals(search.getResults()[0].getTitle(),itemMap.get("itemTitle"));
        assertEquals(search.getResults()[0].getSku(),itemMap.get("itemSku"));
        assertEquals(search.getResults()[0].getItemId(),Integer.parseInt(itemMap.get("itemId")));
        assertEquals(search.getResults()[0].getItems()[0].getItemId(),Integer.parseInt(itemMap.get("itemV1Id")));
        assertEquals(search.getResults()[0].getItems()[1].getItemId(),Integer.parseInt(itemMap.get("itemV2Id")));
        assertEquals(search.getResults()[0].getItems()[0].getSku(),itemMap.get("itemV1SKU"));
        assertEquals(search.getResults()[0].getItems()[1].getSku(),itemMap.get("itemV2SKU"));
        assertEquals(search.getResults()[0].getPriceRange().getMax(), "");
        assertEquals(search.getResults()[0].getPriceRange().getMin(), "");
        assertEquals(search.getQuery().getCount(), 1);
        assertEquals(search.getResults()[0].getVariantCount(), search.getResults()[0].getItems().length);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void getProduct() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_OFFER()+"/get-product/"+itemMap.get("itemSku"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response = client.execute(request);
        Result result = ResponseUtils.unmarshallGeneric(response, Result.class);
        System.out.println(result);
        assertEquals(result.getTitle(),itemMap.get("itemTitle"));
        assertEquals(result.getSku(),itemMap.get("itemSku"));
        assertEquals(result.getItemId(),Integer.parseInt(itemMap.get("itemId")));
        assertEquals(result.getItems()[0].getItemId(),Integer.parseInt(itemMap.get("itemV1Id")));
        assertEquals(result.getItems()[1].getItemId(),Integer.parseInt(itemMap.get("itemV2Id")));
        assertEquals(result.getItems()[0].getSku(),itemMap.get("itemV1SKU"));
        assertEquals(result.getItems()[1].getSku(),itemMap.get("itemV2SKU"));
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void addPriceToVariant() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_OFFER()+"/price");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json = "{\"itemIds\":["+itemMap.get("itemV1Id")+"],\"offers\":[{\"kind\":11,\"channel\":12,\"startDate\":\""+GenerateXSiteContext.startDate()+"\",\"endDate\":\""+GenerateXSiteContext.endDate()+"\",\"price\":{\"base\":\"100.00\",\"currency\":\"USD\",\"sale\":\"80.00\"}}]}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Rate[] rate = ResponseUtils.unmarshallRate(response, Rate.class);
        System.out.println(rate[0].getOffers()[0].getPrice().getBase());
        System.out.println(rate[0].getOffers()[0].getPrice().getSale());
        System.out.println(rate[0].getOffers()[0].getPrice().getCurrency());
        System.out.println(rate[0].getOffers()[0].getOfferCode());
        System.out.println(rate[0].getItemId());
        System.out.println(rate[0].getOfferId());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void addPriceToAllVariant() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_OFFER()+"/price");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json = "{\"itemIds\":["+itemMap.get("itemV1Id")+","+itemMap.get("itemV2Id")+"],\"offers\":[{\"kind\":11,\"channel\":12,\"startDate\":\""+GenerateXSiteContext.startDate()+"\",\"endDate\":\""+GenerateXSiteContext.endDate()+"\",\"price\":{\"base\":\"190.00\",\"currency\":\"USD\",\"sale\":\"180.00\"}}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Rate[] rate = ResponseUtils.unmarshallRate(response, Rate.class);
        assertEquals(rate[0].getOffers()[0].getPrice().getBase(),190);
        assertEquals(rate[0].getOffers()[0].getPrice().getSale(), 180);
        assertEquals(rate[0].getOffers()[0].getPrice().getCurrency(), "USD");
        System.out.println(rate[0].getOffers()[0].getOfferCode());
        System.out.println(rate[0].getItemId());
        System.out.println(rate[0].getOfferId());

        assertEquals(rate[1].getOffers()[0].getPrice().getBase(),190);
        assertEquals(rate[1].getOffers()[0].getPrice().getSale(), 180);
        assertEquals(rate[1].getOffers()[0].getPrice().getCurrency(), "USD");
        System.out.println(rate[1].getOffers()[0].getOfferCode());
        System.out.println(rate[1].getItemId());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        System.out.println(rate[1].getOfferId());
    }

}
