package hznu.hjc.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

/**
 * ��չֻ��Ҫʵ��schedule
 * operatingSequences��ֻ��Ҫ���������Ϣ �м���ȿ���ʱ�䲻��Ҫ
 * Ȼ����ScheduleFactory����������ͺ�
 * @author Administrator
 * @data 2017��11��9��
 */
public abstract class AbstractSchedule
{
	protected List<Progress> progresses;
	protected List<OperatingSequence> operatingSequences;	//ֻ��Ҫ��¼ÿ��������ʲôʱ������ʲôʱ������ͺ� ����Ҫ���ǿ���
	
	public AbstractSchedule(List<Progress> progresses)
	{
		// TODO �Զ����ɵĹ��캯�����
		this.progresses = progresses;
		this.operatingSequences = new ArrayList<>();
	}
	
	protected abstract void schedule();
	
	public void paintResult()
	{
		// TODO �Զ����ɵķ������
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
				System.out.print("����--");
				time = operatingSequences.get(i).getBeginTime();
				System.out.print(time+"--");
			}
			if (operatingSequences.get(i).getEnd() == true)
			{
				//���̵Ľ���ʱ���ȥ����ʱ���ȥ����ʱ�䡣
				index = map.get(operatingSequences.get(i).getProgressId());
				progresses.get(index).setWaittingTime(operatingSequences.get(i).getEndTime()-progresses.get(index).getArrivedTime()-progresses.get(index).getRunTime());
//				System.out.println();
//				System.out.println(operatingSequences.get(i).getEndTime()+" "+progresses.get(index).getArrivedTime()+" "+progresses.get(index).getRunTime());
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
