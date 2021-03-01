package tspSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {
	private List<City> tour = new ArrayList<>();
	private double distance = 0;

	SingleTour(List<City> city) {
		List<City> currentCity = new ArrayList<>();
		for (int i = 0; i < Respository.getNumberOfCitites(); i++)
			currentCity.add(null);
		for (int i = 0; i < city.size(); i++)
			currentCity.set(i, city.get(i));
		this.tour = currentCity;

	}

	SingleTour() {
		List<City> currentCity = new ArrayList<>();
		for (int i = 0; i < Respository.getNumberOfCitites(); i++)
			currentCity.add(null);
		this.tour = currentCity;
	}

	public double getDistance() {
		if (distance == 0) {
			for (int i = 0; i < tour.size(); i++) {
				if (i == tour.size() - 1) {
					distance += tour.get(i).distanceTo(tour.get(0));
				} else {
					distance += tour.get(i).distanceTo(tour.get(i + 1));
				}
			}
		}
		return distance;
	}

	public List<City> getTour() {
		return this.tour;
	}

	public void swapTourCities(int idx1, int idx2) {
		City c1 = tour.get(idx1);
		tour.set(idx1, tour.get(idx2));
		tour.set(idx2, c1);
	}

	public void swapRandomCities() {
		int idx1 = (int) (Math.random() * tour.size());
		int idx2 = (int) (Math.random() * tour.size());
		City c1 = tour.get(idx1);
		tour.set(idx1, tour.get(idx2));
		tour.set(idx2, c1);
	}

	public void generateIndividual() {
		for (int i = 0; i < Respository.getNumberOfCitites(); i++) {
			setCity(i, Respository.getCity(i));
		}
		Collections.shuffle(tour);

	}

	public City getCity(int idx) {
		return tour.get(idx);
	}

	public int getSize() {
		return tour.size();
	}

	private void setCity(int i, City city) {
		// TODO Auto-generated method stub
		this.tour.set(i, city);
		distance = 0;

	}

	@Override
	public String toString() {
		String str = "Total Distance: " + getDistance() + "\n";
		for (City cc : tour) {
			str += cc + " -> ";
		}
		// TODO Auto-generated method stub
		return str;
	}
}
