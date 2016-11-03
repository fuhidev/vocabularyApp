package vocabulary.ui;

import java.awt.Point;

public interface MyTransparentListener {
	Point getLocation();
	void setLocation(Point p);
	void setPressed(boolean b);
	boolean isPressed();
	void hideWindows();
	void showWindows();
}
