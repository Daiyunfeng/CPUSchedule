package hznu.hjc.schedule;

import java.util.List;
import java.util.Scanner;

import hznu.hjc.model.Progress;
import lombok.Getter;
import lombok.Setter;
/**
 * 轮转 额外加了一个时间片属性
 * 在构造函数调用init()初始化
 * @author Administrator
 * @data 2017年11月10日
 */
@Getter
@Setter
public class RoundRobinSchedule extends AbstractSchedule
{
	private int timeSlicing;//时间片
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
		timeSlicing =in.nextInt();
	}
	
	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		
	}

}
