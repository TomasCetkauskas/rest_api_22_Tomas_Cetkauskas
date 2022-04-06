package clickUpApi.stepDefinitions;

import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeEveryScenario( Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO IS BEGINNING THE EXECUTION!");
    }

    @After
    public void afterEveryScenario(){

        System.out.println("THE SCENARIO IS FINISHED!");
    }
}
