package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUtil {
	

		// get a database connection
		public Connection getConnection() {
			Connection connection = null;
			try {
				
				String driverName =Constants.DRIVERNAME;
				String url =Constants.URL;
				String userName = Constants.USERNAME;
				String password = Constants.PASSWORD;
				
				
				Class.forName(driverName);			
				connection = DriverManager.getConnection(url,userName,password);
				
				System.out.println("connection establisted");
			} catch (ClassNotFoundException ex) {

				System.out.println("connection not establisted" + ex);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			return connection;
		}

		// close all 
		public void closeAll(Connection con, PreparedStatement ps, ResultSet rs) {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
			}
		}

		


	}



