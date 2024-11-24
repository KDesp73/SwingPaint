package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

public class FormattedTextFieldPainter implements Painter {

	private final JFormattedTextField formattedTextField;

	public FormattedTextFieldPainter(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}

	@Override
	public void setBackgroundColor(Color color) {
		formattedTextField.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		formattedTextField.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		formattedTextField.setBorder(javax.swing.BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setCaretColor(Color color) {
		formattedTextField.setCaretColor(color);
	}

	public void setSelectionColors(Color selectionBackground, Color selectionForeground) {
		formattedTextField.setSelectionColor(selectionBackground);
		formattedTextField.setSelectedTextColor(selectionForeground);
	}
}
