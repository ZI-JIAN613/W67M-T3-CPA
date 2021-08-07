import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAcademicCluster {
	
	private AcademicCluster ac1;
	private AcademicCluster ac2;
	
	private ArrayList<AcademicCluster> acList;
	
	public TestAcademicCluster() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		ac1 = new AcademicCluster(1,"Engineering","Aerospace Engineering, Aviation Management");
		ac2 = new AcademicCluster(2,"Information Technology","Financial Technology, Business Information Systems, Infocomm Security Management");
		
		acList = new ArrayList<AcademicCluster>();
	}

	
	@Test
	public void testAddAcademicCluster() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Academic Cluster arraylist to add to", acList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		AcademicClusterList.addAC(acList, ac1);		
		assertEquals("Test if that Academic Cluster arraylist size is 1?", 1, acList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Academic Cluster is added same as 1st item of the list?", ac1, acList.get(0));
		
		//Add another item. test The size of the list is 2?
		AcademicClusterList.addAC(acList, ac2);		
		assertEquals("Test that Academic Cluster arraylist size is 2?", 2, acList.size());
	}
	
	@Test
	public void testRemoveAcademicCluster() {
		//Test if Item List is not null
		assertNotNull("Test if there is valid Camcorder arraylist to add to", acList);
		//Add items into the array list
		AcademicClusterList.addAC(acList, ac1);
		AcademicClusterList.addAC(acList, ac2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, acList.size());
		//Test remove one item
		AcademicClusterList.removeAC(acList, ac1.getId());
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, acList.size());
		//Test remove last item
		AcademicClusterList.removeAC(acList, ac2.getId());
		//Test that array list is empty
		String allAC= AcademicClusterList.acRetrieveAll(acList);
		String testOutput = "";
		assertEquals("Check that ViewAllaclist", testOutput, allAC);
		
	}
	@Test
	public void testRetrieveAllAcademicCluster() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", acList);
		
		//test if the list of Academic Clusters retrieved is empty
				String allAC= AcademicClusterList.acRetrieveAll(acList);
				String testOutput = "";
				assertEquals("Check that ViewAllaclist", testOutput, allAC);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
				AcademicClusterList.addAC(acList, ac1);
				AcademicClusterList.addAC(acList, ac2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, acList.size());
		
		//test if the expected output string same as the list of Academic Cluster retrieved
		allAC= AcademicClusterList.acRetrieveAll(acList);

		testOutput += String.format("%-3d %-30s %-20s\n", 1,"Engineering","Aerospace Engineering, Aviation Management");
		testOutput += String.format("%-3d %-30s %-20s\n", 2,"Information Technology","Financial Technology, Business Information Systems, Infocomm Security Management");
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allAC);
		
	}
	
	@After
	public void tearDown() throws Exception {
		ac1 = null;
		ac2 = null;
		acList = null;
	}
}
