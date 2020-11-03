package com.ydv.identity.account;

import com.ydv.BaseTest;
import com.ydv.utils.ResponseUtils;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AccountBodyTest extends BaseTest {


    @Test
    public void accountBodyTest() throws IOException {
        HttpGet get = new HttpGet(testEnvironment.BASE_ENDPOINT_IDENTITY() + "/account/5c004660ccde9c03efc5b500");
        response = client.execute(get);
        Account account = ResponseUtils.unmarshallGeneric(response, Account.class);
        System.out.println("****"+account.getDisplayText());
        assertEquals( account.getDisplayText(),"Synergized 3rd generation local area network");
       // assertEquals(role.get_id(),"5c004660ccde9c03efc5b4ff", "Tested ID");
        //assertEquals(role.getDisplayText(), "Super Administrator");
        //assertEquals(role.getDescription(),"I have the power!!");


    }
}
