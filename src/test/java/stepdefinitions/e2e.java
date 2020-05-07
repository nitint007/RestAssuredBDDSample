/**
 * 
 */
package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author nitinthite
 *
 */
public class e2e {

	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "TOOLSQA-Test";
	private static final String PASSWORD = "Test@@123";
	private static final String BASE_URL = "http://bookstore.toolsqa.com";

	private static String token;
	private static Response response;
	private static String jsonString;
	private static String bookId;

	@Given("^I am an authorized user$")
	public void checkAuthenticityOfUser() throws Throwable {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
				.post("/Account/v1/GenerateToken");

		String jsonString = response.asString();
		token = JsonPath.from(jsonString).get("token");

	}

	@Given("^A list of books are available$")
	public void aListOfBooksAvailable() throws Throwable {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/BookStore/v1/Books");

		jsonString = response.asString();
		List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
		Assert.assertTrue(books.size() > 0);

		bookId = books.get(0).get("isbn");

	}

	@When("^I add a book to my reading list$")
	public void iAddBookToMyReadingList() throws Throwable {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

		response = request.body(
				"{ \"userId\": \"" + USER_ID + "\", " + "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
				.post("/BookStore/v1/Books");
	}

	@Then("^the book is added$")
	public void ifTheBookIsAdded() throws Throwable {

		Assert.assertEquals(201, response.getStatusCode());

	}

	@When("^I remove a book from my reading list$")
	public void removingBookFromReadingList() throws Throwable {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

		response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
				.delete("/BookStore/v1/Book");
	}

	@Then("^the book is removed$")
	public void bookisRemoved() throws Throwable {

		Assert.assertEquals(204, response.getStatusCode());

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

		response = request.get("/Account/v1/User/" + USER_ID);
		Assert.assertEquals(200, response.getStatusCode());

		jsonString = response.asString();
		List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
		Assert.assertEquals(0, booksOfUser.size());

	}

}
