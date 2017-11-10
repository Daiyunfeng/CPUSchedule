package hznu.hjc.schedule;

import java.util.List;

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
		
	}
	
	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		
	}

}
