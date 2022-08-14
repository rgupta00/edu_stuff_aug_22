package com.demo.tx_demo;

import java.sql.*;

import com.day12.session1.ConnectionFactory;

//declartive tx mgt: spring tx mgt

public class NeedOfTx {

	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();

		//tx mgt:  :( problem with jdbc is u have to write lots of lots ... spring declarticve @Tranactional
		try {
			connection.setAutoCommit(false);
			
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			PreparedStatement pstmt = connection.
					prepareStatement("update account set balance=balance-10 where id=?");
			pstmt.setInt(1, 1);
			pstmt.executeUpdate();

			pstmt = connection.prepareStatement("update acount set balance=balance+10 where id=?");
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

			connection.commit();
			System.out.println("transfer is done");

		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
