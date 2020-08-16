package exceptions;

public enum ExceptionStatus
{
	Craft_Failed("����ʧ��"), 
	Craft_Success("�����ɹ�"), 
	Not_HQ("�����޷�ʹ�ã����Ǹ�Ʒ��״̬��"), 
	No_Inner_Quiet("�����޷�ʹ�ã�û���ھ�/�������㣩"), 
	Inner_Quiet_Exists("�����޷�ʹ�ã��ھ��Ѿ����ڣ�"),
	Not_Turn_One("�����޷�ʹ�ã�ֻ�����״���ҵʱʹ�ã�"),
	Waste_Not_Exist("�����޷�ʹ�ã��޷��ڼ�Լbuff����ʱʹ�ü�Լ�ӹ���"),
	No_Enough_CP("CP����"),
	Maximun_Reached("�����޷�ʹ�ã��Ѵﵽ���ʹ�ô�����"),
	Now_Crafting("���������У��޷��༭����λ��"),
	Code_Error("��������޷�����"),
	Replay_loading_Error("�ļ������޷���ȷ����"),
	;
	
	private String message;
	private ExceptionStatus(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
