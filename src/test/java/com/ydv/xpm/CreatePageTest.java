package com.ydv.xpm;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class CreatePageTest extends BaseTest {


    @Test(priority = 1,description = "Create New Page API Request")
    public void createNewPage() throws IOException   {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/page") ;
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/pages.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        xpmMap.put("pageId",page.getData().getPage().getPageId());
        xpmMap.put("versionId", page.getData().getVersion().getVersionId());
        xpmMap.put("status",page.getData().getStatus());
        xpmMap.put("status",page.getStatus());

        assertEquals(response.getStatusLine().getStatusCode(),200);
        assertEquals(page.getStatus_code(),201);
        assertEquals(page.getStatus(),xpmMap.get("status"));
        assertEquals(page.getData().getPage().getName(),"ApiAutomationPages");
        assertEquals(page.getData().getVersion().getName(),"Holidays");
        assertEquals(page.getData().getPage().getPageUrl(),"/apiautomationpages@com");
        assertEquals(page.getData().getVersion().getStatus(),"DRAFT");
    }

    @Test(priority = 2)
    public void createDuplicatePage() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/page");
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/pages.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response,Pages.class);
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus, 409);
        assertEquals(page.getMessage(),"Page already exists. Page name needs to be unique");

    }


    @Test(priority = 3,description = "Remane Page API Request")
    public void renamePage() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/renamepage.json"), ContentType.APPLICATION_JSON));
        response=client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response,Pages.class);
        assertEquals(page.getData().getPageUpdate().getName(),"Latest");
        assertEquals(response.getStatusLine().getStatusCode(),200);

    }

    @Test(priority = 4 , description = "Create New Version API Request")
    public void createNewVersion() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/createnewversion.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response,Pages.class);
        assertEquals(page.getData().getVersion().getName(),"New");
        assertEquals(response.getStatusLine().getStatusCode(),200);


    }

    @Test(priority=5 , description = "Inactive Page API Request")
    public void inactivePage() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/inactivepage.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus, 200);
        assertFalse(page.getData().getPageUpdate().isActive());

    }

    @Test(priority=6 , description = "Active Page API Request")
    public void activePage() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/activepage.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus, 200);
        assertTrue(page.getData().getPageUpdate().isActive());
    }

    @Test(priority = 7 , description = "Archive Page API Request")
    public void archivePage() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/archivepage.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus,200);
        assertTrue(page.getData().getisArchived());

    }


    @Test(priority = 8, description = "UnArchive Page API Request")
    public void unarchivePage() throws  IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/unarchivepage.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        assertEquals(response.getStatusLine().getStatusCode(),200);

    }


    @Test(priority = 9,description = "Delete Page API Request")
    public void deletePage() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN );
        request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
        response = client.execute(request);
        Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
        xpmMap.put("status",page.getStatus());
        int actualstatus = response.getStatusLine().getStatusCode();
        assertEquals(actualstatus, 200);
        assertEquals(page.getStatus_code(),204);
        assertEquals(page.getStatus(),xpmMap.get("status"));

    }

}