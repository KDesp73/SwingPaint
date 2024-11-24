package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CheckboxPainter implements Painter {
	private final JCheckBox checkBox;

	public CheckboxPainter(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}

	@Override
	public void setBackgroundColor(Color color) {
		checkBox.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		checkBox.setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = checkBox.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			// Update the border with the new color and the same thickness
			checkBox.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			// Replace the border with a new one if it's not a LineBorder
			checkBox.setBorder(new LineBorder(color, thickness));
		}
	}

	public void setSelectedColor(Color color) {
		checkBox.setSelectedIcon(new IconWithColor(color));
	}

	public void setUnselectedColor(Color color) {
		checkBox.setIcon(new IconWithColor(color));
	}

	// Custom Icon class to allow changing the checkbox icon colors
	private record IconWithColor(Color color) implements Icon {

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(color);
			g.fillRect(x, y, getIconWidth(), getIconHeight());
		}

		@Override
		public int getIconWidth() {
			return 16; // Default icon size
		}

		@Override
		public int getIconHeight() {
			return 16; // Default icon size
		}
	}
}
