package com.example.ssam;

import com.vaadin.Application;
import com.vaadin.ui.*;

@SuppressWarnings("serial")
public class SsamApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Ssam Application");
		Label nomeSite = new Label("SSAM - Sistema de Seleção dos Alunos de Mestrado ");
		mainWindow.addComponent(nomeSite);
		//setSpacing(true);
		SsamLogin l = new SsamLogin();
		mainWindow.addComponent(l);
		setMainWindow(mainWindow);
		
		/*//mainWindow.removeAllComponents();
		
		SsamMenu m = new SsamMenu();
		mainWindow.addComponent(m);
		setMainWindow(mainWindow);*/
		
	}
}
