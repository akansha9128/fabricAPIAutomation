package com.ydv.channel;

import com.ydv.BaseTest;
import com.ydv.channel.company.Company;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CreateCompanyNegativeTest extends BaseTest {

    String ID1 = "";
    String ID2 = "";

    @Test(priority = 1)
    public void createRole() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_CHANNEL() + "/company");

        String json = "{\"name\":\"testing company\",\"kind\":[\"Vendor\",\"Customer\",\"Manufacturer\",\"Partner\"],\"address\":[{\"attention\":\"att1\",\"address1\":\"312\",\"address2\":\"Tower 1\",\"city\":\"Pune\",\"name\":{\"first\":\"YDV\",\"last\":\"Solutions\"},\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}],\"email\":\"ydv@ydv.com\",\"kind\":\"personal\"}],\"extra\":{}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        ID1 = company.get_id();
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 2)
    public void createRoleAgain() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_CHANNEL() + "/company");


        // Define Json to Post and set as Entity
        //String json = "{\"name\": \"SUPER_ADMIN\",  \"displayText\": \"I am a super admin\", \"description\": \"SUPER_ADMIN get created\", \"extra\": {\"kind\": \"I very kind\"} }";
        String json = "{\"name\":\"testings company\",\"kind\":[\"Vendor\",\"Customer\",\"Manufacturer\",\"Partner\"],\"address\":[{\"attention\":\"att1\",\"address1\":\"312\",\"address2\":\"Tower 1\",\"city\":\"Pune\",\"name\":{\"first\":\"YDV\",\"last\":\"Solutions\"},\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}],\"email\":\"ydv@ydv.com\",\"kind\":\"personal\"}],\"extra\":{}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        ID2 = company.get_id();
        System.out.println("my getID is" +ID2);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }


    //TODO Bug, Will be getting fixed soon.
    @Test(priority = 3)
    public void modifyTheSecondOne() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company/"+ID2);
        String json = "{\"name\":\"testing company\",\"kind\":[\"Vendor\",\"Customer\",\"Manufacturer\",\"Partner\"],\"address\":[{\"attention\":\"att1\",\"address1\":\"312\",\"address2\":\"Tower 1\",\"city\":\"Pune\",\"name\":{\"first\":\"YDV\",\"last\":\"Solutions\"},\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}],\"email\":\"ydv@ydv.com\",\"kind\":\"personal\"}],\"extra\":{}}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        assertEquals(company.getCode(),"11000");
        assertEquals(company.getMessage(), "E11000 duplicate key error collection: identity_eddiebauer.roles index: name_1 dup key: { : \"NEGETIVE_ADMIN\" }");
        assertEquals(response.getStatusLine().getStatusCode(), 500);
    }

    @Test(priority = 4)
    public void deleteRoleID1() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company/"+ID1);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteRoleID2() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company/"+ID2);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
