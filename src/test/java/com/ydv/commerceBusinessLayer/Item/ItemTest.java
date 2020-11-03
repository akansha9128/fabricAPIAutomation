package com.ydv.commerceBusinessLayer.Item;

import com.ydv.BaseTest;
import com.ydv.CBL.item.Item;
import com.ydv.CBL.item.Products;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class ItemTest extends BaseTest {

    @Test
    public void getItembyItemId() throws IOException {
        HttpGet request  = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_ITEM()+"/item/1000010226");
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response = client.execute(request);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        System.out.println(item.get_id());
        System.out.println(item.getItemId());
        System.out.println(item.getAttributes()[0].getId());
        System.out.println(item.getAttributes()[0].getIsDefault());
        System.out.println(item.getAttributes()[0].getName());
        System.out.println(item.getAttributes()[0].getValue());
        System.out.println(item.getAttributes().length);
    }

    @Test
    public void getItembySKU() throws IOException {
        HttpGet request  = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_ITEM()+"/item/product/1598819-CONFIG");
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response = client.execute(request);
        Products products = ResponseUtils.unmarshallGeneric(response, Products.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        System.out.println(products.getProduct().get_id());
        System.out.println(products.getProduct().getItemId());
        System.out.println(products.getProduct().getPrice().getSale());
        System.out.println(products.getProduct().getPrice().getBase());
        System.out.println(products.getProduct().getPrice().getCurrency());
    }

    @Test
    public void getItemBySKUs() throws IOException {
        HttpPost request  = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_ITEM()+"/item/sku");
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity("{\"skus\":[\"1598819-CONFIG\"]}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Item[] items = ResponseUtils.unmarshallItem(response, Item.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        System.out.println(items[0].get_id());
        System.out.println(items[0].getItemId());
        System.out.println(items[0].getTitle());
        System.out.println(items[0].getDescription());
        System.out.println(items.length);
    }
}
