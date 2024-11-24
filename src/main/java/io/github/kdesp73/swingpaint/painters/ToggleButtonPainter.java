package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ToggleButtonPainter implements Painter {
	private final JToggleButton toggleButton;

	public ToggleButtonPainter(JToggleButton toggleButton) {
		this.toggleButton = toggleButton;
	}

	@Override
	public void setBackgroundColor(Color color) {
		toggleButton.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		toggleButton.setForeground(color);
	}


	@Override
	public void setBorderColor(Color color, int thickness) {
		toggleButton.setBorder(new LineBorder(color, thickness));
	}

	public void setSelectedBackgroundColor(Color color) {
		toggleButton.setSelectedIcon(new Icon() {
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				g.setColor(color);
				g.fillRect(x, y, toggleButton.getWidth(), toggleButton.getHeight());
			}

			@Override
			public int getIconWidth() {
				return toggleButton.getWidth();
			}

			@Override
			public int getIconHeight() {
				return toggleButton.getHeight();
			}
		});
	}

	public void setUnselectedBackgroundColor(Color color) {
		toggleButton.setIcon(new Icon() {
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				g.setColor(color);
				g.fillRect(x, y, toggleButton.getWidth(), toggleButton.getHeight());
			}

			@Override
			public int getIconWidth() {
				return toggleButton.getWidth();
			}

			@Override
			public int getIconHeight() {
				return toggleButton.getHeight();
			}
		});
	}
}
