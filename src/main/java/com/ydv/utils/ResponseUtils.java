package com.ydv.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydv.CBL.auth.Addressess;
import com.ydv.CBL.item.Item;
import com.ydv.CBL.shipping.shipping;
import com.ydv.offer.Rate;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {

    public static String getHeader(CloseableHttpResponse response, String headerName) {

        // Get All headers
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        // Loop over the headers list
        for(Header header : httpHeaders){
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader = header.getValue();
            }
        }
        // If no header found - throw an exception
        if(returnHeader.isEmpty()){
            throw new RuntimeException("Didn't find the header: " + headerName);
        }
        // Return the header
        return returnHeader;
    }


    public static String getHeaderJava8Way(CloseableHttpResponse response, String headerName) {

        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didn't find the header"));

        return matchedHeader.getValue();
    }

    public static boolean headerIsPresent(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(header -> header.getName().equalsIgnoreCase(headerName));
    }

    public static shipping[] unmarshall(CloseableHttpResponse response, Class<shipping> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper1 = new ObjectMapper();

        shipping[] shipp = mapper1.readValue(jsonBody, shipping[].class);
        return shipp;
    }


    public static Rate[] unmarshallRate(CloseableHttpResponse response, Class<Rate> clazz) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper1 = new ObjectMapper();
        Rate[] rate = mapper1.readValue(jsonBody, Rate[].class);
        return rate;
    }

    public static Addressess[] unmarshallAddress(CloseableHttpResponse response, Class<Addressess> clazz) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper1 = new ObjectMapper();
        Addressess[] add = mapper1.readValue(jsonBody, Addressess[].class);
        return add;
    }

    public static Item[] unmarshallItem(CloseableHttpResponse response, Class<Item> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper1 = new ObjectMapper();

        Item[] item = mapper1.readValue(jsonBody, Item[].class);
        return item;
    }

    public static <T> T unmarshallGeneric(CloseableHttpResponse response, Class<T> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, clazz);
    }

    ArrayList<Integer> al = new ArrayList<>();


    /*public static <T> T parseJsonArray(CloseableHttpResponse response,
                                            Class<T> clasz)
            throws IOException, ClassNotFoundException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, clasz[].class);



        ObjectMapper mapper = new ObjectMapper();
        T[] objects = (T[]) mapper.readValue(EntityUtils.toString(response.getEntity()), classOnWhichArrayIsDefined);
        return Arrays.toString(objects);
    }
*/
    //TODO, Can b
   /* public static  Object xyz(String response,  int index) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(response);
        JsonNode results = node.get("result");
        if(!Objects.isNull(results) && results.isArray()) {
            for(JsonNode result : results) {
              return result;
            }
        }
        return null;

    }*/


   public static String getRequestPayload(String path) throws IOException {
       return new String(Files.readAllBytes(Paths.get("./src/test/resources/"+path)));
   }
   
   
 /*  public static String updateJsonValue(String value, String fileName) {
	   String getData = null;
   //
       try {
		getData = getRequestPayload(fileName);

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("our data is" +getData);

	   return getData;
   } */




}
