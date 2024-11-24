package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SplitPanePainter implements Painter {
	private final JSplitPane splitPane;

	public SplitPanePainter(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public void setDividerColor(Color color) {
		splitPane.setDividerSize(10); // Ensure the divider is wide enough to show the color
		splitPane.setUI(new CustomSplitPaneUI(color));
	}

	@Override
	public void setBackgroundColor(Color color) {
		splitPane.setBackground(color);
		splitPane.getLeftComponent().setBackground(color);
		splitPane.getRightComponent().setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		splitPane.setForeground(color);
		splitPane.getLeftComponent().setForeground(color);
		splitPane.getRightComponent().setForeground(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		splitPane.setBorder(new LineBorder(color, thickness));
	}

	// Custom UI to allow changing the divider color
	private static class CustomSplitPaneUI extends javax.swing.plaf.basic.BasicSplitPaneUI {
		private final Color dividerColor;

		public CustomSplitPaneUI(Color dividerColor) {
			this.dividerColor = dividerColor;
		}

		@Override
		public void paint(Graphics g, JComponent jc) {
			super.paint(g, jc);
			g.setColor(dividerColor);
			g.fillRect(splitPane.getDividerLocation(), 0, splitPane.getDividerSize(), splitPane.getHeight());
		}
	}
}
