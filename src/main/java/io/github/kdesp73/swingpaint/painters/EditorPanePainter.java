package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import java.awt.*;

class EditorPanePainter implements Painter {

	private final JEditorPane editorPane;

	public EditorPanePainter(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		editorPane.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		editorPane.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		editorPane.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setCaretColor(Color color) {
		editorPane.setCaretColor(color);
	}

	public void setSelectedTextBackgroundColor(Color color) {
		editorPane.setSelectionColor(color);
	}

	public void setSelectedTextForegroundColor(Color color) {
		editorPane.setSelectedTextColor(color);
	}
}
