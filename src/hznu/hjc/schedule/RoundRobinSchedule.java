package hznu.hjc.schedule;

import java.util.List;
import java.util.Scanner;

import hznu.hjc.model.Progress;
import lombok.Getter;
import lombok.Setter;
/**
 * ��ת �������һ��ʱ��Ƭ����
 * �ڹ��캯������init()��ʼ��
 * @author Administrator
 * @data 2017��11��10��
 */
@Getter
@Setter
public class RoundRobinSchedule extends AbstractSchedule
{
	private int timeSlicing;//ʱ��Ƭ
	public RoundRobinSchedule(List<Progress> progresses)
	{
		super(progresses);
		// TODO �Զ����ɵĹ��캯�����
		init();
	}

	private void init()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("����ʱ��Ƭ:");
		timeSlicing =in.nextInt();
	}
	
	@Override
	protected void schedule()
	{
		// TODO �Զ����ɵķ������
		
	}

}
