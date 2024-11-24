package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelPainter implements Painter {
	private final JPanel panel;

	public PanelPainter(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void setBackgroundColor(Color color) {
		panel.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		panel.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = panel.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			// Update the border with the new color and the same thickness
			panel.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			// Replace the border with a new one if it's not a LineBorder
			panel.setBorder(new LineBorder(color, thickness));
		}
	}
}
