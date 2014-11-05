package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import type.MangaType;
import type.MangaWebSite;
import utils.downloadutil.DownloadBrain;

import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;

import factory.DownloadUtilFactory;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class MangaDownloadGUI {

	private JFrame frame;
	private JTextField textField_single;
	private JTextField textField_multiple_from;
	private JTextField textField_multiple_to;
	private JTextField textField_volume;
	private JTextField textField_relative_addr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangaDownloadGUI window = new MangaDownloadGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MangaDownloadGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMangadownload = new JLabel("MangaDownload");
		lblMangadownload.setBounds(0, 0, 450, 16);
		frame.getContentPane().add(lblMangadownload);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(MangaType.values()));
		comboBox.setBounds(17, 46, 201, 27);
		frame.getContentPane().add(comboBox);

		JLabel lblEpisode = new JLabel("episode");
		lblEpisode.setBounds(27, 85, 61, 16);
		frame.getContentPane().add(lblEpisode);

		JLabel lblSingle = new JLabel("single");
		lblSingle.setBounds(37, 113, 51, 16);
		frame.getContentPane().add(lblSingle);

		JLabel lblMultiple = new JLabel("multiple");
		lblMultiple.setBounds(37, 141, 61, 16);
		frame.getContentPane().add(lblMultiple);

		textField_single = new JTextField();
		textField_single.setBounds(97, 110, 40, 22);
		frame.getContentPane().add(textField_single);
		textField_single.setColumns(10);

		textField_multiple_from = new JTextField();
		textField_multiple_from.setColumns(10);
		textField_multiple_from.setBounds(97, 138, 40, 22);
		frame.getContentPane().add(textField_multiple_from);

		textField_multiple_to = new JTextField();
		textField_multiple_to.setColumns(10);
		textField_multiple_to.setBounds(166, 138, 40, 22);
		frame.getContentPane().add(textField_multiple_to);

		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(145, 141, 21, 16);
		frame.getContentPane().add(lblTo);

		JButton btnDownload = new JButton("Download");
		btnDownload.setBounds(304, 224, 117, 29);
		frame.getContentPane().add(btnDownload);

		JLabel lblVolume = new JLabel("volume");
		lblVolume.setBounds(37, 166, 61, 16);
		frame.getContentPane().add(lblVolume);

		textField_volume = new JTextField();
		textField_volume.setColumns(10);
		textField_volume.setBounds(97, 166, 40, 22);
		frame.getContentPane().add(textField_volume);

		JTextArea txtrIfYouDownload = new JTextArea();
		txtrIfYouDownload.setEditable(false);
		txtrIfYouDownload.setLineWrap(true);
		txtrIfYouDownload
				.setText("if the episode you download doesn't exist, this tool will simply do nothing. You can check that from SFOnline to see if the episode or volume exist.");
		txtrIfYouDownload.setBounds(230, 28, 178, 171);
		frame.getContentPane().add(txtrIfYouDownload);

		textField_relative_addr = new JTextField();
		textField_relative_addr.setBounds(145, 210, 134, 28);
		frame.getContentPane().add(textField_relative_addr);
		textField_relative_addr.setColumns(10);

		JLabel lblRelavant = new JLabel("relative address");
		lblRelavant.setBounds(27, 216, 110, 16);
		frame.getContentPane().add(lblRelavant);

		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DownloadBrain db = DownloadUtilFactory
						.getDownloadUtil(MangaWebSite.SFOnline);
				if (!textField_single.getText().isEmpty())
					db.Download(textField_relative_addr.getText(),
							(MangaType) comboBox.getSelectedItem(),
							Integer.parseInt(textField_single.getText()));
				if (!textField_multiple_from.getText().isEmpty()
						&& !textField_multiple_to.getText().isEmpty()) {
					db.Download(
							textField_relative_addr.getText(),
							(MangaType) comboBox.getSelectedItem(),
							Integer.parseInt(textField_multiple_from.getText()),
							Integer.parseInt(textField_multiple_to.getText()));
				}
				if (!textField_volume.getText().isEmpty())
					db.Download(textField_relative_addr.getText(),
							(MangaType) comboBox.getSelectedItem(),
							textField_volume.getText());

			}
		});
	}
}
