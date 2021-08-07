import java.util.ArrayList;

public class SubjectList {

	public static void Subject() {
		// TODO Auto-generated method stub

		Subject S1 = new Subject(1, "Engineering", "A multidisciplinary subject, combining natural and experimental sciences", 4);
		Subject S2 = new Subject(2, "Applied Science", "An area of study that utilizes existing scientific knowledge", 4);
		Subject S3 = new Subject(3, "Information Technology", "A working knowledge of computer concepts and essential skills", 4);
		
		ArrayList<Subject> SList = new ArrayList<Subject>();
		SList.add(S1);
		SList.add(S2);
		SList.add(S3);
		
		int option = -1;
		
		while(option != 4)
		{
			SubjectList.SMenu();
			option = Helper.readInt("Enter choice: ");
			
			if(option == 1)
			{
				String allS = SubjectList.SListToString(SList);
				System.out.println(allS);
			}
			else if(option == 2)
			{
				int SId = Helper.readInt("Enter Subject ID: ");
				String SName = Helper.readString("Enter Subject Name: ");
				String SDescription = Helper.readString("Enter subject's description: ");
				int SCredit = Helper.readInt("Enter Subject's credit: ");

				Subject newS = new Subject(SId, SName, SDescription, SCredit);

				boolean result = SubjectList.addS(SList,newS);

				if (result == true) {
					System.out.println("Subject added!");
				} else {
					System.out.println("Subject NOT added, you must include all details!");
				}
			}
			else if (option == 3) 
			{

				int deleteSID = Helper.readInt("Enter Subject ID: ");

				String acDetails = SubjectList.getSById(SList, deleteSID);

				if (!acDetails.isEmpty()) {
					System.out.println(acDetails);
					char toDelete = Helper.readChar("Do you wish to delete this Subject?(y/n) > ");

					if (toDelete == 'y') {
						boolean deleted = SubjectList.removeS(SList, deleteSID);

						if (deleted == true) {
							System.out.println(String.format("Subject id %d was deleted successfully.",
									deleteSID));
						} else {
							System.out.println("Something went wrong, Subject was not deleted.");
						}
					}

				} else {
					System.out.println("That Subject ID does not exist!");
				}
			}

		}
	}
	
	public static String SListToString(ArrayList<Subject> SList) {

		// Complete code here
		
		String output = String.format("%-3s %-30s %-80s %-20s\n", "ID", "SUBJECT","DESCRIPTION","CREDIT");
		
		for (int i = 0; i < SList.size(); i++) {
			Subject n = SList.get(i);
			
			output += String.format("%-3d %-30s %-80s %-20d\n", n.getSubjectId(),n.getSubjectName(), n.getSubDescription(), n.getSubCredit());
		}
		return output;
	}
	
	public static String SRetrieveAll(ArrayList<Subject> SList) {

		// Complete code here
		
		String output = "";
		
		for (int i = 0; i < SList.size(); i++) {
			Subject n = SList.get(i);
			
			output += String.format("%-3d %-30s %-80s %-20d\n", n.getSubjectId(),n.getSubjectName(), n.getSubDescription(), n.getSubCredit());
		}
		return output;
	}
	
	public static void SMenu() {

		Helper.line(30, "-");
		System.out.println("Subject");
		Helper.line(30, "-");

		System.out.println("1. View all Subjects");
		System.out.println("2. Add a new Subject");
		System.out.println("3. Remove a Subject");
		System.out.println("4. Quit");

	}
	
	public static boolean addS(ArrayList<Subject> SList, Subject S) {

		// Complete code here
		boolean isIdDup = false;
		for(int i = 0; i < SList.size(); i++)
		{
			if(SList.get(i).getSubjectId() == S.getSubjectId())
			{
				System.out.println("Sorry, a Subject with the same ID exists.");
				isIdDup = true;
				break;
			}			
		}
		
		if(isIdDup == true || S.getSubjectId() < 0 || S.getSubjectName().isEmpty() || S.getSubDescription().isEmpty() || S.getSubCredit() < 0 )
		{
			return false;
		}
		else
		{
			SList.add(S);
			return true;
		}
	}
	
	public static String getSById(ArrayList<Subject> SList, int SID) {

		String output = "";

		for (int i = 0; i < SList.size(); i++) {
			Subject n = SList.get(i);

			if (n.getSubjectId() == SID) {
				output = String.format("%-3s %-30s %-80s %-20s\n", "ID", "SUBJECT","DESCRIPTION","CREDIT");
				output += String.format("%-3d %-30s %-80s %-20d\n", n.getSubjectId(),n.getSubjectName(), n.getSubDescription(), n.getSubCredit());
				break;
			}
		}

		return output;
	}
	
	public static boolean removeS(ArrayList<Subject> SList, int SId) {

		// Complete code here
		boolean toDelete = false;
		for(int i = 0; i < SList.size();i++)
		{
			if(SList.get(i).getSubjectId() == SId)
			{
				SList.remove(i);
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
	
}