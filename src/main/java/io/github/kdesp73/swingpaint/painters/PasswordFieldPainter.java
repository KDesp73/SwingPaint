package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

public class PasswordFieldPainter implements Painter {
	private final JPasswordField passwordField;

	public PasswordFieldPainter(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	@Override
	public void setBackgroundColor(Color color) {
		passwordField.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		passwordField.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setCaretColor(Color color) {
		passwordField.setCaretColor(color);
	}

	public void setSelectionColors(Color selectionBackground, Color selectionForeground) {
		passwordField.setSelectionColor(selectionBackground);
		passwordField.setSelectedTextColor(selectionForeground);
	}
}
