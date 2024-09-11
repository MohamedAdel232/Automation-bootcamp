package Listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class iInvokedMethod implements IInvokedMethodListener
{
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        System.out.println(method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        System.out.println(testResult.getStatus());
    }



}
