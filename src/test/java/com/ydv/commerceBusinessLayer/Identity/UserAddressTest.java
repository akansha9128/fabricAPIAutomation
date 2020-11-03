package com.ydv.commerceBusinessLayer.Identity;

import com.ydv.BaseTest;
import com.ydv.CBL.auth.Address;
import com.ydv.CBL.auth.Addressess;
import com.ydv.CBL.auth.Status;
import com.ydv.utils.Credentials;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;


public class UserAddressTest extends BaseTest {

    final static Logger logger = Logger.getLogger(UserAddressTest.class);


    @Test(priority = 0)
    public void createAddress1() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+"user/"+userMap.get("userMId")+"/address");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"address1\":\"500 Yale Ave N\",\"address2\":\"\",\"city\":\"seattle\",\"state\":\"WA\",\"country\":\"US\",\"zipCode\":\"98109\",\"kind\":\"shipping\",\"name\":{\"first\":\""+userMap.get("userFName")+"\",\"last\":\""+userMap.get("userLName")+"\"}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        System.out.println(address);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals( address.getAddress()[0].getAddress1(), "500 Yale Ave N");
        assertEquals( address.getAddress()[0].getCity(), "seattle");
        assertEquals( address.getAddress()[0].getState(), "WA");
        assertEquals( address.getAddress()[0].getCountry(), "US");
        assertEquals( address.getAddress()[0].getZipCode(), "98109");
        assertFalse(address.getAddress()[0].getIsDefault());
        assertEquals(address.getAddress()[0].getKind(), "shipping");
        assertFalse(address.getAddress()[0].getIsValidated());
        userMap.put("userAddressLine1", address.getAddress()[0].getAddress1());
        userMap.put("userAddressCity", address.getAddress()[0].getCity());
        userMap.put("userAddressState", address.getAddress()[0].getState());
        userMap.put("userAddressCountry", address.getAddress()[0].getCountry());
        userMap.put("userAddMId", address.getAddress()[0].get_id());
        userMap.put("userAddisDefault", address.getAddress()[0].get_id());
        userMap.put("userAddisValidated", address.getAddress()[0].get_id());
        userMap.put("userAddress1Kind", address.getAddress()[0].getKind());
    }

    @Test(priority = 0)
    public void createAddress2() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+"user/"+userMap.get("userMId")+"/address");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"address1\":\"400 Yale Ave N\",\"address2\":\"\",\"city\":\"seattle\",\"state\":\"WA\",\"country\":\"US\",\"zipCode\":\"98109\",\"kind\":\"billing\",\"name\":{\"first\":\""+userMap.get("userFName")+"\",\"last\":\""+userMap.get("userLName")+"\"}}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        System.out.println(address);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals( address.getAddress()[1].getAddress1(), "400 Yale Ave N");
        assertEquals( address.getAddress()[1].getCity(), "seattle");
        assertEquals( address.getAddress()[1].getState(), "WA");
        assertEquals( address.getAddress()[1].getCountry(), "US");
        assertEquals( address.getAddress()[1].getZipCode(), "98109");
        assertFalse(address.getAddress()[1].getIsDefault());
        assertFalse(address.getAddress()[1].getIsValidated());
        assertEquals(address.getAddress()[1].getKind(), "billing");
        userMap.put("userAddress2Line1", address.getAddress()[1].getAddress1());
        userMap.put("userAddress2City", address.getAddress()[1].getCity());
        userMap.put("userAddress2State", address.getAddress()[1].getState());
        userMap.put("userAddress2Country", address.getAddress()[1].getCountry());
        userMap.put("userAdd2MId", address.getAddress()[1].get_id());
        userMap.put("userAdd2isDefault", address.getAddress()[1].get_id());
        userMap.put("userAdd2isValidated", address.getAddress()[1].get_id());
        userMap.put("userAddress2Kind", address.getAddress()[1].getKind());
    }


    //TODO, Need to fix this test.
    @Test
    public void getAddress1ByKind() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "user/" + userMap.get("userMId") + "/address?kind=" + userMap.get("userAddress1Kind"));
        System.out.println(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "user/" + userMap.get("userAddMId") + "/address?kind=" + userMap.get("userAddress1Kind"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Addressess[] address =  ResponseUtils.unmarshallAddress(response, Addressess.class);
        assertEquals(address[0].getKind(), userMap.get("userAddress1Kind"));

    }

    @Test
    public void getAddress2ById() throws IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId"));
        System.out.println(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY() + "user/" + userMap.get("userAddMId") + "/address/" + userMap.get("userAdd2MId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getAddress()[0].getKind(), userMap.get("userAddress2Kind"));
        assertEquals(address.get_id(), userMap.get("userMId"));
    }

    @Test
    public void updateAddress2() throws IOException {
        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"address1\":\"600 Congress Ave\",\"city\":\"Austin\",\"state\":\"Texas\",\"country\":\"USA\",\"zipCode\":\"78107\",\"kind\":\"billing\",\"name\":{\"first\":\""+userMap.get("userFName")+"\",\"last\":\""+userMap.get("userLName")+"\"},\"isVerified\":false}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getAddress()[1].getName().getFirst(),userMap.get("userFName"));
        assertEquals(address.getAddress()[1].getKind(),"billing");
        assertEquals(address.getAddress()[1].getName().getLast(),userMap.get("userLName"));
        assertEquals(address.getAddress()[1].getZipCode(),"78107");
        assertEquals(address.getAddress()[1].getAddress1(),"600 Congress Ave");
        assertEquals(address.getAddress()[1].getIsValidated(),false);
        assertEquals(address.getAddress()[1].getIsDefault(),false);
        assertEquals(address.getAddress()[1].getAttention(), null);
        assertEquals(address.getAddress()[1].getCompany(), null);
        assertEquals(address.getAddress()[1].getEmail(), null);
        assertEquals(address.getAddress()[1].getPhone(), null);
        System.out.println(address.getAddress()[1].get_id());
        System.out.println(userMap.get("userAdd2MId"));
    }

    @Test
    public void setAddress2Default() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId") +"/set");
       // System.out.println(BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId") +"/unset");
       // System.out.println("https://qa.abchome.com/api-commerceIdentity/user/5e6ab26dd33d87000871e257/address/5e6d63f4f9d3500008902b75/set");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getAddress()[1].getIsDefault(), true);
    }

    @Test
    public void unSetAddress2Default() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/unset");
         System.out.println(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId") +"/unset");
        // System.out.println("https://qa.abchome.com/api-commerceIdentity/user/5e6ab26dd33d87000871e257/address/5e6d63f4f9d3500008902b75/set");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Status s = ResponseUtils.unmarshallGeneric(response, Status.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        //assertEquals(s.getStatus(), "OK");
    }


    @Test
    public void deleteAddress2() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd2MId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getIsActive().getStatus(), true);
    }

    @Test
    public void setAddress1Default() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAddMId") +"/set");
       // System.out.println(BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd1MId") +"/set");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getAddress()[0].getIsDefault(), true);
        System.out.println(userMap.get("userAdd1MId"));
        System.out.println(address.getAddress()[0].get_id());

    }

    @Test
    public void deleteAddress1() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY()+ "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAddMId"));
        // System.out.println(BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_IDENTITY + "user/" + userMap.get("userMId") + "/address/" + userMap.get("userAdd1MId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        Address address = ResponseUtils.unmarshallGeneric(response, Address.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(address.getIsActive().getStatus(), true);
    }




}


