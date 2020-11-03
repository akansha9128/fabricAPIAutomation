package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.attribute.Attribute;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ItemFamilyTest extends BaseTest {


    String itemTypeID = "";
    String attributeID = "";


    @BeforeClass
    public void beforeClass() {
        CreateAttributeTest createAttributeTest = new CreateAttributeTest();

    }

    @Test(priority = 1)
    public void createItemType() throws IOException {
        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item-type");
        // Define Json to Post and set as Entity
        String json = "{\"name\":\"jeans\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        //ItemType itemType = ResponseUtils.unmarshallGeneric(response, ItemType.class);
       // itemTypeID = itemType.get_id();
        System.out.println("my getID is " + itemTypeID);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }


    @Test(priority = 2)
    public void createAttribute() throws IOException {
        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute");
        // Define Json to Post and set as Entity
        String json = "{\"name\":\"length\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        attributeID = attribute.get_id();
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }


    //TODO, COPI-64
    @Test(priority = 3)
    public void createItemAttribue() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item-attribute/"+itemTypeID+"/attribute/"+attributeID);
        response = client.execute(request);
    }

    @Test
    public void createDuplicateItemAttribute() {

    }

    @Test void updateItemAttribute() {

    }

    @Test(priority = 4)
    public void deleteCreatedAttribute() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/" + attributeID);
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
      //  assertEquals(attribute.getIsActive(), "false");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void deleteCreatedItemType() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/item-type/"+itemTypeID);
        response = client.execute(request);
//        ItemType itemType = ResponseUtils.unmarshallGeneric(response, ItemType.class);
//        assertEquals(itemType.getIsActive(), "false");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }


}


