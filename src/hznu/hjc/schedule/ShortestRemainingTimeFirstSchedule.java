package hznu.hjc.schedule;

import java.util.List;
import java.util.PriorityQueue;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;
/**
 * 最短剩余抢占
 * @author Administrator
 * @data 2017年11月10日
 */
public class ShortestRemainingTimeFirstSchedule extends AbstractSchedule
{

	public ShortestRemainingTimeFirstSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		PriorityQueue<Progress> q = new PriorityQueue<>(Progress.SortByRunTime); //运行时间排序的优先队列 把运行时间当剩余的时间
		int index = -1,count = 1,time,endTime;	//count为已到达的进程
		int previousID = -1;		//记录上一个的唯一id
		boolean flag = false;		//是否全部进队列
		Progress progress;
		q.add(new Progress(progresses.get(0)));
		time = progresses.get(0).getArrivedTime();
		while(q.size()!=0 || count<progresses.size())
		{
			if (q.size() == 0)
			{
				//等待下一个进程
				time = progresses.get(count).getArrivedTime();
				q.add(new Progress(progresses.get(count))); 	//深拷贝
				count++;
				continue;
			}
			if (flag == true)
			{
				progress = q.poll();
				endTime = time + progress.getRunTime();
				if (previousID != progress.getId())
				{
					previousID = progress.getId();
					operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
					index++;
				}
				else
				{
					operatingSequences.get(index).setEndTime(endTime);
					operatingSequences.get(index).setEnd(true);
				}
				time = endTime;
			}
			else
			{
				progress = q.poll();
				if (previousID != progress.getId())
				{
					previousID = progress.getId();
					operatingSequences.add(new OperatingSequence(progress, time, time, false));
					index++;
				}
				endTime = time +1;
				operatingSequences.get(index).setEndTime(endTime);
				progress.setRunTime(progress.getRunTime()-1);
				if (progress.getRunTime() > 0)
				{
					q.add(progress);
				}
				else
				{
					operatingSequences.get(index).setEnd(true);
				}
				time++;
				if(count < progresses.size())
				{
					while(count<progresses.size())
					{
						if (progresses.get(count).getArrivedTime() <= time)
						{
							q.add(new Progress(progresses.get(count))); 	//深拷贝
							count++;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					flag= false;
				}
			}
		}
	}

}