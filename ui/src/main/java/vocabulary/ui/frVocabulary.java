package vocabulary.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.sun.awt.AWTUtilities;

import vocabulary.controller.IChangeVocabulary;
import vocabulary.model.Vocabulary;

public class frVocabulary extends JFrame implements IChangeVocabulary, MyTransparentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4821374715011261012L;
	private JPanel contentPane;
	private Vocabulary vocabulary;

	/**
	 * Create the frame.
	 */
	private boolean isShow = true;
	private boolean isPressed = false;
	private JLabel lblWord;

	private JLabel lbMean;
	private JPanel pnCenter;
	private JPanel pnNorth;
	private JLabel btnClose;

	private JLabel btnMinimize;
	private MouseListener mouseListener;

	private Color backgroundColor = new Color(240, 240, 240);
	private Color transparentColor = new Color(0, 0, 0, 0);

	public frVocabulary() {
		vocabulary = new Vocabulary("word", "mean");
		init();
		thread.start();
	}

	public frVocabulary(Vocabulary vocabulary) throws HeadlessException {
		super();
		this.vocabulary = vocabulary;
		init();
	}

	@Override
	public void change(Vocabulary v) {
		this.vocabulary = v;
//		this.disposePnCenter();

	}

	Thread thread = new Thread(()->
	{
		for(int i = 1;i<4;i++){
			if(i == 3)
				i=1;
			Vocabulary  v = new Vocabulary("word "+i, "mean " + i);
			this.changeVocabulary(v);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showCenter();
			disposePnCenter();
		}
	});
	
	private void changeVocabulary(Vocabulary v){
		lblWord.setText(v.getWord());
		lbMean.setText(v.getMean());
	}
	
	private void disposePnCenter() {
		this.contentPane.remove(pnCenter);
//		this.pnCenter = null;
//		initPnCenter();
	}

	private void hideCenter() {
		if (pnCenter.getBackground().equals(this.transparentColor))
			return;
		pnCenter.setBackground(this.transparentColor);
		isShowCenter = false;
	}

	private void hideNorth() {
//		if (pnNorth.getBackground().equals(this.transparentColor))
//			return;
//		pnNorth.setBackground(this.transparentColor);
//		btnClose.setVisible(false);
//		btnMinimize.setVisible(false);
		 pnNorth.setVisible(false);
	}

	private void excuteBackground() {
		if (!isShowCenter)
			hideCenter();
		else
			showCenter();
	}

	@Override
	public void hideWindows() {
		// setUndecorated(true);
		if (isPressed())
			return;
		if (!isShow)
			return;
		hideNorth();
		this.hideCenter();
		AWTUtilities.setWindowOpaque(this, false);
		isShow = false;
		contentPane.setBackground(this.transparentColor);
	}

	/*
	 * public frVocabulary() { init(); }
	 */
	private void init() {
		setType(Type.UTILITY);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Point loca = AppLocation.point;
		if (loca == null)
			loca = new Point(100, 100);
		setLocation(loca);
		setSize(322, 100);
		
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		mouseListener = new MyMouseListener(this);

		initPnCenter();

		initPnNorth();

		setUndecorated(true);
		hideWindows();
	}

	private boolean isShowCenter = true;

	private void initPnCenter() {
		contentPane.setLayout(null);
		pnCenter = new JPanel();
		pnCenter.setBounds(0, 38, 322, 62);
//		excuteBackground();
		contentPane.add(pnCenter);
		pnCenter.setLayout(new GridLayout(0, 1, 0, 0));
		lblWord = new JLabel(vocabulary.getWord());
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		// lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lblWord);
		lblWord.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMean = new JLabel(vocabulary.getMean());
		lbMean.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbMean);
		lbMean.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnCenter.addMouseListener(mouseListener);
		hideCenter();
	}

	private void initPnNorth() {
		pnNorth = new JPanel();
		pnNorth.setBounds(0, 0, 322, 38);
		FlowLayout fl_pnNorth = (FlowLayout) pnNorth.getLayout();
		fl_pnNorth.setAlignment(FlowLayout.RIGHT);
		

		btnMinimize = new JLabel(new ImageIcon("C:\\Users\\hph\\Desktop\\minimun.png"));
		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimize.setBorder(new LineBorder(new Color(255, 0, 0)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMinimize.setBorder(null);
			}
		});
		pnNorth.add(btnMinimize);

		btnClose = new JLabel(new ImageIcon("C:\\Users\\hph\\Desktop\\Close_Icon-128.png"));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				System.exit(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setBorder(new LineBorder(new Color(255, 0, 0)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnClose.setBorder(null);
			}
		});
		pnNorth.add(btnClose);

		pnNorth.addMouseListener(mouseListener);
		btnClose.addMouseListener(mouseListener);
		btnMinimize.addMouseListener(mouseListener);
		contentPane.add(pnNorth);
	}

	@Override
	public boolean isPressed() {
		return isPressed;
	}

	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		super.setLocation(p);
		AppLocation.point = this.getLocation();
	}

	@Override
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

	private void showCenter() {
		if (pnCenter.getBackground().equals(this.backgroundColor))
			return;
		pnCenter.setBackground(this.backgroundColor);
	}

	private void showNorth() {
//		if (pnNorth.getBackground().equals(backgroundColor))
//			return;
//		btnClose.setVisible(true);
//		btnMinimize.setVisible(true);
//		pnNorth.setBackground(this.backgroundColor);
		 pnNorth.setVisible(true);
	}

	@Override
	public void showWindows() {
		// setUndecorated(false);
		if (isShow)
			return;
		showNorth();
		this.showCenter();
		AWTUtilities.setWindowOpaque(this, true);
		isShow = true;
		contentPane.setBackground(this.backgroundColor);
	}

}
