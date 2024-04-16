package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.DomainEndPoints;
import api.payload.Domain;
import io.restassured.response.Response;

public class DomainTests {
	Faker faker;
	Domain domainpayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		domainpayload = new Domain();

		domainpayload.setDomainName(faker.name().firstName());
	}

	@Test(priority = 1)
	public void testPostDomain() {
		Response response = DomainEndPoints.createDomain(domainpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testGetDomain() {
		Response response = DomainEndPoints.readDomain(this.domainpayload.getDomainName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
