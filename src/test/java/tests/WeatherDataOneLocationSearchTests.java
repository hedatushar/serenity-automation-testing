package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Steps;
import steps.WeatherDataOneLocationSearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)
public class WeatherDataOneLocationSearchTests {
	@Steps
	WeatherDataOneLocationSearchSteps weatherDataSearchSteps;

	@Test
	public void verifyThatWeCanFindLondonByCityName() {
		weatherDataSearchSteps.searchCityByName();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCityName("London");
	}

	@Test
	public void verifyThatWeCanFindLondonByCityNameAndCountryCode() {
		weatherDataSearchSteps.searchCityByNameAndCountryCode();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCityName("London");
	}

	@Test
	public void verifyThatWeCanFindBycityID() {
		weatherDataSearchSteps.searchCityByID();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCityID(2172797);

	}

	@Test
	public void verifyThatWeCanFindByGeographicCoordinates() {
		weatherDataSearchSteps.searchGeographicCcoordinates();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCityName("Shuzenji");
	}

	@Test
	public void verifyThatWeCanFindByZIPCode() {
		weatherDataSearchSteps.searchByZIPCode();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCityName("Mountain View");
	}
}
