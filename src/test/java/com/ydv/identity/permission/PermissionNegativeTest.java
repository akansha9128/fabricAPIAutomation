package com.ydv.identity.permission;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class PermissionNegativeTest extends BaseTest {

    String ID1 = "";
    String ID2 = "";

    @Test(priority = 1)
    public void createPermission() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");

        String json = "{\"name\":\"NEGETIVE_ADMIN\", \"displayText\":\"I am a super admin\", \"description\":\"SUPER_ADMIN get created\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);
        ID1 = permission.get_id();
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 2)
    public void createPermissionAgain() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");


        // Define Json to Post and set as Entity
        //String json = "{\"name\": \"SUPER_ADMIN\",  \"displayText\": \"I am a super admin\", \"description\": \"SUPER_ADMIN get created\", \"extra\": {\"kind\": \"I very kind\"} }";
        String json = "{\"name\":\"NEGETIVE_ADMIN2\", \"displayText\":\"I am a super admin\", \"description\":\"SUPER_ADMIN get created\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);

        ID2 = permission.get_id();
        System.out.println("my getID is" +ID2);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }


    //TODO https://yottadv.atlassian.net/browse/EBIMP-191
    @Test(priority = 3)
    public void modifyTheSecondOne() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_IDENTITY()+"/role/"+ID2);
        String json = "{\"name\":\"NEGETIVE_ADMIN\", \"displayText\":\"I am a super admin\", \"description\":\"SUPER_ADMIN get created\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);

        assertEquals(permission.getCode(),"11000");
        assertEquals(permission.getMessage(), "E11000 duplicate key error collection: identity_eddiebauer.roles index: name_1 dup key: { : \"NEGETIVE_ADMIN\" }");
        assertEquals(response.getStatusLine().getStatusCode(), 500);
    }

    @Test(priority = 4)
    public void deletePermissionID1() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY()+"/role/"+ID1);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deletePermissionID2() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY()+"/role/"+ID2);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
