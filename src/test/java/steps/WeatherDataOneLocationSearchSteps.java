package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.is;

public class WeatherDataOneLocationSearchSteps {
	
	private String appid="appid=6973c6c5b93f6ad690e9942aa6d59c8a";

	private String CITY_NAME_SEARCH = "http://api.openweathermap.org/data/2.5/weather?q=London&";
	private String CITYNAME_ISOCODE_SEARCH = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&";
	private String CITY_ID_SEARCH = "http://api.openweathermap.org/data/2.5/weather?id=2172797&";
	private String GEOGRAPHIC_COORDINATES_SEARCH = "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&";
	private String ZIP_CODE_SEARCH = "http://api.openweathermap.org/data/2.5/weather?zip=94040,us&";
	
	private Response response;

	@Step
	public void searchCityByName() {
		response = SerenityRest.when().get(CITY_NAME_SEARCH + appid);

	}

	@Step
	public void iShouldFindCityName(String cityName) {

		response.then().body("name", is(cityName));

	}

	@Step
	public void searchCityByNameAndCountryCode() {
		response = SerenityRest.when().get(CITYNAME_ISOCODE_SEARCH + appid);

	}

	@Step
	public void searchCityByID() {
		response = SerenityRest.when().get(CITY_ID_SEARCH + appid);
	}

	@Step
	public void iShouldFindCityID(int cityId) {
		response.then().body("id", is(cityId));

	}

	@Step
	public void searchGeographicCcoordinates() {

		response = SerenityRest.when().get(GEOGRAPHIC_COORDINATES_SEARCH + appid);
	}

	@Step
	public void searchByZIPCode() {

		response = SerenityRest.when().get(ZIP_CODE_SEARCH + appid);
	}

	// To verify the status code and print json response in console.
	@Step
	public void searchIsExecutedSuccesfully() {
		response.then().statusCode(200).log().all();
	}

}


