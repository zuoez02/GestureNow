package gesture_now;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ScoreBoardMenu implements Strings {
	JFrame scoreBoard;
	JLabel scoreNumber[]; // 显示名次
	JLabel userName[]; // 用户名标签
	String userNames[]; // 用户名字符串
	JLabel scoreLabel[]; // 分数标签
	int score[]; // 分数
	
	public ScoreBoardMenu() {
		scoreBoard = new JFrame(SCORE_BOARD_TITLE);
		scoreBoard.setLayout(new BorderLayout(5, 5));
		// 顶部标题
		JLabel scoreTitle = new JLabel(SCORE_TITLE, JLabel.CENTER);
		Font scoreFont = new Font("Arial Black", Font.PLAIN, 40);
		scoreTitle.setFont(scoreFont);
		scoreBoard.add(scoreTitle, BorderLayout.NORTH);
		// 中部分数
		JPanel scores = new JPanel();
		scores.setLayout(new GridLayout(5, 3, 5, 5));
		scoreNumber = new JLabel[5];
		scoreLabel = new JLabel[5];
		score = new int[5];
		userName = new JLabel[5];
		userNames = new String[5];
		for (int i = 0; i < 5; i++) {
			scoreNumber[i] = new JLabel(Integer.toString(i + 1), JLabel.RIGHT);
			userNames[i] = "Unknown";
			userName[i] = new JLabel(userNames[i], JLabel.CENTER);
			score[i] = 0;
			scoreLabel[i] = new JLabel(Integer.toString(score[i]), JLabel.LEFT);
			scores.add(scoreNumber[i]);
			scores.add(userName[i]);
			scores.add(scoreLabel[i]);
		}
		scoreBoard.add(scores, BorderLayout.CENTER);
		// 底部按钮		
		JButton close = new JButton(SCORE_BOARD_CLOSE);		
		scoreBoard.add(close, BorderLayout.SOUTH);
		// 设置窗口可见
		scoreBoard.pack();
		scoreBoard.setLocation(500, 500);
		scoreBoard.setVisible(false);
		
		flash();
		
		//close按钮监听器
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				scoreBoard.setVisible(false);
			}
		});
	}
	public void setVisible(boolean visible){			//是否显示窗体
		scoreBoard.setVisible(visible);
		flash();
	}
	public void flash(){								//刷新显示成绩
		
	}
}
