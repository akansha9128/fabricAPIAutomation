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






public class GlobalElementFooterTest extends BaseTest {


	@Test(priority=1,description = "Create New Footer version API Request")
	public void createNewVersionFooter() throws ClientProtocolException, IOException
	{
		HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer");
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/createNewVersionFooter.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		xpmMap.put("versionId", component.getData().getVersion().getVersionId());
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertEquals(component.getData().getVersion().getGlobalComponentId(),"Footer");
	}

	@Test(priority=2)
	public void  createDuplicateNewVersionFooter() throws IOException {
		HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer");
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/createNewVersionFooter.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);

		assertEquals(response.getStatusLine().getStatusCode(),409);
		assertEquals(component.getCode(),"VERSION_EXISTS");
		assertEquals(component.getMessage(),"Version already exists. Version name needs to be unique");


	}




	@Test(priority=3,description = "Edit Footer version API Request")
	public void editFooter() throws ClientProtocolException, IOException {
		HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId")+"/component/");

		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());

		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/editFooter.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertEquals(component.getData().getVersion().getGlobalComponentId(),"Footer");

	}



	@Test(priority=4 ,description = "Make A Copy version API Request")
	public void makeACopyFooter() throws ClientProtocolException, IOException
	{
		HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId"));
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/makeaCopyFooter.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		int actualstatus = response.getStatusLine().getStatusCode();
		assertEquals(actualstatus, 200);
		assertEquals(component.getData().getVersion().getGlobalComponentId(),"Footer");
		assertEquals(component.getData().getVersion().getStatus(),"DRAFT");
		xpmMap.put("copyVersion",component.getData().getVersion());
	}





	@Test(priority=6,description = "Footer Archive API Request")
	public void footerArchive() throws IOException {

		HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId"));
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());

		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/footerArchive.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertTrue(component.getData().getVersion().isArchived());


	}




	@Test(priority=7 , description = "Footer UnArchive API Request")
	public void footerUnArchive() throws IOException {

		HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId"));
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());

		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/footerUnarchive.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertEquals(component.getData().getVersion().getGlobalComponentId(),"Footer");
		assertFalse(component.getData().isArchived());


	}


	@Test(priority=8 , description = "Publish footer API Request")
	public void publisFooterhversion() throws IOException, IOException {
		HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId"));
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
		//  String Json = {\"startDate\":\"2020-06-17T11:30:00.000Z\"};
		request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("XpmGlobalElementFooterPayload/publishFooter.json"), ContentType.APPLICATION_JSON));
		response=client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertFalse(component.getData().getVersion().isArchived());
		assertEquals(component.getData().getVersion().getName(),"NewFooter");
		assertEquals(component.getData().getVersion().getComponents()[0].getId(),"Footer");

	}


	@Test(priority=9 , description = "Delete footer API Request")
	public void deteleFooterVersion() throws IOException {
		HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_XPM()+"/global-component/Footer/version/"+xpmMap.get("versionId"))	;
		request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN);
		request.setHeader("x-site-context", GenerateXSiteContext.xSiteContext());
		response = client.execute(request);
		GlobalComponent component =  ResponseUtils.unmarshallGeneric(response, GlobalComponent.class);
		assertEquals(response.getStatusLine().getStatusCode(),200);
		assertEquals(component.getStatus_code(),204);

	}







}
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	