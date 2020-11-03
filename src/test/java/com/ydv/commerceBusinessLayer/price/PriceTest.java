package com.ydv.commerceBusinessLayer.price;

import com.ydv.BaseTest;
import com.ydv.CBL.item.Item;
import com.ydv.offer.Rate;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class PriceTest extends BaseTest {

    @Test
    public void getPriceByItemId() throws IOException {
        HttpPost request  = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_PRICE()+"/offer/get-by-itemIds");
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity("{\"itemIds\":[\"1000010226\"]}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Rate[] rates = ResponseUtils.unmarshallRate(response, Rate.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        System.out.println(rates[0].get_id());
        System.out.println(rates[0].getItemId());
        System.out.println(rates[0].getOffers()[0].getOfferCode());
        System.out.println(rates[0].getOffers()[0].getPrice().getBase());
        System.out.println(rates[0].getOffers()[0].getPrice().getSale());
    }
}
