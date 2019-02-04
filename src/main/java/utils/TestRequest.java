package utils;


import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.model.FrameworkMethod;


public class TestRequest {

    private String testClass;
    private String frameworkMethod;

    public TestRequest() {}

    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass){
        this.testClass = testClass;
    }

    public String getFrameworkMethod(){
        return frameworkMethod;
    }

    public void setFrameworkMethod(String frameworkMethod){
        this.frameworkMethod = frameworkMethod;
    }

    public TestRequest(Class<?> clazz, FrameworkMethod method) {
        testClass = clazz.getCanonicalName();
        String frameworkMethodName = method.getMethod().getName();
    }

    public TestRequest(Description description) {
        testClass = description.getClassName();
        String frameworkMethod = description.getMethodName();
    }



}
