package com.example.model;

public class Usuario {

	private static String NewUser;
	private String NewPass;

	public Usuario(String newUser, String newPass) {

		NewUser = newUser;
		NewPass = newPass;
	}

	public String getNewUser() {
		return NewUser;
	}

	public void setNewUser(String newUser) {
		NewUser = newUser;
	}

	public String getNewPass() {
		return NewPass;
	}

	public void setNewPass(String newPass) {
		NewPass = newPass;
	}

}
