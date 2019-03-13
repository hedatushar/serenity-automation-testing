package steps;

import static org.hamcrest.Matchers.is;
import java.util.List;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherDataSeveralLocationSearchSteps {
	
	private String appid="appid=6973c6c5b93f6ad690e9942aa6d59c8a";

	private String RECTANGLE_ZONE_SEARCH = "http://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&";
	private String CITIES_CYCLE_SEARCH = "http://api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&";
	private String SEVERAL_CITY_IdS_SEARCH = "http://api.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric&";
	
	private Response response;

	@Step
	public void searchRectangleZone() {
		response = SerenityRest.when().get(RECTANGLE_ZONE_SEARCH + appid);

	}

	@Step
	public void iShouldFindCitiesWithinRectangleZoneCount(Integer count) {
		response.then().body("cnt", is(count));

	}

	@Step
	public void searchCitiesInCycle() {
		response = SerenityRest.when().get(CITIES_CYCLE_SEARCH + appid);

	}

	@Step
	public void iShouldFindCitiesInCircle(List<String> cityList) {

		response.then().body("list.name", is(cityList));

	}

	@Step
	public void searchSeveralCityIds() {
		response = SerenityRest.when().get(SEVERAL_CITY_IdS_SEARCH + appid);
	}

	@Step
	public void iShouldFindSeveralCityIds(String id) {

		response.then().body("id", is(id));
	}

	@Step
	public void iShouldFindCityId(List<Integer> cityId) {
		response.then().body("list.id", is(cityId));

	}

	// To verify the status code and print json response in console.
	@Step
	public void searchIsExecutedSuccesfully() {
		response.then().statusCode(200).log().all();

	}
}
