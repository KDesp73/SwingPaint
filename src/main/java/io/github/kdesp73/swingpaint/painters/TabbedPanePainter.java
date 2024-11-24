package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TabbedPanePainter implements Painter {
	private final JTabbedPane tabbedPane;

	public TabbedPanePainter(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		tabbedPane.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		tabbedPane.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = tabbedPane.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			// Update the border with the new color and the same thickness
			tabbedPane.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			// Replace the border with a new one if it's not a LineBorder
			tabbedPane.setBorder(new LineBorder(color, thickness));
		}
	}

	public void setTabBackgroundColor(Color color) {
		for(int i = 0; i < tabbedPane.getTabCount(); i++) {
			Component tabComponent = tabbedPane.getComponentAt(i);
			if (tabComponent != null) {
				tabComponent.setBackground(color);
			}
		}
	}

	public void setTabForegroundColor(Color color) {
		for(int i = 0; i < tabbedPane.getTabCount(); i++) {
			tabbedPane.setForegroundAt(i, color);
		}
	}
}
