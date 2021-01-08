import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;

public class HackflixMainGUI {

	private JFrame frmHackflix;
	private JTextField txtQuickSearch;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HackflixMainGUI window = new HackflixMainGUI();
					window.frmHackflix.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HackflixMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmHackflix = new JFrame();
		frmHackflix.setTitle("Hackflix");
		frmHackflix.setBackground(Color.DARK_GRAY);
		frmHackflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHackflix.getContentPane().setLayout(new BorderLayout(0, 0));
		frmHackflix.getContentPane().setSize(800,400);
		frmHackflix.setResizable(false);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(800, 500));
		frmHackflix.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel movie_search_panel = new JPanel();
		movie_search_panel.setBounds(0, 0, 800, 500);
		movie_search_panel.setBackground(Color.BLACK);
		movie_search_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(movie_search_panel);
		
		JPanel main_panel = new JPanel();
		movie_search_panel.add(main_panel);
		main_panel.setBounds(0, 0, 800, 500);
		main_panel.setBackground(Color.BLACK);
		main_panel.setPreferredSize(new Dimension(800, 500));
		GridBagLayout gbl_main_panel = new GridBagLayout();
		gbl_main_panel.rowWeights = new double[]{0.0, 0.7, 0.2, 0.5, 1.0, 1.0, 0.0};
		gbl_main_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_main_panel.columnWidths = new int[]{100, 100, 100};
		gbl_main_panel.rowHeights = new int[]{100, 137, 30, 50, 0, 50, 100};
		main_panel.setLayout(gbl_main_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		main_panel.add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(145, 16, 323, 96);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("hackflix.png").getImage().getScaledInstance(330, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		main_panel.add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Find your next quarantine entertainment.");
		lblNewLabel_1.setFont(new Font("Gill Sans", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		main_panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton movie_button = new JButton("Movies");
		movie_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		movie_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Movie button pressed!");
			}
		});
		panel_3.add(movie_button);
		
		JButton show_button = new JButton("TV Shows");
		show_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		show_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "TV show button pressed!");
			}
		});
		panel_3.add(show_button);
		
		JButton both_button = new JButton("Both");
		both_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Both button pressed!");
			}
		});
		both_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		panel_3.add(both_button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 4;
		main_panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtQuickSearch = new JTextField();
		txtQuickSearch.setText("Quick Search");
		panel_4.add(txtQuickSearch);
		txtQuickSearch.setColumns(10);

		JPanel tvshow_search_panel = new JPanel();
		tvshow_search_panel.setBounds(0, 0, 800, 500);
		tvshow_search_panel.setBackground(Color.BLACK);
		tvshow_search_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(tvshow_search_panel);
		
		JPanel both_search_panel = new JPanel();
		both_search_panel.setBounds(0, 0, 800, 500);
		both_search_panel.setBackground(Color.BLACK);
		both_search_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(both_search_panel);
		
		JPanel results_panel = new JPanel();
		results_panel.setBounds(0, 0, 800, 500);
		results_panel.setBackground(Color.BLACK);
		panel.add(results_panel);
		frmHackflix.pack();
		frmHackflix.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
