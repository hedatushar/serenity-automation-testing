package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import steps.WeatherDataSeveralLocationSearchSteps;

@RunWith(SerenityRunner.class)
public class WeatherDataSeveralLocationSearchTests {
	

	@Steps
	WeatherDataSeveralLocationSearchSteps weatherDataSearchSteps;

	@Test
	public void verifyThatWeCanFindCitiesWithinRectangleZone() {
		weatherDataSearchSteps.searchRectangleZone();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();
		weatherDataSearchSteps.iShouldFindCitiesWithinRectangleZoneCount(15);

	}

	@Test
	public void verifyThatWeCanFindCitiesInCycle() {
		weatherDataSearchSteps.searchCitiesInCycle();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();

		List<String> citiesList = new ArrayList<String>();
		String[] citiesArrayList = { "Shcherbinka", "Dubrovitsy", "Butovo", "Kommunarka", "Lesparkkhoz",
				"Sed’moy Mikrorayon", "Vlas’yevo", "Bachurino", "Shestoy Mikrorayon", "Podolsk" };
		citiesList = Arrays.asList(citiesArrayList);

		weatherDataSearchSteps.iShouldFindCitiesInCircle(citiesList);
	}

	@Test
	public void verifyThatWeCanCallSeveralCityIds() {
		weatherDataSearchSteps.searchSeveralCityIds();
		weatherDataSearchSteps.searchIsExecutedSuccesfully();

		List<Integer> cityId = new ArrayList<Integer>();
		Integer[] citiesArrayList = { 524901, 703448, 2643743 };
		cityId = Arrays.asList(citiesArrayList);

		weatherDataSearchSteps.iShouldFindCityId(cityId);

	}

}
