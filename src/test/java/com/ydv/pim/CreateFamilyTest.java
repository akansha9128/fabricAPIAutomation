package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.attribute.Attribute;
import com.ydv.pim.attributeGroup.AttributeGroup;
import com.ydv.pim.itemFamily.ItemFamily;
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

public class CreateFamilyTest extends BaseTest {

    @Test(priority = 1)
    public void createAttribute1() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Family/attribute1.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"familyAttribute1");
        assertEquals(attribute.getDatatype(),"STRING");
        assertEquals(attribute.getDescription(), "Attribute for Family");
        assertTrue(attribute.getIsActive());
        familyMap.put("attribute1Id", attribute.getAttributeId());
        familyMap.put("attribute1Name", attribute.getName());
        familyMap.put("attribute1MId",attribute.get_id());
    }

    @Test(priority = 2)
    public void createAttribute2() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Family/attribute2.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"familyAttribute2");
        assertEquals(attribute.getDatatype(),"BOOLEAN");
        assertEquals(attribute.getDescription(), "Attribute for Family");
        assertTrue(attribute.getIsActive());
        familyMap.put("attribute2Id", attribute.getAttributeId());
        familyMap.put("attribute2Name", attribute.getName());
        familyMap.put("attribute2MId",attribute.get_id());
    }

    @Test(priority = 3)
    public void createAttribute3() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Family/attribute3.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"familyAttribute3");
        assertEquals(attribute.getDatatype(),"NUMBER");
        assertEquals(attribute.getDescription(), "Attribute for Family");
        assertTrue(attribute.getIsActive());
        familyMap.put("attribute3Id", attribute.getAttributeId());
        familyMap.put("attribute3Name", attribute.getName());
        familyMap.put("attribute3MId",attribute.get_id());
    }

    @Test(priority = 4)
    public void createAttribute4() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Family/attribute4.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(),"familyAttribute4");
        assertEquals(attribute.getDatatype(),"DATE");
        assertEquals(attribute.getDescription(), "Attribute for Family");
        assertTrue(attribute.getIsActive());
        familyMap.put("attribute4Id", attribute.getAttributeId());
        familyMap.put("attribute4Name", attribute.getName());
        familyMap.put("attribute4MId",attribute.get_id());
    }

    @Test(priority = 5)
    public void createAttributeGroup() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"name\":\"AttributeGroupForFamily\",\"attributes\":[{\"id\":\""+familyMap.get("attribute3MId")+"\",\"order\":1},{\"id\":\""+familyMap.get("attribute4MId")+"\",\"order\":2}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertTrue(attributeGroup.getIsActive());
        assertEquals(attributeGroup.getName(), "AttributeGroupForFamily");
        assertEquals(attributeGroup.getAttributes()[0].getId(), familyMap.get("attribute3MId"));
        assertEquals(attributeGroup.getAttributes()[1].getId(), familyMap.get("attribute4MId"));
        familyMap.put("attributeGroupMId", attributeGroup.get_id());
        familyMap.put("attribute3MIdInAttributeGroup", attributeGroup.getAttributes()[0].get_id());
        familyMap.put("attribute4MIdInAttributeGroup", attributeGroup.getAttributes()[1].get_id());
        familyMap.put("attributeGroupId", attributeGroup.getAttributeGroupId());
    }

    @Test(priority = 6)
    public void createItemFamily() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/family/create");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        String json =
                "{\"name\":\"Family\",\"attributes\":[{\"id\":\""+familyMap.get("attribute1MId")+"\",\"value\":null,\"datatype\":\"STRING\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":1}," +
                "{\"id\":\""+familyMap.get("attribute2MId")+"\",\"value\":null,\"datatype\":\"HTML\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":2}," +
                "{\"attributeGroupId\":\""+familyMap.get("attributeGroupMId")+"\",\"id\":\""+familyMap.get("attribute3MId")+"\",\"value\":null,\"datatype\":\"NUMBER\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":3}," +
                "{\"attributeGroupId\":\""+familyMap.get("attributeGroupMId")+"\",\"id\":\""+familyMap.get("attribute4MId")+"\",\"value\":null,\"datatype\":\"DATE\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":4}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertTrue(itemFamily.getIsActive());
        assertEquals(itemFamily.getName(), "Family");
        assertEquals(itemFamily.getAttributes()[0].getAttributeGroupId(), null);
        assertEquals(itemFamily.getAttributes()[0].getId(), familyMap.get("attribute1MId"));
        assertTrue(itemFamily.getAttributes()[0].getIsEditable());
        assertTrue(itemFamily.getAttributes()[0].getdisplay());
        assertFalse(itemFamily.getAttributes()[0].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[0].getIsActive());
        assertFalse(itemFamily.getAttributes()[0].getIsRequired());
        assertFalse(itemFamily.getAttributes()[0].getIsMulitple());
        assertEquals(itemFamily.getAttributes()[0].getOrder(), 1);
        assertEquals(itemFamily.getAttributes()[0].getValue(), "");
        assertEquals(itemFamily.getAttributes()[1].getAttributeGroupId(), null);
        assertEquals(itemFamily.getAttributes()[1].getId(), familyMap.get("attribute2MId"));
        assertTrue(itemFamily.getAttributes()[1].getIsEditable());
        assertTrue(itemFamily.getAttributes()[1].getdisplay());
        assertFalse(itemFamily.getAttributes()[1].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[1].getIsActive());
        assertFalse(itemFamily.getAttributes()[1].getIsRequired());
        assertFalse(itemFamily.getAttributes()[1].getIsMulitple());
        assertEquals(itemFamily.getAttributes()[1].getOrder(), 2);
        assertEquals(itemFamily.getAttributes()[1].getValue(), "");
        assertEquals(itemFamily.getAttributes()[2].getAttributeGroupId(), familyMap.get("attributeGroupMId"));
        assertEquals(itemFamily.getAttributes()[2].getId(), familyMap.get("attribute3MId"));
        assertTrue(itemFamily.getAttributes()[2].getIsEditable());
        assertTrue(itemFamily.getAttributes()[2].getdisplay());
        assertFalse(itemFamily.getAttributes()[2].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[2].getIsActive());
        assertFalse(itemFamily.getAttributes()[2].getIsRequired());
        assertFalse(itemFamily.getAttributes()[2].getIsMulitple());
        assertEquals(itemFamily.getAttributes()[2].getOrder(), 3);
        assertEquals(itemFamily.getAttributes()[2].getValue(), "");
        familyMap.put("itemFamilyId",itemFamily.getItemFamilyId());
        familyMap.put("itemFamilyMId",itemFamily.get_id());
    }

    @Test(priority = 7)
    public void createDuplicateFamily() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/family/create");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        String json = "{\"name\":\"Family\",\"attributes\":[{\"id\":\""+familyMap.get("attribute1MId")+"\",\"value\":null,\"datatype\":\"STRING\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":1}," +
                "{\"id\":\""+familyMap.get("attribute2MId")+"\",\"value\":null,\"datatype\":\"HTML\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":2}," +
                "{\"attributeGroupId\":\""+familyMap.get("attributeGroupMId")+"\",\"id\":\""+familyMap.get("attribute3MId")+"\",\"value\":null,\"datatype\":\"NUMBER\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":3}," +
                "{\"attributeGroupId\":\""+familyMap.get("attributeGroupMId")+"\",\"id\":\""+familyMap.get("attribute4MId")+"\",\"value\":null,\"datatype\":\"DATE\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":4}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        assertEquals(response.getStatusLine().getStatusCode(), 406);
        assertEquals(itemFamily.getCode(), "ITEM_FAMILY_NAME_EXISTS");
        assertEquals(itemFamily.getMessage(), "item family name already exists.");
    }

    @Test(priority = 8)
    public void updateItemFamily() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM()+"/family/update/"+familyMap.get("itemFamilyId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        String json = "{\"name\":\"Family Updated\",\"attributes\":[{\"id\":\""+familyMap.get("attribute1MId")+"\",\"value\":\"\",\"datatype\":\"STRING\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":1},{\"id\":\""+familyMap.get("attribute2MId")+"\",\"value\":\"\",\"datatype\":\"BOOLEAN\",\"isEditable\":true,\"display\":true,\"isAttribute\":false,\"isRequired\":false,\"isActive\":true,\"order\":2}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(itemFamily.getName(), "Family Updated");
        assertEquals(itemFamily.getItemFamilyId(), familyMap.get("itemFamilyId"));
        assertEquals(itemFamily.getAttributes()[0].getAttributeGroupId(), null);
        assertEquals(itemFamily.getAttributes().length, 2);
        assertEquals(itemFamily.getAttributes()[0].getId(), familyMap.get("attribute1MId"));
        assertTrue(itemFamily.getAttributes()[0].getIsEditable());
        assertTrue(itemFamily.getAttributes()[0].getdisplay());
        assertFalse(itemFamily.getAttributes()[0].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[0].getIsActive());
        assertFalse(itemFamily.getAttributes()[0].getIsRequired());
        assertFalse(itemFamily.getAttributes()[0].getIsMulitple());
        assertEquals(itemFamily.getAttributes()[0].getOrder(), 1);
        assertEquals(itemFamily.getAttributes()[0].getValue(), "");
        assertEquals(itemFamily.getAttributes()[1].getAttributeGroupId(), null);
        assertEquals(itemFamily.getAttributes()[1].getId(), familyMap.get("attribute2MId"));
        assertTrue(itemFamily.getAttributes()[1].getIsEditable());
        assertTrue(itemFamily.getAttributes()[1].getdisplay());
        assertFalse(itemFamily.getAttributes()[1].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[1].getIsActive());
        assertFalse(itemFamily.getAttributes()[1].getIsRequired());
        assertFalse(itemFamily.getAttributes()[1].getIsMulitple());
        assertEquals(itemFamily.getAttributes()[1].getOrder(), 2);
        assertEquals(itemFamily.getAttributes()[1].getValue(), "");
    }

    @Test(priority = 9)
    public void deleteItemFamily() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM()+"/family/"+familyMap.get("itemFamilyId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        response = client.execute(request);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(itemFamily.getName(), "Family Updated");
        assertEquals(itemFamily.getItemFamilyId(), familyMap.get("itemFamilyId"));
        assertFalse(itemFamily.getIsActive());
        assertEquals(itemFamily.get_id(), familyMap.get("itemFamilyMId"));
    }

        @Test(priority = 10)
        public void deleteCreatedAttributeGroup() throws IOException {
            HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute-group/" + familyMap.get("attributeGroupMId"));
            request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
            response = client.execute(request);
            AttributeGroup attributeGroup = ResponseUtils.unmarshallGeneric(response, AttributeGroup.class);
            assertFalse(attributeGroup.getIsActive());
            assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

        @Test(priority = 11)
        public void deleteAttribute1() throws IOException {
            HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+familyMap.get("attribute1Id"));
            request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
            response = client.execute(request);
            Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
            assertFalse(attribute.getIsActive());
            assertEquals(response.getStatusLine().getStatusCode(), 200);
        }

    @Test(priority = 12)
    public void deleteAttribute2() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+familyMap.get("attribute2Id"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 13)
    public void deleteAttribute3() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+familyMap.get("attribute3Id"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }


    @Test(priority = 14)
    public void deleteAttribute4() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+familyMap.get("attribute4Id"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        assertFalse(attribute.getIsActive());
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
    }
