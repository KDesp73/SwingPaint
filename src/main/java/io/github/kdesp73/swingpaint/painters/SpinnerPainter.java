package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

public class SpinnerPainter implements Painter {

	private final JSpinner spinner;

	public SpinnerPainter(JSpinner spinner) {
		this.spinner = spinner;
	}

	@Override
	public void setBackgroundColor(Color color) {
		spinner.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		spinner.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		spinner.setBorder(javax.swing.BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	// Optional: Customize the text field inside the spinner
	public void setTextFieldBackgroundColor(Color color) {
		JComponent editor = (JComponent) spinner.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) editor;
			JTextField textField = defaultEditor.getTextField();
			textField.setBackground(color);
		}
	}

	public void setTextFieldForegroundColor(Color color) {
		JComponent editor = (JComponent) spinner.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) editor;
			JTextField textField = defaultEditor.getTextField();
			textField.setForeground(color);
		}
	}

	public void setButtonBackgroundColor(Color color) {
		JComponent editor = (JComponent) spinner.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) editor;
			JButton upButton = (JButton) defaultEditor.getTextField().getActionMap().get("increment");
			JButton downButton = (JButton) defaultEditor.getTextField().getActionMap().get("decrement");
			upButton.setBackground(color);
			downButton.setBackground(color);
		}
	}
}
