package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuBarPainter implements Painter {
	private final JMenuBar menuBar;

	public MenuBarPainter(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	@Override
	public void setBackgroundColor(Color color) {
		menuBar.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		// JMenuBar does not directly support setting foreground color,
		// so we apply it to all child menu items.
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
			JMenu menu = menuBar.getMenu(i);
			if (menu != null) {
				menu.setForeground(color);
			}
		}
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		Border currentBorder = menuBar.getBorder();

		if (currentBorder instanceof LineBorder lineBorder) {
			// Update the border with the new color and the same thickness
			menuBar.setBorder(new LineBorder(color, lineBorder.getThickness()));
		} else {
			// Replace the border with a new one if it's not a LineBorder
			menuBar.setBorder(new LineBorder(color, thickness));
		}
	}

	public void setMenuItemBackgroundColor(Color color) {
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
			JMenu menu = menuBar.getMenu(i);
			if (menu != null) {
				setMenuItemBackground(menu, color);
			}
		}
	}

	public void setMenuItemForegroundColor(Color color) {
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
			JMenu menu = menuBar.getMenu(i);
			if (menu != null) {
				setMenuItemForeground(menu, color);
			}
		}
	}

	private void setMenuItemBackground(JMenu menu, Color color) {
		menu.setBackground(color);
		for (int i = 0; i < menu.getItemCount(); i++) {
			JMenuItem menuItem = menu.getItem(i);
			if (menuItem != null) {
				menuItem.setBackground(color);
			}
		}
	}

	private void setMenuItemForeground(JMenu menu, Color color) {
		menu.setForeground(color);
		for (int i = 0; i < menu.getItemCount(); i++) {
			JMenuItem menuItem = menu.getItem(i);
			if (menuItem != null) {
				menuItem.setForeground(color);
			}
		}
	}
}
