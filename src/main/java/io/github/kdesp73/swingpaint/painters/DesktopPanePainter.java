package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DesktopPanePainter implements Painter {
	private final JDesktopPane desktopPane;

	public DesktopPanePainter(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	@Override
	public void setBackgroundColor(Color color) {
		desktopPane.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		desktopPane.setForeground(color);
		for (JInternalFrame frame : desktopPane.getAllFrames()) {
			frame.getContentPane().setForeground(color);
		}
	}

	public void setBorderColor(Color color, int thickness) {
		desktopPane.setBorder(new LineBorder(color, thickness));
	}
}
