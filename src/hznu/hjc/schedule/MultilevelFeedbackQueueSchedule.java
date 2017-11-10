package hznu.hjc.schedule;

import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

/**
 * 多级队列 分3个队列 需要输入每个队列优先级范围 [0,priority1] [priority1,priority2] [priority2,max)
 * 前2个为轮转 需要输入2个时间片 最后一个为FCFS
 * 
 * @author Administrator
 * @data 2017年11月10日
 */
public class MultilevelFeedbackQueueSchedule extends AbstractSchedule
{
	private int priority1, priority2, timeSlicing1, timeSlicing2;
	private Queue<Progress> q1; // timeSlicing1 轮转
	private Queue<Progress> q2; // timeSlicing2 轮转
	private Queue<Progress> q3; // FCFS
	int count = 0, time, endTime;

	public MultilevelFeedbackQueueSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
		init();
	}

	private void init()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("最高优先级队列优先级范围1-");
		priority1 = in.nextInt();
		System.out.print("最高优先级队列时间片:");
		timeSlicing1 = in.nextInt();
		System.out.print("第二优先级队列优先级范围" + priority1 + "-");
		priority2 = in.nextInt();
		System.out.print("第二优先级队列时间片(需要大于最高优先级队列时间片):");
		timeSlicing2 = in.nextInt();
	}

	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		q1 = new LinkedList<>(); // timeSlicing1 轮转
		q2 = new LinkedList<>(); // timeSlicing2 轮转
		q3 = new LinkedList<>(); // FCFS
		Progress progress;
		progress = progresses.get(count);
		time = progress.getArrivedTime();
		count++;
		offerProgress(progress);
		q1Working();
	}

	private void q1Working()
	{
		Progress progress;
		boolean flag;
		while (q1.size() != 0)
		{
			progress = q1.poll();
			if (progress.getRunTime() <= timeSlicing1) // 一个时间片就结束了
			{
				flag = true; // 结束
				endTime = time + progress.getRunTime();
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			}
			else
			{
				flag = false;
				endTime = time + timeSlicing1;
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
				progress.setRunTime(progress.getRunTime() - timeSlicing1);
			}
			time = endTime;
			while (count < progresses.size())
			{
				if (progresses.get(count).getArrivedTime() <= time)
				{
					offerProgress(progresses.get(count));
					count++;
				}
				else
				{
					break;
				}
			}
			if (!flag)
			{
				q2.offer(progress); // 放在q2队列最后
			}
		}
		q2Working();
	}

	private void q2Working()
	{
		Progress progress;
		boolean flag;
		while (q2.size() != 0)
		{
			progress = q2.poll();
			if (progress.getRunTime() <= timeSlicing2) // 一个时间片就结束了
			{
				flag = true; // 结束
				endTime = time + progress.getRunTime();
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			}
			else
			{
				flag = false;
				endTime = time + timeSlicing2;
				operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
				progress.setRunTime(progress.getRunTime() - timeSlicing2);
			}
			time = endTime;
			while (count < progresses.size())
			{
				if (progresses.get(count).getArrivedTime() <= time)
				{
					offerProgress(progresses.get(count));
					count++;
				}
				else
				{
					break;
				}
			}
			if (!flag)
			{
				q3.offer(progress); // 放在q3队列最后
			}
			//优先级高的在等待
			if(q1.size()!=0)
			{
				q1Working();
				return;
			}
		}
		q3Working();
	}
	/*
	 * FCFS
	 */
	private void q3Working()
	{
		Progress progress;
		while (q3.size() != 0 || count < progresses.size())
		{
			if(q3.size() == 0)
			{
				progress = progresses.get(count);
				time = progress.getArrivedTime();
				count++;
				offerProgress(progress);
				if(q1.size()!=0)
				{
					q1Working();
					return;
				}
				else if(q2.size()!=0)
				{
					q2Working();
					return;
				}
				continue;
			}
			progress = q3.poll();
			endTime = progress.getRunTime()+time;
			operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			time = endTime;
			while (count < progresses.size())
			{
				if (progresses.get(count).getArrivedTime() <= time)
				{
					offerProgress(progresses.get(count));
					count++;
				}
				else
				{
					break;
				}
			}
			if(q1.size()!=0)
			{
				q1Working();
				return;
			}
			else if(q2.size()!=0)
			{
				q2Working();
				return;
			}
		}
	}

	private void offerProgress(Progress progress)
	{
		int priority = progress.getPriority();

		if (priority >= 1 && priority < priority1)
		{
			q1.offer(new Progress(progress));
		}
		else if (priority >= priority1 && priority < priority2)
		{
			q2.offer(new Progress(progress));
		}
		else if (priority >= priority2)
		{
			q3.offer(new Progress(progress));
		}
	}
}
