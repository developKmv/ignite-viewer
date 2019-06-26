package org.ignite;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.Iterator;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Main {
	private static Ignite ignite;
	private static IgniteCache<Object, Object> cache;
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Main.class);
	public static void main(String args[]) {

		ClientConfiguration cfgIgnite = new ClientConfiguration().setAddresses("127.0.0.1:10800");
		IgniteClient igniteClient = Ignition.startClient(cfgIgnite);
		
		AppFrame frame = new AppFrame("IGNITE Viewer",igniteClient);

		PrintStream ps = new PrintStream(new FrameOutputStream(frame.textArea2,frame.textArea,frame.textArea1));
		System.setOut(ps);
		System.setErr(ps);
		frame.setSize(new Dimension(800, 600));
		frame.setVisible(true);
		
		System.out.println("Enter operation for Apache Ignite");
		
		
	}
}
