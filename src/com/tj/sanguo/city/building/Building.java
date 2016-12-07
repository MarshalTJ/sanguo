package com.tj.sanguo.city.building;

import java.io.Serializable;

import com.tj.sanguo.city.City;
import com.tj.sanguo.effect.BuildingEffect;

/**
 * ������
 * @author Administrator
 *
 */
public abstract class Building implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected City city;
	protected int number = 0;
	protected String name;
	protected String desc;
	protected int level = 1;
	protected int population = 0;
	protected boolean iswait = false;
	// �����ﵱǰ״̬��0 �ޣ�1 ������ 2 ���� 
	protected int status = 0;
	protected long startTime;
	protected long updateCost = 100;
	protected int updateNeedPopulation = 0;
	protected long degradeCost = 80;
	protected float buildRate = 1.25f;
	
	protected int costFood = 100;
	protected int costWood = 100;
	protected int costIron = 100;
	protected float costRate = 1.30f;
	
	// �������Ӧ��Ч��
	protected BuildingEffect effect = null;
	
	public Building(City city) {
		this.city = city;
		init();
	}
	
	protected void init() {
		initEffect();
		changeDesc();
		if (this.city == null) {
			return;
		}
		this.number = this.city.getAndAddSubNumber();
//		this.startTime = System.currentTimeMillis();
	}
	
	protected abstract void initEffect();
	// ���콨����
	public void build() {
		level = 0;
		population = 0;
		updatecheck();
		costResouce();
		status = 1;
		iswait = true;
	}
	public void update() {
		updatecheck();
		costResouce();
		status = 1;
		iswait = true;
	}
	
	public void degrade() {
		status = 2;
		iswait =true;
	}
	
	public void updateCommit() {
		this.level ++;
		this.updateChangePopulation();
		this.updateChangeCostTime();
		this.updateChangeCostResource();
	}
	
	//����������Դ
	private void updateChangeCostResource() {
		this.costWood *= this.costRate;
		this.costIron *= this.costRate;
		this.costFood *= this.costRate;
	}

	public void degradeCommit() {
		this.level --;
		this.degradeChangePopulation();
		this.degradeChangeCostTime();
		this.degradeChangeCostResource();
	}
	
	private void degradeChangeCostResource() {
		this.costWood /= this.costRate;
		this.costIron /= this.costRate;
		this.costFood /= this.costRate;
	}

	public void startBuild() {
		this.startTime = System.currentTimeMillis();
		iswait = false;
	}
	
	public void buildCommit() {
		if (status == 1) {
			updateCommit();
		}
		else if (status == 2) {
			degradeCommit();
		}
		
		status = 0;
		this.changeEffect();
		this.city.recountPopulation();
	}
	
	public long getCostTime() {
		if (status == 1) {
			return updateCost;
		}
		else if (status == 2) {
			return degradeCost;
		}
		else {
			return 0;
		}
	}
	
	protected void changeDesc() {
		this.desc = this.name + "����ǰ�ȼ�Ϊ " +this.getLevel() + "���ȼ�Ϊ " + this.getCity().getMaxLevel() 
				+ ".\n ����������Դ:ľ" + this.getCostWood() + " ��" + this.getCostIron() + " ��" + this.getCostFood()
				+ " �˿�" + this.updateNeedPopulation
				+ ".\n " + this.effect.getDesc()
			    ;
	}
	
	protected void changeEffect() {
		changeDesc();
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	protected void updateChangeCostTime() {
		this.updateCost = (long) (updateCost * buildRate);
	}
	
	protected void degradeChangeCostTime() {
		this.degradeCost = (long) (degradeCost / buildRate);
	}
	
	protected void updateChangePopulation() {
		this.population += updateNeedPopulation;
		
		if (this.level < 5) {
			this.updateNeedPopulation = 1;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation = 2;
		}
		else if (this.level < 15) {
			this.updateNeedPopulation = 3;
		}
		else {
			this.updateNeedPopulation = 4;
		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.updateNeedPopulation = 1;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation = 2;
		}
		else if (this.level < 15) {
			this.updateNeedPopulation = 3;
		}
		else {
			this.updateNeedPopulation = 4;
		}
		this.population -= updateNeedPopulation;
	}
	
	// �������������
	protected void updatecheck() {
		checkResource();
		checkPopulation();
		checkCondition();
	}
	// �����������(��ٸ��ȼ��Ƿ��㹻�������õȼ��Ƿ�)��������Ը�д
	protected void checkCondition() {
		
	}
	// ����˿��Ƿ�����
	private void checkPopulation() {
		if (this.getCity().getCityResouce().getProductFoods().changeIntToShow() - this.getCity().getPopulation() - this.updateNeedPopulation < 0) {
			throw new RuntimeException("������ʳ�������㣬��������ũ��!");
		}
	}
	// �����Դ�Ƿ��㹻
	private void checkResource() {
		if (this.getCity().getCityResouce().getOwnWoods().changeIntToShow() < this.costWood) {
			throw new RuntimeException("����ľͷ���㣬������ũ�����߹���ɽկ��ȡ��Դ����������ʽ��ȡ��Դ!");
		}
		if (this.getCity().getCityResouce().getOwnIrons().changeIntToShow() < this.costIron) {
			throw new RuntimeException("���������㣬������ũ�����߹���ɽկ��ȡ��Դ����������ʽ��ȡ��Դ!");
		}
		if (this.getCity().getCityResouce().getOwnFoods().changeIntToShow() < this.costFood) {
			throw new RuntimeException("������ʳ���㣬������ũ�����߹���ɽկ��ȡ��Դ����������ʽ��ȡ��Դ!");
		}
	}

	protected void costResouce() {
		this.getCity().getCityResouce().getOwnWoods().cost(this.costWood);
		this.getCity().getCityResouce().getOwnIrons().cost(this.costIron);
		this.getCity().getCityResouce().getOwnFoods().cost(this.costFood);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getUpdateNeedPopulation() {
		return updateNeedPopulation;
	}

	public void setUpdateNeedPopulation(int updateNeedPopulation) {
		this.updateNeedPopulation = updateNeedPopulation;
	}

	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getUpdateCost() {
		return updateCost;
	}
	public void setUpdateCost(long updateCost) {
		this.updateCost = updateCost;
	}
	public long getDegradeCost() {
		return degradeCost;
	}
	public void setDegradeCost(long degradeCost) {
		this.degradeCost = degradeCost;
	}
	public float getBuildRate() {
		return buildRate;
	}
	public void setBuildRate(float buildRate) {
		this.buildRate = buildRate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCostFood() {
		return costFood;
	}

	public void setCostFood(int costFood) {
		this.costFood = costFood;
	}

	public int getCostWood() {
		return costWood;
	}

	public void setCostWood(int costWood) {
		this.costWood = costWood;
	}

	public int getCostIron() {
		return costIron;
	}

	public void setCostIron(int costIron) {
		this.costIron = costIron;
	}

	public float getCostRate() {
		return costRate;
	}

	public void setCostRate(float costRate) {
		this.costRate = costRate;
	}

	public boolean isIswait() {
		return iswait;
	}

	public void setIswait(boolean iswait) {
		this.iswait = iswait;
	}

	public BuildingEffect getEffect() {
		return effect;
	}

	public void setEffect(BuildingEffect effect) {
		this.effect = effect;
	}
	
}
