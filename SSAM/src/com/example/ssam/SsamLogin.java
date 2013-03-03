package com.example.ssam;

import java.sql.SQLException;

import com.example.dao.LoginDao;
import com.example.model.Login;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Window;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
public class SsamLogin extends VerticalLayout {

	public SsamLogin() {
		LoginForm login = new LoginForm();
		login.setWidth("100%");
		login.setHeight("300px");

		login.addListener(new LoginForm.LoginListener() {
			public void onLogin(LoginEvent event) {

				Login loginObj = new Login(event.getLoginParameter("username"),
						event.getLoginParameter("password"));
				LoginDao loginDao = new LoginDao();

				try {
					if (loginDao.verificaLogin(loginObj)) {

						SsamMenu m = new SsamMenu();
						Label User = new Label("Seja bem vindo, "+event.getLoginParameter("username"));
						Window mainWindow2 = new Window("" + User);
						mainWindow2.setWidth(1500, Window.UNITS_PIXELS);
						mainWindow2.setHeight(1500, Window.UNITS_PIXELS);
						mainWindow2.addComponent(m);
						System.out.println("" + getWindow());
						getWindow().addWindow(mainWindow2);
					} else {
						getWindow().showNotification(
								"Usuario e/ou senha incorretos!",
								Notification.TYPE_WARNING_MESSAGE);
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		addComponent(login);

	}
}
