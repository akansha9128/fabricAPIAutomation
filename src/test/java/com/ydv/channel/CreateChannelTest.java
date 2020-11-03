package com.ydv.channel;

import com.ydv.BaseTest;

import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;
import com.ydv.channel.channels.Channels;
import static org.testng.Assert.assertEquals;

public class CreateChannelTest extends BaseTest {

    String channelID = "";
    @Test(priority = 1, dataProvider = "channelType")
    public void createChannel(String channel) throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_CHANNEL()+"/channel");

        // Define Json to Post and set as Entity
        String json = "{\"name\":\"testing channel\",\"kind\":\"Store\",\"address\":[{\"attention\":\"att1\",\"street1\":\"st1\",\"street2\":\"st2\",\"city\":\"pune\",\"state\":\"Maharashtra\",\"country\":\"India\",\"zipCode\":\"411014\",\"phone\":[{\"number\":\"1234\",\"kind\":\"mob\"}]}],\"extra\":{\"test1\":\"ex1\"}}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        Channels channels = ResponseUtils.unmarshallGeneric(response, Channels.class);
        channelID = channels.get_id();
        System.out.println("my getID is " + channelID);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
    }

}
