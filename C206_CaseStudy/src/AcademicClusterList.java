import java.util.ArrayList;

public class AcademicClusterList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AcademicCluster ac1 = new AcademicCluster(1,"Engineering","Aerospace Engineering, Aviation Management");
		AcademicCluster ac2 = new AcademicCluster(2,"Information Technology","Financial Technology, Business Information Systems, Infocomm Security Management");
		AcademicCluster ac3 = new AcademicCluster(3,"Applied Sciences","Applied Chemistry, Biomedical Science, Biotechnology");
		
		ArrayList<AcademicCluster> acList = new ArrayList<AcademicCluster>();
		acList.add(ac1);
		acList.add(ac2);
		acList.add(ac3);
		
		int option = -1;
		
		while(option != 4)
		{
			AcademicClusterList.acMenu();
			option = Helper.readInt("Enter choice: ");
			
			if(option == 1)
			{
				String allAC = AcademicClusterList.acListToString(acList);
				System.out.println(allAC);
			}
			else if(option == 2)
			{
				int acId = Helper.readInt("Enter Academic Cluster ID: ");
				String acName = Helper.readString("Enter Academic Cluster Name: ");
				int acNumSubject = Helper.readInt("Enter number of subjects in Academic Cluster: ");
				String acSubjects = "";
				for(int k = 0;k < acNumSubject;k++)
				{
					if(k < acNumSubject-1)
					{
						acSubjects += Helper.readString("Enter subject: ") + ", "; 
					}
					else
					{
						acSubjects += Helper.readString("Enter subject: "); 
					}
				}

				AcademicCluster newAC = new AcademicCluster(acId, acName, acSubjects);

				boolean result = AcademicClusterList.addAC(acList,newAC);

				if (result == true) {
					System.out.println("Academic Cluster added!");
				} else {
					System.out.println("Academic Cluster NOT added, you must include all details!");
				}
			}
			else if (option == 3) 
			{

				int deleteACID = Helper.readInt("Enter Academic Cluster ID: ");

				String acDetails = AcademicClusterList.getACById(acList, deleteACID);

				if (!acDetails.isEmpty()) {
					System.out.println(acDetails);
					char toDelete = Helper.readChar("Do you wish to delete this Academic Cluster?(y/n) > ");

					if (toDelete == 'y') {
						boolean deleted = AcademicClusterList.removeAC(acList, deleteACID);

						if (deleted == true) {
							System.out.println(String.format("Academic Cluster id %d was deleted successfully.",
									deleteACID));
						} else {
							System.out.println("Something went wrong, Academic Cluster was not deleted.");
						}
					}

				} else {
					System.out.println("That Academic Cluster ID does not exist!");
				}
			}

		}
	}
	
	public static String acListToString(ArrayList<AcademicCluster> acList) {

		// Complete code here
		
		String output = String.format("%-3s %-30s %-20s\n", "ID", "ACADEMIC CLUSTER NAME","SUBJECTS");
		
		for (int i = 0; i < acList.size(); i++) {
			AcademicCluster j = acList.get(i);
			
			output += String.format("%-3d %-30s %-20s\n", j.getId(),
						j.getName(), j.getSubjects());
		}
		return output;
	}
	
	public static String acRetrieveAll(ArrayList<AcademicCluster> acList) {

		// Complete code here
		
		String output = "";
		
		for (int i = 0; i < acList.size(); i++) {
			AcademicCluster j = acList.get(i);
			
			output += String.format("%-3d %-30s %-20s\n", j.getId(),
						j.getName(), j.getSubjects());
		}
		return output;
	}
	
	public static void acMenu() {

		Helper.line(30, "-");
		System.out.println("ACADEMIC CLUSTER");
		Helper.line(30, "-");

		System.out.println("1. View all Academic Clusters");
		System.out.println("2. Add a new Academic Cluster");
		System.out.println("3. Remove an Academic Cluster");
		System.out.println("4. Quit");

	}
	
	public static boolean addAC(ArrayList<AcademicCluster> acList, AcademicCluster ac) {

		// Complete code here
		boolean isIdDup = false;
		for(int i = 0; i < acList.size(); i++)
		{
			if(acList.get(i).getId() == ac.getId())
			{
				System.out.println("Sorry, a Academic Cluster with the same ID exists.");
				isIdDup = true;
				break;
			}			
		}
		
		if(isIdDup == true || ac.getId() < 0 || ac.getName().isEmpty() || ac.getSubjects().isEmpty())
		{
			return false;
		}
		else
		{
			acList.add(ac);
			return true;
		}
	}
	
	public static String getACById(ArrayList<AcademicCluster> acList, int acID) {

		String output = "";

		for (int i = 0; i < acList.size(); i++) {
			AcademicCluster s = acList.get(i);

			if (s.getId() == acID) {
				output = String.format("%-3s %-30s %-20s\n", "ID", "ACADEMIC CLUSTER NAME","SUBJECTS");
				output += String.format("%-3d %-30s %-20s\n", s.getId(),
						s.getName(), s.getSubjects());
				break;
			}
		}

		return output;
	}
	
	public static boolean removeAC(ArrayList<AcademicCluster> acList, int acId) {

		// Complete code here
		boolean toDelete = false;
		for(int i = 0; i < acList.size();i++)
		{
			if(acList.get(i).getId() == acId)
			{
				acList.remove(i);
				toDelete = true;
				break;
			}
			else
			{
				toDelete = false;
			}
		}
		return toDelete;
	}
	//test
}
