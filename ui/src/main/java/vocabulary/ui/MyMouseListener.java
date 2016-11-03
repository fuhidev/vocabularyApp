package vocabulary.ui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
	private Point pOld;
	private MyTransparentListener view;
	
	

	public MyMouseListener(MyTransparentListener view) {
		super();
		this.view = view;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		double x = e.getX()-pOld.getX();
		double y = e.getY()-pOld.getY();
		Point oldLoca = view.getLocation();
		Point newLoca = new Point((int)(oldLoca.getX() + x), (int)(oldLoca.getY() + y));
		view.setLocation(newLoca);
		view.setPressed(false);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		pOld = e.getPoint();
		view.setPressed(true);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		view.hideWindows();
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		view.showWindows();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
