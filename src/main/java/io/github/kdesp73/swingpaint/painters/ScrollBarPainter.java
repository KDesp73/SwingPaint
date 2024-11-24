package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollBarPainter implements Painter {
	private final JScrollBar scrollBar;

	public ScrollBarPainter(JScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}

	@Override
	public void setBackgroundColor(Color color) {
		scrollBar.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		// Foreground color isn't directly applicable to JScrollBar; use thumb color instead
		setThumbColor(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		if (color != null && thickness > 0) {
			scrollBar.setBorder(BorderFactory.createLineBorder(color, thickness));
		} else {
			scrollBar.setBorder(null); // Remove border if no color is provided
		}
	}

	public void setThumbColor(Color color) {
		if (scrollBar.getUI() instanceof BasicScrollBarUI basicUI) {
//			basicUI.getThumbBounds(); // Ensure the UI is updated with the new color
			scrollBar.setUI(new CustomScrollBarUI(color, getTrackColor()));
		}
	}

	public void setTrackColor(Color color) {
		if (scrollBar.getUI() instanceof BasicScrollBarUI basicUI) {
			scrollBar.setUI(new CustomScrollBarUI(getThumbColor(), color));
		}
	}

	private Color getThumbColor() {
		return scrollBar.getForeground(); // Defaults to foreground color
	}

	private Color getTrackColor() {
		return scrollBar.getBackground(); // Defaults to background color
	}

	/**
	 * Custom ScrollBar UI for applying thumb and track colors.
	 */
	private static class CustomScrollBarUI extends BasicScrollBarUI {
		private final Color thumbColor;
		private final Color trackColor;

		public CustomScrollBarUI(Color thumbColor, Color trackColor) {
			this.thumbColor = thumbColor;
			this.trackColor = trackColor;
		}

		@Override
		protected void configureScrollBarColors() {
//			this.thumbColor = thumbColor;
//			this.trackColor = trackColor;
		}

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
			g.setColor(thumbColor != null ? thumbColor : Color.GRAY);
			g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
		}

		@Override
		protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
			g.setColor(trackColor != null ? trackColor : Color.LIGHT_GRAY);
			g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
		}
	}
}
