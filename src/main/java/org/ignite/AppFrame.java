package org.ignite;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class AppFrame extends Frame implements ActionListener, ItemListener {

	public static String configpath = "";
	Checkbox get, put, getAll;
	TextArea textField = new TextArea(20, 80);
	TextArea textField1 = new TextArea(30, 80);
	public static TextArea textField2 = new TextArea(25, 90);
	CardLayout cardLO;
	Button back, back1, execute, execute1;
	Label key, value, labelSelect;
	TextField field0, field1;
	CheckboxGroup group;

	// ----create--panels-----------------------------------
	Panel panels;
	Panel mainPanel = new Panel();
	Panel getAndPut = new Panel();
	Panel getAlls = new Panel();
	// ----create--panels-----------------------------------

	

	public AppFrame(String title) {
		super(title);
		panels = new Panel();

		// -------create--menu-------------------------------
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		Menu menu = new Menu("Menu");
		MenuItem item1, item2;

		menu.add(item1 = new MenuItem("Open ignite config"));
		menu.add(item2 = new MenuItem("Exit"));
		mbar.add(menu);
		// -------create--menu-------------------------------

		// -------create-listener------------------------------
		addWindowListener(new MyWindowListener());
		MenuHandler menuHandler = new MenuHandler(this);
		item1.addActionListener(menuHandler);
		item2.addActionListener(menuHandler);
		// -------create-listener------------------------------

		// -------elements---------------------------------

		back = new Button("Back");
		back.addActionListener(this);
		back1 = new Button("Back");
		back1.addActionListener(this);
		execute = new Button("execute");
		execute1 = new Button("execute");

		labelSelect = new Label("Selected methods");
		key = new Label("Key", Label.LEFT);
		value = new Label("Value", Label.LEFT);

		field0 = new TextField(10);
		field1 = new TextField(10);

		group = new CheckboxGroup();

		get = new Checkbox("Get", group, false);
		put = new Checkbox("Put", group, false);
		getAll = new Checkbox("GetALL", group, false);

		get.addItemListener(this);
		put.addItemListener(this);
		getAll.addItemListener(this);

		GridBagLayout gBag = new GridBagLayout();
		GridBagConstraints gConstraint = new GridBagConstraints();

		// ------set--layout--mainPanel---------------------------
		mainPanel.setLayout(gBag);
		gConstraint.fill = GridBagConstraints.HORIZONTAL;
		gConstraint.gridwidth = 1;
		gConstraint.gridx = 0;
		gConstraint.gridy = 0;
		mainPanel.add(get, gConstraint);
		gConstraint.gridwidth = 1;
		gConstraint.gridx = 1;
		gConstraint.gridy = 0;
		mainPanel.add(put, gConstraint);
		gConstraint.gridwidth = 1;
		gConstraint.gridx = 2;
		gConstraint.gridy = 0;
		mainPanel.add(getAll, gConstraint);
		gConstraint.gridwidth = GridBagConstraints.REMAINDER;
		gConstraint.gridx = 0;
		gConstraint.gridy = 1;
		mainPanel.add(textField2, gConstraint);
		// ------set--layout--mainPanel---------------------------

		// --------------set--layout--getAndPut------

		getAndPut.setLayout(gBag);

		gConstraint.anchor = GridBagConstraints.CENTER;
		gConstraint.fill = GridBagConstraints.HORIZONTAL;
		gConstraint.gridwidth = GridBagConstraints.RELATIVE;
		gConstraint.gridx = 0;
		gConstraint.gridy = 0;
		getAndPut.add(key, gConstraint);

		gConstraint.gridwidth = GridBagConstraints.REMAINDER;
		gConstraint.gridx = 1;
		gConstraint.gridy = 0;
		getAndPut.add(field0, gConstraint);

		gConstraint.gridwidth = GridBagConstraints.RELATIVE;
		gConstraint.gridx = 0;
		gConstraint.gridy = 1;
		getAndPut.add(value, gConstraint);

		gConstraint.gridwidth = GridBagConstraints.REMAINDER;
		gConstraint.gridx = 1;
		gConstraint.gridy = 1;
		getAndPut.add(field1, gConstraint);

		gConstraint.fill = GridBagConstraints.HORIZONTAL;
		gConstraint.gridx = 0;
		gConstraint.gridy = 2;
		getAndPut.add(execute1, gConstraint);

		gConstraint.gridx = 0;
		gConstraint.gridy = 3;
		getAndPut.add(textField, gConstraint);

		gConstraint.gridx = 0;
		gConstraint.gridy = 4;
		getAndPut.add(back, gConstraint);

		// --------------set--layout--getAndPut------

		// --------------set--layout--getAll------
		getAlls.setLayout(gBag);

		gConstraint.gridx = 0;
		gConstraint.gridy = 0;
		getAlls.add(execute, gConstraint);

		gConstraint.gridx = 0;
		gConstraint.gridy = 1;
		getAlls.add(textField1, gConstraint);

		gConstraint.gridx = 0;
		gConstraint.gridy = 2;
		getAlls.add(back1, gConstraint);
		// --------------set--layout--getAll------
		cardLO = new CardLayout();
		panels.setLayout(cardLO);

		panels.add(mainPanel, "this");
		panels.add(getAndPut, "getAndPut");
		panels.add(getAlls, "getAlls");

		add(panels);
	}

	@Override
	public void paint(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Back")) {
			cardLO.show(panels, "this");
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		switch (group.getSelectedCheckbox().getLabel()) {
		case "Get":
			cardLO.show(panels, "getAndPut");
			break;
		case "Put":
			cardLO.show(panels, "getAndPut");
			break;
		case "GetALL":
			cardLO.show(panels, "getAlls");
			break;
		}

	}

}
