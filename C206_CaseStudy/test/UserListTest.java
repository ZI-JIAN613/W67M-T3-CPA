import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserListTest {
	private User U1;
	private User U2;

	
	private ArrayList<User> UList;
	
	public UserListTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		U1 = new User(20019018, "Robin", "Student", "20019018@myrp.edu.sg", "123456");
		U2 = new User(20007386, "Aayush", "Student", "20007386@myrp.edu.sg", "234567");

		UList= new ArrayList<User>();
	}
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid User arraylist to add to", UList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		UserList.addS(UList, U1);		
		assertEquals("Test if that Userlist size is 1?", 1, UList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that User is added same as 1st item of the list?", U1, UList.get(0));
		
		//Add another item. test The size of the list is 2?
		UserList.addS(UList, U2);
		assertEquals("Test that User arraylist size is 2?", 2, UList.size());
	}
	@Test
	public void testRetrieveAllUser() {
		UList=new ArrayList<User>();
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		UserList.addS(UList, U1);
		UserList.addS(UList, U2);
	    assertNotNull("Test if there is user in the list to retrieve",UList);
	    //There should not be any duplication
	    assertNotEquals("Test there is not duplicate",UList.get(0),UList.get(1));
	    
	    //Ensure all the users have been displayed and not left any user that have display
	    UserList.URetrieveAll(UList);
	    assertSame("Test that all users in the list are display",UList.size(),2);
	  }
	@Test
	public void testDeleteUser() {
		UserList.addS(UList, U1);
		UserList.addS(UList, U2);
		// Item list is not null, so that can delete a item
		assertNotNull("Test if there is valid User arraylist to delete to", UList);
		
		//Given an full list, after deleting 1 item, the size of the list is 0
		UserList.removeU(UList, 20019018);		
		assertEquals("Test if that Userlist size is 1?", 1, UList.size());
		
		//Delete another user. test The size of the list is 0?
		UserList.removeU(UList, 20007386);
		assertEquals("Test that User arraylist size is 2?", 0, UList.size());
	}

}
