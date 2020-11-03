package com.ydv.xpm;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import com.ydv.xpmMenu.Menus;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;






public class MenuTest extends BaseTest {


    @Test(priority=1 ,description = "Create Menu API Request")
    public void createMenuTest() throws  IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/menu") ;
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/departement.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);

        xpmMap.put("_id", menu.getData().get_id());
        xpmMap.put("id",menu.getData().getId());
        xpmMap.put("parent", menu.getData().getParent());
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(menu.getData().getName(),"deptT");
        assertEquals(menu.getStatus_code(),201);


    }


    @Test(priority=2 ,description = "Create Duplicate Menu API Request")
    public void createDuplicateMenuTest() throws  IOException {

        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/menu") ;
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/departement.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),409);
        assertEquals(menu.getCode(),"MENU_NAME_EXISTS");
        assertEquals(menu.getMessage(),"menu name already exists. Menu name needs to be unique");



    }




    @Test(priority=3 ,description = "Rename Menu API Request")
    public void renameMenu() throws IOException {

        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/renameMenuDept.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);

    }


    @Test(priority=4 , description = "Enable Menu API Request")
    public void enableMenu() throws ClientProtocolException, IOException {

        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/enablemenu.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertTrue(menu.getData().getisActive());
    }


    @Test(priority=5, description = "Disable Menu API Request")
    public void disableMenu() throws ClientProtocolException, IOException {

        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/disableMenu.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus, 200);
        assertFalse(menu.getData().getisActive());



    }




    @Test(priority=6)
    public void enableMenuAgain() throws ClientProtocolException, IOException {

        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/enablemenu.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertTrue(menu.getData().getisActive());

    }


    @Test(priority=7 , description = "Edit Menu API Request")
    public void editItem() throws ClientProtocolException, IOException {

        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/edititemDept.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertTrue(menu.getData().getisActive());


    }




    //   Category1 Test  started from here




    @Test(priority=8 , description = "Get menu tree API Request")
    public void menuTree() throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/tree/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
    }





    @Test(priority=9 , description = "Create SunMenu API Request")
    public void createSubMenu() throws ClientProtocolException, IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/menu") ;
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json = "{\"name\":\"Testing1\",\"label\":\"Testing1\",\"parent\":\""+xpmMap.get("_id").toString()+"\"}"  ;
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);

        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(menu.getData().getName(),"Testing1");
        assertEquals(menu.getStatus_code(),201);
        xpmMap.put("child_id", menu.getData().get_id());
    }




    @Test(priority=10,description = "Create duplicate SunMenu API Request" )
    public void createDuplicateSubMenu() throws ClientProtocolException, IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/menu") ;
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json = "{\"name\":\"Testing1\",\"label\":\"Testing1\",\"parent\":\""+xpmMap.get("_id").toString()+"\"}"  ;
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),409);
        //   assertEquals(menu.getData().getName(),"Testing1");
        //  assertEquals(menu.getStatus_code(),201);

    }



    @Test(priority=11 , description = "Rename SunMenu API Request" )
    public void renameSubMenu() throws IOException {
        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("child_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        String json ="{\"label\":\"testingone\"}";
        //  request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/renameCategory1.json"), ContentType.APPLICATION_JSON));
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);

        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(menu.getData().getLabel(),"testingone");


    }



    @Test(priority=12 , description = "Enable SunMenu API Request")
    public void enableSubMenu() throws ClientProtocolException, IOException {
        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("child_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/enableCategory1.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertTrue(menu.getData().getisActive());
    }




    @Test(priority=13 , description = "Disable SunMenu API Request")
    public void disbleSubMenu() throws ClientProtocolException, IOException {
        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("child_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/disableCategory1.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertFalse(menu.getData().getisActive());
    }


    @Test(priority=14 , description = "Edit SunMenu API Request")
    public void editSubMenuItem() throws ClientProtocolException, IOException {
        HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("child_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmMenuPayload/editCategory1.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertFalse(menu.getData().getisActive());


    }


    @Test(priority=15 , description = "Delete SunMenu API Request")
    public void deleteSubMenu() throws IOException, IOException {

        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("child_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(menu.getStatus_code(),204);
    }





    @Test(priority=16 , description = "Delete Menu API Request")
    public void deleteMenu() throws IOException, IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/menu/"+xpmMap.get("_id"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response=client.execute(request);
        Menus menu = ResponseUtils.unmarshallGeneric(response, Menus.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(menu.getStatus_code(),204);
    }



}
