import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {


    public static void executeTests(){

        Method[] pagetTitleMethods;
        Method[] smokeTestsMethods;

        try {
            pagetTitleMethods   = Class.forName("PagetTitleTests").getMethods();
            smokeTestsMethods   = Class.forName("SmokeTests").getMethods();

            Object pageTitleTestsObj = new PagetTitleTests();
            //Object smokeTestsObj = new SmokeTests();

            for(Method method : pagetTitleMethods){
                System.out.println("Invoking the Method " + method.getName());
                method.invoke(pageTitleTestsObj);
            }

//            for (Method method: smokeTestsMethods){
//                System.out.println("Invoking the Method " + method.getName());
//                method.invoke(smokeTestsObj);
//            }

        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
