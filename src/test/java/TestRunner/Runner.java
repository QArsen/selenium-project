package TestRunner;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;



public class Runner {

    static TestNG testNG;
    static List<String> suites = new ArrayList<>();
    public static void main(String[] args) {
        testNG = new TestNG();
        suites.add("src\\test\\java\\suits\\MAIN SUITE.xml");
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
