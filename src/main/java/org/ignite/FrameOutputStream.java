package org.ignite;

import java.awt.TextArea;
import java.io.IOException;
import java.io.OutputStream;

public class FrameOutputStream extends OutputStream{
	
	TextArea textField;
	TextArea textField1;
	TextArea textField2;
	
	public FrameOutputStream(TextArea textField,TextArea textField1,TextArea textField2){
		this.textField = textField;
		this.textField1 = textField1;
		this.textField2 = textField2;
	}

	@Override
	public void write(int b) throws IOException {
		
		textField.append(String.valueOf((char)b));
		textField1.append(String.valueOf((char)b));
		textField2.append(String.valueOf((char)b));
	}
	
	

}
