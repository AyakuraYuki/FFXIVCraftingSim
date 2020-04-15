package skills;

import exceptions.CraftingException;
import exceptions.ExceptionStatus;
import engine.CraftingStatus;
import engine.Engine;

public enum SpecialSkills implements Skill
{
	Byregots_Blessing("�ȶ����ף��", 24),
	Masters_Mend("����", 88),
	Observe("�۲�", 7),
	Tricks_of_the_Trade("�ؾ�", 0),
	Careful_Observation("��Ʊ��", 0)
	;
	
	String name; 
	String imgAddress;
	int cpCost;
	static Engine engine;
	
	private SpecialSkills(String name, int cpCost) {
		this.name = name;
		this.imgAddress = "/icons/" + this.toString() + ".png";
		this.cpCost = cpCost;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getAddress() {
		return imgAddress;
	}
	
	@Override 
	public String getBaseProgressRate() {
		return "0.0%";
	}
	
	@Override 
	public String getBaseQualityRate() {
		if(this == Byregots_Blessing) {
			return "100% + 20% * �ھ�����";
		} else {
			return "0.0%";
		}
	}
	
	@Override
	public double getActualProgressRate()
	{
		return 0;
	}

	@Override
	public double getActualQualityRate()
	{
		if(this == Byregots_Blessing) {

			double temp = 1.0;
			for(ActiveBuff ab: engine.getActiveBuffs()) {
				temp += ab.buff.getQualityBuff();
			}
			
			return temp * (1.0 + (engine.getInnerQuiet() - 1) * 0.2);
		} else {
			return 0;
		}
	}

	@Override
	public boolean isSuccess()
	{
		return true;
	}

	@Override
	public int getCPCost()
	{
		return cpCost;
	}

	@Override
	public int getDurCost()
	{
		if(this == Byregots_Blessing) {
			return 10;
		} else {
			return 0;
		}
	}

	public static void setEngine(Engine e)
	{
		engine = e;
	}
	
	@Override
	public double getSuccessRate() {
		return 1.0;
	}
	
	@Override
	public double getSuccessRate(CraftingStatus cs) {
		return 1.0;
	}
	
	@Override
	public int getSkillIndex()
	{
		
		for(int i = 0; i < values().length; i++) {
			if(this == values()[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public void execute() throws CraftingException {
		if(this == Byregots_Blessing) {
			engine.setInnerQuiet(0);
			for(ActiveBuff ab: engine.getActiveBuffs()) {
				if(ab.buff == Buff.inner_quiet) {
					engine.getActiveBuffs().remove(ab);
					return;
				}
			}
		} else if(this == Masters_Mend) {
			int t = engine.getPresentDurability();
			t += 30;
			if(t > engine.getTotalDurability()) {t = engine.getTotalDurability();}
			engine.setPresentDurability(t);
		} else if (this == Observe) {
			engine.setObserved(true);
		} else if (this == Tricks_of_the_Trade) {
			if(engine.getCraftingStatus() != CraftingStatus.HQ) {
				throw new CraftingException(ExceptionStatus.Not_HQ);
			}
			int t = engine.getPresentCP();
			t += 20;
			if(t > engine.getTotalCP()) {t = engine.getTotalCP();}
			engine.setPresentCP(t);
		}
	}
}
