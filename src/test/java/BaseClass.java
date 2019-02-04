import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.TestRequest;
import utils.TestResult;

import java.lang.reflect.Method;


public class BaseClass implements RequestHandler<TestRequest, TestResult>  {

    private static TestResult testResult;
    public Browser browser;
    public WebDriver driver;

    public BaseClass() {
        testResult = new TestResult();
        browser = new Browser();
        driver = browser.driver;
    }

    public TestResult handleRequest(TestRequest testRequest, Context context) {
        System.out.print("Inside the Test Handle Requests");
        if (testRequest == null) {
            TestRunner.executeTests();
            return testResult;
        }
        try {
            browser.initialiseChromeOptions();
            Method[] pagetTitleMethods = Class.forName("PagetTitleTests").getMethods();
            for(Method method : pagetTitleMethods) {
             if(method.getName() == testRequest.getFrameworkMethod() && method.getDeclaringClass().toString() == testRequest.getTestClass()){
                 Object pageTitleTestsObj = new PagetTitleTests();
                 method.invoke(pageTitleTestsObj);
             }
            }
            //Method[] smokeTestsMethods = Class.forName("SmokeTests").getMethods();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return testResult;
    }

    public static void main(String[] args){
       new BaseClass().handleRequest(null, null);
    }

}