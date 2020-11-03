package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.group.Group;
import com.ydv.utils.Credentials;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.*;

import java.io.IOException;


import static org.testng.Assert.*;

public class CategoryTest extends BaseTest {

   private static Number categoryId;
   private static Number childCategoryId;
   private static String parentCategoryMId;
   private static String childCategoryMId;

    @Test(priority = 1)
    public void createCategory() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/group");
        request.setHeader(HttpHeaders.AUTHORIZATION, com.ydv.utils.Credentials.TOKEN );
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/Group/category.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
         Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        categoryId = group.getGroupId();
        assertTrue(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Test Automation Category");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        parentCategoryMId = group.get_id();
    }

    @Test(priority = 2)
    public void createChildCategory() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/group");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        System.out.println(parentCategoryMId);
        String json = "{\"name\":\"Child Category\",\"isInternal\":false,\"parent\":\""+parentCategoryMId+"\",\"kind\":\"CATEGORY\"}";
        System.out.println(json);
        request.setEntity(new StringEntity (json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        childCategoryId = group.getGroupId();
        childCategoryMId = group.get_id();
        assertTrue(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Child Category");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }


    //TODO https://yottadv.atlassian.net/browse/EBIMP-191
    @Test(priority = 3)
    public void renameChildCategory() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM()+"/group/"+childCategoryId);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        String json = "{\"name\":\"Child Category Renamed\",\"isInternal\":false,\"parent\":\""+parentCategoryMId+"\",\"kind\":\"CATEGORY\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        assertTrue(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Child Category Renamed");
        assertEquals(group.get_id(),childCategoryMId);
        assertEquals(group.getGroupId(),childCategoryId);
        assertEquals(group.getParent(),parentCategoryMId);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteChildCategory() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM()+"/group/"+childCategoryId);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        response = client.execute(request);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        assertFalse(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Child Category Renamed");
        assertEquals(group.get_id(),childCategoryMId);
        assertEquals(group.getGroupId(),childCategoryId);
        assertEquals(group.getParent(),parentCategoryMId);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteParentCategory() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM()+"/group/"+categoryId);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        response = client.execute(request);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        assertFalse(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Test Automation Category");
        assertEquals(group.get_id(),parentCategoryMId);
        assertEquals(group.getGroupId(),categoryId);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

}

