package io.github.kdesp73.swingpaint.painters;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class SliderPainter implements Painter {
	private final JSlider slider;

	public SliderPainter(JSlider slider) {
		this.slider = slider;
		this.slider.setUI(new CustomSliderUI(slider));
	}

	@Override
	public void setBackgroundColor(Color color) {
		slider.setBackground(color);
	}

	@Override
	public void setForegroundColor(Color color) {
		// Foreground color isn't directly applicable; use thumb color instead
		setThumbColor(color);
	}

	@Override
	public void setBorderColor(Color color, int thickness) {
		if (color != null && thickness > 0) {
			slider.setBorder(BorderFactory.createLineBorder(color, thickness));
		} else {
			slider.setBorder(null); // Remove border if no color is provided
		}
	}

	public void setThumbColor(Color color) {
		CustomSliderUI ui = getCustomSliderUI();
		if (ui != null) {
			ui.setThumbColor(color);
			slider.repaint();
		}
	}

	public void setTrackColor(Color color) {
		CustomSliderUI ui = getCustomSliderUI();
		if (ui != null) {
			ui.setTrackColor(color);
			slider.repaint();
		}
	}

	public void setTickColor(Color color) {
		CustomSliderUI ui = getCustomSliderUI();
		if (ui != null) {
			ui.setTickColor(color);
			slider.repaint();
		}
	}

	private CustomSliderUI getCustomSliderUI() {
		if (slider.getUI() instanceof CustomSliderUI customSliderUI) {
			return customSliderUI;
		}
		return null;
	}

	/**
	 * Custom Slider UI for applying custom colors to the slider.
	 */
	private static class CustomSliderUI extends BasicSliderUI {
		private Color thumbColor = Color.GRAY;
		private Color trackColor = Color.LIGHT_GRAY;
		private Color tickColor = Color.BLACK;

		public CustomSliderUI(JSlider slider) {
			super(slider);
		}

		public void setThumbColor(Color thumbColor) {
			this.thumbColor = thumbColor;
		}

		public void setTrackColor(Color trackColor) {
			this.trackColor = trackColor;
		}

		public void setTickColor(Color tickColor) {
			this.tickColor = tickColor;
		}

		@Override
		public void paintThumb(Graphics g) {
			g.setColor(thumbColor != null ? thumbColor : Color.GRAY);
			g.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
		}

		@Override
		public void paintTrack(Graphics g) {
			g.setColor(trackColor != null ? trackColor : Color.LIGHT_GRAY);
			Rectangle trackBounds = trackRect;
			g.fillRect(trackBounds.x, trackBounds.y + (trackBounds.height / 4),
				trackBounds.width, trackBounds.height / 2);
		}

		@Override
		public void paintTicks(Graphics g) {
			g.setColor(tickColor != null ? tickColor : Color.BLACK);
			super.paintTicks(g);
		}
	}
}
