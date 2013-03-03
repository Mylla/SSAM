package com.example.ssam;

//import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Window;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SsamMenu extends VerticalLayout {

	private MenuBar menubar = new MenuBar();

	public SsamMenu() {

		final MenuBar.MenuItem usuario = menubar.addItem(
				"Gerenciamento de Usuário", null);
		usuario.addItem("Cadastrar", menuCommand);
		usuario.addItem("Consultar", menuCommand);
		// usuario.addSeparator();

		final MenuBar.MenuItem processo = menubar.addItem("Processo Seletivo",
				null);
		processo.addItem("Análise", menuCommand);
		processo.addItem("Comparativo", menuCommand);
		processo.addItem("Seleção", menuCommand);
		// processo.addSeparator();

		menubar.setHeight("70%");
		menubar.setWidth("70%");

		addComponent(menubar);

	}

	private Command menuCommand = new Command() {
		public void menuSelected(MenuItem selectedItem) {
			if (selectedItem.getText().equals("Cadastrar")) {
				SsamUsuario U = new SsamUsuario();
				Window mainWindow3 = new Window("Cadastrar");
				System.out.println("PARENT " + getWindow().getParent());
				mainWindow3.setWidth(1500, Window.UNITS_PIXELS);
				mainWindow3.setHeight(1500, Window.UNITS_PIXELS);
				mainWindow3.addComponent(U);
				getWindow().getParent().addWindow(mainWindow3);		
				
			}

		}
	};

}
