@e2e
Feature: CRUD API test for Book Store
Description: The aim to test CRUD operation on Library API for user

Bookstore swagger URL: http://bookstore.toolsqa.com/swagger/index.html

Background: User generates token for Authorisation
Given I am an authorized user


Scenario: the Authorized user can Add and Remove a book.
Given A list of books are available
When I add a book to my reading list
Then the book is added
When I remove a book from my reading list
Then the book is removed