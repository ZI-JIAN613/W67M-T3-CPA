import java.util.ArrayList;
/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Aayush
 * Student ID: 20007386
 * Class: E73E
 * Date/Time created: Monday 02-08-2021 10:45
 */
public class UserList {

	public static void User() {
		// TODO Auto-generated method stub
		User U1 = new User(20019018, "Robin", "Student", "20019018@myrp.edu.sg", "123456");
		User U2 = new User(20007386, "Aayush", "Student", "20007386@myrp.edu.sg", "234567");
		User U3 = new User(20025988, "Zi Jian", "Student", "20025988@myrp.edu.sg", "345678");
		User U4 = new User(20047518, "Yun Keat", "Student", "20047518@myrp.edu.sg", "456789");
		
		ArrayList<User> UList = new ArrayList<User>();
		UList.add(U1);
		UList.add(U2);
		UList.add(U3);
		UList.add(U4);
		
		int option = -1; 
		   
		  while(option != 4) 
		  { 
			  UserList.UMenu(); 
		   option = Helper.readInt("Enter choice: "); 
		    
		   if(option == 1) 
		   { 
		    String allS = UserList.UListToString(UList); 
		    System.out.println(allS); 
		   } 
		   else if(option == 2) 
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
		   else if (option == 3)  
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
		  
		}