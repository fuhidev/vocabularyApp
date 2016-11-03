package vocabulary.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.awt.AWTUtilities;

import vocabulary.controller.IChangeVocabulary;
import vocabulary.model.Vocabulary;

public class ss extends JFrame implements IChangeVocabulary {

	/**
	 * 
	 */
	private static final long serialVersionUID = -930402994022964928L;
	private JPanel contentPane;

	private JLabel lbWord;
	public Vocabulary data;
	private JLabel lbMean;
	private JPanel panel_1;

	public ss(Vocabulary data) throws HeadlessException {
		super();
		this.data = data;
		init();
	}

	private void show1() {
		contentPane.setBackground(new Color(240, 240, 240));
		panel_1.setBackground(new Color(240, 240, 240));
	}

	private void hide1() {
		contentPane.setBackground(new Color(0, 0, 0, 0));
		panel_1.setBackground(new Color(0, 0, 0, 0));
	}

	public void change(Vocabulary s) {
		System.out.println(s);
//		show1();
		lbWord.setText(s.getWord());
		lbMean.setText(s.getMean());
//		hide1();
	}

	/**
	 * Create the frame.
	 */
	public ss() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		panel.setLayout(fl_panel);

		JLabel btn = new JLabel(new ImageIcon("C:\\Users\\hph\\Desktop\\minimun.png"));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBorder(new LineBorder(new Color(255, 0, 0)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btn.setBorder(null);
			}
		});
		panel.add(btn);
		JLabel btnClose = new JLabel(new ImageIcon("C:\\Users\\hph\\Desktop\\Close_Icon-128.png"));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
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
		panel.add(btnClose);
		/*
		 * JButton btnNewButton_1 = new JButton();
		 * btnNewButton_1.setBorder(null); btnNewButton_1.setBackground(new
		 * Color(0, 0, 0, 0));
		 */
		/*
		 * btnNewButton_1.setIcon(new
		 * ImageIcon("C:\\Users\\hph\\Desktop\\close.png"));
		 * btnNewButton_1.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * System.out.println("A"); } }); panel.add(btnNewButton_1);
		 */

		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// System.out.println("center");
			}

		});
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		lbWord = new JLabel("hieu dep trai");
		lbWord.setHorizontalAlignment(SwingConstants.CENTER);
		lbWord.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lbWord);
		
		lbMean = new JLabel("mean");
		lbMean.setHorizontalAlignment(SwingConstants.CENTER);
		lbMean.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lbMean);
		setUndecorated(true);
		contentPane.setBackground(new Color(0, 0, 0, 0));
//		panel_1.setBackground(new Color(0, 0, 0, 0));
		AWTUtilities.setWindowOpaque(this, true);
	}
}
