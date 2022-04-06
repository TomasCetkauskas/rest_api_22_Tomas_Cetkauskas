package clickUpApi.helpers;

import clickUpApi.domain.Folder;
import clickUpApi.domain.Task;
import clickUpApi.domain.List;
import io.cucumber.java.Scenario;

public class TestCaseContext {
    private static Folder testFolder;
    private static Task testTask;
    private static List testList;
    private static Scenario scenario;

    public static void init(){
        testFolder = null;
        testTask = null;
        testList = null;
    }
    public static void setFolder( Folder testFolder) {
        TestCaseContext.testFolder = testFolder;
    }
    public static Folder getFolder(){
        return testFolder;
        }

    public static void setTask( Task testTask){
        TestCaseContext.testTask = testTask;
    }

    public static Task getTask(){
        return testTask;
    }

    public static void setList( List testList){
        TestCaseContext.testList = testList;
    }

    public static List getList(){
        return testList;
    }

    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }
}
