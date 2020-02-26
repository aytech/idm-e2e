package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features"},
        glue = "steps",
        tags = {"@new"},
        plugin = "pretty")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IdmAcceptanceTest {

    @BeforeClass
    @SuppressWarnings("EmptyMethod")
    public static void setUp() {
    }

    @AfterClass
    @SuppressWarnings("EmptyMethod")
    public static void tearDown() {
    }
}
