package hw8;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;


public class ReservationSystem extends JFrame
{
	private final JTextField textField0;
	private final JLabel labelA;
	private final JLabel labelB;
	private final JRadioButton roomtype1;
	private final JRadioButton roomtype2;
	private final ButtonGroup roomtypegroup;
	private final JLabel labelC;
	private final JTextField studentid;
	private final JLabel labelD;
	private final JList<String> borrowingdays;
	private static final String[] BorrowingDays= {"1","2","3"};
	private final JLabel labelE;
	private static final String[] RoomNumber= {"???","101","102","201","202","203","301","302"};
	private final JComboBox<String> room;
	private final JLabel labelF;
	private static final String[] Equipment= {"NO","Projecter","Camera","Recording pen","Notebooks"};
	private final JList<String> equipment;
	private final JLabel labelG;
	private final JTextArea textarea;
	private final JCheckBox checkbox;
	
	private String ROOMTYPE="";
	private String STUDENTID="";
	private String BORROWINGDAYS="";
	private Object ROOMCHOICE="";
	private List<String> EQUIPMENTREQUIREMENTS;
	private String BRIEFDESCRIPTION="";
	
	public ReservationSystem()
	{
		super("NCKU Library Froup Study Room Reservation System");
		setLayout(new FlowLayout());
		
		textField0=new JTextField("NCKU Library Froup Study Room Reservation System");
		textField0.setBackground(new Color(11,97,164));
		textField0.setForeground(Color.white);
		textField0.setHorizontalAlignment(textField0.CENTER);
		textField0.setEditable(false);
		textField0.setBounds(0, 0, 800,30);
		add(textField0);
		
		labelA=new JLabel(String.format("Contact:Circulation & Public Services Division (06)2757575"));
		labelA.setHorizontalTextPosition(SwingConstants.LEFT);
		labelA.setBounds(10,30,800,30);
		add(labelA);
		
		labelB=new JLabel("Please select room type...");
		labelB.setHorizontalTextPosition(SwingConstants.LEFT);
		labelB.setBounds(10,60,800,30);
		add(labelB);
		
		roomtype1=new JRadioButton("Main Library Group Study Room",false);
		roomtype1.setBounds(10, 90, 800, 30);
		add(roomtype1);
		roomtype2=new JRadioButton("Medical Library Group Study Room",false);
		roomtype2.setBounds(10, 120, 800, 30);
		add(roomtype2);
		
		roomtypegroup=new ButtonGroup();
		roomtypegroup.add(roomtype1);
		roomtypegroup.add(roomtype2);
		
		labelC=new JLabel("Student ID");
		labelC.setHorizontalTextPosition(SwingConstants.LEFT);
		labelC.setBounds(10,150,70,30);
		add(labelC);
		
		studentid=new JTextField(70);
		studentid.setBounds(80, 155, 100, 20);
		add(studentid);
		
		labelD=new JLabel("Borrowing Days");
		labelD.setHorizontalTextPosition(SwingConstants.LEFT);
		labelD.setBounds(10,180,150,30);
		add(labelD);
		
		borrowingdays=new JList<String>(BorrowingDays);
		borrowingdays.setBounds(120,185,150,60);
		add(borrowingdays);
		
		labelE=new JLabel("Choose a room");
		labelE.setHorizontalTextPosition(SwingConstants.LEFT);
		labelE.setBounds(10,250,100,30);
		add(labelE);
		
		room=new JComboBox<String>(RoomNumber);
		room.setBounds(110,255,100,20);
		add(room);
		
		labelF=new JLabel("Equipment Requirement");
		labelF.setHorizontalTextPosition(SwingConstants.LEFT);
		labelF.setBounds(10,280,150,30);
		add(labelF);
		
		equipment=new JList<String>(Equipment);
		equipment.setBounds(160,285,150,100);
		add(equipment);
		
		labelG=new JLabel("Brief Description of meeting agenda");
		labelG.setHorizontalTextPosition(SwingConstants.LEFT);
		labelG.setBounds(10,390,800,30);
		add(labelG);
		
		textarea=new JTextArea();
		textarea.setBounds(10, 420, 700, 200);
		add(textarea);
		
		checkbox=new JCheckBox("I agree with, understand, "
				+ "and am willing to obey the NCKU discussion room rules.");
		checkbox.setBounds(10,620,800,30);
		add(checkbox);
		
		JMenu filemenu=new JMenu("File");
		JMenuItem reservationitem=new JMenuItem("Reservation");
		filemenu.add(reservationitem);
		//如果之前沒有送出資料過，則跳出提醒，有送出資料過，則跳出之前選取的內容
		reservationitem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(ROOMTYPE=="")
							JOptionPane.showMessageDialog(null,"There is no reservation.");
						else
							JOptionPane.showMessageDialog(null, String.format(" Reservation %n Room type : %s%n StudentID : %s%n Borrowing days : %s%n Room :%s%n Equipment requirements : %s%n Brief description : %s%n", 
									ROOMTYPE , STUDENTID, BORROWINGDAYS,ROOMCHOICE, EQUIPMENTREQUIREMENTS, BRIEFDESCRIPTION));	
					}
				}
				);
		
		//按下exit則終止程式
		JMenuItem exititem=new JMenuItem("Exit");
		filemenu.add(exititem);
		exititem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);						
					}
					
				}
				);
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		bar.add(filemenu);
		
		//按下about，跳出相關資訊
		JMenuItem aboutmenu=new JMenuItem("About");
		bar.add(aboutmenu);
		aboutmenu.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JOptionPane.showMessageDialog(null,
								String.format("This Reservation System is copyrighted by Huang-Han-Sheng%n"
										+ "(FOR NCKU IIM JAVA CLASS 2017)%n "
										+ "Finished Day：2017/12/14" ));
					}
				}
				);
		
		JButton sendbutton=new JButton("Send");
		sendbutton.setBounds(200, 700, 100, 20);
		add(sendbutton);
		
		JButton clearbutton=new JButton("Clear");
		clearbutton.setBounds(350,700,100,20);
		add(clearbutton);
	
		//按下send，先檢查是否每格都有輸入資料，若有空白則跳出提醒。
		//如果都填了，則跳出選取內容並將內容存入對應的static變數中
		sendbutton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					//檢查是否每格都有輸入資料
					if(roomtypegroup.getSelection()==null
							||studentid.getText().equals("")
							||borrowingdays.getSelectedIndex()==-1
							||room.getSelectedIndex()==0
							||equipment.getSelectedIndex()==-1
							||textarea.getText().equals("")
							||checkbox.isSelected()==false
						)
					{
						JOptionPane.showMessageDialog(null,"You need to fill in all the questions.");				
					}
					
					else
					{
						if(roomtype1.isSelected())
						{
							//跳出選取內容並將內容存入對應的static變數中
							JOptionPane.showMessageDialog(null, 
									String.format(" Room type : %s%n StudentID : %s%n Borrowing days : %s%n Room :%s%n Equipment requirements : %s%n Brief description : %s%n", 
											roomtype1.getText() , studentid.getText(), borrowingdays.getSelectedValue(), room.getSelectedItem(), equipment.getSelectedValuesList(), textarea.getText()));
							ROOMTYPE=roomtype1.getText();
							STUDENTID=studentid.getText();
							BORROWINGDAYS=borrowingdays.getSelectedValue();
							ROOMCHOICE=room.getSelectedItem();
							EQUIPMENTREQUIREMENTS=equipment.getSelectedValuesList();
							BRIEFDESCRIPTION=textarea.getText();
						}
								
						else if(roomtype2.isSelected())
						{
							//跳出選取內容並將內容存入對應的static變數中
							JOptionPane.showMessageDialog(null, 
									String.format("Room type : %s%n StudentID : %s%n Borrowing days : %s%n Room :%s%n Equipment requirements : %s%n Brief description : %s%n", 
											roomtype2.getText() , studentid.getText(), borrowingdays.getSelectedValue(), room.getSelectedItem(), equipment.getSelectedValuesList(), textarea.getText()));
							ROOMTYPE=roomtype1.getText();
							STUDENTID=studentid.getText();
							BORROWINGDAYS=borrowingdays.getSelectedValue();								
							ROOMCHOICE=room.getSelectedItem();
							EQUIPMENTREQUIREMENTS=equipment.getSelectedValuesList();
							BRIEFDESCRIPTION=textarea.getText();
						}
					}
				}
			}
		);
		
		//按下clear，清除所有填寫的資料
		clearbutton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						roomtypegroup.clearSelection();
						studentid.setText("");
						borrowingdays.clearSelection();
						room.setSelectedIndex(0);
						equipment.clearSelection();
						textarea.setText("");
						checkbox.setSelected(false);
					}
				}
				);
	}
}
