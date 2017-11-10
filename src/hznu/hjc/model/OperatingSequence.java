package hznu.hjc.model;

import hznu.hjc.model.Progress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 抢占式的不好直接保存运行顺序 使用OperatingSequence存储
 * 
 * @author Administrator
 * @data 2017年11月9日
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperatingSequence
{
	private int progressId; // 进程唯一id
	private String progressName; // 进程名
	private int beginTime, endTime;
	private Boolean end; // 记录此次是否结束

	public OperatingSequence(Progress progress, int beginTime, int endTime, Boolean end)
	{
		this.progressId = progress.getId();
		this.progressName = progress.getName();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.end = end;
	}
}
