package com.pc.project.jdbc.service.impl;

import java.sql.SQLException;

import com.pc.project.jdbc.dao.AccountDao;
import com.pc.project.jdbc.service.AccountServiceInter;
import com.pc.project.jdbc.utils.C3P0Utils;

/**
 * 账号服务实现类
 * 
 * @author Switch
 * @data 2016年10月17日
 * @version V1.0
 */
public class AccountServiceImpl implements AccountServiceInter {

	@Override
	public boolean transferMoney(String from, String to, Double money) {
		// 转账标识
		boolean isTransfered = true;
		// 转账
		try {
			// 开启事务
			C3P0Utils.beginTransaction();
			if (!AccountDao.queryFromBlance(from, money) || !AccountDao.transferFrom(from, money)
					|| !AccountDao.transferTo(to, money)) {
				isTransfered = false;
			}
			// 提交事务
			C3P0Utils.commitTransaction();
		} catch (SQLException e) {
			try {
				// 回滚事务
				C3P0Utils.rollbackTransaction();
				isTransfered = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return isTransfered;
	}

}
