package hznu.hjc.schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;
import lombok.Getter;
import lombok.Setter;

/**
 * 轮转 额外加了一个时间片属性 在构造函数调用init()初始化
 * 
 * @author Administrator
 * @data 2017年11月10日
 */
@Getter
@Setter
public class RoundRobinSchedule extends AbstractSchedule
{
	private int timeSlicing;// 时间片

	public RoundRobinSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
		init();
	}

	private void init()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("输入时间片:");
		timeSlicing = in.nextInt();
	}

	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		Queue<Progress> q = new LinkedList<Progress>();
		int count = 0, time, endTime;
		Progress progress;
		Boolean flag;
		q.offer(new Progress(progresses.get(count)));
		time = progresses.get(count).getArrivedTime();
		count++;
		while (q.size() != 0 || count < progresses.size())
		{
			if (q.size() == 0)
			{
				// 等待下一个进程
				time = progresses.get(count).getArrivedTime();
				q.offer(new Progress(progresses.get(count))); // 深拷贝
				count++;
				continue;
			}
			progress = q.poll();
			if (progress.getRunTime() <= timeSlicing) // 一个时间片就结束了
			{
				flag = true; // 结束
				endTime = time + progress.getRunTime();
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			}
			else
			{
				flag = false;
				endTime = time + timeSlicing;
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
				progress.setRunTime(progress.getRunTime() - timeSlicing);
			}
			time = endTime;
			while (count < progresses.size())
			{
				if (progresses.get(count).getArrivedTime() <= time)
				{
					q.offer(new Progress(progresses.get(count))); // 深拷贝
					count++;
				}
				else
				{
					break;
				}
			}
			if (!flag)
			{
				q.offer(progress); // 放在队列最后
			}
		}
	}
}
