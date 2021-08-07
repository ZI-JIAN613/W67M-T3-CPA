import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubjectTest {
	
	private Subject S1;
	private Subject S2;
	
	private ArrayList<Subject> SList;
	
	public SubjectTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		S1 = new Subject(1, "Engineering", "A multidisciplinary subject, combining natural and experimental sciences", 4);
		S2 = new Subject(2, "Applied Science", "An area of study that utilizes existing scientific knowledge", 4);
		
		
		SList = new ArrayList<Subject>();
	}

	
	@Test
	  public void testAddSubject() {
	    // Item list is not null, so that can add a new item
	    assertNotNull("Test if there is valid Subject arraylist to add to", SList);
	    
	    //Given an empty list, after adding 1 item, the size of the list is 1
	    SubjectList.addS(SList, S1);     
	    assertEquals("Test if that SList size is 1?", 1, SList.size());
	    
	    //The item just added is as same as the first item of the list
	    assertSame("Test that Subject is added same as 1st item of the list?", S1, SList.get(0));
	    
	    //Add another item. test The size of the list is 2?
	    SubjectList.addS(SList, S2); 
	    assertEquals("Test that Subject arraylist size is 2?", 2, SList.size());
	  }
	
	@Test
	public void testRemoveSubject() {
		//Test if Item List is not null
		assertNotNull("Test if there is valid Camcorder arraylist to add to", SList);
		//Add items into the array list
		SubjectList.addS(SList, S1);
		SubjectList.addS(SList, S2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, SList.size());
		//Test remove one item
		SubjectList.removeS(SList, S1.getSubjectId());
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, SList.size());
		//Test remove last item
		SubjectList.removeS(SList, S2.getSubjectId());
		//Test that array list is empty
		String allAC= SubjectList.SRetrieveAll(SList);
		String testOutput = "";
		assertEquals("Check that ViewAllSList", testOutput, allAC);
		
	}
	
	@Test
	  public void testRetrieveAllUser() {
	    SList=new ArrayList<Subject>();
	    //Given an empty list, after adding 2 items, test if the size of the list is 2
	    SubjectList.addS(SList, S1);
	    SubjectList.addS(SList, S2);
	      assertNotNull("Test if there is user in the list to retrieve",SList);
	      //There should not be any duplication
	      assertNotEquals("Test there is not duplicate", SList.get(0), SList.get(1));
	      
	      //Ensure all the users have been displayed and not left any user that have display
	      SubjectList.SRetrieveAll(SList);
	      assertSame("Test that all users in the list are display", SList.size(),2);
	    }

	@After
	public void tearDown() throws Exception {
		S1 = null;
		S2 = null;
		SList = null;
	}
}
