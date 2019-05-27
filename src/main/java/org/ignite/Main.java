package org.ignite;

import java.awt.Dimension;

import org.ignite.test.AppWindows;

public class Main {
	public static void main(String args[]) {
	
		AppFrame frame = new AppFrame("IGNITE Viewer");
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);
	}
}
