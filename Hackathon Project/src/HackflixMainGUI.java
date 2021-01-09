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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;

public class HackflixMainGUI {

	private JFrame frmHackflix;
	private JTextField txtQuickSearch;
	private final Action action = new SwingAction();
	private JTextField txtTypeKeywordHere;
	boolean movies = false;
	boolean tvshow = false;
	boolean both = false;

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
		
		JPanel search_panel = new JPanel();
		search_panel.setBounds(0, 0, 800, 500);
		search_panel.setBackground(Color.BLACK);
		search_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(search_panel);
		search_panel.setVisible(false);
		
		JPanel grid_panel = new JPanel();
		grid_panel.setBackground(Color.BLACK);
		search_panel.add(grid_panel);
		GridBagLayout gbl_grid_panel = new GridBagLayout();
		gbl_grid_panel.columnWidths = new int[]{50, 100, 100, 100, 50, 50};
		gbl_grid_panel.rowHeights = new int[]{100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0};
		gbl_grid_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_grid_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		grid_panel.setLayout(gbl_grid_panel);
		
		JLabel title_label = new JLabel("");
		GridBagConstraints gbc_title_label = new GridBagConstraints();
		gbc_title_label.insets = new Insets(0, 0, 5, 5);
		gbc_title_label.gridx = 2;
		gbc_title_label.gridy = 1;
		grid_panel.add(title_label, gbc_title_label);
		title_label.setIcon(new ImageIcon("movies.png"));
		
		JLabel genre_label = new JLabel("Genre");
		genre_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_genre_label = new GridBagConstraints();
		gbc_genre_label.insets = new Insets(0, 0, 5, 5);
		gbc_genre_label.gridx = 1;
		gbc_genre_label.gridy = 3;
		grid_panel.add(genre_label, gbc_genre_label);
		
		JLabel release_year_label = new JLabel("Release Year");
		release_year_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_release_year_label = new GridBagConstraints();
		gbc_release_year_label.insets = new Insets(0, 0, 5, 5);
		gbc_release_year_label.gridx = 2;
		gbc_release_year_label.gridy = 3;
		grid_panel.add(release_year_label, gbc_release_year_label);
		
		JLabel rating_label = new JLabel("Rating");
		rating_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_rating_label = new GridBagConstraints();
		gbc_rating_label.insets = new Insets(0, 0, 5, 5);
		gbc_rating_label.gridx = 3;
		gbc_rating_label.gridy = 3;
		grid_panel.add(rating_label, gbc_rating_label);
		
		JComboBox genre_combobox = new JComboBox();
		genre_label.setLabelFor(genre_combobox);
		genre_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_genre_combobox = new GridBagConstraints();
		gbc_genre_combobox.fill = GridBagConstraints.VERTICAL;
		gbc_genre_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_genre_combobox.gridx = 1;
		gbc_genre_combobox.gridy = 4;
		grid_panel.add(genre_combobox, gbc_genre_combobox);
		
		JComboBox releaseyear_combobox = new JComboBox();
		release_year_label.setLabelFor(releaseyear_combobox);
		releaseyear_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_releaseyear_combobox = new GridBagConstraints();
		gbc_releaseyear_combobox.fill = GridBagConstraints.BOTH;
		gbc_releaseyear_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_releaseyear_combobox.gridx = 2;
		gbc_releaseyear_combobox.gridy = 4;
		grid_panel.add(releaseyear_combobox, gbc_releaseyear_combobox);
		
		JComboBox rating_combobox = new JComboBox();
		rating_label.setLabelFor(rating_combobox);
		rating_combobox.setModel(new DefaultComboBoxModel(new String[] {"Combobox"}));
		GridBagConstraints gbc_rating_combobox = new GridBagConstraints();
		gbc_rating_combobox.fill = GridBagConstraints.BOTH;
		gbc_rating_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_rating_combobox.gridx = 3;
		gbc_rating_combobox.gridy = 4;
		grid_panel.add(rating_combobox, gbc_rating_combobox);
		
		JLabel director_label = new JLabel("Director");
		director_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_director_label = new GridBagConstraints();
		gbc_director_label.insets = new Insets(0, 0, 5, 5);
		gbc_director_label.gridx = 1;
		gbc_director_label.gridy = 6;
		grid_panel.add(director_label, gbc_director_label);
		
