package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

public class TextPanePainter implements Painter {

	private final JTextPane textPane;

	public TextPanePainter(JTextPane textPane) {
		this.textPane = textPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		textPane.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		textPane.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		textPane.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setCaretColor(Color color) {
		textPane.setCaretColor(color);
	}

	public void setSelectedTextBackgroundColor(Color color) {
		textPane.setSelectionColor(color);
	}

	public void setSelectedTextForegroundColor(Color color) {
		textPane.setSelectedTextColor(color);
	}
}
