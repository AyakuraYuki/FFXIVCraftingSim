package skills;

public enum Buff
{
	final_appraisal("����ȷ��", true, 0, 0), 
	great_strides("����", true, 0, 1.0),
	inner_quiet("�ھ�", false, 0, 0),
	innovation("�ĸ�", false, 0, 0.5),
	manipulation("����", false, 0, 0),
	name_of_the_elements("Ԫ��֮����", false, 0, 0),
	waste_not("��Լ", false, 0, 0),
	veneration("�羴�����룩", false, 0.5, 0),
	muscle_memory("����", true, 1, 0);
	
	public String name;
	private String address;
	private boolean once;
	private double progressBuff;
	private double qualityBuff;

	private Buff(String name, boolean once,  double progressBuff, double qualityBuff) {
		this.name = name;
		this.once = once;
		this.progressBuff = progressBuff;
		this.qualityBuff = qualityBuff;
		this.address = "/icons/buff_" + this.toString() + ".png";
	}
	
	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}
	
	public boolean isOnce() {
		return once;
	}
	
	public double getProgressBuff() {
		return progressBuff;
	}
	
	public double getQualityBuff() {
		return qualityBuff;
	}
}
