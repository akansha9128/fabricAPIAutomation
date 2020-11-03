package com.ydv.commerceBusinessLayer.tax;

import com.ydv.BaseTest;
import com.ydv.CBL.tax.tax;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;


public class taxTest extends BaseTest {

    final static Logger logger = Logger.getLogger(taxTest.class);

    @Test(priority = 0)
    public void createFinalTax() throws IOException {
        HttpPost request = new HttpPost(testEnvironment.BASE_ENDPOINT_COMMERCE_BUSINESS_LAYER_TAX() + "/data-external/tax/create");
        request.setHeader("x-api-key", "d41d8cd98f00b204e9800998ecf8427e");
        request.setEntity(new StringEntity(ResponseUtils.getRequestPayload("CBL/cblFinalTax.json"), ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        tax taax = ResponseUtils.unmarshallGeneric(response, tax.class);
        assertTrue(taax.getCode() instanceof String);
        assertTrue(taax.getDate() instanceof Date);
        assertEquals(taax.getStatus(),"Saved");
        assertEquals(taax.getType(),"SalesInvoice");
        assertEquals(taax.getCustomerCode(),"ABC");
        assertEquals(taax.getTotalAmount(),900);
        assertEquals(taax.getTotalExempt(),900);
        assertEquals(taax.getTotalDiscount(),0);
        assertEquals(taax.getTotalTax(),0);
        assertEquals(taax.getTotalTaxable(),0);
        assertEquals(taax.getTotalTaxCalculated(),0);
        assertEquals(taax.getLines()[0].getLineAmount(), 900);
        assertTrue(taax.getLines()[0].getId() instanceof  Number);
        assertEquals(taax.getLines()[0].getLineNumber(), 1);
        assertEquals(taax.getLines()[0].getQuantity(), 1);
        assertEquals(taax.getLines()[0].getTax(), 0);
        assertEquals(taax.getLines()[0].getTaxableAmount(), 0);
        assertEquals(taax.getLines()[0].getTaxCalculated(), 0);
        assertEquals(taax.getLines()[0].getTaxCode(), "PF050099");
        assertEquals(taax.getLines()[0].getDescription(), "Chocolate");



    }
}
