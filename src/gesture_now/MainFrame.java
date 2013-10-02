package gesture_now;
//This is the main window of the program

import java.awt.*;
import javax.swing.*;

public class MainFrame implements Strings{
	JFrame mainFrame;											//������	
	int scoreNumber = 0;
	float timeNumber = 0;
	int roundNumber = 0;
	public MainFrame(){
		mainFrame = new JFrame(GAME_TITLE);			//ʵ�����������
		mainFrame.setLayout(new BorderLayout(5,5));
		
		//�����˵���
		MenuBar menuBar;											//�˵���
		Menu menu1,menu2;											//�˵���������ť
		MenuItem menu1_Start,menu1_Score,menu1_Exit;				//��һ����ť�µ�������ť
		MenuItem menu2_Help,menu2_About;							//�ڶ�����ť�µ�������ť
		menuBar = new MenuBar();
		menu1 = new Menu(MENU_FILE);
		menu2 = new Menu(MENU_HELP);
		menu1_Start = new MenuItem(MENU_ITEM_START);
		menu1_Score = new MenuItem(MENU_ITEM_SCORE);
		menu1_Exit = new MenuItem(MENU_ITEM_EXIT);
		menu2_Help = new MenuItem(MENU_ITEM_HELP);
		menu2_About = new MenuItem(MENU_ITEM_ABOUT);
		menu1.add(menu1_Start);
		menu1.add(menu1_Score);
		menu1.addSeparator();
		menu1.add(menu1_Exit);
		menu2.add(menu2_About);
		menu2.addSeparator();
		menu2.add(menu2_Help);
		menuBar.add(menu1);
		menuBar.add(menu2);
		mainFrame.setMenuBar(menuBar);		
		
		//���÷������
		JPanel score = new JPanel(new BorderLayout(0,3));
		JLabel scoreTitle = new JLabel(SCORE_TITLE,JLabel.CENTER);
		Font scoreTitleFont = new Font("Arial Black",Font.PLAIN,40);
		scoreTitle.setFont(scoreTitleFont);
		JLabel labelScoreNumber = new JLabel(Integer.toString(scoreNumber),JLabel.CENTER);
		Font scoreNumberFont = new Font("Arial Black",Font.PLAIN,60);
		labelScoreNumber.setFont(scoreNumberFont);
		score.add(scoreTitle, BorderLayout.NORTH);
		score.add(labelScoreNumber,BorderLayout.SOUTH);		
		mainFrame.add(score,BorderLayout.NORTH);

		//������Ϸ���
		JPanel game = new JPanel(new GridLayout(2,5,3,3));
		JLabel gesturePic1 = new JLabel("1",JLabel.CENTER);
		JLabel gesturePic2 = new JLabel("2",JLabel.CENTER);
		JLabel gesturePic3 = new JLabel("3",JLabel.CENTER);
		JLabel gesturePic4 = new JLabel("4",JLabel.CENTER);
		JLabel gesturePic5 = new JLabel("5",JLabel.CENTER);
		JLabel gestureText1 = new JLabel("11",JLabel.CENTER);
		JLabel gestureText2 = new JLabel("22",JLabel.CENTER);
		JLabel gestureText3 = new JLabel("33",JLabel.CENTER);
		JLabel gestureText4 = new JLabel("44",JLabel.CENTER);
		JLabel gestureText5 = new JLabel("55",JLabel.CENTER);
		game.add(gesturePic1);
		game.add(gesturePic2);
		game.add(gesturePic3);
		game.add(gesturePic4);
		game.add(gesturePic5);
		game.add(gestureText1);
		game.add(gestureText2);
		game.add(gestureText3);
		game.add(gestureText4);
		game.add(gestureText5);
		mainFrame.add(game,BorderLayout.CENTER);
		
		//���õײ���ʾ��
		JPanel bottom = new JPanel(new GridLayout(1,2,5,5));
		JLabel bottomTimeTitle = new JLabel(BOTTOM_TIME_TITLE,JLabel.CENTER);
		JLabel bottomTimeNumber = new JLabel(Float.toString(timeNumber),JLabel.CENTER);
		JLabel bottomRoundTitle = new JLabel(BOTTOM_ROUND_TITLE,JLabel.CENTER);
		JLabel bottomRoundNumber = new JLabel(Integer.toString(roundNumber),JLabel.CENTER);
		Font bottomFont = new Font("Arial",Font.PLAIN,30);
		bottomTimeTitle.setFont(bottomFont);		
		bottomTimeNumber.setFont(bottomFont);
		bottomTimeNumber.setForeground(Color.RED);
		bottomRoundTitle.setFont(bottomFont);
		bottomRoundNumber.setFont(bottomFont);
		bottom.add(bottomTimeTitle);
		bottom.add(bottomTimeNumber);
		bottom.add(bottomRoundTitle);
		bottom.add(bottomRoundNumber);
		mainFrame.add(bottom,BorderLayout.SOUTH);
		
		
		
		//��������������
		mainFrame.setSize(720,560);					//Ĭ�ϴ�С720*560
		mainFrame.setBackground(Color.gray);		//������ɫΪ��ɫ
		mainFrame.setLocation(300,200);				//Ĭ��λ��Ϊ300,200
		mainFrame.setVisible(true);					//���ô���ɼ�


		ChooseDifficultyFrame cdf = new ChooseDifficultyFrame();
		

	}	
}
