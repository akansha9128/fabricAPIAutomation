package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.attribute.Attribute;
import com.ydv.utils.Credentials;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CreateAttributeTest extends BaseTest {

    @Test(priority = 1)
    public void createAttribute() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Attribute/attribute.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"test12auto");
        assertEquals(attribute.getDatatype(),"STRING");
        assertEquals(attribute.getDescription(), "Automation Attribute");
        assertTrue(attribute.getIsActive());
        attributeMap.put("attributeId", attribute.getAttributeId());
        attributeMap.put("attributeName", attribute.getName());
    }

     @Test(priority = 3)
    public void createDuplicateAttribute() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
         request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
         request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Attribute/attribute.json"), ContentType.APPLICATION_JSON));
         response = client.execute(request);
         Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertEquals(response.getStatusLine().getStatusCode(), 406);
        assertEquals(attribute.getCode(), "ATTRIBUTE_ALREADY_EXISTS");
        assertEquals(attribute.getMessage(), "You are trying to insert a already  attribute with name "+attributeMap.get("attributeName")+".");
    }

    @Test(priority = 4)
    public void renameAttributeName() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/update/"+attributeMap.get("attributeId"));
        System.out.println("For Rename Attribute ID is"  +attributeMap.get("attributeId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Attribute/renameAttribute.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertEquals(attribute.getName(), "Automation Renamed Attribute");
        assertEquals(attribute.getDatatype(),"BOOLEAN");
        assertEquals(attribute.getDescription(), "change data type and name of attribute");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        
    }

    @Test(priority = 5)
    public void deleteCreatedAttribute() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeMap.get("attributeId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void deleteAlreadyDeletedAttribute() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeMap.get("attributeId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 404);
    }


}

