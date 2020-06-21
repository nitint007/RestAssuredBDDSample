$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleTest.feature");
formatter.feature({
  "line": 2,
  "name": "CRUD API test for Book Store",
  "description": "Description: The aim to test CRUD operation on Library API for user\n\nBookstore swagger URL: http://bookstore.toolsqa.com/swagger/index.html",
  "id": "crud-api-test-for-book-store",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@e2e"
    }
  ]
});
formatter.background({
  "line": 7,
  "name": "User generates token for Authorisation",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "I am an authorized user",
  "keyword": "Given "
});
formatter.match({
  "location": "e2e.checkAuthenticityOfUser()"
});
formatter.result({
  "duration": 5044214852,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "the Authorized user can Add and Remove a book.",
  "description": "",
  "id": "crud-api-test-for-book-store;the-authorized-user-can-add-and-remove-a-book.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "A list of books are available",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I add a book to my reading list",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the book is added",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I remove a book from my reading list",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the book is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "e2e.aListOfBooksAvailable()"
});
formatter.result({
  "duration": 868824346,
  "status": "passed"
});
formatter.match({
  "location": "e2e.iAddBookToMyReadingList()"
});
formatter.result({
  "duration": 779658723,
  "status": "passed"
});
formatter.match({
  "location": "e2e.ifTheBookIsAdded()"
});
formatter.result({
  "duration": 989793,
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c400\u003e\n\tat org.junit.Assert.fail(Assert.java:89)\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\n\tat org.junit.Assert.assertEquals(Assert.java:647)\n\tat org.junit.Assert.assertEquals(Assert.java:633)\n\tat stepdefinitions.e2e.ifTheBookIsAdded(e2e.java:80)\n\tat ✽.Then the book is added(SampleTest.feature:14)\n",
  "status": "failed"
});
formatter.match({
  "location": "e2e.removingBookFromReadingList()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "e2e.bookisRemoved()"
});
formatter.result({
  "status": "skipped"
});
});