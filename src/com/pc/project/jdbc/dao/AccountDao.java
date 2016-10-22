package com.pc.project.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.pc.project.jdbc.domain.Account;
import com.pc.project.jdbc.utils.C3P0Utils;

public class AccountDao {
	/**
	 * 转账
	 * 
	 * @param from
	 *            转账方
	 * @param money
	 *            转账额
	 * @return true,接收成功；false，接收失败
	 * @throws SQLException
	 */
	public static boolean transferFrom(String from, Double money) throws SQLException {
		// 转账标识
		boolean isTransfered = true;
		// 获取连接(开启事务，则是事务连接，没开事务，则是连接池连接)
		Connection conn = C3P0Utils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update tbl_account set money=money-? where name=?";
		Object[] params = { money, from };
		int update = queryRunner.update(conn, sql, params);
		if (update == 0) {
			isTransfered = false;
		}
		return isTransfered;
	}

	/**
	 * 收款
	 * 
	 * @param to
	 *            收款方
	 * @param money
	 *            转账额
	 * @return true,接收成功；false，接收失败
	 * @throws SQLException
	 */
	public static boolean transferTo(String to, Double money) throws SQLException {
		// 转账标识
		boolean isTransfered = true;
		// 获取连接(开启事务，则是事务连接，没开事务，则是连接池连接)
		Connection conn = C3P0Utils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update tbl_account set money=money+? where name=?";
		Object[] params = { money, to };
		int update = queryRunner.update(conn, sql, params);
		if (update == 0) {
			isTransfered = false;
		}
		return isTransfered;
	}

	/**
	 * 查询转账方余额是否充足
	 * 
	 * @param from
	 *            转账方
	 * @param money
	 *            转账额
	 * @return true,充足；false，不充足
	 * @throws SQLException
	 */
	public static boolean queryFromBlance(String from, Double money) throws SQLException {
		// 转账标识
		boolean isTransfered = true;
		// 获取连接(开启事务，则是事务连接，没开事务，则是连接池连接)
		Connection conn = C3P0Utils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from tbl_account where name = ?";
		Object[] params = { from };
		Account account = queryRunner.query(conn, sql, new BeanHandler<Account>(Account.class), params);
		if (account.getMoney() < money) {
			isTransfered = false;
		}
		return isTransfered;
	}
}
