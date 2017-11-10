package hznu.hjc.model;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

/**
 * 模拟的进程 默认的排序方法
 * 默认按arrivedTime从小到大来排序
 * @author Administrator
 * @data 2017年11月9日
 */
@Getter
@Setter
public class Progress
{
	private String name;
	private int id, arrivedTime, priority, runTime, waittingTime;
	
	/**
	 * arrivedTime从小到大
	 */
	public static Comparator<Progress> SortByArrivedTime = new Comparator<Progress>()
	{
		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO 自动生成的方法存根
			return o1.arrivedTime - o2.arrivedTime;
		}
	};
			
	/**
	 * priority 从小到大
	 */
	public static Comparator<Progress> SortByPriority = new Comparator<Progress>()
	{

		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO 自动生成的方法存根
			return o1.priority - o2.priority;
		}
	};

	/**
	 * runTime 从小到大
	 */
	public static Comparator<Progress> SortByRunTime = new Comparator<Progress>()
	{

		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO 自动生成的方法存根
			return o1.runTime - o2.runTime;
		}
	};
	
	public Progress()
	{
		waittingTime = 0;
	}

	public Progress(int id, String name, int arrivedTime, int priority, int runTime)
	{
		this.id = id;
		this.name = name;
		this.arrivedTime = arrivedTime;
		this.priority = priority;
		this.runTime = runTime;
		waittingTime = 0;
	}

}
