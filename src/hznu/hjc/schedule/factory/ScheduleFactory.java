package hznu.hjc.schedule.factory;

import java.util.List;

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
		default:
			throw new Exception("ID错误 没有此调度算法");
		}
	}
}