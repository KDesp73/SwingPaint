package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextAreaPainter implements Painter {
	private final JTextArea textArea;

	public TextAreaPainter(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void setBackgroundColor(Color color) {
		textArea.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		textArea.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		if (color != null && thickness > 0) {
			Border border = BorderFactory.createLineBorder(color, thickness);
			textArea.setBorder(border);
		} else {
			textArea.setBorder(null); // Remove border if no color is provided
		}
	}

	public void setCaretColor(Color color) {
		textArea.setCaretColor(color);
	}

	public void setDisabledColor(Color color) {
		if (!textArea.isEnabled()) {
			textArea.setBackground(color);
		}
	}

	public void setSelectionBackgroundColor(Color color) {
		textArea.setSelectionColor(color);
	}

	public void setSelectionForegroundColor(Color color) {
		textArea.setSelectedTextColor(color);
	}

	public void setPlaceholderColor(Color placeholderColor) {
		textArea.putClientProperty("placeholderColor", placeholderColor);
	}
}
