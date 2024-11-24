package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class ProgressBarPainter implements Painter {
	private final JProgressBar progressBar;

	public ProgressBarPainter(JProgressBar progressBar) {
		this.progressBar = progressBar;
		this.progressBar.setUI(new CustomProgressBarUI());
	}

	@Override
	public void setBackgroundColor(Color color) {
		progressBar.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		progressBar.setForeground(color);
		CustomProgressBarUI ui = getCustomProgressBarUI();
		if (ui != null) {
			ui.setBarColor(color);
			progressBar.repaint();
		}
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		if (color != null && thickness > 0) {
			progressBar.setBorder(BorderFactory.createLineBorder(color, thickness));
		} else {
			progressBar.setBorder(null); // Remove border if no color is provided
		}
	}

	public void setTrackColor(Color color) {
		CustomProgressBarUI ui = getCustomProgressBarUI();
		if (ui != null) {
			ui.setTrackColor(color);
			progressBar.repaint();
		}
	}

	private CustomProgressBarUI getCustomProgressBarUI() {
		if (progressBar.getUI() instanceof CustomProgressBarUI customProgressBarUI) {
			return customProgressBarUI;
		}
		return null;
	}

	/**
	 * Custom UI for the progress bar.
	 */
	private static class CustomProgressBarUI extends BasicProgressBarUI {
		private Color barColor = Color.BLUE;
		private Color trackColor = Color.LIGHT_GRAY;

		public void setBarColor(Color barColor) {
			this.barColor = barColor;
		}

		public void setTrackColor(Color trackColor) {
			this.trackColor = trackColor;
		}

		@Override
		protected void paintDeterminate(Graphics g, JComponent c) {
			if (!(g instanceof Graphics2D g2)) {
				return;
			}

			Insets b = progressBar.getInsets(); // Border insets
			int width = progressBar.getWidth() - b.left - b.right;
			int height = progressBar.getHeight() - b.top - b.bottom;

			// Paint track
			g2.setColor(trackColor);
			g2.fillRect(b.left, b.top, width, height);

			// Paint bar
			int barWidth = (int) (width * progressBar.getPercentComplete());
			g2.setColor(barColor);
			g2.fillRect(b.left, b.top, barWidth, height);
		}

		@Override
		protected void paintIndeterminate(Graphics g, JComponent c) {
			if (!(g instanceof Graphics2D g2)) {
				return;
			}

			Insets b = progressBar.getInsets();
			int width = progressBar.getWidth() - b.left - b.right;
			int height = progressBar.getHeight() - b.top - b.bottom;

			// Paint the track
			g2.setColor(trackColor);
			g2.fillRect(b.left, b.top, width, height);

			// Animate the indeterminate progress
			g2.setColor(barColor);

			Rectangle box = getBox(null);
			if (box != null) {
				g2.fillRect(box.x, box.y, box.width, box.height);
			}
		}
	}
}
