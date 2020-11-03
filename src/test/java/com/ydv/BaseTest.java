package com.ydv;


import org.aeonbits.owner.ConfigFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.ITestResult;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Properties;



public class BaseTest {

    public CloseableHttpClient client;
    public Environment testEnvironment = ConfigFactory.create(Environment.class);
    public CloseableHttpResponse response;
    public static Properties prop;


    public static LinkedHashMap<String, String> itemMap = new LinkedHashMap<String, String>();
    public static LinkedHashMap<String, Object> attributeMap = new LinkedHashMap<String, Object>();
    public static LinkedHashMap<String, Object> attributeGroupMap = new LinkedHashMap<String, Object>();
    public static LinkedHashMap<String, Object> familyMap = new LinkedHashMap<String, Object>();
    public static LinkedHashMap<String, Object> CollectionMap = new LinkedHashMap<String, Object>();
    public static LinkedHashMap<String, String> userMap = new LinkedHashMap<String, String>();
    public static LinkedHashMap<String, Object> xpmMap = new LinkedHashMap<String, Object>();
    public static LinkedHashMap<String, Object> itemFamilyMap = new LinkedHashMap<String, Object>();
   

    @DataProvider
    protected Object[][] endpoints() {
        return new Object[][]{
                {"/user"},
                {"/role"},
                {"/permission"},
                {"/account"}
        };
    }

    @DataProvider
    protected Object[][] channelType() {
        return new Object[][]{
                {"Web"},
                {"Store"},
                {"ThirdParty"},
        };
    }

    @BeforeMethod
    public void setup(Method method) {
        System.out.println("Before Test of" + method.getName());
        client = HttpClientBuilder.create().build();
    }

    @BeforeClass
    @Parameters({"environment"})
    public void beforeTest(String environemnt) {
        ConfigFactory.setProperty("environment", environemnt);
        System.out.println("Value of env us " + environemnt);
        testEnvironment = ConfigFactory.create(Environment.class);
        System.out.println("Setting up env variable");
    }

    @AfterMethod(alwaysRun = true)
    public void closeResources(ITestResult iTestResult) throws IOException {

        client.close();
        response.close();
        int status = iTestResult.getStatus();

        switch (status) {
            case ITestResult.SUCCESS:
                System.out.println("After Test of Method :::" + iTestResult.getMethod().getMethodName() + " And Result is PASS");
                break;
            case ITestResult.FAILURE:
                System.out.println("After Test of Method :::" + iTestResult.getMethod().getMethodName() + " And Result is FAIL");
                break;
            case ITestResult.SKIP:
                System.out.println("After Test of Method :::" + iTestResult.getMethod().getMethodName() + " And Result is SKIPPED");
                break;
            default:
                throw new RuntimeException("Invalid status");
        }

    }

   // @BeforeTest
    public void beforeTest() {
        System.out.println("In Before Test");
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/tes/resources/Properties/devEnv.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
