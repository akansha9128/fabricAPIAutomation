package com.ydv.pim;

import com.ydv.BaseTest;
import org.apache.commons.io.IOUtils;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import static org.testng.Assert.assertEquals;

public class ItemTypeTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
      //  Object d = "{\"itemId\":1000000808,\"images\":[{\"order\":0,\"label\":\"dsfas\",\"source\":[{\"url\":\"https://s3.us-west-2.amazonaws.com/com.rippling.images/584f8834-5152-4073-b1d6-f9b24cb28639\"}]}]}";
       // URI u = new URI("https://s3.us-west-2.amazonaws.com/com.rippling.images/584f8834-5152-4073-b1d6-f9b24cb28639");
       // System.out.println(IOUtils.toString(URI.create("https://s3.us-west-2.amazonaws.com/com.rippling.images/584f8834-5152-4073-b1d6-f9b24cb28639"),"image/jpeg"));

        //URL url = new URL("https://s3.us-west-2.amazonaws.com/com.rippling.images/584f8834-5152-4073-b1d6-f9b24cb28639");
        //System.out.println(url.toString());
        //String json = "{\"itemId\":1000000808,\"images\":[{\"order\":0,\"label\":\"dsfas\",\"source\":[{\"url\":\""+url.toString()+"\"}]}]}";
//        TimeZone tz = TimeZone.getTimeZone("UTC");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
//        df.setTimeZone(tz);
//        String nowAsISO = df.format(new Date());
//
//        System.out.println(nowAsISO);

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString()+"@gmail.com";
        System.out.println(saltStr);

    }
}