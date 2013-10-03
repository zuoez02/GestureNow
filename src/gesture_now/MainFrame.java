package gesture_now;
//This is the main window of the program

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;

import java.io.*;

public class MainFrame implements Strings{
	JFrame mainFrame;											//主窗口	
	int scoreNumber = 0;
	float timeNumber = 0;
	int roundNumber = 0;
	Icon icon = new ImageIcon("DownGray.png");
	ScoreBoardFrame sbf;
	ScoreBoardMenu sbm;
	ControllerListener controllerListener;
	Controller controller;
	public MainFrame(){
		controllerListener = new ControllerListener();
		controller = new Controller();
		controller.addListener(controllerListener);
		
		sbf = new ScoreBoardFrame();
		sbm = new ScoreBoardMenu();
		mainFrame = new JFrame(GAME_TITLE);			//实例化窗体对象
		mainFrame.setLayout(new BorderLayout(5,5));
		
		//创建菜单栏
		MenuBar menuBar;											//菜单栏
		Menu menu1,menu2;											//菜单栏两个按钮
		MenuItem menu1_Start,menu1_Score,menu1_Exit;				//第一个按钮下的三个按钮
		MenuItem menu2_Help,menu2_About;							//第二个按钮下的两个按钮
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
		//添加菜单栏监听器
		menu1_Start.addActionListener(new ActionListener(){			//Start监听器
			public void actionPerformed(ActionEvent e){
				if(!controller.isConnected()){						//如果没有连接，则弹出提示消息
					JOptionPane.showMessageDialog( null , DISCONNECT_INFORMATION ,DISCONNECT_TITLE , JOptionPane.ERROR_MESSAGE);								
				}else{
					start();//开始游戏
				}
			}
		});
		menu1_Score.addActionListener(new ActionListener(){			//Score监听器
			public void actionPerformed(ActionEvent e){
				sbm.setVisible(true);				
			}
		});
		menu1_Exit.addActionListener(new ActionListener(){			//Exit监听器
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		menu2_Help.addActionListener(new ActionListener(){			//Help监听器
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog( null , HELP_INFORMATION ,MENU_ITEM_HELP , JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu2_About.addActionListener(new ActionListener(){			//About监听器
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog( null , ABOUT_INFORMATION ,MENU_ITEM_ABOUT , JOptionPane.INFORMATION_MESSAGE);
			}
		});
 		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		
		//设置分数面板
		JPanel score = new JPanel(new BorderLayout(0,3));
		JLabel scoreTitle = new JLabel(SCORE_TITLE,JLabel.CENTER);
		Font scoreTitleFont = new Font("Arial Black",Font.PLAIN,40);
		scoreTitle.setFont(scoreTitleFont);
		JLabel labelScoreNumber = new JLabel(Integer.toString(scoreNumber),JLabel.CENTER);
		Font scoreNumberFont = new Font("Arial Black",Font.PLAIN,60);
		labelScoreNumber.setFont(scoreNumberFont);
		score.add(scoreTitle, BorderLayout.NORTH);
		score.add(labelScoreNumber,BorderLayout.SOUTH);		
		score.setBackground(Color.WHITE);
		mainFrame.add(score,BorderLayout.NORTH);

		//设置游戏面板
		JPanel game = new JPanel(new GridLayout(1,5,3,3));
		JLabel gesturePic1 = new JLabel("",icon,JLabel.CENTER);
		JLabel gesturePic2 = new JLabel("",icon,JLabel.CENTER);
		JLabel gesturePic3 = new JLabel("",icon,JLabel.CENTER);
		JLabel gesturePic4 = new JLabel("",icon,JLabel.CENTER);
		JLabel gesturePic5 = new JLabel("",icon,JLabel.CENTER);
		game.add(gesturePic1);
		game.add(gesturePic2);
		game.add(gesturePic3);
		game.add(gesturePic4);
		game.add(gesturePic5);
		game.setBackground(Color.WHITE);
		mainFrame.add(game,BorderLayout.CENTER);
		
		//设置底部提示栏
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
		bottom.setBackground(Color.WHITE);
		mainFrame.add(bottom,BorderLayout.SOUTH);
				
		//设置主窗体属性
		mainFrame.setSize(800,480);					//默认大小800
		mainFrame.setBackground(Color.WHITE);		//背景颜色为灰色
		mainFrame.setLocation(300,200);				//默认位置为300,200
		mainFrame.setVisible(true);					//设置窗体可见
	}
	private void start(){
		System.out.println("Start");
		int time = 8;
		Object[] difficulty = {DIFFICULTY_EASY_TITLE,DIFFICULTY_MEDIUM_TITLE,DIFFICULTY_HARD_TITLE};
		String s = (String) JOptionPane.showInputDialog(null,CHOOSE_DIFFICULTY_TITLE,CHOOSE_DIFFICULTY_TITLE , 
				JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), difficulty, DIFFICULTY_EASY_TITLE);
		switch(s){
		case DIFFICULTY_EASY_TITLE:
			time = 8;break;
		case DIFFICULTY_MEDIUM_TITLE:
			time = 5;break;
		case DIFFICULTY_HARD_TITLE:
			time = 3;break;
		}
		
	}
}
class ControllerListener extends Listener{
	private boolean isConnected=false;
	public void onInit(Controller controller){
		System.out.println("Initialized");
	}
	public void onConnect(Controller controller){
		System.out.println("Connected");
		isConnected = true;
	}	
	public boolean isConnected(){
		return isConnected;
	}
}