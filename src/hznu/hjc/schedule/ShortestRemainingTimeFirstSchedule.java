package hznu.hjc.schedule;

import java.util.List;
import java.util.PriorityQueue;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

public class ShortestRemainingTimeFirstSchedule extends AbstractSchedule
{

	public ShortestRemainingTimeFirstSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	protected void schedule()
	{
		// TODO �Զ����ɵķ������
		progresses.sort(Progress.SortByArrivedTime);
		PriorityQueue<Progress> q = new PriorityQueue<>(Progress.SortByRunTime); //����ʱ����������ȶ��� ������ʱ�䵱ʣ���ʱ��
		int index = -1,count = 1,time,endTime;	//countΪ�ѵ���Ľ���
		int previousID = -1;		//��¼��һ����Ψһid
		boolean flag = false;		//�Ƿ�ȫ��������
		Progress progress;
		q.add(new Progress(progresses.get(0)));
		time = progresses.get(0).getArrivedTime();
		while(q.size()!=0 || count<progresses.size())
		{
			if (q.size() == 0)
			{
				//�ȴ���һ������
				time = progresses.get(count).getArrivedTime();
				q.add(new Progress(progresses.get(count))); 	//���
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
							q.add(new Progress(progresses.get(count))); 	//���
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