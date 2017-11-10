package hznu.hjc.model;

import hznu.hjc.model.Progress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ��ռʽ�Ĳ���ֱ�ӱ�������˳�� ʹ��OperatingSequence�洢
 * 
 * @author Administrator
 * @data 2017��11��9��
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperatingSequence
{
	private int progressId; // ����Ψһid
	private String progressName; // ������
	private int beginTime, endTime;
	private Boolean end; // ��¼�˴��Ƿ����

	public OperatingSequence(Progress progress, int beginTime, int endTime, Boolean end)
	{
		this.progressId = progress.getId();
		this.progressName = progress.getName();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.end = end;
	}
}
