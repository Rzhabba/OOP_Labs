package mypackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JToggleButton;
import javax.swing.KeyStroke;


public class MyClass2 extends JFrame {
	private static final long serialVersionUID = 1L;
	public MyClass2 () {
		super ("Заявка по банкам");
		setSize(500, 650);
		setLocation(200,200);
		setLayout(new BorderLayout());
		
		createMenubar();
		createToolbar();
		createListsPanel();
		//createButtonsPanel();
		createToolbarListeners();
		createButtonsListener();
		
	}
	
	
	//public class Starter {
		public static void main(String[] args) {
			new MyClass2().setVisible(true);
		}
	//}
	
	private void createMenubar(){
		JMenuBar menubar= new JMenuBar();
		setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenuItem exitItem= new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(getParent(),
						"Точно выход?", "Да",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null);
				if(option == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		fileMenu.add(exitItem);
	}
	
	private JButton resetButton, saveButton;
	
	private void createToolbar() {
		saveButton = new JButton("Save");
		resetButton= new JButton("Reset");
		JPanel toolbar= new JPanel();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toolbar.add(saveButton);
		toolbar.add(resetButton);
		add(toolbar, BorderLayout.NORTH);
	}
	
	
	public class BeerCans{
		private static final String[] BEER= new String[] {
				"Гиганты", "Peak", "Легенда 13", "Алтай-Марс", "Ozzzero",
				"Черный берег", "Luchador", "Criminals", "Sour Ale Passion Fruit",
				"Тайга", "Хао Бу Хао", "Redline", "Semi-dry Cider", "Протагонист",
				"Stone Run", "Ozzzero zero", "NEPA:Citra, Sabro, Taulus", "Citrus Clash",
				"Роберт 2026", "Liffey Dark", "Призрак Оперы", "Marzen", "Rocks", "Декабрист"
		};
		
		public static String[] getBEER() {
			return BEER;
		}

	}
	
	private DefaultListModel <String> beermodel, itogmodel;
	private JList<String> beerlist, itoglist;
	
	private JPanel createButtonsPanel() {
		JPanel buttonsPanel= new JPanel();
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonsPanel.setLayout(new GridLayout(4,0));
		takeButton= new JButton(">");
		takeButton.setToolTipText("Добавить выделенное");
		takeAllButton= new JButton(">>");
		takeAllButton.setToolTipText("Выбрать все");
		returnButton= new JButton("<");
		returnButton.setToolTipText("Вернуть выделенное");
		returnAllButton= new JButton("<<");
		returnAllButton.setToolTipText("Вернуть все");
		buttonsPanel.add(takeButton);
		buttonsPanel.add(takeAllButton);
		buttonsPanel.add(returnButton);
		buttonsPanel.add(returnAllButton);
		return buttonsPanel;
	}
	
	private void createListsPanel() {
		beermodel= new DefaultListModel<String>();
		for (String beer : BeerCans.getBEER()) {
			beermodel.addElement(beer);
		}
		itogmodel= new DefaultListModel<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		beerlist= new JList<String>(beermodel);
		beerlist.setToolTipText("Доступное пиво");
		beerlist.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itoglist= new JList<String>(itogmodel);
		itoglist.setToolTipText("Выбранное пиво");
		itoglist.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(beerlist);
		panel.add(createButtonsPanel());
		panel.add(itoglist);
		add(panel, BorderLayout.CENTER);
		
	}
	
	private JButton takeButton, returnButton, takeAllButton, returnAllButton;
	
	private void createButtonsListener() {
		takeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection= beerlist.getSelectedValuesList();
				for (String beer : selection) {
					itogmodel.addElement(beer);
				}
				
				for (String beer: selection) {
					beermodel.removeElement(beer);
				}
			}
		});
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection = itoglist.getSelectedValuesList();
				for(String beer: selection) {
					beermodel.addElement(beer);
					itogmodel.removeElement(beer);
				}
			}
		});
		
		takeAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements = beermodel.elements();
				while(elements.hasMoreElements()) {
					String next = elements.nextElement();
					itogmodel.addElement(next);
				}
				beermodel.removeAllElements();
			}
		});
		
		returnAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements= itogmodel.elements();
				while (elements.hasMoreElements()) {
					String next= elements.nextElement();
					beermodel.addElement(next);
				}
				itogmodel.removeAllElements();
				}
		});
	}
	
	private void createToolbarListeners() {
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String all ="";
				Enumeration<String> elements= itogmodel.elements();
				while(elements.hasMoreElements()) {
					all+= elements.nextElement() + "\n";
				}
				JOptionPane.showMessageDialog(getParent(), all,
						"Выбраны следующие позиции:",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		resetButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itogmodel.removeAllElements();
				beermodel.removeAllElements();
				for (String beer : BeerCans.getBEER()) {
					beermodel.addElement(beer);
				}
			}
		});
	}
}
