import java.util.ArrayList;

public class CareerInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;
		CareerInfo career1 = new CareerInfo(1, "Web Designer", "Information Technology", 1);
		CareerInfo career2 = new CareerInfo(2, "Software Tester", "Information Technology", 2);
		CareerInfo career3 = new CareerInfo(3, "Game Programmer", "Information Technology", 3);
		ArrayList<CareerInfo> careerList = new ArrayList<CareerInfo>();
		careerList.add(career1);
		careerList.add(career2);
		careerList.add(career3);
		while (option != 7) {
			CareerInfoMain.staffMenu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				String allCareers = CareerInfo.careerListToString(careerList);
				System.out.println(allCareers);
				System.out.println("Total number of careers: " + CareerInfo.getNumCareers(careerList));

			} else if (option == 2) {
				int careerId = Helper.readInt("Enter career ID > ");
				String careerName = Helper.readString("Enter career name > ");
				String careerCategory = Helper.readString("Enter career category > ");
				int clusterId = Helper.readInt("Enter Cluster ID > ");
				CareerInfo newSchedule = new CareerInfo(careerId, careerName, careerCategory, clusterId);
				boolean result = CareerInfo.addCareer(careerList, newSchedule);
				if (result == true) {
					System.out.println("Career information added!");
				} else {
					System.out.println("Career information NOT added, you must include all details!");
				}

			} else if (option == 3) {
				int editCareerID = Helper.readInt("Enter Career ID > ");
				String careerdetails = CareerInfo.getCareerById(careerList, editCareerID);
				if (!careerdetails.isEmpty()) {
					System.out.println(careerdetails);
					String careerNameUpdate = Helper.readString("Enter new career name > ");
					boolean isEdited = CareerInfo.editCareer(careerList, editCareerID, careerNameUpdate);
					if (isEdited) {
						careerdetails = CareerInfo.getCareerById(careerList, editCareerID);
						System.out
								.println(String.format("Career name %d updated to %s", editCareerID, careerNameUpdate));
						System.out.println(careerdetails);
					} else {
						System.out.println("The status you entered is invalid.");
					}
				} else {
					System.out.println("That Career ID does not exist!");
				}

			} else if (option == 4) {

				int deleteCareerID = Helper.readInt("Enter Career ID > ");

				String careerdetails = CareerInfo.getCareerById(careerList, deleteCareerID);

				if (!careerdetails.isEmpty()) {
					System.out.println(careerdetails);
					char toDelete = Helper.readChar("Do you wish to delete this career information?(y/n) > ");

					if (toDelete == 'y') {
						boolean deleted = CareerInfo.removeCareer(careerList, deleteCareerID);

						if (deleted == true) {
							System.out.println(String.format("Career id %d was deleted successfully.", deleteCareerID));
						} else {
							System.out.println("Something went wrong, career information was not deleted.");
						}
					}
				} else {
					System.out.println("That Career ID does not exist!");
				}

			} else {
				System.out.println("Invalid choice");
			}
		}
	}

	public static void staffMenu() {

		Helper.line(30, "-");
		System.out.println("Career information options");
		Helper.line(30, "-");

		System.out.println("1. View all career information");
		System.out.println("2. Add a new career information");
		System.out.println("3. Update a career information");
		System.out.println("4. Remove a career information");

	}

}
