package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Login;

public class LoginDao {

	public LoginDao() {

	}

	public Boolean verificaLogin(Login login) throws SQLException {

		Conexao bd = new Conexao("localhost", "ssambd", "root", "dados");

		// Retirar
		if (bd.obtemConexao()) {
			System.out.println("Conectado!");
		}

		Boolean lbLoginEfetuado = false;
		String lsSelect = "select adm_user,adm_password from adm_administrador where adm_user like '"
				+ login.getUser() + "'";
		
		try {
			PreparedStatement stmt = bd.con.prepareStatement(lsSelect);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			//System.out.println("onti "+rs.getString(2));
			if ((login.getPass()).equals(rs.getString(2))) {
				lbLoginEfetuado = true;
				bd.con.close();
			}

			return lbLoginEfetuado;

		} catch (Exception e) {
			bd.con.close();
			return lbLoginEfetuado;
		}

	}

}
