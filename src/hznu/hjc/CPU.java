package hznu.hjc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;
import hznu.hjc.schedule.AbstractSchedule;
import hznu.hjc.schedule.ScheduleFactory;

public class CPU
{
	private final static String fileName = "C:\\Users\\Administrator\\Desktop\\input.txt";
	private int n;
	private AbstractSchedule schedule;
	private List<Progress> progresses;

	public CPU()
	{
		progresses = new ArrayList<>();
	}

	private void init()
	{
		try
		{
			gainProgress();
			setSchedule();
		}
		catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private void gainProgress() throws Exception
	{
		boolean flag = true;
		String data;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		while ((data = br.readLine()) != null)
		{
			if (flag)
			{
				flag = false;
				n = Integer.parseInt(data);
			}
			else
			{
				String strs[] = data.split(" ");
				progresses.add(new Progress(Integer.parseInt(strs[0]), strs[1], Integer.parseInt(strs[2]),
						Integer.parseInt(strs[3]), Integer.parseInt(strs[4])));
			}
		}
	}

	private void setSchedule() throws Exception
	{
		System.out.println("调度算法:");
		System.out.println("0:First Come First Served");
		System.out.println("1:Shortest Job First");
		System.out.println("2:Shortest Remaining Time First");
		System.out.println("3:Priority 非抢占");
		System.out.println("4:Round Robin");
		System.out.println("选择CPU调度算法");
		int choice;
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		this.schedule = ScheduleFactory.getSchedule(choice, progresses);
	}

	public void SimulationScheduling()
	{
		init();
		schedule.paintResult();
	}
}
