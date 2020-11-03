package com.ydv.xpm;

import com.ydv.BaseTest;
import com.ydv.utils.Credentials;
import com.ydv.utils.GenerateXSiteContext;
import com.ydv.utils.ResponseUtils;
import com.ydv.xpmGlobalComponents.GlobalComponent;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class GlobalElementHeaderTest extends BaseTest {

	
	
	
	
 @Test(priority=1 , description = "Create New Version Header API Request")
 public void createNewVersionHeader() throws IOException {
	 HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header");
	    request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
	 	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
	    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/createNewHeaderVersion.json"), ContentType.APPLICATION_JSON));
	    response=client.execute(request); 	
	    GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
	    xpmMap.put("versionId",component.getData().getVersion().getVersionId());
	    xpmMap.put("status", component.getData().getVersion().getStatus());
	    assertEquals(response.getStatusLine().getStatusCode(),200);
	    assertEquals(component.getData().getVersion().getGlobalComponentId(),"Header");
	    assertEquals(component.getData().getVersion().getDescription(),"Testing");
	    assertEquals(component.getData().getVersion().getComponents()[0].getId(),"Header");
	 
}

 
     @Test(priority=2 )
     public void createDuplicateNewVersionHeader() throws  IOException {
	
	HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header");
	request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
 	request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/createNewHeaderVersion.json"), ContentType.APPLICATION_JSON));
    response=client.execute(request); 	
    GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
    assertEquals(response.getStatusLine().getStatusCode(),409);
    assertEquals(component.getMessage(),"Version already exists. Version name needs to be unique");
	
}

    @Test(priority=3,description = "Edit Header API Request")
    public void editHeaderVersion() throws ClientProtocolException, IOException {
    HttpPut  request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId")+"/component/");
    request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
    request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/editHeader.json"), ContentType.APPLICATION_JSON));
    response=client.execute(request);
    GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
    assertEquals(response.getStatusLine().getStatusCode(),200);
    assertEquals(component.getData().getVersion().getGlobalComponentId(),"Header");
    assertEquals(component.getData().getVersion().getComponents()[0].getId(),"Header");
 
 
 
 }
 
    @Test(priority=4 , description = "Make A Copy Header version API Request")
    public void makeaCopyHeaderVersion() throws IOException, IOException {
	 
    HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId"));
    request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
    request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());  
    request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/makeaCopyHeader.json"), ContentType.APPLICATION_JSON));
    response=client.execute(request);	 
    GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
    assertEquals(response.getStatusLine().getStatusCode(),200);
    assertFalse(component.getData().getVersion().isArchived());

 }
 
 
 

  @Test(priority=4 , description = "Header Archive API Request")
  public void headerArchive() throws IOException, IOException {
  HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId"));
  request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
  request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());  
  request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/headerArchive.json"), ContentType.APPLICATION_JSON));
  response=client.execute(request); 	
  GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);	
  assertEquals(response.getStatusLine().getStatusCode(),200);
  assertTrue(component.getData().getVersion().isArchived());
 // assertEquals(component.getData().getVersion(),xpmMap.get("status"));
	 
  }

  
  
  
 
  @Test(priority=5,description = "Header UnArchive API Request")
  public void headerUnArchive() throws IOException {
	 
  HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId"));
  request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
  request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
  
   request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/headerUnarchive.json"), ContentType.APPLICATION_JSON));
   response=client.execute(request);
   GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
   assertEquals(response.getStatusLine().getStatusCode(),200);
   assertEquals(component.getData().getVersion().getGlobalComponentId(),"Header");
   assertFalse(component.getData().getVersion().isArchived());
	
	 
}

  
  @Test(priority=7, description = "Publish Header API Request")
  public void publisHeaderhversion() throws IOException, IOException {
  HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId"));
  request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
  request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
  request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGCHeaderPayload/publishHeader.json"), ContentType.APPLICATION_JSON));
  response=client.execute(request);
  GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
  assertEquals(response.getStatusLine().getStatusCode(),200);
  assertFalse(component.getData().getVersion().isArchived());
  assertEquals(component.getData().getVersion().getName(),"NewHeaderApiAutomation");
  assertEquals(component.getData().getVersion().getComponents()[0].getId(),"Header");
 //assertEquals(component.getData().getVersion(),xpmMap.get("statuss"));
	    
	  
	  
	  
  }
  
  
  
  
  @Test(priority=8 , description = "Detele Header API Request")
  public void deleteheaderVersion() throws IOException, IOException {
	  
	 HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Header/version/"+xpmMap.get("versionId"));
	 request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
	 request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
	 response=client.execute(request);
	 GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
	 assertEquals(response.getStatusLine().getStatusCode(),200);
	 assertEquals(component.getStatus_code(),204);
	 
  }
  
  
  

}
