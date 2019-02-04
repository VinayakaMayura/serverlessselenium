import com.amazonaws.services.lambda.invoke.LambdaFunction;
import utils.TestRequest;
import utils.TestResult;

public interface LambdaSeleniumService {
    @LambdaFunction(functionName = "getPageTitle")
    TestResult runTest(TestRequest testRequest);
}
