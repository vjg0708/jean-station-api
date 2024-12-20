package com.example.app_jeanstation.StepDefinition;

import static org.hamcrest.CoreMatchers.equalTo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.Writer;

public class JeanStationSD {

    private Response response;
    private static RequestSpecification baseRequest;
    private RequestSpecification postRequest;
    private RequestSpecification getRequest;
    private RequestSpecification putRequest;
    private RequestSpecification patchRequest;
    private RequestSpecification deleteRequest;



    @Before
    public static void before_or_after_all() {

        RestAssured.baseURI = "http://localhost:8000/api/jean-station";
        baseRequest = RestAssured.given();


    }


    @Given("Enter the post request url")
    public void enter_the_post_request_url() {
        postRequest = baseRequest.request();

    }

    @And("Enter the product details")
    public void enter_the_product_details() {
        JSONObject object = new JSONObject();
        object.put("id", 1);
        object.put("productName", "Powder");
        object.put("productPrice", 322.0);
        object.put("productStock", 50);
        object.put("productCode", "PC101");

        postRequest.contentType(ContentType.JSON)
                .body(object.toJSONString()).log().all();
    }

    @When("Post the product details")
    public void post_the_product_details() {
        response = postRequest.post("/addProduct");
        //SharedContext.productid = response.jsonPath().getLong("id");
    }

    @And("Validate the product name")
    public void validate_the_product_name() {

        response.then().body("productName", equalTo("Powder")).log().all();

    }

    @And("Validate the product price")
    public void validate_the_product_price() {

        response.then().body("productPrice", equalTo(322.0F)).log().all();

    }

    @Given("Enter the get request url")
    public void enter_the_get_request_url() {
        getRequest = baseRequest.request();

    }

    @When("Get the product details")
    public void get_the_product_details() {

        response = getRequest.get("/getProduct/1");
    }

    @And("Validate the Status code")
    public void validate_the_status_code() {

        response.then().statusCode(200).log().all();

    }

    @Given("Enter the put request url")
    public void enter_the_put_request_url() {
        putRequest = baseRequest.request();

    }

    @And("Enter Updated product details")
    public void enter_updated_product_details() {
        JSONObject object = new JSONObject();
        object.put("id", 1);
        object.put("productName", "Table");
        object.put("productPrice", 3225.0);
        object.put("productStock", 10);
        object.put("productCode", "PC101");

        putRequest.contentType(ContentType.JSON)
                .body(object.toJSONString()).log().all();
    }

    @When("Put the product details")
    public void put_the_product_details() {
        response = putRequest.put("/updateProduct/1");

        response.then().body("productCode", equalTo("PC101"))
                .body("productStock", equalTo(10))
                .body("productName", equalTo("Table"))
                .body("productPrice", equalTo(3225.0F)).log().all();

    }

    @Given("Enter the patch request url")
    public void enter_the_patch_request_url() {
        patchRequest = baseRequest.request();

    }

    @When("Patch the product details")
    public void patch_the_product_details() {
        JSONObject object = new JSONObject();
        object.put("productStock", 50);

        patchRequest.contentType(ContentType.JSON).body(object.toJSONString());
        response = patchRequest.patch("/updateProductStock/1");

        response.then().body("productStock", equalTo(50)).log().all();

    }


    @Given("Enter the delete request url")
    public void enter_the_delete_request_url() {
        deleteRequest = baseRequest.request();

    }

    @When("Delete the product details")
    public void delete_the_product_details() throws IOException {
        response = deleteRequest.delete("/deleteProduct/1");
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body :"+responseBody);


        response.then().body(equalTo("Entity Deleted"))
                .log().all();

    }

    @Given("Enter the placing order request url")
    public void enter_the_placing_order_request_url() {
        postRequest = baseRequest.request();

    }

    @And("Enter the desired product details")
    public void enter_the_desired_product_details() {
        JSONObject object = new JSONObject();
        object.put("orderId", 1);
        object.put("productCode", "PC101");
        object.put("quantity", 10);
        object.put("status", "PENDING");
        postRequest.contentType(ContentType.JSON).body(object.toJSONString()).log().all();
        response = postRequest.post("/placeorder");
    }

    @And("validate the Order Status")
    public void validateTheOrderStatus() {

        response.then()
                .statusCode(200)
                .body("status", equalTo("PLACED"))
                .body("product.productCode", equalTo("PC101"))
                .body("quantity", equalTo(10)).log().all();

    }

    @Given("Enter the releasing order request url")
    public void enter_the_releasing_order_request_url() {
        putRequest = baseRequest.request();
    }

    @And("Enter the Order details")
    public void enter_the_order_details() {
        JSONObject object = new JSONObject();
        object.put("orderId", 1);
        putRequest.contentType("application/json").body(object.toJSONString());
        response = putRequest.put("/release/1");
    }

    @And("validate Release status")
    public void validateReleaseStatus() {

        response.then()
                .statusCode(200)
                .body("status", equalTo("RELEASED")).log().all();

    }

    @Given("Enter the delete order request url")
    public void enter_the_delete_order_request_url() {
        deleteRequest = baseRequest.request();

    }

    @And("Validate the order deletion")
    public void validate_the_order_deletion() {
        response = deleteRequest.delete("/deleteorder/1");

        response.then()
                .statusCode(200)
                .body("status", equalTo("REMOVED")).log().all();

    }


}
