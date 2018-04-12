package mineSweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Board mineSweeper = new Board();
	private int actionListI = 0;
	private int actionListJ = 0;

	// private double N = Math.pow(mineSweeper.getHeight(), 2);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGui frame = new BoardGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoardGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);

		JPanel bombsLeft = bombsLeft();
		topPanel.add(bombsLeft);

		JPanel restartGame = restartGame();
		topPanel.add(restartGame);

		JPanel timer = timer();
		topPanel.add(timer);

		JPanel grid = fillBoard();

		contentPane.add(grid, BorderLayout.CENTER);

	}

	private JPanel fillBoard() {
		JPanel grid = new JPanel();
		mineSweeper.placeMines();
		grid.setLayout(new GridLayout(9, 0, 1, 0));
		JButton[][] boardButton = new JButton[mineSweeper.getHeight()][mineSweeper
				.getWidth()];
		for (actionListI = 0; actionListI < mineSweeper.getHeight(); actionListI++) {
			for (actionListJ = 0; actionListJ < mineSweeper.getWidth(); actionListJ++) {
				boardButton[actionListI][actionListJ] = new JButton();

					boardButton[actionListI][actionListJ]
							.addActionListener(new ActionListener() {
								int i = actionListI;
								int j = actionListJ;
								public void actionPerformed(ActionEvent e) {
									boardButton[i][j].setText(""
											+ mineSweeper.getGrid()[i][j]);
								}
							});

					grid.add(boardButton[actionListI][actionListJ]);
			}
		}


		return grid;
	}

	/**
	 * Timer GUI for minesweeper
	 * 
	 * @return
	 */
	private JPanel timer() {
		JPanel timer = new JPanel();
		timer.setBorder(new EmptyBorder(0, 10, 0, 0));

		JLabel lblTimer = new JLabel("Timer");
		timer.add(lblTimer);
		return timer;
	}

	/**
	 * Smilelly Face for restarting game
	 * 
	 * @return
	 */
	private JPanel restartGame() {
		JPanel restartGame = new JPanel();

		JButton btnRestart = new JButton("Restart");
		restartGame.add(btnRestart);
		return restartGame;
	}

	/**
	 * number of how many bombs are left GUI
	 * 
	 * @return
	 */
	private JPanel bombsLeft() {
		JPanel bombsLeft = new JPanel();
		bombsLeft.setBorder(new EmptyBorder(0, 0, 0, 10));

		JLabel lblBombsLeft = new JLabel("Bombs Left");
		bombsLeft.add(lblBombsLeft);
		return bombsLeft;
	}

}
