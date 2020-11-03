package com.ydv.channel;


import com.ydv.BaseTest;
import com.ydv.channel.company.Company;

import com.ydv.utils.ResponseUtils;



import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.testng.annotations.Test;

import java.io.IOException;




import static org.testng.Assert.assertEquals;

public class CreateCompanyTest extends BaseTest {
    String companyId = "";

    @Test(priority = 1)
    public void createCompany() throws IOException {
        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company");

        // Define Json to Post and set as Entity
        String json = "{\"name\":\"testing company\",\"kind\":[\"Vendor\",\"Customer\",\"Manufacturer\",\"Partner\"],\"address\":[{\"attention\":\"att1\",\"address1\":\"312\",\"address2\":\"Tower 1\",\"city\":\"Pune\",\"name\":{\"first\":\"YDV\",\"last\":\"Solutions\"},\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}],\"email\":\"ydv@ydv.com\",\"kind\":\"personal\"}],\"extra\":{}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        System.out.println("******"+response);
        Company channel = ResponseUtils.unmarshallGeneric(response, Company.class);
        companyId = channel.get_id();
        System.out.println("my getID is " + companyId);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

    @Test(priority = 6)
    public void deleteCreatedCompany() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company/"+companyId);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void vendorCompanyBodyTest() throws IOException {
        HttpGet get = new HttpGet("http://localhost:4021/company/" + companyId);
        response = client.execute(get);
        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        assertEquals(company.getName(), "testing company");
        assertEquals(company.get_id(), companyId);
        assertEquals(company.getKind()[0], "Vendor");
        assertEquals(company.getKind()[1], "Customer");
        assertEquals(company.getKind()[2], "Manufacturer");
        assertEquals(company.getKind()[3], "Partner");
        assertEquals(company.getIsActive(),"true");
        assertEquals(company.getAddresses()[0].getCity(), "Pune");
        assertEquals(company.getAddresses()[0].getCountry(), "India");
        assertEquals(company.getAddresses()[0].getAttention(), "att1");
        assertEquals(company.getAddresses()[0].getState(), "MH");
        assertEquals(company.getAddresses()[0].getAddress1(), "312");
        assertEquals(company.getAddresses()[0].getAddress2(), "Tower 1");
        assertEquals(company.getAddresses()[0].getZipCode(), "411014");
        assertEquals(company.getAddresses()[0].getEmail(), "ydv@ydv.com");
        assertEquals(company.getAddresses()[0].getKind(), "personal");
        assertEquals(company.getAddresses()[0].getPhone()[0].getNumber(), "1234");
        assertEquals(company.getAddresses()[0].getPhone()[0].getKind(), "mob");

    }

    @Test(priority = 3)
    public void createDuplicateCompanyAndVerifyMessage() throws IOException {
        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/company");

        // Define Json to Post and set as Entity
        String json = "{\"name\":\"testing company\",\"kind\":[\"Vendor\",\"Customer\",\"Manufacturer\",\"Partner\"],\"address\":[{\"attention\":\"att1\",\"address1\":\"312\",\"address2\":\"Tower 1\",\"city\":\"Pune\",\"name\":{\"first\":\"YDV\",\"last\":\"Solutions\"},\"state\":\"MH\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}],\"email\":\"ydv@ydv.com\",\"kind\":\"personal\"}],\"extra\":{}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        assertEquals(company.getCode(), "COMPANY_NAME_EXISTS");
        assertEquals(company.getMessage(), "Company name already exists.");

        assertEquals(response.getStatusLine().getStatusCode(), 406);
    }

    @Test(priority = 7)
    public void deleteAlreadyDeletedCompany() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/"+companyId);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 404);
    }

    //TODO, Need to get clarify
    @Test(priority = 4)
    public void updateNameOfTheCompany() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_CHANNEL()+ "/company/" +companyId);
        System.out.println("Name of the company" +companyId);
        String json = "{\"name\": \"testing company AUTOMATION\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        assertEquals(company.getName(), "testing company AUTOMATION");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    //TODO, Need to get clarify
    @Test(priority = 5)
    public void updateKindOfTheCompany() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_CHANNEL()+ "/company/" +companyId);
        System.out.println("Name of the company" +companyId);
        String json = "{\"kind\": [\"Vendor\",\"Manufacturer\"]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Company company = ResponseUtils.unmarshallGeneric(response, Company.class);
        assertEquals(company.getKind()[0], "Vendor");
        assertEquals(company.getKind()[1],"Manufacturer");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }


    //TODO We are doing RnD
/*
    @Test
    public void createCompany() throws IOException {
        HttpPost request = new HttpPost("http://localhost:4444/graphql");

        String json = "{\"query\":\"mutation {\\n  companyCreate( company:{\\n    name: \\\"XXXXfdsZZXX\\\"\\n    kind: \\\"Vendor\\\"\\n    parent: \\\"5c3453645ac4df8c2229d8b8\\\"\\n    address: [\\n      {\\n        salutation: \\\"Mr\\\"\\n        street1: \\\"888\\\"\\n        firstName: \\\"hello\\\"\\n        street2: \\\"888\\\"\\n        title: \\\"Ms\\\"\\n        state: \\\"WA\\\"\\n        country: \\\"US\\\"\\n        email: \\\"v@v\\\"\\n        kind: \\\"personal\\\"\\n      }\\n    ]\\n  }\\n  ) {\\n    id\\n    name\\n    kind\\n    parent\\n    address {\\n      salutation\\n      street1\\n      state\\n      street2\\n    }\\n  }\\n}\\n\"}";



       request.addHeader("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoic2lnbmluIiwidXNlcklkIjoiNWMzNWY4NjQxOWExYWMyNTE0Zjg0ZDAwIiwiaWF0IjoxNTQ3MDQwODY4fQ.acu-txJs4seA1e3Wrw_5NJEf4KhRlTx6OD9V20-eI80");
       // request.addHeader("Accept","application/json");

       // client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", TokenResponse.AccessToken);


        //request.setHeader(HttpHeaders.AUTHORIZATION, "x-access-token:" + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoiYW5vbnltb3VzIiwidXNlcklkIjoiY2pxbnJxYWV4MDAwMnJ1c2dvMXB0OWx3MSIsImlhdCI6MTU0Njk1Mjc1Nn0.2RxaVTMx5l7hpqlmtN-iH6Hpj_VRHDefQaAIdnEMDWY");
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
       // System.out.println(request.getFirstHeader(json).toString());
        // Send
        response = client.execute(request);

      //  System.out.println(response.toString());
        //System.out.println(response.getStatusLine().getStatusCode());
    }*/
}
