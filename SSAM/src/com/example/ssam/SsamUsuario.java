package com.example.ssam;

import java.sql.SQLException;

import org.mortbay.jetty.security.Password;

import com.example.dao.UsuarioDao;
import com.example.model.Usuario;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.Form;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
//import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SsamUsuario extends VerticalLayout {
	private Button ok = new Button("Ok");
	// private TextField pass = new TextField("Password: ");
	private TextField user = new TextField("User: ");
	private TextField nome = new TextField("Nome Completo: ");
	private PasswordField pass = new PasswordField("Password: ");
	private PasswordField confpass = new PasswordField("Confirmar Password: ");

	public SsamUsuario() {

		setMargin(true);
		final Form formUser = new Form();

		formUser.setCaption("Informe seus dados");
		formUser.addField("nome", nome);
		formUser.addField("user", user);
		formUser.addField("pass", pass);
		formUser.addField("confPass", confpass);
		formUser.addField("ok", ok);

		formUser.getField("nome").setRequired(true);
		formUser.getField("nome").setRequiredError("Está faltando o nome!");
		formUser.getField("user").setRequired(true);
		formUser.getField("user").setRequiredError("Está faltando o user!");
		formUser.getField("pass").setRequired(true);
		formUser.getField("pass").setRequiredError("Está faltando o pass!");
		formUser.getField("confPass").setRequired(true);
		formUser.getField("confPass").setRequiredError(
				"Está faltando a confirmação do pass!");

		addComponent(formUser);

		ok.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {

				Usuario user = new Usuario("" + formUser.getField("user"), ""
						+ formUser.getField("pass"));
				UsuarioDao useDao = new UsuarioDao();
				try {
					String a = ""+formUser.getField("pass"); 
					String b = ""+formUser.getField("confPass");
					if (a.equals(b)){
						useDao.Inserção(user);
						getWindow().showNotification(
								"Usuario inserido com Sucesso",
								Notification.TYPE_WARNING_MESSAGE);
					}else{

						getWindow().showNotification(
								"Senhas diferentes",
								Notification.TYPE_WARNING_MESSAGE);
						formUser.getField("pass").setValue("");
						formUser.getField("confPass").setValue("");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println("Errooooooooo");
				}


			}
		});

	}

	// Event Click desse botão

}
