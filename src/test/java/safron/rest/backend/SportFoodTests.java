package safron.rest.backend;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.with;

@SpringBootTest
class SportFoodTests {

	static {
		RestAssured.baseURI = "http://localhost:8080";
	}

	private RequestSpecification spec =
			with()
					.baseUri("http://localhost:8080")
					.basePath("/");

	@Test
	@DisplayName("Get All Brands")
	void getAllBrandsTest() {
		String response = spec.get("brand/getAllBrands")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.asString();
		Assertions.assertEquals(response, "[\"Xtend\",\"Optimum Nutrition\",\"Universal Nutrition\",\"NOW\"]");
	}

	@Test
	@DisplayName("Get All Tastes")
	void getAllTastesTest() {
		String response = spec.get("brand/getAllTastes")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.asString();
		Assertions.assertEquals(response, "[[\"Mango\",\"Strawberry\",\"Vanilla\"]," +
				"[\"Chocolate\",\"Banana\",\"Vanilla\"]," +
				"[\"Vanilla\",\"Banana\"]," +
				"[\"Strawberry\",\"Vanilla\"]]");
	}

	@Test
	@DisplayName("Get All Tastes Of One Brand")
	void getAllTastesOfOneBrand() {
		String response = spec.get("brand/getAllTastesOfOneBrand")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.asString();
		Assertions.assertEquals(response, "[\"Chocolate\",\"Banana\",\"Vanilla\"]");
	}

}
