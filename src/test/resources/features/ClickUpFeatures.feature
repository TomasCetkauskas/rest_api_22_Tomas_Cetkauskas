Feature: This feature will test ClickUp API
Scenario: Add a task to the new list of the new created folder
  Given The new folder is created and the folder name is "Test Folder"
  When I created a new "Test Title" list on a folder
  And I create task in a list and check if a task name is correct
  Then I remove task from a list