		JLabel cast_label = new JLabel("Cast");
		cast_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_cast_label = new GridBagConstraints();
		gbc_cast_label.insets = new Insets(0, 0, 5, 5);
		gbc_cast_label.gridx = 2;
		gbc_cast_label.gridy = 6;
		grid_panel.add(cast_label, gbc_cast_label);
		
		JLabel duration_label = new JLabel("Duration");
		duration_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_duration_label = new GridBagConstraints();
		gbc_duration_label.insets = new Insets(0, 0, 5, 5);
		gbc_duration_label.gridx = 3;
		gbc_duration_label.gridy = 6;
		grid_panel.add(duration_label, gbc_duration_label);
		
		JComboBox director_combobox = new JComboBox();
		director_label.setLabelFor(director_combobox);
		director_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_director_combobox = new GridBagConstraints();
		gbc_director_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_director_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_director_combobox.gridx = 1;
		gbc_director_combobox.gridy = 7;
		grid_panel.add(director_combobox, gbc_director_combobox);
		
		JComboBox cast_combobox = new JComboBox();
		cast_label.setLabelFor(cast_combobox);
		cast_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_cast_combobox = new GridBagConstraints();
		gbc_cast_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_cast_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cast_combobox.gridx = 2;
		gbc_cast_combobox.gridy = 7;
		grid_panel.add(cast_combobox, gbc_cast_combobox);
		
		JComboBox duration_combobox = new JComboBox();
		duration_label.setLabelFor(duration_combobox);
		duration_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_duration_combobox = new GridBagConstraints();
		gbc_duration_combobox.fill = GridBagConstraints.BOTH;
		gbc_duration_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_duration_combobox.gridx = 3;
		gbc_duration_combobox.gridy = 7;
		grid_panel.add(duration_combobox, gbc_duration_combobox);
		
		JLabel keyword_label = new JLabel("Keyword");
		keyword_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_keyword_label = new GridBagConstraints();
		gbc_keyword_label.insets = new Insets(0, 0, 5, 5);
		gbc_keyword_label.gridx = 2;
		gbc_keyword_label.gridy = 9;
		grid_panel.add(keyword_label, gbc_keyword_label);
		
		txtTypeKeywordHere = new JTextField();
		keyword_label.setLabelFor(txtTypeKeywordHere);
		txtTypeKeywordHere.setText("Type Keyword Here");
		GridBagConstraints gbc_txtTypeKeywordHere = new GridBagConstraints();
		gbc_txtTypeKeywordHere.insets = new Insets(0, 0, 5, 5);
		gbc_txtTypeKeywordHere.fill = GridBagConstraints.BOTH;
		gbc_txtTypeKeywordHere.gridx = 2;
		gbc_txtTypeKeywordHere.gridy = 10;
		grid_panel.add(txtTypeKeywordHere, gbc_txtTypeKeywordHere);
		txtTypeKeywordHere.setColumns(10);
		
		JButton btnNewButton = new JButton("Find my recs!");
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Search button pressed!");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 12;
		grid_panel.add(btnNewButton, gbc_btnNewButton);
		
		JPanel results_panel = new JPanel();
		results_panel.setBounds(0, 0, 800, 500);
		results_panel.setBackground(Color.BLACK);
		panel.add(results_panel);
		results_panel.setVisible(false);
		
		JPanel main_panel = new JPanel();
		main_panel.setBounds(0, 0, 800, 500);
		main_panel.setBackground(Color.BLACK);
		main_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(main_panel);
		
		JPanel main_panel2 = new JPanel();
		main_panel.add(main_panel2);
		main_panel2.setBounds(0, 0, 800, 500);
		main_panel2.setBackground(Color.BLACK);
		main_panel2.setPreferredSize(new Dimension(800, 500));
		GridBagLayout gbl_main_panel2 = new GridBagLayout();
		gbl_main_panel2.rowWeights = new double[]{0.0, 0.7, 0.2, 0.5, 1.0, 1.0, 0.0};
		gbl_main_panel2.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_main_panel2.columnWidths = new int[]{100, 100, 100};
		gbl_main_panel2.rowHeights = new int[]{100, 137, 30, 50, 0, 50, 100};
		main_panel2.setLayout(gbl_main_panel2);
		
