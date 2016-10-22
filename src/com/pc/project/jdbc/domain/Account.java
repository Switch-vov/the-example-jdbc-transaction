package com.pc.project.jdbc.domain;

/**
 * 账户类
 * 
 * @author Switch
 * @data 2016年10月17日
 * @version V1.0
 */
public class Account {
	private Integer id;
	private String name;
	private Double money;

	public Account() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
}