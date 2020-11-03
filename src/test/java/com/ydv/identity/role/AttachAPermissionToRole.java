package com.ydv.identity.role;

import com.ydv.BaseTest;
import com.ydv.identity.permission.Permission;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AttachAPermissionToRole extends BaseTest {

    String getPermissionID="";
    String getRoleId="";

    @Test(priority = 1)
    public void createPermissionToAttach() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission");


        // Define Json to Post and set as Entity
        String json = "{\"name\": \"attchPermission\"}";


        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);
        getPermissionID = permission.get_id();
        System.out.println("my getID is" +getPermissionID);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }


    @Test(priority = 2)
    public void createRoletoAttachPermission() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");


        // Define Json to Post and set as Entity
        //String json = "{\"name\": \"SUPER_ADMIN\",  \"displayText\": \"I am a super admin\", \"description\": \"SUPER_ADMIN get created\", \"extra\": {\"kind\": \"I very kind\"} }";
        String json = "{\"name\":\"SUPER_ADMIN\", \"displayText\":\"I am a super admin\", \"description\":\"SUPER_ADMIN get created\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Role role = ResponseUtils.unmarshallGeneric(response, Role.class);
        getRoleId = role.get_id();
        System.out.println("my getID is" +getRoleId);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 3)
    public void attachPermissionToARole() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" + getRoleId + "/permission/" + getPermissionID);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);

    }


    @Test(priority = 4)
    void deleteRoleAndPermission() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/" + getPermissionID);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        HttpDelete request_role = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" + getRoleId);
        response = client.execute(request_role);
        assertEquals(response.getStatusLine().getStatusCode(), 200);

    }


}