		JPanel hackflix_logo = new JPanel();
		hackflix_logo.setBackground(Color.BLACK);
		hackflix_logo.setLayout(null);
		GridBagConstraints gbc_hackflix_logo = new GridBagConstraints();
		gbc_hackflix_logo.insets = new Insets(0, 0, 5, 5);
		gbc_hackflix_logo.fill = GridBagConstraints.BOTH;
		gbc_hackflix_logo.gridx = 1;
		gbc_hackflix_logo.gridy = 1;
		main_panel2.add(hackflix_logo, gbc_hackflix_logo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(145, 16, 323, 96);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("hackflix.png").getImage().getScaledInstance(330, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		
		hackflix_logo.add(lblNewLabel);
		
		JPanel hackflix_quote = new JPanel();
		hackflix_quote.setBackground(Color.BLACK);
		GridBagConstraints gbc_hackflix_quote = new GridBagConstraints();
		gbc_hackflix_quote.insets = new Insets(0, 0, 5, 5);
		gbc_hackflix_quote.fill = GridBagConstraints.BOTH;
		gbc_hackflix_quote.gridx = 1;
		gbc_hackflix_quote.gridy = 2;
		main_panel2.add(hackflix_quote, gbc_hackflix_quote);
		
		JLabel hackflix_string = new JLabel("Find your next quarantine entertainment.");
		hackflix_string.setFont(new Font("Gill Sans", Font.PLAIN, 16));
		hackflix_string.setForeground(Color.WHITE);
		hackflix_quote.add(hackflix_string);
		
		JPanel main_buttons = new JPanel();
		main_buttons.setBackground(Color.BLACK);
		GridBagConstraints gbc_main_buttons = new GridBagConstraints();
		gbc_main_buttons.insets = new Insets(0, 0, 5, 5);
		gbc_main_buttons.fill = GridBagConstraints.BOTH;
		gbc_main_buttons.gridx = 1;
		gbc_main_buttons.gridy = 3;
		main_panel2.add(main_buttons, gbc_main_buttons);
		main_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton movie_button = new JButton("Movies");
		movie_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		movie_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				movies = true;
				ImageIcon typeFont = new ImageIcon(new ImageIcon("movies.png").getImage().getScaledInstance(125, 50, Image.SCALE_SMOOTH));
				title_label.setIcon(typeFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		main_buttons.add(movie_button);
		
		JButton show_button = new JButton("TV Shows");
		show_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		show_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				tvshow = true;
				ImageIcon typeFont = new ImageIcon(new ImageIcon("tvshows.png").getImage().getScaledInstance(125, 50, Image.SCALE_SMOOTH));
				title_label.setIcon(typeFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		main_buttons.add(show_button);
		
		JButton both_button = new JButton("Both");
		both_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				both = true;
				ImageIcon typeFont = new ImageIcon(new ImageIcon("moviesAndTV.png").getImage().getScaledInstance(125, 50, Image.SCALE_SMOOTH));
				title_label.setIcon(typeFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		both_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		main_buttons.add(both_button);
		
		JPanel quick_search = new JPanel();
		quick_search.setBackground(Color.BLACK);
		GridBagConstraints gbc_quick_search = new GridBagConstraints();
		gbc_quick_search.insets = new Insets(0, 0, 5, 5);
		gbc_quick_search.fill = GridBagConstraints.BOTH;
		gbc_quick_search.gridx = 1;
		gbc_quick_search.gridy = 4;
		main_panel2.add(quick_search, gbc_quick_search);
		quick_search.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtQuickSearch = new JTextField();
		txtQuickSearch.setText("Quick Search");
		txtQuickSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creates quick search window when user presses Enter after typing wine name
				main_panel.setVisible(false);
				results_panel.setVisible(true);
				
				String textSearchString = txtQuickSearch.getText();
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Quick search used!");
			}
		});
		quick_search.add(txtQuickSearch);
		txtQuickSearch.setColumns(10);
		
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