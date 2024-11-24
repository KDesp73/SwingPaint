package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ToolBarPainter implements Painter {
	private final JToolBar toolBar;

	public ToolBarPainter(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	@Override
	public void setBackgroundColor(Color color) {
		toolBar.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		toolBar.setForeground(color);
		for (Component component : toolBar.getComponents()) {
			component.setForeground(color);
		}
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		toolBar.setBorder(new LineBorder(color, thickness));
	}
}
