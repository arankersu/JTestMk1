package JCRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) //basically, to use this junit and tons of other imports are needed
@CucumberOptions(features="Features",glue={"CucumberStepDef"})
public class JRunner
{
}
