package hznu.hjc.schedule;

import java.util.List;
import java.util.PriorityQueue;

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
		int index = 0,count = 0;	//countΪ�ѵ���Ľ���
		boolean flag = false;		//�Ƿ�ȫ��������
		q.add(progresses.get(0));
		while(q.size()!=0 || count<progresses.size())
		{
			
		}
	}


}
/*
priority_queue<Progress> q = priority_queue<Progress>();					//����ʱ����������ȶ��� ������ʱ�䵱ʣ���ʱ��
		operatingSequences = vector<OperatingSequence>();							//��¼һ��
		string previousName = "";													//���뱣֤ÿ�����̵����ֲ�ͬ
		int index = 1, count = -1, time = 0;	//count Ϊ����˳����±�
		bool flag = false;
		q.push(progresses[0]);
		time = progresses[0].arrivedTime;
		while (q.size() != 0 || index < n)
		{
			if (q.size() == 0)
			{
				//�ȴ���һ������
				time = progresses[index].arrivedTime;
				q.push(progresses[index]);
				index++;
				continue;
			}
			if (flag == true)
			{
				Progress progress = q.top();
				q.pop();
				if (previousName != progress.name)
				{
					previousName = progress.name;
					operatingSequences.push_back(OperatingSequence(progress.name, time, time, false));
					count++;
				}
				time += progress.runTime;
				operatingSequences[count].endTime = time;
				operatingSequences[count].isEnd = true;
			}
			else
			{
				Progress progress = q.top();
				q.pop();
				if (previousName != progress.name)
				{
					previousName = progress.name;
					operatingSequences.push_back(OperatingSequence(progress.name, time, time, false));
					count++;
				}
				time++;				//ģ��ʱ������һ��
				operatingSequences[count].endTime = time;
				progress.runTime--;
				if (progress.runTime > 0)
				{
					q.push(progress);
				}
				else
				{
					operatingSequences[count].isEnd = true;
				}
				if (index < n)	//����δ����Ľ���
				{
					while (index < n)
					{
						if (progresses[index].arrivedTime <= time)
						{
							q.push(progresses[index]);
							index++;
						}
						else
						{
							break;
						}
					}
				}
				else	//���н��̶��ڶ����� ֱ��˳��ִ�� �����ж��Ƿ��н��̵���
				{
					flag = true;
				}
			}
		}
*/