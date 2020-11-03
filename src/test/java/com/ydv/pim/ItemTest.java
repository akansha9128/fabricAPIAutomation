package com.ydv.pim;

import com.ydv.BaseTest;
import com.ydv.pim.attribute.Attribute;
import com.ydv.pim.group.Group;
import com.ydv.pim.item.Item;
import com.ydv.pim.itemFamily.ItemFamily;
import com.ydv.utils.Credentials;
import com.ydv.utils.ResponseUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ItemTest extends BaseTest {

    private static Number itemId;
    private static String itemMId;
    private static Number attributeID;
    private static String attributeMId;
    private static String attributeMIdAfterValue;
    private static String attributeName;
    private static String attributeType;
    private static String attributeV1MId;
    private static String attributeVName;
    private static String attributeVType;
    private static String attributeV2MId;
    private static String attributeV2Name;
    private static String attributeV2Type;
    private static Number itemFamilyId;
    private static String itemFamilyMId;
    private static String itemFamilyName;
    private static Number categoryId;
    private static String parentCategoryMId;
    private static String itemTitle;
    private static String itemSKU;
    private static String itemDesc;
    private static String attributeValue;
    private static String D0V0;
    private static String D0V1;
    private static String D1V0;
    private static String D1V1;
    private static Number itemIdV1;
    private static Number itemIdV2;
    private static String item1MId;
    private static String item2MId;


    @Test(priority = 1)
    public void createAttribute() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setEntity(new StringEntity("{\"name\":\"Item Attribute31\",\"datatype\":\"STRING\"}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        attributeID = attribute.getAttributeId();
        attributeMId = attribute.get_id();
        attributeName = attribute.getName();
        attributeType = attribute.getDatatype();
        attributeMap.put("attributeID",attribute.getAttributeId());
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(), "Item Attribute31");
        assertEquals(attribute.getDatatype(), "STRING");
        assertTrue(attribute.getIsActive());
    }

    @Test(priority = 1)
    public void createVariantAttribute() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setEntity(new StringEntity("{\"name\":\"Item Attribute Variant128\",\"datatype\":\"STRING\"}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        //attributeID = attribute.getAttributeId();

        attributeV1MId = attribute.get_id();
        attributeVName = attribute.getName();
        attributeVType = attribute.getDatatype();
        attributeMap.put("attributeV1MId",attribute.get_id());
        System.out.println(attributeV1MId );
        System.out.println(attributeMap.get("attributeV1MId"));
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(), "Item Attribute Variant128");
        assertEquals(attribute.getDatatype(), "STRING");
        assertTrue(attribute.getIsActive());
    }

    @Test(priority = 1)
    public void createVariantAttribute2() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/attribute/create");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.setEntity(new StringEntity("{\"name\":\"Item Attribute Variant227\",\"datatype\":\"STRING\"}", ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        //attributeID = attribute.getAttributeId();
        attributeV2MId = attribute.get_id();
        attributeV2Name = attribute.getName();
        attributeV2Type = attribute.getDatatype();
        attributeMap.put("attributeV2MId",attribute.get_id());
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 200);
        assertEquals(attribute.getName(), "Item Attribute Variant227");
        assertEquals(attribute.getDatatype(), "STRING");
        assertTrue(attribute.getIsActive());
    }

    @Test(priority = 2)
    public void createItemFamily() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/family/create");
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        System.out.println(attributeMId);
        System.out.println(attributeV1MId);
        System.out.println(attributeV2MId);
        String json = "{\"name\":\"ItemFamily for Item122\",\"attributes\":[{\"id\":\"" + attributeMId + "\",\"name\":\"" + attributeName + "\",\"isRequired\":false,\"isEditable\":true,\"isActive\":true,\"isAttribute\":false,\"display\":true,\"value\":null,\"datatype\":\"" + attributeType + "\",\"order\":\"1\"},{\"id\":\"" + attributeV1MId + "\",\"name\":\"" + attributeVName + "\",\"isRequired\":false,\"isEditable\":true,\"isActive\":true,\"isAttribute\":true,\"display\":true,\"value\":null,\"datatype\":\"" + attributeVType + "\",\"order\":\"2\"},{\"id\":\"" + attributeV2MId + "\",\"name\":\"" + attributeV2Name + "\",\"isRequired\":false,\"isEditable\":true,\"isActive\":true,\"isAttribute\":true,\"display\":true,\"value\":null,\"datatype\":\"" + attributeV2Type + "\",\"order\":\"3\"}]}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        System.out.println(itemFamily.getItemFamilyId());
        itemFamilyId = itemFamily.getItemFamilyId();
        itemFamilyMId = itemFamily.get_id();
        itemFamilyName = itemFamily.getName();
        itemFamilyMap.put("itemFamilyId", itemFamily.getItemFamilyId());
        assertTrue(itemFamily.getIsActive());
        assertEquals(itemFamily.getName(), "ItemFamily for Item122");
        assertEquals(itemFamily.getAttributes()[0].getId(), attributeMId);
        assertTrue(itemFamily.getAttributes()[0].getIsEditable());
        assertTrue(itemFamily.getAttributes()[0].getdisplay());
        assertFalse(itemFamily.getAttributes()[0].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[0].getIsActive());
        assertFalse(itemFamily.getAttributes()[0].getIsRequired());

        assertEquals(itemFamily.getAttributes()[1].getId(), attributeV1MId);
        assertTrue(itemFamily.getAttributes()[1].getIsEditable());
        assertTrue(itemFamily.getAttributes()[1].getdisplay());
        assertTrue(itemFamily.getAttributes()[1].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[1].getIsActive());
        assertFalse(itemFamily.getAttributes()[1].getIsRequired());

        assertEquals(itemFamily.getAttributes()[2].getId(), attributeV2MId);
        assertTrue(itemFamily.getAttributes()[2].getIsEditable());
        assertTrue(itemFamily.getAttributes()[2].getdisplay());
        assertTrue(itemFamily.getAttributes()[2].getIsAttribute());
        assertTrue(itemFamily.getAttributes()[2].getIsActive());
        assertFalse(itemFamily.getAttributes()[2].getIsRequired());

        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void createCategory() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/group");
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CopilotBizLayer/category.json"), ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        System.out.println("categoryId:" + group.getGroupId());
        categoryId = group.getGroupId();
        Assert.assertTrue(group.getIsActive());
        assertFalse(group.getIsInternal());
        assertFalse(group.getisSoftDeleted());
        assertEquals(group.getKind(), "CATEGORY");
        assertEquals(group.getName(), "Test Automation Category25");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        parentCategoryMId = group.get_id();
    }

    @Test(priority = 4)
    public void createItem() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item");
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        String json = "{\"title\":\"Automation item_20\",\"itemFamily\":\"" + itemFamilyMId + "\",\"channel\":[12,13],\"group\":[\"" + parentCategoryMId + "\"]," +
                "\"sku\":\"api_automation_15\",\"description\":\"Wr are created by automated api\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        itemMId = item.get_id();
        itemId = item.getItemId();
        itemTitle = item.getTitle();
        itemSKU = item.getSku();
        itemDesc = item.getDescription();
        System.out.println(itemMId);
        System.out.println(itemId);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertTrue(item.getIsActive());
        assertEquals(item.getChannel()[0], 12);
        assertEquals(item.getChannel()[1], 13);
        assertEquals(item.getGroup()[0], parentCategoryMId);
        assertFalse(item.getIsDefault());
        assertFalse(item.getIsSoftDeleted());
        assertEquals(item.getTitle(), "Automation item_20");
        assertEquals(item.getItemFamily(), itemFamilyMId);
        assertEquals(item.getSku().toLowerCase(), "api_automation_15");
        assertEquals(item.getDescription(), "Wr are created by automated api");
        assertEquals(item.getState(), "READY");
        itemMap.put("itemId", String.valueOf(itemId));
        itemMap.put("itemSku", itemSKU);
        itemMap.put("itemTitle", itemTitle);

    }

    @Test(priority = 5)
    public void addImageToItem() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item/product/images");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        URL url = new URL("https://s3.us-west-2.amazonaws.com/com.rippling.images/584f8834-5152-4073-b1d6-f9b24cb28639");
        String json = "{\"itemId\":" + itemId + ",\"images\":[{\"order\":0,\"label\":\"imageForItem\",\"source\":[{\"url\":\"" + url.toString() + "\"}]}]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(item.getImages()[0].getLabel(), "imageForItem");
        assertEquals(item.getImages()[0].getOrder(), 0);
        assertEquals(item.getImages()[0].getSource()[0].getUrl(), url.toString());
    }


    @Test(priority = 6)
    public void addAttributeValue() throws IOException {
        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM() + "/item/" + itemId);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "{\"title\":\"" + itemTitle + "\",\"itemFamily\":\"" + itemFamilyMId + "\",\"channel\":[12,13],\"sku\":\"" + itemSKU + "\"," +
                "\"description\":\"" + itemDesc + "\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true," +
                "\"attributes\":[{\"id\":\"" + attributeMId + "\",\"value\":\"attributeValue\"}]}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        attributeValue = item.getAttributes()[0].getValue();
        attributeMIdAfterValue = item.getAttributes()[0].get_id();
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(item.getState(), "READY");
        assertEquals(item.getAttributes()[0].getId(), attributeMId);
        assertFalse(item.getAttributes()[0].getIsDefault());
    }

    @Test(priority = 7)
    public void generateVariant() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item/variants");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "[{\"attributes\":" +
                "[{\"isDefault\":false,\"_id\":\"" + attributeMIdAfterValue + "\",\"id\":\"" + attributeMId + "\",\"value\":\"" + attributeValue + "\"}]" +
                ",\"parent\":\"" + itemMId + "\",\"itemFamily\":\"" + itemFamilyMId + "\",\"channel\":[12,13]" +
                ",\"title\":\"" + itemTitle + "\",\"description\":\"" + itemDesc + "\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true,\"" +
                "variants\":[{\"id\":\"" + attributeV1MId + "\",\"value\":\"V1\"},{\"id\":\"" + attributeV2MId + "\",\"value\":\"V2\"}]}," +
                "{\"attributes\":[{\"isDefault\":false,\"_id\":\"" + attributeMIdAfterValue + "\",\"id\":\"" + attributeMId + "\",\"value\":\"" + attributeValue + "\"}]," +
                "\"parent\":\"" + itemMId + "\",\"itemFamily\":\"" + itemFamilyMId + "\",\"channel\":[12,13]," +
                "\"title\":\"" + itemTitle + "\",\"description\":\"" + itemDesc + "\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true,\"" +
                "variants\":[{\"id\":\"" + attributeV1MId + "\",\"value\":\"V1\"},{\"id\":\"" + attributeV2MId + "\",\"value\":\"V3\"}]}]";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        D0V0 = item.getData()[0].getVariants()[0].getValue();
        D0V1 = item.getData()[0].getVariants()[1].getValue();
        D1V0 = item.getData()[1].getVariants()[0].getValue();
        D1V1 = item.getData()[1].getVariants()[1].getValue();

        itemIdV1 = item.getData()[0].getItemId();
        itemIdV2 = item.getData()[1].getItemId();

        assertEquals(item.getData()[0].getVariants()[0].getValue(), "V1");
        assertEquals(item.getData()[0].getVariants()[1].getValue(), "V2");
        assertEquals(item.getData()[1].getVariants()[0].getValue(), "V1");
        ;
        assertEquals(item.getData()[1].getVariants()[1].getValue(), "V3");
        assertEquals(item.getData()[0].getState(), "DRAFT");
        assertEquals(item.getData()[1].getState(), "DRAFT");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 8)
    public void createVariantSku() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_PIM() + "/item/variants");
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        String json = "[{\"attributes\":[{\"id\":\"" + attributeMId + "\",\"value\":\"" + attributeValue + "\",\"isDefault\":false}],\"channel\":[12,13],\"description\":\"" + itemDesc + "\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true,\"isDefault\":true,\"itemFamily\":\"" + itemFamilyMId + "\",\"itemId\":" + itemIdV1 + ",\"parent\":\"" + itemMId + "\"," +
                "\"sku\":\"SKU23\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"title\":\"" + itemTitle + "\",\"variants\":[{\"id\":\"" + attributeV1MId + "\",\"value\":\"" + D0V0 + "\",\"isDefault\":false},{\"id\":\"" + attributeV2MId + "\",\"value\":\"" + D0V1 + "\",\"isDefault\":false}]},{\"attributes\":[{\"id\":\"" + attributeMId + "\",\"value\":\"attributeValue\",\"isDefault\":false}],\"channel\":[12,13],\"description\":\"" + itemDesc + "\",\"endDate\":\"2099-12-31T00:00:00.000Z\",\"isActive\":true,\"isDefault\":false,\"itemFamily\":\"" + itemFamilyMId + "\",\"itemId\":" + itemIdV2 + ",\"parent\":\"" + itemMId + "\"" +
                ",\"sku\":\"SKU233\",\"startDate\":\"2020-03-03T16:18:23.642Z\",\"title\":\"" + itemTitle + "\",\"variants\":[{\"id\":\"" + attributeV1MId + "\",\"value\":\"" + D1V0 + "\",\"isDefault\":false},{\"id\":\"" + attributeV2MId + "\",\"value\":\"" + D1V1 + "\",\"isDefault\":false}]}]";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertEquals(item.getData()[0].getSku().trim(), "SKU23");
        assertEquals(item.getData()[1].getSku().trim(), "SKU233");
        assertEquals(item.getData()[0].getState(), "READY");
        assertEquals(item.getData()[1].getState(), "READY");
        assertEquals(item.getData()[0].getAttributes()[0].getValue(), attributeValue);
        assertEquals(item.getData()[1].getAttributes()[0].getValue(), attributeValue);
        item1MId = item.getData()[0].get_id();
        item2MId = item.getData()[1].get_id();
        itemMap.put("itemV1Id", String.valueOf(itemIdV1));
        itemMap.put("itemV2Id", String.valueOf(itemIdV2));
        itemMap.put("itemV1SKU", item.getData()[0].getSku());
        itemMap.put("itemV2SKU", item.getData()[1].getSku());
        itemMap.put("itemAttributeValue", attributeValue);
        itemMap.put("AttributeName", attributeName);
        Set<String> keys = itemMap.keySet();
        for (String k : keys) {
            System.out.println(k + " -- " + itemMap.get(k));
        }

    }

    @Test(priority = 9)
    public void enableDisableProduct() throws IOException {

        HttpPut request = new HttpPut(testEnvironment.BASE_ENDPOINT_PIM() + "/item/product/enable-disable");
        System.out.println(request);
        String API_key = "{\"date\":\"2020-07-14T09:33:17.664Z\",\"channel\":12}";
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        request.addHeader("x-site-context", API_key);
        System.out.println(Credentials.TOKEN);
        System.out.println("itemid" + itemId);
        System.out.println("sku" + itemSKU);
        String json = "{\"itemId\":\"" + itemId + "\",\"sku\":\"" + itemSKU + "\",\"enable\":false}";
        System.out.println(json);
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        System.out.println(response);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);


    }
    @Test(priority = 10)
    public void deleteVariant1() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/item/"+itemIdV1);
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
    @Test(priority = 11)
    public void deleteVariant2() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/item/"+itemIdV2);
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }



    @Test(priority = 12)
    public void deleteItem() throws IOException {

        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/item/" + itemId);
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        response = client.execute(request);
        System.out.println(response);
        Item item = ResponseUtils.unmarshallGeneric(response, Item.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test(priority = 13)
    public void deleteCategory() throws IOException {

        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/group/" + categoryId);
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        System.out.println(Credentials.TOKEN);
        response = client.execute(request);
        System.out.println(response);
        Group group = ResponseUtils.unmarshallGeneric(response, Group.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        Assert.assertFalse(group.getIsActive());
    }

    @Test(priority = 14)

    public void deleteFamily() throws IOException {
        HttpDelete request = new HttpDelete(testEnvironment.BASE_ENDPOINT_PIM() + "/family/" + itemFamilyMap.get("itemFamilyId"));
        request.setHeader(HttpHeaders.AUTHORIZATION, Credentials.TOKEN);
        response = client.execute(request);
        System.out.println(response);
        ItemFamily itemFamily = ResponseUtils.unmarshallGeneric(response, ItemFamily.class);
        assertEquals(response.getStatusLine().getStatusCode(), 200);
        assertFalse(itemFamily.getIsActive());
    }

    @Test (priority =15)

    public void deleteVariantAttribute1() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeMap.get("attributeV2MId"));
        System.out.println(attributeMap.get("attributeV2MId"));
        System.out.println(request);
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        System.out.println(Credentials.TOKEN);
        response = client.execute(request);
        System.out.println(response);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertFalse(attribute.getIsActive());
        assertEquals(actualStatusCode, 200);
    }

    @Test (priority =16)

    public void deleteVariantAttribute2() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeMap.get("attributeV1MId"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertFalse(attribute.getIsActive());
        assertEquals(actualStatusCode, 200);
    }

    @Test (priority =17)

    public void deleteAttribute() throws IOException {
        HttpDelete request = new HttpDelete( testEnvironment.BASE_ENDPOINT_PIM()+"/attribute/"+attributeMap.get("attributeID"));
        request.setHeader(HttpHeaders.AUTHORIZATION,Credentials.TOKEN );
        response = client.execute(request);
        Attribute attribute = ResponseUtils.unmarshallGeneric(response, Attribute.class);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertFalse(attribute.getIsActive());
        assertEquals(actualStatusCode, 200);
    }
}
