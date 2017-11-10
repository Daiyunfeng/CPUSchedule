package hznu.hjc.model;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

/**
 * ģ��Ľ��� Ĭ�ϵ����򷽷�
 * Ĭ�ϰ�arrivedTime��С����������
 * @author Administrator
 * @data 2017��11��9��
 */
@Getter
@Setter
public class Progress
{
	private String name;
	private int id, arrivedTime, priority, runTime, waittingTime;
	
	/**
	 * arrivedTime��С����
	 */
	public static Comparator<Progress> SortByArrivedTime = new Comparator<Progress>()
	{
		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO �Զ����ɵķ������
			return o1.arrivedTime - o2.arrivedTime;
		}
	};
			
	/**
	 * priority ��С����
	 */
	public static Comparator<Progress> SortByPriority = new Comparator<Progress>()
	{

		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO �Զ����ɵķ������
			return o1.priority - o2.priority;
		}
	};

	/**
	 * runTime ��С����
	 */
	public static Comparator<Progress> SortByRunTime = new Comparator<Progress>()
	{

		@Override
		public int compare(Progress o1, Progress o2)
		{
			// TODO �Զ����ɵķ������
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
	
	public Progress(Progress progress)
	{
		this.id = progress.id;
		this.name = progress.name;
		this.arrivedTime = progress.arrivedTime;
		this.priority = progress.priority;
		this.runTime = progress.runTime;
		this.waittingTime = progress.waittingTime;
	}
	
}
