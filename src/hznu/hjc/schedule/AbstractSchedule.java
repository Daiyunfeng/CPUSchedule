package hznu.hjc.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

/**
 * 扩展只需要实现schedule
 * operatingSequences中只需要保存进程信息 中间调度空闲时间不需要
 * 然后在ScheduleFactory中添加这个类就好
 * @author Administrator
 * @data 2017年11月9日
 */
public abstract class AbstractSchedule
{
	protected List<Progress> progresses;
	protected List<OperatingSequence> operatingSequences;	//只需要记录每个进程在什么时候运行什么时候结束就好 不需要考虑空余
	
	public AbstractSchedule(List<Progress> progresses)
	{
		// TODO 自动生成的构造函数存根
		this.progresses = progresses;
		this.operatingSequences = new ArrayList<>();
	}
	
	protected abstract void schedule();
	
	public void paintResult()
	{
		// TODO 自动生成的方法存根
		schedule();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < progresses.size(); i++)
		{
			map.put(progresses.get(i).getId(), i);
		}
		int time = 0,index;
		System.out.print(time);
		for (int i = 0; i < operatingSequences.size(); i++)
		{
			System.out.print("--");
			if (time < operatingSequences.get(i).getBeginTime())
			{
				System.out.print("空闲--");
				time = operatingSequences.get(i).getBeginTime();
				System.out.print(time+"--");
			}
			if (operatingSequences.get(i).getEnd())
			{
				//进程的结束时间减去到达时间减去运行时间。
				index = map.get(operatingSequences.get(i).getProgressId());
				progresses.get(index).setWaittingTime(operatingSequences.get(i).getEndTime()-progresses.get(index).getArrivedTime()-progresses.get(index).getRunTime());
			}
			time = operatingSequences.get(i).getEndTime();
			System.out.print(operatingSequences.get(i).getProgressName()+"--"+time);
		}
		System.out.println();
		double sum = 0;
		for (int i = 0; i < progresses.size(); i++)
		{
			sum += progresses.get(i).getWaittingTime();
			System.out.println(progresses.get(i).getName()+" watiting time:"+progresses.get(i).getWaittingTime());
		}
		sum /= progresses.size();
		System.out.println("Average watiting time:" + sum);
	}
}
