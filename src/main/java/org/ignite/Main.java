package org.ignite;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.Iterator;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Main {
	private static Ignite ignite;
	private static IgniteCache<Object, Object> cache;
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Main.class);
	public static void main(String args[]) {

		AppFrame frame = new AppFrame("IGNITE Viewer");

		PrintStream ps = new PrintStream(new FrameOutputStream(frame.textField2));
		System.setOut(ps);
		System.setErr(ps);
		frame.setSize(new Dimension(800, 600));
		frame.setVisible(true);
		
		
	}
}
