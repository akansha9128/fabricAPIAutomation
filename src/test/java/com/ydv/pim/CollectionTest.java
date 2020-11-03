package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.collection.Collection;
import com.ydv.utils.Credentials;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CollectionTest extends BaseTest {

    @Test(priority = 1)
    public void createCollection() throws IOException {

        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/collection");
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/collection.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response);
        Collection collection = ResponseUtils.unmarshallGeneric(response, Collection.class);
        CollectionMap.put("_id", collection.get_id());
        CollectionMap.put("collectionId",collection.getCollectionId());
        CollectionMap.put("title",collection.getTitle());
        CollectionMap.put("media_id",collection.getMedia()[0].get_id());
        //CollectionMap.put("Media_id",collection.getMedia().get_id());
        Assert.assertTrue(collection.getIsActive());
        Assert.assertEquals(collection.getTitle(),"testauto4");
        Assert.assertEquals(collection.getMedia()[0].getLabel().trim(),"automation test1");
        Assert.assertEquals(collection.getMedia()[0].getSource()[0].getUrl(),"https://rukminim1.flixcart.com/image/832/832/j8vy1e80/portable-laptop-table/9/h/4/particle-board-por-704-my-buddy-portronics-off-white-original-imaeyt3mhzw6a6ww.jpeg?q=70");
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

     }

     @Test(priority =2)
     public void createDuplicateCollection() throws IOException{

         HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/collection");
         request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
         request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/collection.json"), ContentType.APPLICATION_JSON));
         response = client.execute(request);
         Collection collection = ResponseUtils.unmarshallGeneric(response, Collection.class);
         Assert.assertEquals(response.getStatusLine().getStatusCode(), 406);
         Assert.assertEquals(collection.getCode(),"COLLECTION_ALREADY_EXISTS");
         Assert.assertEquals(collection.getMessage(),"You are trying to insert a already existing collection with title "+CollectionMap.get("title")+".");
     }


     @Test(priority=3)
     public void renameCollection() throws IOException {

         HttpPatch request = new HttpPatch(testEnvironment.BASE_ENDPOINT_PIM() + "/collection/" + CollectionMap.get("collectionId"));
         System.out.println(request);
         request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
         String json = "{\"title\":\"CollectionUpdate2\"}";
         request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
         response = client.execute(request);
         Collection collection = ResponseUtils.unmarshallGeneric(response, Collection.class);
         Assert.assertTrue(collection.getIsActive());
         Assert.assertEquals(collection.getTitle(),"CollectionUpdate2");
         Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

     }

     @Test(priority =4)
    public void deleteCollection() throws IOException {
         String deleted_id= (String) CollectionMap.get("_id");
         HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() +"/collection/" + CollectionMap.get("collectionId"));
         System.out.println(request);
         request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
         response = client.execute(request);
         System.out.println(response);
         Collection collection = ResponseUtils.unmarshallGeneric(response, Collection.class);
         Assert.assertEquals(collection.get_id(),deleted_id);
        // Assert.assertFalse(collection.getIsActive());
         Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

     }
}
