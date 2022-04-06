package clickUpApi.stepDefinitions;

import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.domain.Task;
import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import java.util.UUID;

import static clickUpApi.clients.ClickUpClient.*;

public class ClickUpSteps {
    @Given("The new folder is created and the folder name is {string}")
    public void makeClickUpFolderCheckInfo( String name ) {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = createFolder(obj);
        Folder createdFolder = resp.as(Folder.class);
        System.out.println(resp);
        Assertions.assertThat(createdFolder.getName())
                .as("We assert that created folder name is correct")
                .isEqualTo(name);
        TestCaseContext.setFolder(createdFolder);
    }


    @When("I created a new {string} list on a folder")
    public void createNewListOnFolder( String name ) {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = createNewList(obj);
        List createdList = resp.as(List.class);
        Assertions.assertThat(createdList.getName())
                .as("We assert that created List name is correct")
                .isEqualTo(name);//Here provide your board name
        Assertions.assertThat(TestCaseContext.getFolder().getName())
                        .as("We assert that created list is in correct folder")
                                .isEqualTo("Test Folder");//Here provide your Folder name
        TestCaseContext.setList(createdList);

    }


    @And("I create task in a list and check if a task name is correct")
    public void createTaskOnList() {
        String uuid = UUID.randomUUID().toString();
        JSONObject obj = new JSONObject();
        obj.put("name", uuid );
        Response resp = ceateNewTask(obj);
        Task createdTask = resp.as(Task.class);
        Assertions.assertThat(createdTask.getName())
                        .as("We assert that task name is correct ")
                        .isEqualTo(uuid);
        TestCaseContext.setTask(createdTask);


    }


    @Then("I remove task from a list")
    public void removeTaskOnList(String name){
        //JSONObject obj = new JSONObject();
       // obj.put("name", null);
        Response resp = removeTask();
        List removedTask = resp.as(List.class);
        //Assertions.assertThat(removedTask.getId())
               // .as("We assert that the created folder id is correct")
              //  .isEqualTo("");
        //TestCaseContext.setTask(removeTask);


    }

}
