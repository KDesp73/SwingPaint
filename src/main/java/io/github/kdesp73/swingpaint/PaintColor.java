package io.github.kdesp73.swingpaint;

import io.github.kdesp73.swingpaint.exceptions.InvalidColorException;

import java.awt.*;

public class PaintColor {
	public class RGB{
		public int r;
		public int g;
		public int b;

		public RGB(int r, int b, int g) {
			if(r < 0 || r > 255) throw new InvalidColorException("r was out of bounds");
			if(g < 0 || g > 255) throw new InvalidColorException("g was out of bounds");
			if(b < 0 || b > 255) throw new InvalidColorException("b was out of bounds");

			this.r = r;
			this.b = b;
			this.g = g;
		}

		public RGB(String hex) {
			if (hex.startsWith("#")) {
				hex = hex.substring(1);
			}

			r = Integer.parseInt(hex.substring(0, 2), 16);
			g = Integer.parseInt(hex.substring(2, 4), 16);
			b = Integer.parseInt(hex.substring(4, 6), 16);
		}
	}

	private final Color color;
	private String hex;
	private RGB rgb;

	public PaintColor(Color color) {
		this.color = color;
		this.rgb = new RGB(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
		this.hex = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
	}

	public PaintColor(String hex) {
		this.hex = hex;
		this.color = Color.decode(hex);
		this.rgb = new RGB(hex);
	}

	public PaintColor(RGB rgb) {
		this.rgb = rgb;
		this.color = new Color(rgb.r, rgb.g, rgb.b);
		this.hex = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
	}

	public Color getColor() {
		return color;
	}

	public String getHex() {
		return hex;
	}

	public RGB getRgb() {
		return rgb;
	}
}
