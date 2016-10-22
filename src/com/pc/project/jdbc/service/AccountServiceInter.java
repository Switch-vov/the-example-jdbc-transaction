package com.pc.project.jdbc.service;

/**
 * 用户服务接口
 * 
 * @author Switch
 * @data 2016年10月17日
 * @version V1.0
 */
public interface AccountServiceInter {
	/**
	 * 转账
	 * 
	 * @param from
	 *            转账方
	 * @param to
	 *            收款方
	 * @param money
	 *            钱款数
	 * @return 成功，true；失败，false
	 */
	public boolean transferMoney(String from, String to, Double money);
}
