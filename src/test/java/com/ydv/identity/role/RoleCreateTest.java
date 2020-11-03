package com.ydv.identity.role;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class RoleCreateTest extends BaseTest {


    String getID = "";


    @Test(priority = 1)
    public void createRole() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");


        // Define Json to Post and set as Entity
        //String json = "{\"name\": \"SUPER_ADMIN\",  \"displayText\": \"I am a super admin\", \"description\": \"SUPER_ADMIN get created\", \"extra\": {\"kind\": \"I very kind\"} }";
        String json = "{\"name\":\"SUPER_ADMIN\", \"displayText\":\"I am a super admin\", \"description\":\"SUPER_ADMIN get created\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Role role = ResponseUtils.unmarshallGeneric(response, Role.class);
        getID = role.get_id();
        System.out.println("my getID is" +getID);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 2)
    public void returnRoleBodyTest() throws IOException {
        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/"+getID);
        response = client.execute(get);
        Role role = ResponseUtils.unmarshallGeneric(response, Role.class);
        assertEquals(role.getName(), "SUPER_ADMIN");
        assertEquals(role.get_id(),getID);
        assertEquals(role.getDisplayText(), "I am a super admin");
        assertEquals(role.getDescription(),"SUPER_ADMIN get created");
    }


    @Test(priority = 3)
    public void createDuplicateRole() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");


        // Define Json to Post and set as Entity
        String json = "{\"name\": \"SUPER_ADMIN\"}";


        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 406);

    }

    @Test(priority = 4)
    public void verifyDuplicateRoleMessage() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role");

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"SUPER_ADMIN\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Role role = ResponseUtils.unmarshallGeneric(response, Role.class);

        assertEquals(role.getCode(), "ROLE_EXISTS");
        assertEquals(role.getMessage(), "Role name is already in use.");
    }

    @Test(priority = 6)
    public void deleteCreatedRole() throws IOException {
        System.out.println("****"+getID);
        System.out.println(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" + getID);
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" + getID);
        response = client.execute(request);

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void deleteAlreadyDeletedRole() throws IOException {
        //System.out.println("****"+getID);
        //System.out.println(BASE_ENDPOINT_IDENTITY + "/permission/" + getID)ea
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" + getID);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 404);
    }

    @Test(priority = 5)
    public void updateTheNameofRole() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/role/" +getID);

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"SUPER_ADMIN_UPDATED\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        Role role = ResponseUtils.unmarshallGeneric(response, Role.class);

        assertEquals(role.getName(), "SUPER_ADMIN_UPDATED");

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}

