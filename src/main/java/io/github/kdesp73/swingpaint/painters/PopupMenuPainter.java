package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PopupMenuPainter implements Painter {
	private final JPopupMenu popupMenu;

	public PopupMenuPainter(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	@Override
	public void setBackgroundColor(Color color) {
		popupMenu.setBackground(color);
		setMenuItemBackgroundColor(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		popupMenu.setForeground(color);
		setMenuItemForegroundColor(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = popupMenu.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			// Update the border with the new color and the same thickness
			popupMenu.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			// Replace the border with a new one if it's not a LineBorder
			popupMenu.setBorder(new LineBorder(color, thickness));
		}
	}

	public void setMenuItemBackgroundColor(Color color) {
		for (Component component : popupMenu.getComponents()) {
			if (component instanceof JMenuItem menuItem) {
				menuItem.setBackground(color);
			}
		}
	}

	public void setMenuItemForegroundColor(Color color) {
		for (Component component : popupMenu.getComponents()) {
			if (component instanceof JMenuItem menuItem) {
				menuItem.setForeground(color);
			}
		}
	}
}
