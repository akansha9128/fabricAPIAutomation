package com.ydv.commerceBusinessLayer.shipping;

import com.ydv.BaseTest;
import com.ydv.CBL.shipping.shipping;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class createShipping extends BaseTest {
    final static Logger logger = Logger.getLogger(createShipping.class);

    private int shippingMethodId;

    @Test(priority = 0)
    public void createShipping() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/create");
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CBL/cblCreateShipping.json"), ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        shippingMethodId = ship.getShippingMethodId();
        System.out.println(shippingMethodId);
        logger.info("shipping method id is" + shippingMethodId);
        assertEquals(ship.getName(), "Cathal Test");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void getShippingById() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/" + shippingMethodId);
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        assertEquals(ship.getName(), "Cathal Test");
        assertEquals(ship.getDescription(), "Cathal Testing this write in");
        assertEquals(ship.getTaxCode(), "FR123456");
        assertEquals(ship.getMinimumDays(), 2);
        assertEquals(ship.getMaximumDays(), 4);
        assertEquals(ship.getCutOffTime(), 1600);
        assertEquals(ship.getCost(), 5.99);
        assertEquals(ship.getCreatedBy(), "41224d776a326fb40f000001");
        assertEquals(ship.getAddressType()[0],"PO");
        assertEquals(ship.getChannel()[0], 100);
        assertEquals(ship.getChannel()[1], 200);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void getShippingByAll() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/all");
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping[] ship = ResponseUtils.unmarshall(response, shipping.class);
        assertEquals(ship[0].getName(), "Cathal Test");
        assertEquals(ship[0].getDescription(), "Cathal Testing this write in");
        assertEquals(ship[0].getTaxCode(), "FR123456");
        assertEquals(ship[0].getMinimumDays(), 2);
        assertEquals(ship[0].getMaximumDays(), 4);
        assertEquals(ship[0].getCutOffTime(), 1600);
        assertEquals(ship[0].getCost(), 5.99);
        assertEquals(ship[0].getCreatedBy(), "41224d776a326fb40f000001");
        assertEquals(ship[0].getAddressType()[0],"PO");
        assertEquals(ship[0].getChannel()[0], 100);
        assertEquals(ship[0].getChannel()[1], 200);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }



    @Test(priority = 3)
    public void updateCreatedShipping() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/update/" + shippingMethodId);
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        request.setEntity(new StringEntity("{\"name\":\"Cathal Diverrrrrrrr Test\",\"description\":\"Cathal Testing this write in\",\"taxCode\":\"FR1234567\",\"minimumDays\":3,\"maximumDays\":5,\"cutOffTime\":1800,\"cost\":6.99,\"channel\":[300,400],\"addressType\":[\"APO\"],\"updatedBy\":\"41224d776a326fb40f000002\"}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        assertEquals(ship.getName(), "Cathal Diverrrrrrrr Test");
        assertEquals(ship.getDescription(), "Cathal Testing this write in");
        assertEquals(ship.getTaxCode(), "FR1234567");
        assertEquals(ship.getMinimumDays(), 3);
        assertEquals(ship.getMaximumDays(), 5);
        assertEquals(ship.getCutOffTime(), 1800);
        assertEquals(ship.getCost(), 6.99);
        assertEquals(ship.getCreatedBy(), "41224d776a326fb40f000001");
        assertEquals(ship.getUpdatedBy(), "41224d776a326fb40f000002");
        assertEquals(ship.getAddressType()[0],"APO");
        assertEquals(ship.getChannel()[0], 300);
        assertEquals(ship.getChannel()[1], 400);
        assertEquals(response.getStatusLine().getStatusCode(), 200);

    }


    @Test(priority = 4)
    public void getShippingByIdAfterUpdate() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/" + shippingMethodId);
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        assertEquals(ship.getName(), "Cathal Diverrrrrrrr Test");
        assertEquals(ship.getDescription(), "Cathal Testing this write in");
        assertEquals(ship.getTaxCode(), "FR1234567");
        assertEquals(ship.getMinimumDays(), 3);
        assertEquals(ship.getMaximumDays(), 5);
        assertEquals(ship.getCutOffTime(), 1800);
        assertEquals(ship.getCost(), 6.99);
        assertEquals(ship.getCreatedBy(), "41224d776a326fb40f000001");
        assertEquals(ship.getAddressType()[0],"APO");
        assertEquals(ship.getChannel()[0], 300);
        assertEquals(ship.getChannel()[1], 400);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void deletedShipping() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/delete/" + shippingMethodId);
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        assertEquals(ship.getName(), "Cathal Diverrrrrrrr Test");
        assertEquals(ship.getDescription(), "Cathal Testing this write in");
        assertEquals(ship.getTaxCode(), "FR1234567");
        assertEquals(ship.getMinimumDays(), 3);
        assertEquals(ship.getMaximumDays(), 5);
        assertEquals(ship.getCutOffTime(), 1800);
        assertEquals(ship.getCost(), 6.99);
        assertEquals(ship.getCreatedBy(), "41224d776a326fb40f000001");
        assertEquals(ship.getAddressType()[0],"APO");
        assertEquals(ship.getChannel()[0], 300);
        assertEquals(ship.getChannel()[1], 400);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void verifyDeletedShippingMethod() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/" + shippingMethodId);
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping ship = ResponseUtils.unmarshallGeneric(response, shipping.class);
        assertEquals(ship.getCode(), "SHIPPING_METHOD_NOT_FOUND");
        assertEquals(ship.getMessage(), "Shipping Method Not Found.");
        assertEquals(ship.getStatusCode(), 404);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void verifyGetAllShippingMethodWithoutData() throws IOException, ClassNotFoundException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_SERVICE_SHIPPING() + "/data-shipping/shipping/all");
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        response = client.execute(request);
        shipping[] ship  = (ResponseUtils.unmarshall(response, shipping.class));
       assertEquals(ship.length, 0);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

}
