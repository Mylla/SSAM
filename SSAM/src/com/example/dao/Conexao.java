package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String host;
    private String user;
    private String pass;
    private String database;
    
	public Connection con;
	
	public Conexao( String host, String database, String user, String pass){
		 this.pass = pass;
	     this.user = user;
	     this.host = host;
	     this.database = database;
	}
	
	public Boolean obtemConexao(){
		
		Boolean isConnected = false;
		String url;
		
		url = "jdbc:mysql://"+this.host+"/"
	              +this.database+"?"
	              +"user="+this.user
	              +"&password="+this.pass;
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.con = DriverManager.getConnection (url);
			isConnected = true;
		}catch(SQLException e) {
			e.printStackTrace();
			isConnected = false;
		} catch ( ClassNotFoundException e ) {
            e.printStackTrace();
            isConnected = false;
        } catch ( InstantiationException e ) {
            e.printStackTrace();
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
            isConnected = false;
        }
        
        return isConnected;
	}
	
}

