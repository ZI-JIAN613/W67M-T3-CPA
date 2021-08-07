import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Chu Yun Keat
 * Student ID: 20047518
 * Class: E37C
 * Date/Time created: Wednesday 04-08-2021 09:48
 */

public class CareerInfo {

	private int careerId;
	private String careerName;
	private String careerCategory;
	private int clusterId;

	/**
	 * @param careerId
	 * @param careerName
	 * @param careerCategory
	 * @param clusterId
	 */
	public CareerInfo(int careerId, String careerName, String careerCategory, int clusterId) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.careerCategory = careerCategory;
		this.clusterId = clusterId;
	}

	/**
	 * @return the careerId
	 */
	public int getCareerId() {
		return careerId;
	}

	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}

	/**
	 * @return the careerName
	 */
	public String getCareerName() {
		return careerName;
	}

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	/**
	 * @return the careerCategory
	 */
	public String getcareerCategory() {
		return careerCategory;
	}

	public void setcareerCategory(String careerCategory) {
		this.careerCategory = careerCategory;
	}

	/**
	 * @return the clusterId
	 */
	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

	@Override
	public String toString() {
		return "CareerInfo [careerId=" + careerId + ", careerName=" + careerName + ", careerCategory="
				+ careerCategory + ", clusterId=" + clusterId + "]";
	}

	public static int getNumCareers(ArrayList<CareerInfo> careerList) {

		return careerList.size();

	}

	public static String getCareerById(ArrayList<CareerInfo> careerList, int flightScheduleId) {

		String output = "";

		for (int i = 0; i < careerList.size(); i++) {
			CareerInfo s = careerList.get(i);

			if (s.getCareerId() == flightScheduleId) {
				output += String.format("%-10s %-20s %-30s %-15s\n", "CAREER ID", "CAREER NAME",
						"CAREER CATEGORY", "CLUSTER ID");
				output += String.format("%-10s %-20s %-30s %-15s\n", s.getCareerId(),
						s.getCareerName(), s.getcareerCategory(), s.getClusterId());
				break;
			}
		}

		return output;
	}

	public static String careerListToString(ArrayList<CareerInfo> careerList) {
		String output = "";
		output += String.format("%-10s %-20s %-30s %-15s\n", "CAREER ID", "CAREER NAME",
				"CAREER CATEGORY", "CLUSTER ID");
		for (int i = 0; i < careerList.size(); i++) {
			CareerInfo s = careerList.get(i);
			output += String.format("%-10d %-20s %-30s %-15s\n", s.getCareerId(), s.getCareerName(),
					s.getcareerCategory(), s.getClusterId());
		}
		return output;

	}

	public static boolean addCareer(ArrayList<CareerInfo> careerList, CareerInfo career) {
		boolean r = false;
		if (career.getCareerName().isEmpty() == true || career.getcareerCategory().isEmpty() == true) {
			r = false;

		} else {
			r = true;
			careerList.add(career);
		}
		return r;
	}

	public static boolean editCareer(ArrayList<CareerInfo> careerList, int careerId, String newStatus) {

		for (int i = 0; i < careerList.size(); i++) {
			CareerInfo s = careerList.get(i);
			if (s.getCareerId() == careerId) {
				s.setCareerName(newStatus);
				break;
			}
		}
		return true;

	}

	public static boolean removeCareer(ArrayList<CareerInfo> careerList, int careerId) {
		boolean a = false;
		for (int i = 0; i < careerList.size(); i++) {
			CareerInfo s = careerList.get(i);
			if (s.getCareerId() == careerId) {
				careerList.remove(i);
				a = true;
				break;
			}
		}
		return a;
	}


}
