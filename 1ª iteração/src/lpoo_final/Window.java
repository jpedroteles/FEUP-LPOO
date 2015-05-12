package lpoo_final;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private JButton newGamebt;
	private JButton opts;
	private JButton quit;
	private JButton saveAndLoad;

	private JPanel panelButtons;
	
	private OptionsWindow options;
	private NewGameWindow	newGame;
	
	public Window(){
		setVisible(true);
		setTitle("Dungeon");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelButtons = new JPanel();
		panelButtons = new JPanel();
		
		options = new OptionsWindow();
		
		setUpButtons();
		getContentPane().setLayout(new BorderLayout(0, 0));
		addButtons();		
		pack();
	}
	
	private void setUpButtons() {
		newGamebt = new JButton("New Game");
		newGamebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Want to play a new game?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);
				if (res == JOptionPane.YES_OPTION) {
					newGame.startNewGame();				
				}
			}
		});
		
		saveAndLoad = new JButton("Save/Load");
		saveAndLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		
		//options = new JButton("Options");
		options.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				options.startOption();
			}
		});
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Are you sure you want to quit?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION) {
					System.exit(0);					
				}
			}
		});
	}
	
	private void addButtons() {
		//Puts this buttons on the top page
		panelButtons.add(newGamebt);
		panelButtons.add(saveAndLoad);		
		getContentPane().add(panelButtons, BorderLayout.NORTH);		
		
		//Puts this buttons on the bottom page
		panelButtons.add(opts);
		panelButtons.add(quit);	
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}
	
	public void startGameFrame() {
		setSize(400, 400);

		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(size.width / 2 - getSize().width / 2, size.height / 2
				- getSize().height / 2);

		setVisible(true);
	}

	

}