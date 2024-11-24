package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;


public class ButtonPainter implements Painter {
	private final JButton button;

	public ButtonPainter(JButton button) {
		this.button = button;
	}

	@Override
	public void setBackgroundColor(Color color) {
		button.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		button.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = button.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			button.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			button.setBorder(new LineBorder(color, thickness));
		}
	}
}
