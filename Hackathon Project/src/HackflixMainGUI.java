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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class HackflixMainGUI {

	private JFrame frmHackflix;
	private JTextField txtQuickSearch;
	private final Action action = new SwingAction();
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
		
		JPanel results_panel = new JPanel();
		results_panel.setBounds(0, 0, 800, 500);
		results_panel.setBackground(new Color(255, 255, 255));
		results_panel.setPreferredSize(new Dimension(600, 800));
		panel.add(results_panel);
		results_panel.setVisible(false);
		
		JPanel results_grid_panel = new JPanel();
		results_grid_panel.setBackground(new Color(255, 255, 255));
		results_panel.add(results_grid_panel);
		GridBagLayout gbl_results_grid_panel = new GridBagLayout();
		gbl_results_grid_panel.columnWidths = new int[]{0, 70, 325, 70, 0};
		gbl_results_grid_panel.rowHeights = new int[]{20, 120, 0, 450};
		gbl_results_grid_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0};
		gbl_results_grid_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0};
		results_grid_panel.setLayout(gbl_results_grid_panel);
		
		JLabel result_title_image_label = new JLabel("");
		result_title_image_label.setHorizontalAlignment(JLabel.CENTER);
		result_title_image_label.setVerticalAlignment(JLabel.CENTER);
		ImageIcon netflix_quote = new ImageIcon(new ImageIcon("netflix_quote.jpg").getImage().getScaledInstance(300, 175, Image.SCALE_SMOOTH));
		result_title_image_label.setIcon(netflix_quote);
		
		GridBagConstraints gbc_result_title_image_label = new GridBagConstraints();
		gbc_result_title_image_label.insets = new Insets(0, 0, 5, 5);
		gbc_result_title_image_label.gridx = 2;
		gbc_result_title_image_label.gridy = 1;
		results_grid_panel.add(result_title_image_label, gbc_result_title_image_label);
		
		JPanel sort_by_panel = new JPanel();
		sort_by_panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_sort_by_panel = new GridBagConstraints();
		gbc_sort_by_panel.insets = new Insets(0, 0, 5, 5);
		gbc_sort_by_panel.fill = GridBagConstraints.BOTH;
		gbc_sort_by_panel.gridx = 2;
		gbc_sort_by_panel.gridy = 2;
		results_grid_panel.add(sort_by_panel, gbc_sort_by_panel);
		
		JLabel sort_by_label = new JLabel("Sort By:");
		sort_by_label.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		sort_by_panel.add(sort_by_label);
		
		JComboBox sort_by_combobox = new JComboBox();
		sort_by_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		sort_by_panel.add(sort_by_combobox);
		
		
		JScrollPane results_scrollPane = new JScrollPane();
		results_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		results_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_results_scrollPane = new GridBagConstraints();
		gbc_results_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_results_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_results_scrollPane.gridx = 1;
		gbc_results_scrollPane.gridy = 3;
		gbc_results_scrollPane.gridwidth = 3;
		results_scrollPane.getViewport().setBackground(Color.GRAY);
		results_grid_panel.add(results_scrollPane, gbc_results_scrollPane);
		
		//JTextArea txtrLoremIpsumDolor = new JTextArea();
		//txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed facilisis eget libero et consequat. Sed imperdiet purus vel elementum dapibus. Integer eget libero imperdiet, mattis tellus vel, semper nunc. Donec congue sollicitudin risus vel ultricies. Sed malesuada euismod orci, ac tristique sem ornare at. Phasellus sit amet sem quis turpis mollis elementum sed vel metus. Vestibulum finibus at lacus ornare mollis. Phasellus a feugiat lacus, sed consectetur odio. Nulla tincidunt eu tellus et euismod. Suspendisse nisi erat, dignissim at egestas et, congue laoreet quam. Pellentesque in tortor suscipit, fermentum magna eu, fermentum nisi. Curabitur ut auctor metus.\n\nFusce consectetur tellus dolor, ut lacinia nisi eleifend ut. Nunc fermentum, eros ut mattis volutpat, tellus enim lobortis mi, a mattis nunc nisl sit amet quam. Sed facilisis lacus vitae leo pretium eleifend. Nullam pulvinar orci sed egestas bibendum. Pellentesque vel semper nisl, eu tempor purus. Fusce vestibulum sit amet leo eu bibendum. Phasellus ut nisl tincidunt est sodales lobortis. Integer neque tortor, posuere rhoncus tellus vel, tincidunt tincidunt elit. Aliquam nunc ante, varius sed turpis a, facilisis sollicitudin purus. Praesent eget imperdiet orci. Donec a semper urna, sit amet condimentum turpis.\n\nProin tempus consequat porttitor. Duis efficitur gravida libero, sit amet tincidunt erat pulvinar placerat. Nulla vel urna gravida, blandit diam in, euismod dui. Donec auctor vulputate arcu condimentum egestas. Nulla facilisi. Donec id nunc ac tellus pulvinar varius. Vestibulum consectetur posuere ante in fermentum. Fusce at vestibulum velit, id porta elit. Sed vel est porttitor, fringilla enim at, interdum orci. Etiam molestie eros lorem, et interdum justo auctor ullamcorper. Donec vitae tristique ipsum, et volutpat neque. Curabitur aliquam enim est, et lacinia ante cursus vitae. Ut arcu velit, commodo ac porta eu, mattis quis tellus. Mauris vel lacus ut ex eleifend pharetra hendrerit eget sapien. Nulla pharetra, risus vel sagittis iaculis, ligula sapien placerat lectus, suscipit placerat magna risus id massa.\n\nProin finibus porta sapien, cursus hendrerit elit mattis a. Integer sem sem, tempor sit amet urna at, fermentum consequat est. Nunc consequat metus feugiat porttitor consequat. Duis sit amet lorem sapien. Nunc id ex id dui semper accumsan at quis urna. Duis laoreet metus iaculis nibh consequat, et egestas magna porttitor. Cras in auctor augue. Sed purus metus, facilisis eget nunc id, lacinia viverra ligula. Nam nec turpis nunc. Mauris nec sagittis felis. Quisque quis dignissim nisi. Morbi a arcu quis massa fermentum fringilla vitae eget turpis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus euismod et mi non molestie. Aliquam erat volutpat.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id sodales risus. Ut vestibulum eros id placerat iaculis. Morbi quis tempor ante. Curabitur sed lacinia est. Nulla facilisi. Vestibulum id pretium neque. Curabitur vel pellentesque dolor. Mauris porttitor risus a tellus fringilla, ut finibus enim tempor. Nunc ex velit, pellentesque in dui ac, dictum vehicula metus.");
		//results_scrollPane.setColumnHeaderView(txtrLoremIpsumDolor);
		
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
		gbl_grid_panel.columnWidths = new int[]{50, 100, 100, 100, 50};
		gbl_grid_panel.rowHeights = new int[]{100, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0};
		gbl_grid_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0};
		gbl_grid_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		grid_panel.setLayout(gbl_grid_panel);
		
		JLabel movie_or_tv_title_label = new JLabel("");
		GridBagConstraints gbc_movie_or_tv_title_label = new GridBagConstraints();
		gbc_movie_or_tv_title_label.insets = new Insets(0, 0, 5, 5);
		//gbc_title_label.insets = new Insets(0, 0, 5, 5);
		gbc_movie_or_tv_title_label.gridx = 1;
		gbc_movie_or_tv_title_label.gridy = 1;
		gbc_movie_or_tv_title_label.gridwidth = 3;
		grid_panel.add(movie_or_tv_title_label, gbc_movie_or_tv_title_label);
		movie_or_tv_title_label.setIcon(new ImageIcon("movies.png"));
		
		JLabel genre_label = new JLabel("Genre");
		genre_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_genre_label = new GridBagConstraints();
		gbc_genre_label.insets = new Insets(0, 0, 5, 5);
		gbc_genre_label.gridx = 1;
		gbc_genre_label.gridy = 4;
		grid_panel.add(genre_label, gbc_genre_label);
		
		JLabel release_year_label = new JLabel("Release Year");
		release_year_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_release_year_label = new GridBagConstraints();
		gbc_release_year_label.insets = new Insets(0, 0, 5, 5);
		gbc_release_year_label.gridx = 2;
		gbc_release_year_label.gridy = 4;
		grid_panel.add(release_year_label, gbc_release_year_label);
		
		JLabel rating_label = new JLabel("Rating");
		rating_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_rating_label = new GridBagConstraints();
		gbc_rating_label.insets = new Insets(0, 0, 5, 5);
		gbc_rating_label.gridx = 3;
		gbc_rating_label.gridy = 4;
		grid_panel.add(rating_label, gbc_rating_label);
		
		JComboBox genre_combobox = new JComboBox();
		genre_combobox.setBackground(new Color(0, 0, 0));
		genre_label.setLabelFor(genre_combobox);
		genre_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_genre_combobox = new GridBagConstraints();
		gbc_genre_combobox.fill = GridBagConstraints.VERTICAL;
		gbc_genre_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_genre_combobox.gridx = 1;
		gbc_genre_combobox.gridy = 5;
		grid_panel.add(genre_combobox, gbc_genre_combobox);
		
		JComboBox releaseyear_combobox = new JComboBox();
		releaseyear_combobox.setBackground(new Color(0, 0, 0));
		release_year_label.setLabelFor(releaseyear_combobox);
		releaseyear_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_releaseyear_combobox = new GridBagConstraints();
		gbc_releaseyear_combobox.fill = GridBagConstraints.BOTH;
		gbc_releaseyear_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_releaseyear_combobox.gridx = 2;
		gbc_releaseyear_combobox.gridy = 5;
		grid_panel.add(releaseyear_combobox, gbc_releaseyear_combobox);
		
		JComboBox rating_combobox = new JComboBox();
		rating_combobox.setBackground(new Color(0, 0, 0));
		rating_label.setLabelFor(rating_combobox);
		rating_combobox.setModel(new DefaultComboBoxModel(new String[] {"Combobox"}));
		GridBagConstraints gbc_rating_combobox = new GridBagConstraints();
		gbc_rating_combobox.fill = GridBagConstraints.BOTH;
		gbc_rating_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_rating_combobox.gridx = 3;
		gbc_rating_combobox.gridy = 5;
		grid_panel.add(rating_combobox, gbc_rating_combobox);
		
		JLabel director_label = new JLabel("Director");
		director_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_director_label = new GridBagConstraints();
		gbc_director_label.insets = new Insets(0, 0, 5, 5);
		gbc_director_label.gridx = 1;
		gbc_director_label.gridy = 7;
		grid_panel.add(director_label, gbc_director_label);
		
		JLabel cast_label = new JLabel("Cast");
		cast_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_cast_label = new GridBagConstraints();
		gbc_cast_label.insets = new Insets(0, 0, 5, 5);
		gbc_cast_label.gridx = 2;
		gbc_cast_label.gridy = 7;
		grid_panel.add(cast_label, gbc_cast_label);
		
		JLabel duration_label = new JLabel("Duration");
		duration_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_duration_label = new GridBagConstraints();
		gbc_duration_label.insets = new Insets(0, 0, 5, 5);
		gbc_duration_label.gridx = 3;
		gbc_duration_label.gridy = 7;
		grid_panel.add(duration_label, gbc_duration_label);
		
		JComboBox director_combobox = new JComboBox();
		director_combobox.setBackground(new Color(0, 0, 0));
		director_label.setLabelFor(director_combobox);
		director_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_director_combobox = new GridBagConstraints();
		gbc_director_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_director_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_director_combobox.gridx = 1;
		gbc_director_combobox.gridy = 8;
		grid_panel.add(director_combobox, gbc_director_combobox);
		
		JComboBox cast_combobox = new JComboBox();
		cast_combobox.setBackground(new Color(0, 0, 0));
		cast_label.setLabelFor(cast_combobox);
		cast_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_cast_combobox = new GridBagConstraints();
		gbc_cast_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_cast_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cast_combobox.gridx = 2;
		gbc_cast_combobox.gridy = 8;
		grid_panel.add(cast_combobox, gbc_cast_combobox);
		
		JComboBox duration_combobox = new JComboBox();
		duration_combobox.setBackground(new Color(0, 0, 0));
		duration_label.setLabelFor(duration_combobox);
		duration_combobox.setModel(new DefaultComboBoxModel(new String[] {"ComboBox"}));
		GridBagConstraints gbc_duration_combobox = new GridBagConstraints();
		gbc_duration_combobox.fill = GridBagConstraints.BOTH;
		gbc_duration_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_duration_combobox.gridx = 3;
		gbc_duration_combobox.gridy = 8;
		grid_panel.add(duration_combobox, gbc_duration_combobox);
		
		JLabel country_label = new JLabel("Country");
		country_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_country_label = new GridBagConstraints();
		gbc_country_label.insets = new Insets(0, 0, 5, 5);
		gbc_country_label.gridx = 2;
		gbc_country_label.gridy = 10;
		grid_panel.add(country_label, gbc_country_label);
		
		JButton find_my_rec_button = new JButton("Find my recs!");
		find_my_rec_button.setBackground(new Color(128, 0, 0));
		find_my_rec_button.setForeground(new Color(255, 255, 255));
		find_my_rec_button.setBackground(Color.RED);
		find_my_rec_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_panel.setVisible(false);
				results_panel.setVisible(true);
				
				frmHackflix.setSize(600, 800);
				frmHackflix.setTitle("Hackflix - Search Results");
				
				/*
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Search button pressed!"); */
			}
		});
		
		JComboBox cast_combobox_1 = new JComboBox();
		cast_combobox_1.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_cast_combobox_1 = new GridBagConstraints();
		gbc_cast_combobox_1.insets = new Insets(0, 0, 5, 5);
		gbc_cast_combobox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_cast_combobox_1.gridx = 2;
		gbc_cast_combobox_1.gridy = 11;
		grid_panel.add(cast_combobox_1, gbc_cast_combobox_1);
		GridBagConstraints gbc_find_my_rec_button = new GridBagConstraints();
		gbc_find_my_rec_button.insets = new Insets(0, 0, 0, 5);
		gbc_find_my_rec_button.gridx = 2;
		gbc_find_my_rec_button.gridy = 13;
		grid_panel.add(find_my_rec_button, gbc_find_my_rec_button);
		
		JPanel main_panel = new JPanel();
		main_panel.setBounds(0, 0, 800, 500);
		main_panel.setBackground(Color.BLACK);
		main_panel.setPreferredSize(new Dimension(800, 500));
		panel.add(main_panel);
		
		JPanel main_grid_panel = new JPanel();
		main_panel.add(main_grid_panel);
		main_grid_panel.setBounds(0, 0, 800, 500);
		main_grid_panel.setBackground(Color.BLACK);
		main_grid_panel.setPreferredSize(new Dimension(800, 500));
		GridBagLayout gbl_main_grid_panel = new GridBagLayout();
		gbl_main_grid_panel.rowWeights = new double[]{0.0, 0.7, 0.2, 0.5, 1.0, 1.0, 0.0};
		gbl_main_grid_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_main_grid_panel.columnWidths = new int[]{100, 100, 100};
		gbl_main_grid_panel.rowHeights = new int[]{100, 137, 30, 50, 0, 50, 100};
		main_grid_panel.setLayout(gbl_main_grid_panel);
		
		JPanel hackflix_logo = new JPanel();
		hackflix_logo.setBackground(Color.BLACK);
		hackflix_logo.setLayout(null);
		GridBagConstraints gbc_hackflix_logo = new GridBagConstraints();
		gbc_hackflix_logo.insets = new Insets(0, 0, 5, 5);
		gbc_hackflix_logo.fill = GridBagConstraints.BOTH;
		gbc_hackflix_logo.gridx = 1;
		gbc_hackflix_logo.gridy = 1;
		main_grid_panel.add(hackflix_logo, gbc_hackflix_logo);
		
		JLabel hackflix_logo_jlabel = new JLabel("");
		hackflix_logo_jlabel.setBounds(145, 16, 323, 96);
		hackflix_logo_jlabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("hackflix.png").getImage().getScaledInstance(330, 100, Image.SCALE_SMOOTH));
		hackflix_logo_jlabel.setIcon(imageIcon);
		
		hackflix_logo.add(hackflix_logo_jlabel);
		
		JPanel hackflix_quote = new JPanel();
		hackflix_quote.setBackground(Color.BLACK);
		GridBagConstraints gbc_hackflix_quote = new GridBagConstraints();
		gbc_hackflix_quote.insets = new Insets(0, 0, 5, 5);
		gbc_hackflix_quote.fill = GridBagConstraints.BOTH;
		gbc_hackflix_quote.gridx = 1;
		gbc_hackflix_quote.gridy = 2;
		main_grid_panel.add(hackflix_quote, gbc_hackflix_quote);
		
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
		main_grid_panel.add(main_buttons, gbc_main_buttons);
		main_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton movie_button = new JButton("Movies");
		movie_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		movie_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// add action here
				movies = true;
				frmHackflix.setTitle("Hackflix - Movie Search");
				ImageIcon typeFont = new ImageIcon(new ImageIcon("movies.png").getImage().getScaledInstance(125, 50, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(typeFont);
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
				frmHackflix.setTitle("Hackflix - TV Show Search");
				ImageIcon typeFont = new ImageIcon(new ImageIcon("tvshows.png").getImage().getScaledInstance(175, 50, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(typeFont);
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
				frmHackflix.setTitle("Hackflix - Movies & TV Show Search");
				ImageIcon typeFont = new ImageIcon(new ImageIcon("moviesAndTV.png").getImage().getScaledInstance(275, 50, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(typeFont);
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
		main_grid_panel.add(quick_search, gbc_quick_search);
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