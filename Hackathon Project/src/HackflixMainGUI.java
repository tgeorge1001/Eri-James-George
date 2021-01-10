import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


/*
 * This class creates the Hackflix GUI.
 */

public class HackflixMainGUI {

	public JFrame frmHackflix;
	private JLayeredPane panel = new JLayeredPane();
	private JPanel results_panel = new JPanel();
	private JPanel search_panel = new JPanel();
	private JPanel main_panel = new JPanel();
	private JLabel movie_or_tv_title_label = new JLabel("");
	private JTextField txtQuickSearch;
	JComboBox sort_by_combobox;
	@SuppressWarnings("unused")
	private final Action action = new SwingAction();
	boolean movies = false;
	boolean tvshow = false;
	boolean both = false;
	JTextArea textArea;
	JScrollPane results_scrollPane;
	
	NetflixCSVReader reader;
	NetflixSearchSelection nss; 
	private Map<String, String> searchSelection;
	List<NetflixData> allNetflixData = new LinkedList<NetflixData>();

	/**
	 * Create the GUI application.
	 */
	public HackflixMainGUI(NetflixCSVReader reader) {
		this.reader = reader;
		nss = new NetflixSearchSelection();
		searchSelection = nss.getInitializedMap();
		initialize();
	}

	/*
	 * Create and add contents to the GUI.
	 */
	private void initialize() {
		
		setJFrame();
		setJLayeredPane();
		setMainJPanel();
		setSearchJPanel();
		setResultsJPanel();
		
		frmHackflix.pack();
		frmHackflix.setVisible(true);
	}
	
	/*
	 * Initialize JFrame.
	 */
	private void setJFrame() {
		frmHackflix = new JFrame();
		frmHackflix.setTitle("Hackflix");
		frmHackflix.setBackground(Color.DARK_GRAY);
		frmHackflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHackflix.getContentPane().setLayout(new BorderLayout(0, 0));
		frmHackflix.getContentPane().setSize(800,400);
		frmHackflix.setResizable(false);
	}
	
