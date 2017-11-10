package hznu.hjc.schedule;

import java.util.List;
import java.util.PriorityQueue;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

public class PrioritySchedule extends AbstractSchedule
{

	public PrioritySchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		PriorityQueue<Progress> q = new PriorityQueue<>(Progress.SortByPriority); // 优先级排序的优先队列
		int count = 0, time, endTime;
		Progress progress;
		q.add(new Progress(progresses.get(count)));
		time = progresses.get(count).getArrivedTime();
		count++;
		while (q.size() != 0 || count < progresses.size())
		{
			if (q.size() == 0)
			{
				// 等待下一个进程
				time = progresses.get(count).getArrivedTime();
				q.add(new Progress(progresses.get(count))); // 深拷贝
				count++;
				continue;
			}
			progress = q.poll();
			endTime = time + progress.getRunTime();
			operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			time = endTime;
			while (count < progresses.size())
			{
				if (progresses.get(count).getArrivedTime() <= time)
				{
					q.add(new Progress(progresses.get(count))); // 深拷贝
					count++;
				}
				else
				{
					break;
				}
			}
		}
	}

}
