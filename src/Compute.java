/*
MIT License

Copyright (c) 2017 Beau Hahn

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

import java.sql.*;

public class Compute {
	private static String thisodbc;
	private static String thistype;
	
	public static void initialize(String odbc,String type) {
		try { 
			thisodbc = odbc;
			thistype = odbc;
			Connection c = DriverManager.getConnection("jdbc:odbc:"+thisodbc);
			Statement s = c.createStatement();
			int rval = 0;
			s.addBatch("CREATE TABLE CLIENTS (id AUTOINCREMENT NOT NULL,"+
						"title TEXT(4) NOT NULL,"+
						"fname TEXT(25) NOT NULL,"+
						"mi TEXT(1),"+
						"lname TEXT(25) NOT NULL,"+
						"suffix TEXT(4),"+
						"address1 TEXT(50) NOT NULL,"+
						"address2 TEXT(50),"+
						"city TEXT(30) NOT NULL,"+
						"state TEXT(2) NOT NULL,"+
						"zip TEXT(5) NOT NULL,"+
						"plusfour TEXT(4),"+
						"homephone TEXT(10) NOT NULL,"+
						"altphone TEXT(10),"+
						"fax TEXT(10),"+
						"mobile TEXT(10),"+
						"email TEXT(50),"+
						"altcon TEXT(50),"+
						"notes TEXT)");
			s.addBatch("CREATE TABLE ARTISTS (id AUTOINCREMENT NOT NULL,"+
						"title TEXT(4) NOT NULL,"+
						"fname TEXT(25) NOT NULL,"+
						"mi TEXT(1),"+
						"lname TEXT(25) NOT NULL,"+
						"suffix TEXT(4),"+
						"address1 TEXT(50) NOT NULL,"+
						"address2 TEXT(50),"+
						"city TEXT(30) NOT NULL,"+
						"state TEXT(2) NOT NULL,"+
						"zip TEXT(5) NOT NULL,"+
						"plusfour TEXT(4),"+
						"homephone TEXT(10) NOT NULL,"+
						"altphone TEXT(10),"+
						"fax TEXT(10),"+
						"mobile TEXT(10),"+
						"email TEXT(50),"+
						"altcon TEXT(50),"+
						"notes TEXT,"+
						"bio TEXT,"+
						"portrait IMAGE)");
			s.addBatch("CREATE TABLE SALES (id AUTOINCREMENT NOT NULL,"+
						"pymt INTEGER(0) NOT NULL,"+
						"date DATE,"+
						"piece INTEGER(0),"+
						"type TEXT NOT NULL,"+
						"frame INTEGER(0),"+
						"fdc INTEGER(2),"+
						"glass INTEGER(0),"+
						"gdc INTEGER(2),"+
						"mat1 INTEGER(0),"+
						"dc1 INTEGER(2),"+
						"mat2 INTEGER(0),"+
						"dc2 INTEGER(2),"+
						"mat3 INTEGER(0),"+
						"dc3 INTEGER(2),"+
						"mat4 INTEGER(0),"+
						"dc4 INTEGER(2),"+
						"mat5 INTEGER(0),"+
						"dc5 INTEGER(2),"+
						"mat6 INTEGER(0),"+
						"dc6 INTEGER(2),"+
						"pay TEXT NOT NULL,"+
						"client INTEGER(0),"+
						"adj INTEGER(2),"+
						"tax INTEGER(2),"+
						"exempt CHECKBOX,"+
						"total INTEGER(2),"+
						"notes TEXT)");
			s.addBatch("CREATE TABLE PIECES (id AUTOINCREMENT NOT NULL)");
			s.addBatch("CREATE TABLE FRAMES (id AUTOINCREMENT NOT NULL)");
			s.addBatch("CREATE TABLE MATS (id AUTOINCREMENT NOT NULL)");
			s.addBatch("CREATE TABLE ITEMS (id AUTOINCREMENT NOT NULL)");
			s.addBatch("CREATE TABLE CONTACTS (id AUTOINCREMENT NOT NULL)");
			s.addBatch("CREATE TABLE ACCOUNTS (id AUTOINCREMENT NOT NULL,"+
						"limit INTEGER(2),"+
						"balance INTEGER(2),"+
						"routing TEXT(9),"+
						"account TEXT(13),"+
						"card TEXT(16),"+
						"cvv2 TEXT(3),"+
						"exp DATE)");
			s.addBatch("CREATE TABLE SUPPLIERS (id AUTOINCREMENT NOT NULL)");
			s.executeBatch();
			c.commit();
			c.close();
			//if(rval==Statement.EXECUTE_FAILED) { System.err.println("Client table not created. Aborting..."); return; }
		}
		catch (SQLException sqle) { sqle.printStackTrace(); }
	}
	
	public static void setup(String odbc,String type) {
		thisodbc = odbc;
		thistype = type;
	}
	public static void insert(String table,String values) {
		try {
			Connection c = DriverManager.getConnection("jdbc:odbc:"+thisodbc);
			Statement s = c.createStatement();
			System.out.println("INSERT INTO "+table+" "+values);
			s.execute("INSERT INTO "+table+" "+values);
		}
		catch (SQLException sqle) { sqle.printStackTrace(); System.exit(1); }
	}
	
	public static void update(String table,String params) {
		try {
			Connection c = DriverManager.getConnection("jdbc:odbc:"+thisodbc);
			Statement s = c.createStatement();
			System.out.println("UPDATE "+table+" "+params);
			s.execute("UPDATE "+table+" "+params);
		}
		catch (SQLException sqle) { sqle.printStackTrace(); System.exit(1); }
	}
	
	public static void delete(String cols, String table,String params) {
	}
	
	public static ResultSet query(String cols,String table,String params) {
		ResultSet rs = null;
		try {
			Connection c = DriverManager.getConnection("jdbc:odbc:"+thisodbc);
			Statement s = c.createStatement();
			System.out.println("SELECT "+cols+" FROM "+table+" "+params);
			rs = s.executeQuery("SELECT "+cols+" FROM "+table+" "+params);
		}
		catch (SQLException sqle) { sqle.printStackTrace(); System.exit(1); }
		return rs;	
	}
}