	/* 
	 * Initialize JLayeredPane.
	 */
	private void setJLayeredPane() {
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(800, 500));
		frmHackflix.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
	}
	
	/* 
	 * Initialize Search Page JPanel.
	 */
	private void setSearchJPanel() {
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
		gbl_grid_panel.rowHeights = new int[]{75, -10, 20, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0};
		gbl_grid_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_grid_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		grid_panel.setLayout(gbl_grid_panel);
		
		GridBagConstraints gbc_movie_or_tv_title_label = new GridBagConstraints();
		gbc_movie_or_tv_title_label.insets = new Insets(0, 0, 5, 5);
		gbc_movie_or_tv_title_label.gridx = 2;
		gbc_movie_or_tv_title_label.gridy = 1;
		gbc_movie_or_tv_title_label.gridwidth = 1;
		grid_panel.add(movie_or_tv_title_label, gbc_movie_or_tv_title_label);
		
		JPanel title_quote = new JPanel();
		title_quote.setBackground(Color.BLACK);
		GridBagConstraints gbc_title_quote = new GridBagConstraints();
		gbc_title_quote.insets = new Insets(0, 0, 5, 5);
		gbc_title_quote.fill = GridBagConstraints.VERTICAL;
		gbc_title_quote.gridx = 2;
		gbc_title_quote.gridy = 2;
		gbc_movie_or_tv_title_label.gridwidth = 3;
		
		JLabel title_string = new JLabel("Grab your popcorn; it's time to chill.");
		title_string.setFont(new Font("Gill Sans", Font.PLAIN, 14));
		title_string.setForeground(Color.WHITE);
		title_quote.add(title_string);
		grid_panel.add(title_quote, gbc_title_quote);
		
		JLabel genre_label = new JLabel("Genre");
		genre_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_genre_label = new GridBagConstraints();
		gbc_genre_label.insets = new Insets(0, 0, 5, 5);
		gbc_genre_label.gridx = 1;
		gbc_genre_label.gridy = 5;
		grid_panel.add(genre_label, gbc_genre_label);
		
		JLabel release_year_label = new JLabel("Release Year");
		release_year_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_release_year_label = new GridBagConstraints();
		gbc_release_year_label.insets = new Insets(0, 0, 5, 5);
		gbc_release_year_label.gridx = 2;
		gbc_release_year_label.gridy = 5;
		grid_panel.add(release_year_label, gbc_release_year_label);
		
		JLabel rating_label = new JLabel("Rating");
		rating_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_rating_label = new GridBagConstraints();
		gbc_rating_label.insets = new Insets(0, 0, 5, 5);
		gbc_rating_label.gridx = 3;
		gbc_rating_label.gridy = 5;
		grid_panel.add(rating_label, gbc_rating_label);
		
		JComboBox genre_combobox = new JComboBox();
		genre_label.setLabelFor(genre_combobox);
		genre_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "Action", "Anime", "British", "Children", "Classic", "Comedy", "Documentary", "Drama", "Horror", "Indie", "International", "Musical", "Reality", "Romance", "Sci-Fi & Fantasy", "Spanish-Language", "Sports", "Thriller"}));
		GridBagConstraints gbc_genre_combobox = new GridBagConstraints();
		gbc_genre_combobox.fill = GridBagConstraints.VERTICAL;
		gbc_genre_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_genre_combobox.gridx = 1;
		gbc_genre_combobox.gridy = 6;
		genre_combobox.setForeground(Color.BLACK);
		genre_combobox.setBackground(Color.GRAY);
		genre_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(genre_combobox.getSelectedItem());
				searchSelection.put("Genre", selection);
			}
		});
		grid_panel.add(genre_combobox, gbc_genre_combobox);
		
		JComboBox releaseyear_combobox = new JComboBox();
		release_year_label.setLabelFor(releaseyear_combobox);
		releaseyear_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "pre-1960s", "1970s", "1980s", "1990s", "2000s", "2010s", "2020"}));
		GridBagConstraints gbc_releaseyear_combobox = new GridBagConstraints();
		gbc_releaseyear_combobox.fill = GridBagConstraints.BOTH;
		gbc_releaseyear_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_releaseyear_combobox.gridx = 2;
		gbc_releaseyear_combobox.gridy = 6;
		releaseyear_combobox.setForeground(Color.BLACK);
		releaseyear_combobox.setBackground(Color.GRAY);
		releaseyear_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(releaseyear_combobox.getSelectedItem());
				searchSelection.put("Release Year", selection);
			}
		});
		grid_panel.add(releaseyear_combobox, gbc_releaseyear_combobox);
		
		JComboBox rating_combobox = new JComboBox();
		rating_label.setLabelFor(rating_combobox);
		rating_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "G/TV-G or lower", "PG/TV-PG", "PG-13/TV-14", "R/TV-MA", "NC-17", "NR"}));
		GridBagConstraints gbc_rating_combobox = new GridBagConstraints();
		gbc_rating_combobox.fill = GridBagConstraints.BOTH;
		gbc_rating_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_rating_combobox.gridx = 3;
		gbc_rating_combobox.gridy = 6;
		rating_combobox.setForeground(Color.BLACK);
		rating_combobox.setBackground(Color.GRAY);
		rating_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(rating_combobox.getSelectedItem());
				searchSelection.put("Rating", selection);
			}
		});
		grid_panel.add(rating_combobox, gbc_rating_combobox);
		
		JLabel director_label = new JLabel("Director");
		director_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_director_label = new GridBagConstraints();
		gbc_director_label.insets = new Insets(0, 0, 5, 5);
		gbc_director_label.gridx = 1;
		gbc_director_label.gridy = 8;
		grid_panel.add(director_label, gbc_director_label);
		
		JLabel cast_label = new JLabel("Cast");
		cast_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_cast_label = new GridBagConstraints();
		gbc_cast_label.insets = new Insets(0, 0, 5, 5);
		gbc_cast_label.gridx = 2;
		gbc_cast_label.gridy = 8;
		grid_panel.add(cast_label, gbc_cast_label);
		
		JLabel duration_label = new JLabel("Duration");
		duration_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_duration_label = new GridBagConstraints();
		gbc_duration_label.insets = new Insets(0, 0, 5, 5);
		gbc_duration_label.gridx = 3;
		gbc_duration_label.gridy = 8;
		grid_panel.add(duration_label, gbc_duration_label);
		
		JComboBox director_combobox = new JComboBox();
		director_label.setLabelFor(director_combobox);
		director_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "Alfred Hitchcock", "Christopher Nolan", "M. Night Shyamalan", "Martin Scorsese", "Peter Jackson", "Quentin Tarantino", "Stanley Kubrick", "Steven Spielberg", "Taika Waititi", "Tim Burton"}));
		GridBagConstraints gbc_director_combobox = new GridBagConstraints();
		gbc_director_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_director_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_director_combobox.gridx = 1;
		gbc_director_combobox.gridy = 9;
		director_combobox.setForeground(Color.BLACK);
		director_combobox.setBackground(Color.GRAY);
		director_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(director_combobox.getSelectedItem());
				searchSelection.put("Director", selection);
			}
		});
		grid_panel.add(director_combobox, gbc_director_combobox);
		
		JComboBox cast_combobox = new JComboBox();
		cast_label.setLabelFor(cast_combobox);
		cast_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "Angelina Jolie", "Anne Hathaway", "Ben Affleck", "Brad Pitt", "Charlize Theron", "Christian Bale", "Clint Eastwood", "Clint Eastwood", "Dwayne Johnson", "George Clooney", "Jackie Chan", "Jennifer Aniston", "Jennifer Lawrence", "Johnny Depp", "Julia Roberts", "Leonardo DiCaprio", "Matt Damon", "Meryl Streep", "Morgan Freeman", "Natalie Portman", "Nicole Kidman", "Robert De Niro", "Ryan Gosling", "Scarlett Johansson", "Tom Cruise"}));
		GridBagConstraints gbc_cast_combobox = new GridBagConstraints();
		gbc_cast_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_cast_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cast_combobox.gridx = 2;
		gbc_cast_combobox.gridy = 9;
		cast_combobox.setForeground(Color.BLACK);
		cast_combobox.setBackground(Color.GRAY);
		cast_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(cast_combobox.getSelectedItem());
				searchSelection.put("Cast", selection);
			}
		});
		grid_panel.add(cast_combobox, gbc_cast_combobox);
		
		JComboBox duration_combobox = new JComboBox();
		duration_label.setLabelFor(duration_combobox);
		duration_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "1 Season (TV-only)", "Short Film (<40 min)", "Featurette (40-75 min)", "Feature Film (75+ min)"}));
		GridBagConstraints gbc_duration_combobox = new GridBagConstraints();
		gbc_duration_combobox.fill = GridBagConstraints.BOTH;
		gbc_duration_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_duration_combobox.gridx = 3;
		gbc_duration_combobox.gridy = 9;
		duration_combobox.setForeground(Color.BLACK);
		duration_combobox.setBackground(Color.GRAY);
		duration_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(duration_combobox.getSelectedItem());
				searchSelection.put("Duration", selection);
			}
		});
		grid_panel.add(duration_combobox, gbc_duration_combobox);
		
		JLabel country_label = new JLabel("Country");
		country_label.setForeground(Color.WHITE);
		GridBagConstraints gbc_country_label = new GridBagConstraints();
		gbc_country_label.insets = new Insets(0, 0, 5, 5);
		gbc_country_label.gridx = 2;
		gbc_country_label.gridy = 11;
		grid_panel.add(country_label, gbc_country_label);
		
		JButton find_my_rec_button = new JButton("Find my recs!");
		find_my_rec_button.setFont(new Font("Gill Sans", Font.PLAIN, 15));
		find_my_rec_button.setBackground(new Color(128, 0, 0));
		find_my_rec_button.setForeground(new Color(255, 255, 255));
		find_my_rec_button.setBackground(Color.RED);
		find_my_rec_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sort_by_combobox.setSelectedIndex(0);
				//nss.printMap(searchSelection);
				reader.clearNetflixData();
				reader.parseData(searchSelection);
				allNetflixData = reader.getAllNetflixData();
								
				int resultSize = allNetflixData.size();
				String resultText = stringOutputRandom(resultSize);
				
				textArea.setText(resultText);
				
				results_panel.revalidate();
				results_panel.repaint();
				
				search_panel.setVisible(false);
				results_panel.setVisible(true);
				
				frmHackflix.setSize(600, 800);
				frmHackflix.setTitle("Hackflix - Search Results");
				nss = new NetflixSearchSelection();
				searchSelection = nss.getInitializedMap();
				
				/*
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Search button pressed!"); */
			}
		});
		
		JComboBox country_combobox = new JComboBox();
		country_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "Argentina", "Australia", "Austria", "Bangladesh", "Belgium", "Brazil", "Bulgaria", "Cambodia", "Canada", "Chile", "China", "Colombia", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Dominican Republic", "Egypt", "Finland", "France", "Georgia", "Germany", "Ghana", "Guatemala", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Ireland", "Israel", "Italy", "Japan", "Lebanon", "Malaysia", "Mexico", "Netherlands", "New Zealand", "Nigeria", "Norway", "Pakistan", "Peru", "Philippines", "Poland", "Romania", "Russia", "Saudi Arabia", "Serbia", "Singapore", "South Africa", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Turkey", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Venezuela", "Vietnam"}));
		country_combobox.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_country_combobox = new GridBagConstraints();
		gbc_country_combobox.insets = new Insets(0, 0, 5, 5);
		gbc_country_combobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_country_combobox.gridx = 2;
		gbc_country_combobox.gridy = 12;
		grid_panel.add(country_combobox, gbc_country_combobox);
		GridBagConstraints gbc_find_my_rec_button = new GridBagConstraints();
		gbc_find_my_rec_button.insets = new Insets(0, 0, 0, 5);
		gbc_find_my_rec_button.gridx = 2;
		gbc_find_my_rec_button.gridy = 15;
		country_combobox.setForeground(Color.BLACK);
		country_combobox.setBackground(Color.GRAY);
		country_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = String.valueOf(country_combobox.getSelectedItem());
				searchSelection.put("Country", selection);
			}
		});
		grid_panel.add(find_my_rec_button, gbc_find_my_rec_button);
				
	}
	
	/* 
	 * Initialize Results Page JPanel.
	 */
	private void setResultsJPanel() {
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
		gbl_results_grid_panel.rowHeights = new int[]{20, 120, 0, 0, 300, 0, 50};
		gbl_results_grid_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0};
		gbl_results_grid_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0};
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
		
		sort_by_combobox = new JComboBox();
		sort_by_combobox.setForeground(Color.BLACK);
		sort_by_combobox.setBackground(Color.GRAY);
		sort_by_combobox.setModel(new DefaultComboBoxModel(new String[] {"---", "Title (Ascending)", "Title (Descending)", "Release Year (Ascending)", "Release Year (Descending)"}));
		sort_by_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = sort_by_combobox.getSelectedIndex();
				
				
				switch (selection) {

				case 1:
					allNetflixData = nss.sortByAlphabetAscend(allNetflixData);

					int resultSize1 = allNetflixData.size();
					String resultText1 = stringOutputRandom(resultSize1);
					
					textArea.setText(resultText1);
					
					results_panel.revalidate();
					results_panel.repaint();


					break;

				case 2:

					allNetflixData = nss.sortByAlphabetDescend(allNetflixData);

					int resultSize2 = allNetflixData.size();
					String resultText2 = stringOutputRandom(resultSize2);
					
					textArea.setText(resultText2);
					
					results_panel.revalidate();
					results_panel.repaint();
					
					break;

				case 3:
					
					allNetflixData = nss.sortByYearAscend(allNetflixData);

					int resultSize3 = allNetflixData.size();
					String resultText3 = stringOutputRandom(resultSize3);
					
					textArea.setText(resultText3);
					
					results_panel.revalidate();
					results_panel.repaint();
					
					break;

				case 4:
					
					allNetflixData = nss.sortByYearDescend(allNetflixData);

					int resultSize4 = allNetflixData.size();
					String resultText4 = stringOutputRandom(resultSize4);
					
					textArea.setText(resultText4);
					
					results_panel.revalidate();
					results_panel.repaint();
					
					break;

				default:
					break;
				}

				
			}
		});
		sort_by_panel.add(sort_by_combobox);
		
		String resultText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices at magna a volutpat. Pellentesque eget hendrerit magna, non fermentum urna. Aliquam sagittis iaculis volutpat. Quisque dictum, ante ac ultrices luctus, mauris neque imperdiet sem, in luctus ipsum libero a lacus. Donec id sagittis elit. Donec nec venenatis massa, in feugiat felis. Mauris arcu turpis, suscipit iaculis rhoncus eu, egestas vitae lectus. Quisque dapibus, orci et mollis placerat, sem ex ornare elit, eu maximus lacus mi a tortor. Praesent consequat diam dolor, vel vehicula sem sollicitudin a. Mauris a laoreet odio.\n"
				+ "\n"
				+ "Maecenas ut augue magna. Suspendisse sed eros nec nisi interdum placerat. Suspendisse sagittis aliquet lorem, auctor blandit est ultrices vitae. Maecenas egestas neque vitae sapien cursus consequat. Proin non lectus non turpis dignissim elementum. Maecenas et fringilla mauris, non feugiat felis. Donec fermentum ultricies facilisis. Fusce tortor est, dapibus quis luctus euismod, congue a urna. Cras vehicula laoreet molestie. Sed porta ligula consectetur nulla fermentum, a imperdiet augue congue. Morbi pulvinar, sem vitae cursus suscipit, diam ipsum condimentum neque, sit amet rutrum sem neque sit amet urna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Fusce vel efficitur sapien. Etiam rhoncus, ligula at aliquam volutpat, quam elit consectetur arcu, vel ullamcorper justo urna ac augue. Quisque vestibulum nec mauris a tincidunt. Suspendisse euismod metus ante, eget fermentum risus vulputate nec.\n"
				+ "\n"
				+ "In hac habitasse platea dictumst. Phasellus mattis fermentum lorem vel ullamcorper. Donec at posuere risus. Etiam malesuada urna vel nibh facilisis sollicitudin. Fusce id metus diam. Morbi in lectus eget purus dictum ultrices. Quisque non efficitur nisi. Sed eu molestie felis. Nam vehicula dictum ex ac semper. Fusce placerat cursus diam sed feugiat. Proin massa ligula, iaculis quis faucibus at, scelerisque et purus. Maecenas fringilla, odio non imperdiet eleifend, augue dui imperdiet nunc, id tempus libero quam quis urna. Etiam suscipit turpis urna, id luctus arcu fringilla pharetra. Nunc ac est urna. Duis convallis ultrices blandit. Vivamus id ipsum vitae felis hendrerit imperdiet.\n"
				+ "\n"
				+ "Etiam rhoncus ligula quis turpis porta viverra. Integer accumsan nunc vel maximus facilisis. Aliquam erat volutpat. Pellentesque tincidunt libero ornare, pharetra elit quis, vulputate est. Pellentesque hendrerit dignissim mi luctus iaculis. Nulla fringilla dolor ante, sed lobortis est hendrerit in. Sed maximus nec orci commodo faucibus. Quisque ut molestie erat. In id magna vehicula, hendrerit mauris et, tincidunt ex. Nunc at feugiat odio, luctus consequat quam. Pellentesque faucibus venenatis justo, eu eleifend nulla molestie at. Quisque nec elit at arcu semper dapibus eu eu ligula. Praesent ac rutrum ipsum.\n"
				+ "\n"
				+ "Phasellus vel eleifend velit. Cras consectetur blandit urna, ac consequat est lobortis nec. Integer lacus erat, interdum sit amet condimentum sed, rhoncus in magna. Integer elit nulla, ultricies sed vehicula in, vehicula eu erat. Vivamus mauris erat, consequat vel turpis ac, consectetur fringilla odio. Donec volutpat ullamcorper augue, ut laoreet elit. Sed et rutrum nunc, eget ultricies ante. Donec vitae nulla rutrum, posuere metus quis, dignissim risus. Praesent posuere ultrices lorem, et facilisis nisl porta at.\n"
				+ "\n"
				+ "Duis quis vestibulum lacus, sed facilisis nisl. Aenean sed convallis erat, eget tincidunt felis. Curabitur velit nisl, cursus pellentesque tristique quis, blandit vitae ante. Integer non dui sed nisl mollis tempus. Donec quis urna euismod, pharetra purus ac, porttitor nisi. Ut malesuada congue est non pulvinar. Donec gravida egestas fringilla.\n"
				+ "\n"
				+ "Ut semper luctus aliquet. Vivamus at odio leo. Pellentesque vulputate lorem quis ligula congue, vitae commodo lectus ullamcorper. Praesent ipsum eros, consequat id arcu vel, interdum fringilla neque. Suspendisse potenti. Integer mattis orci vel leo convallis vestibulum. Quisque erat sem, viverra finibus laoreet nec, tincidunt vel ex. Praesent lacinia, dui id convallis ultricies, tortor lorem placerat augue, at blandit nisl sapien pretium lectus. Nunc venenatis sit amet ipsum vel auctor. Nulla facilisi. Nullam ut dolor eget nibh sodales vulputate sit amet vitae urna. Suspendisse potenti. Etiam in varius diam, vel pharetra lacus. Sed condimentum a nunc ac hendrerit. Nulla tincidunt dui eget turpis laoreet lobortis. Maecenas sed sapien a est hendrerit rutrum sit amet quis nulla.\n"
				+ "\n"
				+ "Curabitur erat risus, iaculis vitae aliquam id, consectetur malesuada purus. Duis dignissim purus a elit porta ultrices. Duis sagittis blandit felis at tincidunt. Quisque tristique dolor eu interdum pretium. Pellentesque laoreet tincidunt ante non tempus. Etiam porttitor sem a risus lobortis tristique. Vestibulum nisl felis, facilisis sed posuere vel, bibendum nec nunc. Cras ante sapien, cursus tempus sem sed, posuere sollicitudin felis. Maecenas quis maximus elit. Nullam in ornare mi.";
		
		textArea = new JTextArea(resultText);
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setSize(400,500);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		results_scrollPane = new JScrollPane(textArea);
		results_scrollPane.setToolTipText("");
		results_scrollPane.setPreferredSize(new Dimension(450, 450));
		results_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		results_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_results_scrollPane = new GridBagConstraints();
		gbc_results_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_results_scrollPane.gridx = 1;
		gbc_results_scrollPane.gridy = 4;
		gbc_results_scrollPane.gridwidth = 3;
		results_scrollPane.setBorder(null);
		results_scrollPane.getViewport().setBackground(Color.GRAY);
		
		// Set JScrollPane scrollbar position to top
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				results_scrollPane.getViewport().setViewPosition(new Point(0, 0));
			}
		}); */
		
		JPanel new_search_panel = new JPanel();
		new_search_panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_new_search_panel = new GridBagConstraints();
		gbc_new_search_panel.insets = new Insets(0, 0, 5, 5);
		gbc_new_search_panel.fill = GridBagConstraints.BOTH;
		gbc_new_search_panel.gridx = 2;
		gbc_new_search_panel.gridy = 3;
		results_grid_panel.add(new_search_panel, gbc_new_search_panel);
		
		JButton start_over_button = new JButton("Start over!");
		start_over_button.setBackground(new Color(192, 192, 192));
		new_search_panel.add(start_over_button);
		results_grid_panel.add(results_scrollPane, gbc_results_scrollPane);
		
		start_over_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				search_panel.setVisible(false);
				results_panel.setVisible(false);
				main_panel.setVisible(true);
				movies = false;
				tvshow = false;
				both = false;
				searchSelection = nss.getInitializedMap(); // clear map
				
				frmHackflix.setSize(800, 500);
				frmHackflix.setTitle("Hackflix");
				
				/*
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Search button pressed!"); */
			}
		});
		
		//JTextArea txtrLoremIpsumDolor = new JTextArea();
		//txtrLoremIpsumDolor.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed facilisis eget libero et consequat. Sed imperdiet purus vel elementum dapibus. Integer eget libero imperdiet, mattis tellus vel, semper nunc. Donec congue sollicitudin risus vel ultricies. Sed malesuada euismod orci, ac tristique sem ornare at. Phasellus sit amet sem quis turpis mollis elementum sed vel metus. Vestibulum finibus at lacus ornare mollis. Phasellus a feugiat lacus, sed consectetur odio. Nulla tincidunt eu tellus et euismod. Suspendisse nisi erat, dignissim at egestas et, congue laoreet quam. Pellentesque in tortor suscipit, fermentum magna eu, fermentum nisi. Curabitur ut auctor metus.\n\nFusce consectetur tellus dolor, ut lacinia nisi eleifend ut. Nunc fermentum, eros ut mattis volutpat, tellus enim lobortis mi, a mattis nunc nisl sit amet quam. Sed facilisis lacus vitae leo pretium eleifend. Nullam pulvinar orci sed egestas bibendum. Pellentesque vel semper nisl, eu tempor purus. Fusce vestibulum sit amet leo eu bibendum. Phasellus ut nisl tincidunt est sodales lobortis. Integer neque tortor, posuere rhoncus tellus vel, tincidunt tincidunt elit. Aliquam nunc ante, varius sed turpis a, facilisis sollicitudin purus. Praesent eget imperdiet orci. Donec a semper urna, sit amet condimentum turpis.\n\nProin tempus consequat porttitor. Duis efficitur gravida libero, sit amet tincidunt erat pulvinar placerat. Nulla vel urna gravida, blandit diam in, euismod dui. Donec auctor vulputate arcu condimentum egestas. Nulla facilisi. Donec id nunc ac tellus pulvinar varius. Vestibulum consectetur posuere ante in fermentum. Fusce at vestibulum velit, id porta elit. Sed vel est porttitor, fringilla enim at, interdum orci. Etiam molestie eros lorem, et interdum justo auctor ullamcorper. Donec vitae tristique ipsum, et volutpat neque. Curabitur aliquam enim est, et lacinia ante cursus vitae. Ut arcu velit, commodo ac porta eu, mattis quis tellus. Mauris vel lacus ut ex eleifend pharetra hendrerit eget sapien. Nulla pharetra, risus vel sagittis iaculis, ligula sapien placerat lectus, suscipit placerat magna risus id massa.\n\nProin finibus porta sapien, cursus hendrerit elit mattis a. Integer sem sem, tempor sit amet urna at, fermentum consequat est. Nunc consequat metus feugiat porttitor consequat. Duis sit amet lorem sapien. Nunc id ex id dui semper accumsan at quis urna. Duis laoreet metus iaculis nibh consequat, et egestas magna porttitor. Cras in auctor augue. Sed purus metus, facilisis eget nunc id, lacinia viverra ligula. Nam nec turpis nunc. Mauris nec sagittis felis. Quisque quis dignissim nisi. Morbi a arcu quis massa fermentum fringilla vitae eget turpis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus euismod et mi non molestie. Aliquam erat volutpat.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id sodales risus. Ut vestibulum eros id placerat iaculis. Morbi quis tempor ante. Curabitur sed lacinia est. Nulla facilisi. Vestibulum id pretium neque. Curabitur vel pellentesque dolor. Mauris porttitor risus a tellus fringilla, ut finibus enim tempor. Nunc ex velit, pellentesque in dui ac, dictum vehicula metus.");
		//results_scrollPane.setColumnHeaderView(txtrLoremIpsumDolor);	
	}
	
	/* 
	 * Initialize Main Page JPanel.
	 */
	private void setMainJPanel() {
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
		movie_button.setFont(new Font("Gill Sans", Font.PLAIN, 16));
		movie_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movies = true;
				searchSelection.put("Type", "Movie");
				searchSelection.put("Keyword", "---");
				frmHackflix.setTitle("Hackflix - Movie Search");
				ImageIcon moviesFont = new ImageIcon(new ImageIcon("movies.png").getImage().getScaledInstance(175, 75, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(moviesFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		main_buttons.add(movie_button);
		
		JButton show_button = new JButton("TV Shows");
		show_button.setFont(new Font("Gill Sans", Font.PLAIN, 16));
		show_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tvshow = true;
				searchSelection.put("Type", "TV Show");
				searchSelection.put("Keyword", "---");
				frmHackflix.setTitle("Hackflix - TV Show Search");
				ImageIcon tvShowFont = new ImageIcon(new ImageIcon("tvshows.png").getImage().getScaledInstance(200, 60, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(tvShowFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		main_buttons.add(show_button);
		
		JButton both_button = new JButton("Both");
		both_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				both = true;
				searchSelection.put("Type", "Both");
				searchSelection.put("Keyword", "---");
				frmHackflix.setTitle("Hackflix - Movies & TV Show Search");
				ImageIcon moviesAndTVShowFont = new ImageIcon(new ImageIcon("moviesAndTV.png").getImage().getScaledInstance(275, 45, Image.SCALE_SMOOTH));
				movie_or_tv_title_label.setIcon(moviesAndTVShowFont);
				main_panel.setVisible(false);
				search_panel.setVisible(true);
				
			}
		});
		both_button.setFont(new Font("Gill Sans", Font.PLAIN, 16));
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
				
				String textSearchString = txtQuickSearch.getText();
				searchSelection.put("Keyword", textSearchString);
				// nss.printMap(searchSelection);
				
				reader.clearNetflixData();
				reader.parseData(searchSelection);
				allNetflixData = reader.getAllNetflixData();
								
				int resultSize = allNetflixData.size();
				String resultText = stringOutputRandom(resultSize);
				
				textArea.setText(resultText);
				//textArea.setCaretPosition(0);
				
				results_panel.revalidate();
				results_panel.repaint();
				
				search_panel.setVisible(false);
				results_panel.setVisible(true);
				
				
				main_panel.setVisible(false);
				results_panel.setVisible(true);
				movies = false;
				tvshow = false;
				both = false;
	
				
				frmHackflix.setSize(600, 800);
				frmHackflix.setTitle("Hackflix - Search Results");
				
				nss = new NetflixSearchSelection();
				searchSelection = nss.getInitializedMap();
				/*
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "Quick search used!");*/
			}
		});
		quick_search.add(txtQuickSearch);
		txtQuickSearch.setColumns(10);
	}
	
	/* 
	 * Initialize SwingAction.
	 */
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public Map<String, String> getUserInput() {
		return searchSelection;
	}
	
	public String resultsToString(List<NetflixData> list, int i) {
		int num = i + 1;
		String minOrSeason = "";
		if (list.get(i).getDuration() == 1) {
			minOrSeason = "season";
		}
		else {
			minOrSeason = "min";
		}
		
		List<String> directors = list.get(i).getDirector();
		String directorString = directors.toString();
		directorString = directorString.substring(1, directorString.length()-1);
		if (directorString.isEmpty()) {
			directorString = "N/A";
		}
		List<String> casts = list.get(i).getCast();
		String castString = casts.toString();
		castString = castString.substring(1, castString.length()-1);
		if (castString.isEmpty()) {
			castString = "N/A";
		}
		List<String> genres = list.get(i).getGenre();
		String genreString = genres.toString();
		genreString = genreString.substring(1, genreString.length()-1);
		if (genreString.isEmpty()) {
			genreString = "N/A";
		}
		List<String> countries = list.get(i).getCountry();
		String countryString = countries.toString();
		countryString = countryString.substring(1, countryString.length()-1);
		if (countryString.isEmpty()) {
			countryString = "N/A";
		}
		String string = "Recommendation " + num + ": \n\n" + "Title: " + list.get(i).getTitle() + "\n" + 
				"Release Year: "
				+ list.get(i).getReleaseyear() + "\n" + "Rating: " + list.get(i).getRating() + "\n"+ 
				"Duration: " + list.get(i).getDuration() + " " + minOrSeason + "\n" +
				"Genre: " + genreString + "\n"+ 
				"Country: " + countryString + "\n"+
				"Director(s): " + directorString + "\n"
				+ "Cast(s): " + castString + "\n" 
				+ "Description: "
				+ list.get(i).getDescription() + "\n \n";
		return string;
	}
	
	public String stringOutputRandom(int resultSize) {
		String resultText = "";
		for (int i = 0; i < resultSize; i++) {
			resultText = resultText + resultsToString(allNetflixData, i);
		}
		
		if (resultText.isEmpty()) {
			resultText = "Sorry, there was no match! Please again.";
		}
		return resultText;
	}
}