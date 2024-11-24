package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class TreePainter implements Painter {

	private final JTree tree;

	public TreePainter(JTree tree) {
		this.tree = tree;
	}

	@Override
	public void setBackgroundColor(Color color) {
		tree.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		tree.setForeground(color);
	}

	@Override
	public void setBorderColor(Color borderColor, int borderThickness) {
		tree.setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
	}

	public void setSelectionColors(Color bgColor, Color fgColor) {
		tree.setCellRenderer(new CustomTreeCellRenderer(bgColor, fgColor));
	}

	private static class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
		private Color bg;
		private Color fg;

		public CustomTreeCellRenderer(Color bg, Color fg){
			this.bg = bg;
			this.fg = fg;
		}

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

			if (sel) {
				c.setBackground(bg);
				setForeground(fg);
			}

			return c;
		}
	}}
