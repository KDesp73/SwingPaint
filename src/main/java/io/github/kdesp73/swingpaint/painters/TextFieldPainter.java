package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

public class TextFieldPainter implements Painter {
	private final JTextField textField;

	public TextFieldPainter(JTextField textField) {
		this.textField = textField;
	}

	@Override
	public void setBackgroundColor(Color color) {
		textField.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		textField.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		if (color != null && thickness > 0) {
			textField.setBorder(BorderFactory.createLineBorder(color, thickness));
		} else {
			textField.setBorder(null);
		}
	}

	public void setPlaceholderColor(Color placeholderColor) {
		textField.putClientProperty("placeholderColor", placeholderColor);
	}

	public void setCaretColor(Color color) {
		textField.setCaretColor(color);
	}

	public void setDisabledColor(Color color) {
		if (!textField.isEnabled()) {
			textField.setBackground(color);
		}
	}
}
