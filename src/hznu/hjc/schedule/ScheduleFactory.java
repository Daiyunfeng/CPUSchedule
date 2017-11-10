package hznu.hjc.schedule;

import java.util.List;

import hznu.hjc.model.Progress;

/**
 * CPU���ȹ���
 * @author Administrator
 * @data 2017��11��9��
 */
public class ScheduleFactory
{

	public final static int First_Come_First_Served = 0, Shortest_Job_First = 1, Shortest_Remaining_Time_First = 2,
			Priority = 3, Round_Robin = 4;
	private ScheduleFactory(){}
	public static AbstractSchedule getSchedule(int id,List<Progress> progresses) throws Exception
	{
		switch (id)
		{
		case First_Come_First_Served:
			return new FirstComeFirstServedSchedule(progresses);
		case Shortest_Remaining_Time_First:
			return new ShortestRemainingTimeFirstSchedule(progresses);
		default:
			throw new Exception("ID���� û�д˵����㷨");
		}
	}
}
