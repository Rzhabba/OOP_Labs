package mypackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
//import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myclass implements Runnable {
	private JPanel panel;
	private int step;
	private int size;
	private int x0;
	private int y0;
	
	public myclass(JPanel panel, int step, int size, int x0, int y0) {
		super();
		this.panel = panel;
		this.step = step;
		this.size = size;
		this.x0 =x0;
		this.y0=y0;
	}
	
	public void run() {
		int x = x0; int y= y0; int xdir =+1; int ydir =+1;
	
		panel.setBackground(Color.GRAY);
		Graphics gr = panel.getGraphics();
		while (true) {
			
			gr.setColor(Color.GREEN);
			gr.fillOval(x, y, size, size);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			
			gr.setColor(Color.GRAY);
			gr.fillOval(x, y, size, size);
			
			if (x>panel.getWidth()- size) {xdir=-1;}
			if (x< size) {xdir =+1;}
			if (y> panel.getHeight()- size) { ydir= -1;}
			if (y<size) {ydir= +1;}
			x+=xdir * step; y+= ydir*step;
}
	}
	
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocation(200, 200);
		frame.setLayout(new GridLayout(0, 2));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3= new JPanel();
		JPanel panel4 = new JPanel();
		
		panel1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		
		frame.setVisible(true);
		
		myclass ball1 = new myclass(panel1, 1, 50, 200, 40);
		myclass ball2 = new myclass(panel2, 4, 10, 100, 50);
		myclass ball3 = new myclass(panel3, 8, 20, 20, 30);
		myclass ball4 = new myclass(panel4, 16, 30, 20, 30);
		
		new Thread(ball1).start();
		new Thread(ball2).start();
		new Thread(ball3).start();
		new Thread(ball4).start();
	}
	
	
}

