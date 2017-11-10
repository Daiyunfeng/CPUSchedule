package hznu.hjc.schedule.factory;

import java.util.List;
import java.util.Scanner;

import hznu.hjc.model.Progress;
import hznu.hjc.schedule.*;

/**
 * CPU调度工厂
 * 
 * @author Administrator
 * @data 2017年11月9日
 */
public class ScheduleFactory
{

	public final static int First_Come_First_Served = 0, Shortest_Job_First = 1, Shortest_Remaining_Time_First = 2,
			Priority = 3, Round_Robin = 4, Multilevel_Queue = 5, Multilevel_Feedback_Queue = 6;;

	private ScheduleFactory()
	{
	}

	public static AbstractSchedule getSchedule(int id, List<Progress> progresses) throws Exception
	{
		switch (id)
		{
		case First_Come_First_Served:
			return new FirstComeFirstServedSchedule(progresses);
		case Shortest_Job_First:
			return new ShortestJobFirstSchedule(progresses);
		case Shortest_Remaining_Time_First:
			return new ShortestRemainingTimeFirstSchedule(progresses);
		case Priority:
			return new PrioritySchedule(progresses);
		case Round_Robin:
			return new RoundRobinSchedule(progresses);
		case Multilevel_Queue:
			return new MultilevelQueueSchedule(progresses);
		case Multilevel_Feedback_Queue:
			return new MultilevelFeedbackQueueSchedule(progresses);
		default:
			throw new Exception("ID错误 没有此调度算法");
		}
	}

	public static int getChoice()
	{
		System.out.println("调度算法:");
		System.out.println("0:First Come First Served");
		System.out.println("1:Shortest Job First");
		System.out.println("2:Shortest Remaining Time First");
		System.out.println("3:Priority 非抢占");
		System.out.println("4:Round Robin");
		System.out.println("5:Multilevel Queue");
		System.out.println("6:Multilevel Feedback Queue");
		System.out.println("选择CPU调度算法");
		int choice;
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		return choice;
	}
}
