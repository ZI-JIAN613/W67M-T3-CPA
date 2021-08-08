import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PreRequisiteTest {
	private PrerequisiteInfo pri1;
	private PrerequisiteInfo pri2;
	private PrerequisiteInfo pri3;
	
	private ArrayList<PrerequisiteInfo> priList;
	
	@Before
	public void setUp() throws Exception {
		pri1 = new PrerequisiteInfo("Agriculture, Food, and Natural Resources");
		pri2 = new PrerequisiteInfo("Architecture and Construction");
		pri3 = new PrerequisiteInfo("Arts, Audio/Video Technology, and Communications");
		
		//priList = new ArrayList<PrerequisiteInfo>();
	}

	@After
	public void tearDown() throws Exception {
		pri1 = null;
		priList = null;
	}

	@Test
	public void testAddPrerequisite() {
		assertNotNull(priList);
		priList.add(pri1);
		assertSame(pri1, priList.get(0));
		assertEquals(1, priList.size());
	}
	
	@Test
	public void testViewAllPrerequisiteInfo() {
		assertNotNull(priList);
		assertEquals(1, priList.size());
		priList.add(pri1);
		assertSame(pri1, priList.get(0));
	}

	@Test
	public void testDeleteAPrerequisiteInfo() {
		assertNotNull(priList);
		priList.add(pri1);
		assertEquals(1, priList.size());
		priList.remove(pri1);
		assertEquals(0, priList.size());
	}
	
	@Test
	public void testUpdatePathwayInfo() {
		assertNotNull(priList);
	}
}
