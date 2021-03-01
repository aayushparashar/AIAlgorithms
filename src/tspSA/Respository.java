package tspSA;

import java.util.ArrayList;
import java.util.List;

public class Respository {
	private static List<City> cities = new ArrayList<>();

	public static City getCity(int index) {
		return cities.get(index);
	}

	public static void addCity(City city) {
		Respository.cities.add(city);
	}

	public static int getNumberOfCitites() {
		return cities.size();
	}

}
