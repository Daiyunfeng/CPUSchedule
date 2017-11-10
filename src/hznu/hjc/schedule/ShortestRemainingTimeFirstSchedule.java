package hznu.hjc.schedule;

import java.util.List;
import java.util.PriorityQueue;

import hznu.hjc.model.Progress;

public class ShortestRemainingTimeFirstSchedule extends AbstractSchedule
{

	public ShortestRemainingTimeFirstSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		PriorityQueue<Progress> q = new PriorityQueue<>(Progress.SortByRunTime); //运行时间排序的优先队列 把运行时间当剩余的时间
		int index = 0,count = 0;	//count为已到达的进程
		boolean flag = false;		//是否全部进队列
		q.add(progresses.get(0));
		while(q.size()!=0 || count<progresses.size())
		{
			
		}
	}


}
/*
priority_queue<Progress> q = priority_queue<Progress>();					//运行时间排序的优先队列 把运行时间当剩余的时间
		operatingSequences = vector<OperatingSequence>();							//记录一下
		string previousName = "";													//必须保证每个进程的名字不同
		int index = 1, count = -1, time = 0;	//count 为运行顺序的下标
		bool flag = false;
		q.push(progresses[0]);
		time = progresses[0].arrivedTime;
		while (q.size() != 0 || index < n)
		{
			if (q.size() == 0)
			{
				//等待下一个进程
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
				time++;				//模拟时间续了一秒
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
				if (index < n)	//还有未进入的进程
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
				else	//所有进程都在队列中 直接顺序执行 不用判断是否有进程到达
				{
					flag = true;
				}
			}
		}
*/