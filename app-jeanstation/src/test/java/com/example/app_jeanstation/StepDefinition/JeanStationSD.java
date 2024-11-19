package com.example.app_jeanstation.StepDefinition;
import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class JeanStationSD {
	private String baseURL = "http://localhost/8080/api/jean-station";
	private Response response;
	private RequestSpecification request;
	

@Given("Enter the post request url")
public void enter_the_post_request_url() {
    // Write code here that turns the phrase above into concrete actions

	RestAssured.baseURI = baseURL;
	request = RestAssured.given();
}

@And("Enter the product details")
public void enter_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	JSONObject object = new JSONObject();
	object.put("productId",1001);
	object.put("productName","Chair");
	object.put("productPrice",300.0);
	object.put("productStock", 2);

	request.contentType(ContentType.JSON)
			.body(object.toJSONString());


}

@When("Post the product details")
public void post_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	response = request.post("/displayproduct/");
 
}

@And("Validate the product name")
public void validate_the_product_name() {
    String productName = response.jsonPath().getString("name[0]");
    if ("expectedProductName".equals(productName)) {
        System.out.println("The Name is validated");
    } else {
        System.out.println("Validation error: Product name does not match");
    }
}


@And("Validate the product price")
public void validate_the_product_price() {
    // Write code here that turns the phrase above into concrete actions
	response.then().body("price", equalTo(200));

}

@Given("Enter the get request url")
public void enter_the_get_request_url() {
    // Write code here that turns the phrase above into concrete actions
	request = RestAssured.given();
}

@When("Get the product details")
public void get_the_product_details() {
    response = request.get("/displayProduct");
}


@And("Validate the Status code")
public void validate_the_status_code() {
    response.then().statusCode(200);
    System.out.println("Response: " + response.getBody().asPrettyString());
}


@Given("Enter the put request url")
public void enter_the_put_request_url() {
    // Write code here that turns the phrase above into concrete actions

	request = RestAssured.given();
}

@And("Enter Updated product details")
public void enter_updated_product_details() {
    // Write code here that turns the phrase above into concrete actions
	JSONObject object = new JSONObject();
	object.put("productId",1001);
	object.put("productName","Table");
	object.put("productPrice",200.70);
	object.put("productStock", 10);

	request.contentType(ContentType.JSON)
			.body(object.toJSONString());
}

@When("Put the product details")
public void put_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	response = request.put("http://localhost/8080/api/jean-station/updateProductById");
}

@Given("Enter the patch request url")
public void enter_the_patch_request_url() {
    // Write code here that turns the phrase above into concrete actions
	request = RestAssured.given();
}

@When("Patch the product details")
public void patch_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	JSONObject object = new JSONObject();
	object.put("productStock", 15);

	request.contentType(ContentType.JSON).body(object.toJSONString());
	response = request.patch("http://localhost/8080/api/jean-station/updateProductPrice/{id}");
}

@Given("Enter the delete request url")
public void enter_the_delete_request_url() {
    // Write code here that turns the phrase above into concrete actions

	request = RestAssured.given();
}

@When("Delete the product details")
public void delete_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	response =request.delete("http://localhost/8080/api/jean-station/deleteAllProducts");
}

@Given("Enter the placing order request url")
public void enter_the_placing_order_request_url() {
    // Write code here that turns the phrase above into concrete actions
	request = RestAssured.given();

}

@And("Enter the desired product details")
public void enter_the_desired_product_details() {
    // Write code here that turns the phrase above into concrete actions
	JSONObject object = new JSONObject();
	object.put("productId",1);

}

@And("validate the Order Status")
public void validate_the_order_status() {
    // Write code here that turns the phrase above into concrete actions
}

@Given("Enter the releasing order request url")
public void enter_the_releasing_order_request_url() {
    // Write code here that turns the phrase above into concrete actions
}

@And("Enter the Order details")
public void enter_the_order_details() {
    // Write code here that turns the phrase above into concrete actions
}

@And("validate Release status")
public void validate_release_status() {
    // Write code here that turns the phrase above into concrete actions
}


}
