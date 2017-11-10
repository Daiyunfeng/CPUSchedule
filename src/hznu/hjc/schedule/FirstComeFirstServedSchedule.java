package hznu.hjc.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hznu.hjc.model.OperatingSequence;
import hznu.hjc.model.Progress;

public class FirstComeFirstServedSchedule extends AbstractSchedule
{
	public FirstComeFirstServedSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void schedule()
	{
		// TODO 自动生成的方法存根
		progresses.sort(Progress.SortByArrivedTime);
		Progress progress;
		int time = progresses.get(0).getArrivedTime(),endTime;
		for(int i =0;i<progresses.size();i++)
		{
			progress = progresses.get(i);
			if(time<progress.getArrivedTime())
			{
				time = progress.getArrivedTime();
			}
			endTime = time + progress.getRunTime();
			this.operatingSequences.add(new OperatingSequence(progress, time, endTime, true));
			time =endTime;
		}
	}
}
