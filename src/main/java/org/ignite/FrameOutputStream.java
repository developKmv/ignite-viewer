package org.ignite;

import java.awt.TextArea;
import java.io.IOException;
import java.io.OutputStream;

public class FrameOutputStream extends OutputStream{
	
	TextArea textField;
	
	public FrameOutputStream(TextArea textField){
		this.textField = textField;
	}

	@Override
	public void write(int b) throws IOException {
		textField.append(String.valueOf((char)b));
	}

}
