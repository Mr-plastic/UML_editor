import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

abstract public class Shape extends JPanel{
	protected static int width;
	protected static int length;
	protected static int start_x;
	protected static int start_y;
}

class Rectangle extends Shape{
	public void draw_rect(int press_x,int press_y,int dragg_x,int dragg_y) {
		width = Math.max(press_x, dragg_x)-Math.min(press_x, dragg_x);
		length = Math.max(press_y, dragg_y)-Math.min(press_y, dragg_y);
		start_x = Math.min(press_x, dragg_x);
		start_y = Math.min(press_y, dragg_y);
		this.setBounds(start_x, start_y, width, length);
		this.setBackground(new Color(224,255,255,120));
		this.setBorder(BorderFactory.createLineBorder(Color.blue));
	};
}

