package hznu.hjc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hznu.hjc.schedule.AbstractSchedule;

public class CPUTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		CPU cpu = new CPU("C:\\Users\\Administrator\\Desktop\\input.txt");
		cpu.SimulationScheduling();
	}

}
