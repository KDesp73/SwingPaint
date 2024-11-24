package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TablePainter implements Painter {

	private final JTable table;

	public TablePainter(JTable table) {
		this.table = table;
	}

	@Override
	public void setBackgroundColor(Color color) {
		table.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		table.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		table.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setSelectionColors(Color selectedBackground, Color selectedForeground, Color defaultBackground, Color defaultForeground) {
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer(selectedBackground, selectedForeground, defaultBackground, defaultForeground));
	}

	public void setHeaderBackgroundColor(Color color) {
		JTableHeader header = table.getTableHeader();
		header.setBackground(color);
	}

	public void setHeaderForegroundColor(Color color) {
		JTableHeader header = table.getTableHeader();
		header.setForeground(color);
	}

	private static class CustomTableCellRenderer extends DefaultTableCellRenderer {

		private final Color selectedBackgroundColor;
		private final Color selectedForegroundColor;
		private final Color defaultBackgroundColor;
		private final Color defaultForegroundColor;

		public CustomTableCellRenderer(Color selectedBackground, Color selectedForeground, Color defaultBackground, Color defaultForeground) {
			this.selectedBackgroundColor = selectedBackground;
			this.selectedForegroundColor = selectedForeground;
			this.defaultBackgroundColor = defaultBackground;
			this.defaultForegroundColor = defaultForeground;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			// Set the background and foreground based on selection state
			if (isSelected) {
				c.setBackground(selectedBackgroundColor);
				setForeground(selectedForegroundColor);
			} else {
				c.setBackground(defaultBackgroundColor);
				setForeground(defaultForegroundColor);
			}

			return c;
		}
	}

}
