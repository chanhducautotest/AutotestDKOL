package runners;

import io.cucumber.testng.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

@CucumberOptions(
        glue = {"stepDefinitions"},
        plugin ={"html:target/cucumber-reports/reportHomepage.html", "json:target/cucumber-reports/CucumberTestReport.json","message:target/cucumber-report-feature-composite.ndjson"}
)
public class RunCucumberByCompositionTest {
    static final Logger logger = LoggerFactory.getLogger(RunCucumberByCompositionTest.class);
    private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass(alwaysRun = true)
    public void setUpCucumber(ITestContext context) {
        logger.info("<<< BeforeClass >>>");
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

//    @BeforeTest(alwaysRun = true)
//    public void setUpClass(ITestContext context) throws Exception {
//        logger.info("<<< BeforeTest >>>");
//    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature)
    {
        logger.info("<<< scenario "+ cucumberFeature +" >>>");
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

//    @AfterTest(alwaysRun = true)
//    public void tearDownTest(ITestContext context) {
//    }


    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(ITestContext context) {
        logger.info("<<< AfterClass >>>");
        testNGCucumberRunner.finish();
    }
}
