package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDao {

	public UsuarioDao() {

	}

	public void Inserção(Usuario usuario) throws SQLException {
		String lsSelect = "SELECT Max(adm_id_pessoa) +1 FROM adm_administrador";
		
		Conexao bd = new Conexao("localhost", "ssambd", "root", "dados");
		if (bd.obtemConexao()) {
			PreparedStatement stmt = bd.con.prepareStatement(lsSelect);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String lsInsert = "insert into adm_administrador (adm_id_pessoa, adm_user, adm_password) VALUES ("
					+ rs.getString(1)
					+ ",'"
					+ usuario.getNewUser()
					+ "','"
					+ usuario.getNewPass() + "' )";
			Statement stmt2 = (Statement) bd.con.createStatement();
			stmt2.execute(lsInsert);
            bd.con.close();

		}
		if (bd.obtemConexao()) {
			
		}

	}

}
