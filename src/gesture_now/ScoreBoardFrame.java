package gesture_now;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class ScoreBoardFrame implements Strings {
	JFrame scoreBoard;
	JLabel scoreNumber[];	//��ʾ����
	JLabel userName[];		//�û�����ǩ
	String userNames[];		//�û����ַ���
	JLabel scoreLabel[];	//������ǩ
	int score[];			//����
	int chosen;				//�ײ���ťѡ��
	public ScoreBoardFrame(){
		chosen = 0;
		scoreBoard = new JFrame(SCORE_BOARD_TITLE);
		scoreBoard.setLayout(new BorderLayout(5,5));
		//��������
		JLabel scoreTitle = new JLabel(SCORE_TITLE,JLabel.CENTER);
		Font scoreFont = new Font("Arial Black",Font.PLAIN,40);
		scoreTitle.setFont(scoreFont);
		scoreBoard.add(scoreTitle, BorderLayout.NORTH);
		//�в�����
		JPanel scores = new JPanel();
		scores.setLayout(new GridLayout(5,3,5,5));
		scoreNumber = new JLabel[5];
		scoreLabel = new JLabel[5];
		score = new int[5];
		userName = new JLabel[5];
		userNames = new String[5];
		for(int i = 0;i < 5;i++){
			scoreNumber[i] = new JLabel(Integer.toString(i+1),JLabel.RIGHT);
			userNames[i] = "Unknown";
			userName[i] = new JLabel(userNames[i],JLabel.CENTER);
			score[i] = 0;
			scoreLabel[i] = new JLabel(Integer.toString(score[i]),JLabel.LEFT);
			scores.add(scoreNumber[i]);	
			scores.add(userName[i]);
			scores.add(scoreLabel[i]);
		}		
		scoreBoard.add(scores,BorderLayout.CENTER);
		//�ײ���ť
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1,2,50,50));
		JButton again = new JButton(SCORE_BOARD_AGAIN);
		JButton cancel = new JButton(SCORE_BOARD_CANCEL);
		bottom.add(again);
		bottom.add(cancel);
		scoreBoard.add(bottom,BorderLayout.SOUTH);
		//�ײ���ť������
		again.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				chosen = 1;
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				chosen = 2;
			}
		});
		//���ô��ڿɼ�
		scoreBoard.pack();
		scoreBoard.setLocation(500,500);
		scoreBoard.setVisible(false);
	}	
	public void setVisible(boolean visible){
		scoreBoard.setVisible(visible);
		flash();
	}
	public void flash(){								//ˢ����ʾ�ɼ�

	}
	public int getChosen(){
		return chosen;
	}
	
}

