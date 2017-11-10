package hznu.hjc.schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import hznu.hjc.model.Progress;
/**
 * 多级队列
 * 分3个队列 需要输入每个队列优先级范围 [0,priority1] [priority1,priority2] [priority2,max)
 * 前2个为轮转 需要输入2个时间片
 * 最后一个为FCFS
 * @author Administrator
 * @data 2017年11月10日
 */
public class MultilevelQueueSchedule extends AbstractSchedule
{
	private int priority1,priority2,timeSlicing1,timeSlicing2;
	public MultilevelQueueSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
	}

	private void init()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("最高优先级队列优先级范围1-");
		priority1 = in.nextInt();
		System.out.print("最高优先级队列时间片:");
		timeSlicing1 = in.nextInt();
		System.out.print("第二优先级队列优先级范围"+ priority1 +"-");
		priority2 = in.nextInt();
		System.out.print("第二优先级队列时间片(需要大于最高优先级队列时间片):");
		timeSlicing2 = in.nextInt();
	}
	
	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		Queue<Process> q1 = new LinkedList<>();	//timeSlicing1 轮转
		Queue<Process> q2 = new LinkedList<>();	//timeSlicing2 轮转
		Queue<Process> q3 = new LinkedList<>();	//FCFS
		int count = 0, time, endTime;
		Progress progress;
		progress = progresses.get(count);
		
	}
	
	
}
