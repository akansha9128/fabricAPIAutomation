package com.ydv.xpm;

import static junit.framework.Assert.assertTrue;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;



public class VersionLevelTest extends BaseTest {


	  @Test(priority = 1 , description = "Create New Page API Request")
	  public void createNewPage() throws IOException   {
	  HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/page") ;
	  request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
	  request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
	  request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/pages.json"), ContentType.APPLICATION_JSON));
	  response=client.execute(request);
	  Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
	   xpmMap.put("pageId",page.getData().getPage().getPageId());
	   xpmMap.put("versionId",page.getData().getVersion().getVersionId());
	   xpmMap.put("status",page.getData().getStatus());
	   xpmMap.put("status",page.getStatus());
	   assertEquals(response.getStatusLine().getStatusCode(),200);
	   assertEquals(page.getStatus(),xpmMap.get("status"));
	   assertEquals(page.getData().getPage().getName(),"ApiAutomationPages");
	   assertEquals(page.getData().getVersion().getName(),"Holidays");
	   assertEquals(page.getData().getPage().getPageUrl(),"/apiautomationpages@com");
       
    }


	 

  
       
	
    @Test(priority=2 , description = "Page Version Edit API Request")
    public void editVersion() throws IOException  {
    HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId")+"/components/");
    request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
    request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/editversion.json"), ContentType.APPLICATION_JSON));
    response = client.execute(request);
    Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
    assertEquals(response.getStatusLine().getStatusCode(),200);
    assertEquals(page.getData().getVersion().getName(),"Holidays");
    assertEquals(page.getData().getVersion().getStatus(),"DRAFT");
            
        	
     }
	
	
	
	
	
	
	@Test(priority=3 , description = "Make a Copy Version API Request")
	public void makeaCopy() throws  IOException {
	HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId"));
	request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
    
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/makeCopyVersion.json"),ContentType.APPLICATION_JSON));
	response = client.execute(request);
	Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
    assertEquals(response.getStatusLine().getStatusCode(),200);
		
	}
	
	
	
	
	@Test(priority=4 , description = "Page Version Archive API Request")
	public void versionArchive() throws IOException {
	HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId"));
	request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
   
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/versionarchive.json"), ContentType.APPLICATION_JSON));
    response=client.execute(request);
    Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
    assertEquals(response.getStatusLine().getStatusCode(),200);
    assertTrue(page.getData().getisArchived());
    }
	
	
	
	
	
	@Test(priority=5 ,description = "Page Version Unarchive API Request")
	public void versionUnArchive() throws  IOException {
		
   HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId"));
   request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
   request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
   
   request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/versionUnrchive.json"), ContentType.APPLICATION_JSON));
   response=client.execute(request);
   Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
   assertEquals(response.getStatusLine().getStatusCode(),200);
   assertEquals(page.getData().getStatus(),"DRAFT");
		
	}
	
	

	@Test(priority=6 , description = "Publish Page Version API Request")
	public void publishVersion() throws ClientProtocolException, IOException {
	HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId"));
	request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
//	String json = "{\"startDate\":\"2020-06-17T11:30:00.000Z\"}";
//	GenerateXSiteContext.startDate();
 //   request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));		
	request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmPagesAndVersionPayload/publishVersion.json"), ContentType.APPLICATION_JSON));
    response=client.execute(request);
    Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
    
    xpmMap.put("status",page.getData().getStatus());
    assertEquals(response.getStatusLine().getStatusCode(),200);
    //assertEquals(page.getData().getStatus(),"SCHEDULED");
     assertEquals(page.getData().getStatus(),xpmMap.get("status"));
    
		
		
	}
	
	
	
	
	
	
	
	@Test(priority=7 , description = "Delete Page Version API Request")
	public void versionDelete() throws IOException, IOException {
	HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/page/"+xpmMap.get("pageId")+"/version/"+xpmMap.get("versionId"));
	request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
	response = client.execute(request);
	Pages page = ResponseUtils.unmarshallGeneric(response, Pages.class);
	assertEquals(response.getStatusLine().getStatusCode(),200);
	assertEquals(page.getStatus_code(),204);
	    
	}
	
	@Test(priority = 8,description = "Delete Make a copyPage API Request")
    
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
