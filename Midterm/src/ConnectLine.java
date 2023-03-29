import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

interface Connect_Line_basic{
	void paint(Graphics g);
}
public class ConnectLine implements Connect_Line_basic{
	 protected Object startObj;
	 protected Object endObj;
	 protected Point startConnPort;
	 protected Point endConnPort;
	
    ConnectLine(Point start,Point end,Object startObj,Object endObj) {
    	startObj = startObj;
    	endObj = endObj;
    	startConnPort = start;
    	endConnPort = end;
    }
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}

class AssocLine extends ConnectLine{
	protected Point start_point;
	protected Point end_point;
	AssocLine(Point start,Point end,Object startObj,Object endObj) {
		super(start, end,startObj,endObj);
		start_point = start;
		end_point = end;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
        double nx, ny;
        double lineLength = Math.hypot(start_point.x - end_point.x, start_point.y - end_point.y);
        nx = (start_point.x - end_point.x) / lineLength;
        ny = (start_point.y - end_point.y) / lineLength;
        int c1x, c1y, c2x, c2y, c3x, c3y;
        int w=8, h=16;
        c1x = (int)(end_point.x+nx*w) + (int) (ny * w);
        c1y = (int)(end_point.y+ny*w) + (int) (-nx * w);
        c2x = (int)(end_point.x+nx*w) + (int) (-ny * w);
        c2y = (int)(end_point.y+ny*w) + (int) (nx * w);
        c3x = (int)(end_point.x+nx*h);
        c3y = (int)(end_point.y+ny*h);
        g.drawLine(c1x, c1y, end_point.x, end_point.y);
        g.drawLine(c2x, c2y, end_point.x, end_point.y);
        g.drawLine(start_point.x,start_point.y,c3x,c3y);
		
	}

}
class CompositionLine extends ConnectLine{
	private int diamondW = 10, diamondH = 10;
	protected Point start_point;
	protected Point end_point;
	CompositionLine(Point start, Point end, Object startObj, Object endObj) {
		super(start, end, startObj, endObj);
		// TODO Auto-generated constructor stub
		start_point = start;
		end_point = end;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int dx = end_point.x - start_point.x, dy = end_point.y - start_point.y;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + start_point.x;
        ym = xm*sin + ym*cos + start_point.y;
        xm = x;

        x = xn*cos - yn*sin + start_point.x;
        yn = xn*sin + yn*cos + start_point.y;
        xn = x;
        
        // 分點公式算出線上的點, 三角形的三個點與這個點連線即為一個菱形
        double xq = (diamondH*2/D)*start_point.x + ((D-diamondH*2)/D)*end_point.x;
        double yq = (diamondH*2/D)*start_point.y + ((D-diamondH*2)/D)*end_point.y;
   
        int[] xpoints = {end_point.x, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {end_point.y, (int) ym, (int) yq, (int) yn};

        g.fillPolygon(xpoints, ypoints, 4);
		
	}

}
class GeneralizationLine extends ConnectLine{
	private int arrowW = 10, arrowH = 10;
	protected Point start_point;
	protected Point end_point;
	GeneralizationLine(Point start, Point end, Object startObj, Object endObj) {
		super(start, end, startObj, endObj);
		// TODO Auto-generated constructor stub
		start_point = start;
		end_point = end;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int dx = end_point.x - start_point.x, dy = end_point.y - start_point.y;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + start_point.x;
        ym = xm*sin + ym*cos + start_point.y;
        xm = x;

        x = xn*cos - yn*sin + start_point.x;
        yn = xn*sin + yn*cos + start_point.y;
        xn = x;

        int[] xpoints = {end_point.x, (int) xm, (int) xn};
        int[] ypoints = {end_point.y, (int) ym, (int) yn};

        g.fillPolygon(xpoints, ypoints, 3);
		
	}

}
