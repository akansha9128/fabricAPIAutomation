package com.ydv.identity.permission;

import com.ydv.BaseTest;


import com.ydv.utils.ResponseUtils;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static org.testng.Assert.assertEquals;


public class IdentityCreatePermissionTest extends BaseTest {

    String getID = "";


    @Test(priority = 1)
    public void createPermission() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission");


        // Define Json to Post and set as Entity
        String json = "{\"name\": \"CREATE_PERMISSION_TEST\"}";


        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);
        getID = permission.get_id();
        System.out.println("my getID is" +getID);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 2)
    public void returnsCorrectPermission_Create_Permission() throws IOException {
        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/"+getID);
        response = client.execute(get);
        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);
        assertEquals(permission.getName(), "CREATE_PERMISSION_TEST" );
        assertEquals(permission.get_id(),getID);
    }

    @Test(priority = 3)
    public void createDuplicatePermission() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission");


        // Define Json to Post and set as Entity
        String json = "{\"name\": \"CREATE_PERMISSION_TEST\"}";


        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 406);

    }

    @Test(priority = 4)
    public void verifyDuplicatePermissionMessage() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission");

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"CREATE_PERMISSION_TEST\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);

        assertEquals(permission.getCode(), "PERMISSION_EXISTS");
        assertEquals(permission.getMessage(), "Permission name is already in use.");
    }

    @Test(priority = 6)
    public void deleteCreatedPermission() throws IOException {
        System.out.println("****"+getID);
        System.out.println(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/" + getID);
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/" + getID);
        response = client.execute(request);

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void deleteAlreadyDeletedPermission() throws IOException {
        //System.out.println("****"+getID);
        //System.out.println(BASE_ENDPOINT_IDENTITY + "/permission/" + getID);
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/" + getID);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 404);
    }

    @Test(priority = 5)
    public void updateTheNameOfPermission() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/permission/" +getID);

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"CREATE_PERMISSION_TEST_AUTOMATION\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        Permission permission = ResponseUtils.unmarshallGeneric(response, Permission.class);

        assertEquals(permission.getName(), "CREATE_PERMISSION_TEST_AUTOMATION");

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}




