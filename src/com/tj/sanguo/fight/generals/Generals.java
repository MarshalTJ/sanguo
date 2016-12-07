package com.tj.sanguo.fight.generals;

import com.tj.sanguo.city.City;
import com.tj.sanguo.fight.Fighter;
import com.tj.sanguo.treasure.equipment.armor.Armor;
import com.tj.sanguo.treasure.equipment.horse.Horse;
import com.tj.sanguo.treasure.equipment.weapon.Weapon;

/**
 * 武将
 * @author Administrator
 *
 */
public class Generals extends Fighter {

	private static final long serialVersionUID = 1L;
	// 武将所在城市。
	protected City city;
	// 性别，0：女，1：男，
	protected int sex = 0;
	// 武将等级
	protected int level = 1;
	// 经验值
	protected int experience = 0;
	// 血量
	protected int hp = 100;
	// 星级，根据武将的成长值决定
	protected int star = 1;
	// 武将装备，武器，防具，马
	protected Weapon weapon = null;
	protected Armor armor = null;
	protected Horse horse = null;
	
	// 初始智力值，等级1的时候
	protected int intelligenceInit = 100;
	// 当前智力值
	protected int intelligence = 100;
	// 智力成长值，没升级加多少
	protected float intelligenceGrowth = 1.0f;
	
	// 初始防御，等级1的时候
	protected int defenseInit = 100;
	// 当前防御
	protected int defense = 100;
	// 防御成长值，没升级加多少
	protected float defenseGrowth = 1.0f;
	
	// 初始攻击，等级1的时候
	protected int attackInit = 100;
	// 当前攻击
	protected int attack = 100;
	// 攻击成长值，没升级加多少
	protected float attackGrowth = 1.0f;
	
	public static Generals createGenerals(City city) {
		Generals generals = new Generals();
		generals.name = "傻蛋";
		generals.attackInit = (int)(Math.random() * 255);
		generals.defenseInit = (int)(Math.random() * 255);
		generals.intelligenceInit = (int)(Math.random() * 255);
		
		generals.attack = generals.attackInit;
		generals.defense = generals.defenseInit;
		generals.intelligence = generals.intelligenceInit;
		
		generals.intelligenceGrowth = (float)(Math.random() * 2);
		generals.defenseGrowth = (float)(Math.random() * 2);
		generals.attackGrowth = (float)(Math.random() * 2);
		
		generals.computeStar();
		generals.city = city;
		
		return generals;
	}

	private void checkMarry(Generals gen1, Generals gen2) {
		if (gen1.getSex() == gen2.getSex()) {
			throw new RuntimeException("武将性别相同，不允许结婚");
		}
		if (gen1.getLevel() < 50 || gen2.getLevel() < 20) {
			throw new RuntimeException("武将等级不够，不允许结婚");
		}
		if (gen1.weapon != null) {
			throw new RuntimeException("武将装备必须卸掉才能结婚");
		}
	}
	// 武将结婚
	public Generals marry(Generals gen1, Generals gen2) {
		checkMarry(gen1, gen2);
		
		Generals generals = new Generals();
		generals.city = gen1.city;
		generals.name = "傻二代";
		
		generals.attackInit = (int) getMarriedAttributes(gen1.attackInit, gen2.attackInit) ;
		generals.defenseInit = (int) getMarriedAttributes(gen1.defenseInit, gen2.defenseInit) ;
		generals.intelligenceInit = (int) getMarriedAttributes(gen1.intelligenceInit, gen2.intelligenceInit) ;
		
		generals.attack = generals.attackInit;
		generals.defense = generals.defenseInit;
		generals.intelligence = generals.intelligenceInit;
		
		generals.intelligenceGrowth = getMarriedAttributes(gen1.intelligenceGrowth, gen2.intelligenceGrowth);
		generals.defenseGrowth = getMarriedAttributes(gen1.defenseGrowth, gen2.defenseGrowth);
		generals.attackGrowth = getMarriedAttributes(gen1.attackGrowth, gen2.attackGrowth);
		
		generals.computeStar();
		return generals;
	}
	
	// 计算武将星级
	private void computeStar() {
		int temp = (int) (this.attackGrowth + this.defenseGrowth + this.intelligenceGrowth);
		this.star = ++ temp;
	}
	
	private float getMarriedAttributes(float gen1, float gen2) {
		if (gen1 > gen2) {
			return gen1;
		} else {
			float temp = gen2 - gen1;
			temp *= Math.random();
			return gen1 + temp;
		}
	}
	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getIntelligenceInit() {
		return intelligenceInit;
	}

	public void setIntelligenceInit(int intelligenceInit) {
		this.intelligenceInit = intelligenceInit;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public float getIntelligenceGrowth() {
		return intelligenceGrowth;
	}

	public void setIntelligenceGrowth(float intelligenceGrowth) {
		this.intelligenceGrowth = intelligenceGrowth;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public int getDefenseInit() {
		return defenseInit;
	}

	public void setDefenseInit(int defenseInit) {
		this.defenseInit = defenseInit;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public float getDefenseGrowth() {
		return defenseGrowth;
	}

	public void setDefenseGrowth(float defenseGrowth) {
		this.defenseGrowth = defenseGrowth;
	}

	public int getAttackInit() {
		return attackInit;
	}

	public void setAttackInit(int attackInit) {
		this.attackInit = attackInit;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public float getAttackGrowth() {
		return attackGrowth;
	}

	public void setAttackGrowth(float attackGrowth) {
		this.attackGrowth = attackGrowth;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
