package com.ydv.commerceBusinessLayer.cart;

import com.ydv.BaseTest;
import com.ydv.CBL.cart.cart;
import com.ydv.CBL.shipping.shipping;

import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class cartTest extends BaseTest {
    final static Logger logger = Logger.getLogger(cartTest.class);

    @Test(priority = 0)
    public void addToCart() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_CART() + "/api-cart/cart");
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        request.setHeader("x-site-context","{\"channel\":1,\"date\":\"2019-06-19\"}");
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CBL/cblAddToCart.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        cart cc = ResponseUtils.unmarshallGeneric(response, cart.class);
        System.out.println(cc);
    }
}
