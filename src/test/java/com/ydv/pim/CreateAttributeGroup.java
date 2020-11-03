package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.attribute.Attribute;
import com.ydv.pim.attributeGroup.AttributeGroup;
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

public class CreateAttributeGroup extends BaseTest {

    @Test(priority = 1)
    public void createAttribute1() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/AttributeGroup/attribute1.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"attribute1");
        assertEquals(attribute.getDatatype(),"STRING");
        assertEquals(attribute.getDescription(), "Attribute for Attribute Group");
        assertTrue(attribute.getIsActive());
        attributeGroupMap.put("attribute1Id", attribute.getAttributeId());
        attributeGroupMap.put("attribute1MId", attribute.get_id());
        attributeGroupMap.put("attribute1Name", attribute.getName());
    }

    @Test(priority = 2)
    public void createAttribute2() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/AttributeGroup/attribute2.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"attribute2");
        assertEquals(attribute.getDatatype(),"BOOLEAN");
        assertEquals(attribute.getDescription(), "Attribute for Attribute Group");
        assertTrue(attribute.getIsActive());
        attributeGroupMap.put("attribute2Id", attribute.getAttributeId());
        attributeGroupMap.put("attribute2MId", attribute.get_id());
        attributeGroupMap.put("attribute2Name", attribute.getName());
    }

    @Test(priority = 2)
    public void createAttributeGroup() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"name\":\"group\",\"attributes\":[{\"id\":\""+attributeGroupMap.get("attribute1MId")+"\",\"order\":1},{\"id\":\""+attributeGroupMap.get("attribute2MId")+"\",\"order\":2}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertTrue(attributeGroup.getIsActive());
        assertEquals(attributeGroup.getName(), "group");
        assertEquals(attributeGroup.getAttributes()[0].getId(), attributeGroupMap.get("attribute1MId"));
        assertEquals(attributeGroup.getAttributes()[1].getId(), attributeGroupMap.get("attribute2MId"));
        attributeGroupMap.put("attributeGroupMId", attributeGroup.get_id());
        attributeGroupMap.put("attribute1MIdInAttributeGroup", attributeGroup.getAttributes()[0].get_id());
        attributeGroupMap.put("attribute2MIdInAttributeGroup", attributeGroup.getAttributes()[1].get_id());
        attributeGroupMap.put("attributeGroupId", attributeGroup.getAttributeGroupId());
    }

    @Test(priority = 3)
    public void createDuplicateAttributeGroup() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"name\":\"group\",\"attributes\":[{\"id\":\""+attributeGroupMap.get("attribute1MId")+"\",\"order\":1},{\"id\":\""+attributeGroupMap.get("attribute2MId")+"\",\"order\":2}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
        assertEquals(response.getStatusLine().getStatusCode(), 406);
        assertEquals(attributeGroup.getCode(), "ATTRIBUTE_GROUP_NAME_EXISTS");
        assertEquals(attributeGroup.getMessage(), "Attribute group name already exists.");
    }

    @Test(priority = 4)
    public void updateAttributeGroup() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group/" + attributeGroupMap.get("attributeGroupMId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"name\":\"group\",\"attributes\":[{\"id\":\""+attributeGroupMap.get("attribute1MId")+"\",\"order\":1}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertTrue(attributeGroup.getIsActive());
        assertEquals(attributeGroup.getName(), "group");
        assertEquals(attributeGroup.getAttributes()[0].getId(), attributeGroupMap.get("attribute1MId"));
        assertEquals(attributeGroup.getAttributes().length, 1);
        assertEquals(attributeGroup.getAttributeGroupId(), attributeGroupMap.get("attributeGroupId"));
    }


    @Test(priority = 6)
    public void deleteAttributeGroup() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group/" + attributeGroupMap.get("attributeGroupMId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
        assertFalse(attributeGroup.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void deleteAlreadyDeletedGroup() throws IOException{
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group/" + attributeGroupMap.get("attributeGroupMId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 404);
    }

    @Test(priority = 8)
     public void deleteAttribute1() throws IOException{
        System.out.println(attributeGroupMap.get("attribute1Id"));
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeGroupMap.get("attribute1Id"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 9)
    public void deleteAttribute2() throws IOException{
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeGroupMap.get("attribute2Id"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}


