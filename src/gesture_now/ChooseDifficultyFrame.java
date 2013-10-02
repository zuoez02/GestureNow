package gesture_now;

import javax.swing.*;
import java.awt.*;

public class ChooseDifficultyFrame implements Strings{
	public ChooseDifficultyFrame(){
		JFrame chooseDifficulty = new JFrame(CHOOSE_DIFFICULTY_TITLE);
		JButton btnEasy = new JButton(DIFFICULTY_EASY_TITLE);
		JButton btnMedium = new JButton(DIFFICULTY_MEDIUM_TITLE);
		JButton btnHard = new JButton(DIFFICULTY_HARD_TITLE);
		chooseDifficulty.setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
		chooseDifficulty.add(btnEasy);
		chooseDifficulty.add(btnMedium);
		chooseDifficulty.add(btnHard);
		chooseDifficulty.pack();
		chooseDifficulty.setLocation(500,500);
		chooseDifficulty.setVisible(true);
	}
}
