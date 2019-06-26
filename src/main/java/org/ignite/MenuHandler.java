package org.ignite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;

public class MenuHandler implements ActionListener {
	AppFrame appFrame;
	FileDialog fileDialog;

	public MenuHandler(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Open ignite config")) {
			fileDialog = new FileDialog(appFrame, "Open ignite config", FileDialog.LOAD);
			fileDialog.setVisible(true);
			String configPath = fileDialog.getDirectory() + fileDialog.getFile();

		} else if (e.getActionCommand().equals("CleanTextField")) {

			appFrame.textArea.selectAll();
			appFrame.textArea.setText("");
			appFrame.textArea1.selectAll();
			appFrame.textArea1.setText("");
			appFrame.textArea2.selectAll();
			appFrame.textArea2.setText("");

		} else if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
			appFrame.repaint();
		}

	}

}
