import java.util.ArrayList;

/* START: DO NOT change this part of the code */
public class C206_CaseStudy {

	public static void main(String[] args) {
		User U1 = new User(20019018, "Robin", "Student", "20019018@myrp.edu.sg", "123456");
		User U2 = new User(20007386, "Aayush", "Student", "20007386@myrp.edu.sg", "234567");
		User U3 = new User(20025988, "Zi Jian", "Student", "20025988@myrp.edu.sg", "345678");
		User U4 = new User(20047518, "Yun Keat", "Student", "20047518@myrp.edu.sg", "456789");
		
		ArrayList<User> UList = new ArrayList<User>();
		UList.add(U1);
		UList.add(U2);
		UList.add(U3);
		UList.add(U4);
		
		AcademicCluster ac1 = new AcademicCluster(1,"Engineering","Aerospace Engineering, Aviation Management");
		AcademicCluster ac2 = new AcademicCluster(2,"Information Technology","Financial Technology, Business Information Systems, Infocomm Security Management");
		AcademicCluster ac3 = new AcademicCluster(3,"Applied Sciences","Applied Chemistry, Biomedical Science, Biotechnology");
		
		ArrayList<AcademicCluster> acList = new ArrayList<AcademicCluster>();
		acList.add(ac1);
		acList.add(ac2);
		acList.add(ac3);
		
		CareerInfo career1 = new CareerInfo(1, "Web Designer", "Information Technology", 1);
		CareerInfo career2 = new CareerInfo(2, "Software Tester", "Information Technology", 2);
		CareerInfo career3 = new CareerInfo(3, "Game Programmer", "Information Technology", 3);
		ArrayList<CareerInfo> careerList = new ArrayList<CareerInfo>();
		careerList.add(career1);
		careerList.add(career2);
		careerList.add(career3);
		
		Subject S1 = new Subject(1, "Engineering", "A multidisciplinary subject, combining natural and experimental sciences", 4);
		Subject S2 = new Subject(2, "Applied Science", "An area of study that utilizes existing scientific knowledge", 4);
		Subject S3 = new Subject(3, "Information Technology", "A working knowledge of computer concepts and essential skills", 4);
		
		ArrayList<Subject> SList = new ArrayList<Subject>();
		SList.add(S1);
		SList.add(S2);
		SList.add(S3);
		
		ArrayList<PrerequisiteInfo> priList = new ArrayList<PrerequisiteInfo>();//Neo Wen Zong
		
		priList.add(new PrerequisiteInfo("Arts, Audio/Video Technology, and Communications"));//Neo Wen Zong
		
		int option = -1;
		while(option != 6)
		{
			C206_CaseStudy.Menu();
			option = Helper.readInt("Enter choice: ");
			if(option == 1)
			{
				int optionU = -1; 
				   
				  while(optionU != 4) 
				  { 
					  UserList.UMenu(); 
					  optionU = Helper.readInt("Enter choice: "); 
				    
				   if(optionU == 1) 
				   { 
				    String allS = UserList.UListToString(UList); 
				    System.out.println(allS); 
				   } 
				   else if(optionU == 2) 
				   { 
				    int UId = Helper.readInt("Enter User ID: "); 
				    String UName = Helper.readString("Enter User Name: "); 
				    String URoles = Helper.readString("Enter role: ");
				    String UEmail = Helper.readString("Enter Email: ");
				    String password = Helper.readString("Enter password: "); 
				 
				    User newS = new User(UId, UName, URoles, UEmail, password); 
				 
				    boolean result = UserList.addS(UList,newS); 
				 
				    if (result == true) { 
				     System.out.println("User added!"); 
				    } else {
				     System.out.println("User NOT added, you must include all details!"); 
				    } 
				   } 
				   else if (optionU == 3)  
				   { 
				 
				    int deleteUID = Helper.readInt("Enter User ID: "); 
				 
				    String acDetails = UserList.getUById(UList, deleteUID); 
				 
				    if (!acDetails.isEmpty()) { 
				     System.out.println(acDetails); 
				     char toDelete = Helper.readChar("Do you wish to delete this User?(y/n) > "); 
				 
				     if (toDelete == 'y') { 
				      boolean deleted = UserList.removeU(UList, deleteUID); 
				 
				      if (deleted == true) { 
				       System.out.println(String.format("User id %d was deleted successfully.", 
				         deleteUID)); 
				      } else { 
				       System.out.println("Something went wrong, User was not deleted."); 
				      } 
				     } 
				 
				    } else { 
				     System.out.println("That User ID does not exist!"); 
				    } 
				   } 
				 
				  }
			}
			else if(option == 2)
			{
				int optionA = -1;
				
				while(optionA != 4)
				{
					AcademicClusterList.acMenu();
					optionA = Helper.readInt("Enter choice: ");
					
					if(optionA == 1)
					{
						String allAC = AcademicClusterList.acListToString(acList);
						System.out.println(allAC);
					}
					else if(optionA == 2)
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
					else if (optionA == 3) 
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
			else if(option == 3)
			{
				int optionC = -1;

				while (optionC != 5) {
					CareerInfoMain.staffMenu();
					optionC = Helper.readInt("Enter choice > ");
					if (optionC == 1) {
						String allCareers = CareerInfo.careerListToString(careerList);
						System.out.println(allCareers);
						System.out.println("Total number of careers: " + CareerInfo.getNumCareers(careerList));

					} else if (optionC == 2) {
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

					} else if (optionC == 3) {
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

					} else if (optionC == 4) {

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

					}
				}
			}
			else if(option == 4)
			{
				int optionS = -1;
				
				while(optionS != 4)
				{
					SubjectList.SMenu();
					optionS = Helper.readInt("Enter choice: ");
					
					if(optionS == 1)
					{
						String allS = SubjectList.SListToString(SList);
						System.out.println(allS);
					}
					else if(optionS == 2)
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
					else if (optionS == 3) 
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

		}
	}

public static void Menu() {

	Helper.line(30, "-");
	System.out.println("Career Planning Application");
	Helper.line(30, "-");

	System.out.println("1. User");
	System.out.println("2. Academic Clusters");
	System.out.println("3. Career Information");
	System.out.println("4. Subject");
	System.out.println("5. Prerequisites ");
	System.out.println("6. Quit ");
}
public static String UListToString(ArrayList<User> UList) { 
	 
	  // Complete code here 
	   
	  String output = String.format("%-20s %-20s %-20s %-30s %-20s\n", "ID", "NAME","ROLE","EMAIL", "PASSWORD"); 
	   
	  for (int i = 0; i < UList.size(); i++) { 
	   User n = UList.get(i); 
	    
	   output += String.format("%-20d %-20s %-20s %-30s %-20s\n", n.getUserid(),n.getName(), n.getRole(), n.getEmail(), n.getPassword()); 
	  } 
	  return output; 
	 } 
	  
	 public static String URetrieveAll(ArrayList<User> UList) { 
	 
	  // Complete code here 
	   
	  String output = ""; 
	   
	  for (int i = 0; i < UList.size(); i++) { 
	   User n = UList.get(i); 
	    
	   output += String.format("%-20d %-20s %-20s %-30s %-20s\n", n.getUserid(),n.getName(), n.getRole(), n.getEmail(), n.getPassword()); 
	  } 
	  return output; 
	 } 
	  
	 public static void UMenu() { 
	 
	  Helper.line(30, "-"); 
	  System.out.println("User"); 
	  Helper.line(30, "-"); 
	 
	  System.out.println("1. View all Users"); 
	  System.out.println("2. Add a new User"); 
	  System.out.println("3. Remove a User"); 
	  System.out.println("4. Quit"); 
	 
	 } 
	  
	 public static boolean addS(ArrayList<User> UList, User U) { 
	 
	  // Complete code here 
	  boolean isIdDup = false; 
	  for(int i = 0; i < UList.size(); i++) 
	  { 
	   if(UList.get(i).getUserid() == U.getUserid()) 
	   { 
	    System.out.println("Sorry, a User with the same ID exists."); 
	    isIdDup = true; 
	    break; 
	   }    
	  } 
	   
	  if(isIdDup == true || U.getUserid() < 0 || U.getName().isEmpty() || U.getRole().isEmpty() || U.getEmail().isEmpty()
			 || U.getPassword().isEmpty()) 
	  { 
	   return false; 
	  } 
	  else 
	  { 
	   UList.add(U); 
	   return true; 
	  } 
	 } 
	  
	 public static String getUById(ArrayList<User> UList, int SID) { 
	 
	  String output = ""; 
	 
	  for (int i = 0; i < UList.size(); i++) { 
	   User n = UList.get(i); 
	 
	   if (n.getUserid() == SID) { 
	    output =String.format("%-20s %-20s %-20s %-30s %-20s\n", "ID", "NAME","ROLE","EMAIL", "PASSWORD"); 
	    output += String.format("%-20d %-20s %-20s %-30s %-20s\n", n.getUserid(),n.getName(), n.getRole(), n.getEmail(), n.getPassword()); 
		 
	    break; 
	   } 
	  } 
	 
	  return output; 
	 } 
	  
	 public static boolean removeU(ArrayList<User> UList, int UId) { 
	 
	  // Complete code here 
	  boolean toDelete = false; 
	  for(int i = 0; i < UList.size();i++) 
	  { 
	   if(UList.get(i).getUserid() == UId) 
	   { 
	    UList.remove(i); 
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
		public static void staffMenu() {

			Helper.line(30, "-");
			System.out.println("Career information options");
			Helper.line(30, "-");

			System.out.println("1. View all career information");
			System.out.println("2. Add a new career information");
			System.out.println("3. Update a career information");
			System.out.println("4. Remove a career information");
			System.out.println("5. Quit");

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

		public static void prerequisiteInfoMenu(ArrayList<PrerequisiteInfo> priList, ArrayList<Subject> subjectList) { //Neo Wen Zong
			
			int opt = 0;

			while (opt != 6) {

				System.out.println("-------------------------------PrerequisiteInfoMenu-------------------------------");
			    System.out.println("1. View all Prerequisite Info");
			    System.out.println("2. Add a Prerequisite");
			    System.out.println("3. Delete a Prequisite Info");
			    System.out.println("4. Update a Pathway Info");

			    opt = Helper.readInt("Enter an option: ");
	
			    if (opt == 1) {
			    	viewAllPrerequisiteInfo(priList, subjectList);
			    }
	
			    else if (opt == 2) {
			    	addPrerequisite(priList);
			    }
	
			    else if (opt == 3) {
			    	deleteAPrerequisiteInfo(priList);
			    }
			    
			    else if (opt == 4) {
			    	updatePathwayInfo(priList);
			    }
			    
			    else if (opt == 6) {
			    	System.out.println("Bye");
			    }

		    	else {
		    		System.out.println("Invalid option");
		    	}
			}

		}

		public static void addPrerequisite(ArrayList<PrerequisiteInfo> priList) {
		    String job = Helper.readString("Enter a academic cluster: ");
		    int count = 0;
		    
		    for (int i = 0; i < priList.size(); i++) {
		    	if (job.equalsIgnoreCase(priList.get(i).getPrerequisiteInfoName().toLowerCase())) {//Neo Wen Zong
		    		count ++;
		    	}
		    }
		    
		    if (count >= 1) {
		    	System.out.println("Academic cluster already exist.");
		    } else {
		    	priList.add(new PrerequisiteInfo(job));

		    	System.out.println("Prerequisite added");
		    }
		}

		public static void viewAllPrerequisiteInfo(ArrayList<PrerequisiteInfo> priList, ArrayList<Subject> subjectList) {//Neo Wen Zong
		    String out = String.format("%-3s, %-10s %s", "No.", "Subject", "Academic cluster");

		    for (int i = 0; i < priList.size(); i ++) {
		        out += String.format("%-3s, %-10s %s", i + 1, subjectList.get(0), priList.get(i).getPrerequisiteInfoName());
		    }
		    System.out.println(out);
		}

		public static void deleteAPrerequisiteInfo(ArrayList<PrerequisiteInfo> priList) {//Neo Wen Zong
			String job = Helper.readString("Enter a academic cluster: ");
			int count = 0;
			
			for (int i = 0; i < priList.size(); i ++) {
				count ++;
				if (job.equalsIgnoreCase(priList.get(i).getPrerequisiteInfoName().toLowerCase())) {
					priList.remove(i);
					System.out.println("Successfully deleted");
				} else if (count == priList.size()) {
					System.out.println("No such academic cluster");
				}
			}
		}
		
		public static void updatePathwayInfo(ArrayList<PrerequisiteInfo> priList) { //Neo Wen Zong
			String job = Helper.readString("Enter a academic cluster: ");
			int count = 0;
			
			for (int i = 0; i < priList.size(); i ++) {
				count ++;
				if (job.equalsIgnoreCase(priList.get(i).getPrerequisiteInfoName().toLowerCase())) {
					priList.get(i).setPrerequisiteInfoName(job);
					System.out.println("Successfully Updated");
				} else if (count == priList.size()) {
					System.out.println("No such academic cluster");
				}
			}
		}
		
		
		
		
}

