import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCareerInfo {

	private CareerInfo ci1;
	private CareerInfo ci2;
	private CareerInfo ci3;


	private ArrayList<CareerInfo> careerList;

	public TestCareerInfo() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ci1 = new CareerInfo(1, "Web Designer", "Information Technology", 1);
		ci2 = new CareerInfo(2, "Software Tester", "Information Technology", 2);
		ci3 = new CareerInfo(3, "Game Programmer", "Information Technology", 3);


		careerList = new ArrayList<CareerInfo>();
	}

	@Test
	public void testAddCareerInfo() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Career Information arraylist to add to", careerList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		CareerInfo.addCareer(careerList, ci1);
		assertEquals("Test if that Career Information arraylist size is 1?", 1, careerList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Career Information is added same as 1st item of the list?", ci1, careerList.get(0));

		// Add another item. test The size of the list is 2?
		CareerInfo.addCareer(careerList, ci2);
		assertEquals("Test that Career Information arraylist size is 2?", 2, careerList.size());
	}

	@Test
	public void testRemoveCareerInfo() {
		// Test if Item List is not null
		assertNotNull("Test if there is valid Camcorder arraylist to add to", careerList);
		// Add items into the array list
		CareerInfo.addCareer(careerList, ci1);
		CareerInfo.addCareer(careerList, ci2);
		CareerInfo.addCareer(careerList, ci3);

		assertEquals("Test if that Camcorder arraylist size is 3?", 3, careerList.size());
		// Test remove one item
		CareerInfo.removeCareer(careerList, ci1.getCareerId());
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, careerList.size());
		// Test remove last item
		CareerInfo.removeCareer(careerList, ci2.getCareerId());
		// Test that array list is empty
		String allCI = CareerInfo.careerListToString(careerList);
		String testOutput = "";
		assertEquals("Check that ViewAllaclist", testOutput, allCI);

	}

	@Test
	public void testRetrieveAllCareerInfo() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", careerList);

		// test if the list of Career Informations retrieved is empty
		String allCI = CareerInfo.careerListToString(careerList);
		String testOutput = "";
		assertEquals("Check that ViewAllaclist", testOutput, allCI);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		CareerInfo.addCareer(careerList, ci1);
		CareerInfo.addCareer(careerList, ci2);
		CareerInfo.addCareer(careerList, ci3);

		assertEquals("Test if that Camcorder arraylist size is 2?", 2, careerList.size());

		// test if the expected output string same as the list of Career Information
		// retrieved
		allCI = CareerInfo.careerListToString(careerList);

		testOutput += String.format("%-10s %-20s %-30s %-15s\n", 1, "Web Designer", "Information Technology", 1);
		testOutput += String.format("%-10s %-20s %-30s %-15s\n", 2, "Software Tester", "Information Technology", 2);
		testOutput += String.format("%-10s %-20s %-30s %-15s\n", 3, "Game Programmer", "Information Technology", 3);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCI);

	}

	@After
	public void tearDown() throws Exception {
		ci1 = null;
		ci2 = null;
		ci3 = null;
		careerList = null;
	}

}
