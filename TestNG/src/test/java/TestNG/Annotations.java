package TestNG;

import org.testng.annotations.*;

public class Annotations
{
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before suite");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before test");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before method");
    }

    @Test
    public void testCaseOne()
    {
        System.out.println("1");
    }

    @Test
    public void testCaseTwo()
    {
        System.out.println("2");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After suite");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("After test");
    }

    @AfterSuite
    public void afterClass()
    {
        System.out.println("After class");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After method");
    }
}
