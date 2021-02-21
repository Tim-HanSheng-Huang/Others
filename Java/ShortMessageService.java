package hw9;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class ShortMessageService extends JFrame
{
	ArrayList<ArrayList<String>> birthdays = new ArrayList<ArrayList<String>>();
		
	private int FRIENDNUMBER=0;
	private final JTextField title;
	private final JTextField lastnametext;
	private final JTextField firstnametext;
	private final JTextField datetext;
	private final JTextField timetext;
	private final JTextField mobiletext;

	private final JLabel lastname;
	private final JLabel firstname;
	private final JLabel date;
	private final JLabel time;
	private final JLabel mobile;
	private final JLabel message;
	private final JTextArea messagearea;
	
	public ShortMessageService()
	{
		super("Birthday Short Message Service System");
		setLayout(new FlowLayout());
			
		title=new JTextField("Birthday Short Message Service System");
		title.setBackground(new Color(11,97,164));
		title.setForeground(Color.white);
		title.setHorizontalAlignment(title.CENTER);
		title.setEditable(false);
		title.setBounds(0, 0,550,25);
		add(title);
		
		lastname=new JLabel(String.format("LAST NAME¡G"));
		lastname.setHorizontalTextPosition(SwingConstants.LEFT);
		lastname.setBounds(10,30,100,30);
		add(lastname);
		
		lastnametext=new JTextField(70);
		lastnametext.setBounds(100, 35, 200, 20);
		add(lastnametext);
		
		firstname=new JLabel(String.format("FIRST NAME¡G"));
		firstname.setHorizontalTextPosition(SwingConstants.LEFT);
		firstname.setBounds(10,30,100,90);
		add(firstname);
		
		firstnametext=new JTextField(70);
		firstnametext.setBounds(100, 65, 200, 20);
		add(firstnametext);
		
		date=new JLabel(String.format("DATE¡G(MM/DD/YYYY)"));
		date.setHorizontalTextPosition(SwingConstants.LEFT);
		date.setBounds(10,30,200,150);
		add(date);
		
		datetext=new JTextField(70);
		datetext.setBounds(150, 95, 200, 20);
		add(datetext);
		
		time=new JLabel(String.format("TIME¡G(HH:MM)"));
		time.setHorizontalTextPosition(SwingConstants.LEFT);
		time.setBounds(10,30,200,210);
		add(time);
		
		timetext=new JTextField(70);
		timetext.setBounds(150, 125, 200, 20);
		add(timetext);
		
		mobile=new JLabel(String.format("MOBILE¡G(09dd-ddddddd)"));
		mobile.setHorizontalTextPosition(SwingConstants.LEFT);
		mobile.setBounds(10,30,200,270);
		add(mobile);
		
		mobiletext=new JTextField(70);
		mobiletext.setBounds(200, 155, 200, 20);
		add(mobiletext);
		
		message=new JLabel(String.format("MESSAGE¡G"));
		message.setHorizontalTextPosition(SwingConstants.LEFT);
		message.setBounds(10,30,100,330);
		add(message);
		
		messagearea=new JTextArea();
		messagearea.setBounds(10, 210, 500, 150);
		add(messagearea);
		
		JButton clearbutton=new JButton("CLEAR");
		clearbutton.setBounds(125, 400, 100, 20);
		add(clearbutton);
		
		JButton sendbutton=new JButton("SEND");
		sendbutton.setBounds(275, 400, 100, 20);
		add(sendbutton);
		
		sendbutton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						if(lastnametext.getText().equals("")
								||firstnametext.getText().equals("")
								||datetext.getText().equals("")
								||timetext.getText().equals("")
								||mobiletext.getText().equals("")
								||messagearea.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null,"You need to fill in all the questions.");
						}
						else if(!ValidateLastName(lastnametext.getText()))
						{
							JOptionPane.showMessageDialog(null,"The last name is in the wrong format");
						}
						else if(!ValidateFirstName(firstnametext.getText()))
						{
							JOptionPane.showMessageDialog(null,"The first name is in the wrong format");
						}
						else if(!ValidateFirstDate(datetext.getText()))
						{
							JOptionPane.showMessageDialog(null,"The date is in the wrong format");
						}
						else if (!ValidateTime(timetext.getText()))
						{
							JOptionPane.showMessageDialog(null,"The time is in the wrong format");
						}
						else if(!ValidateMobile(mobiletext.getText()))
						{
							JOptionPane.showMessageDialog(null,"The mobile is in the wrong format");
						}
						else
						{
							JOptionPane.showMessageDialog(null, 
									String.format(" lastname:%s%n firstname:%s%n date:%s%n time:%s%n mobile:%s%n message:%s%n"
											,lastnametext.getText(),firstnametext.getText()
											,datetext.getText(),timetext.getText()
											,mobiletext.getText(),messagearea.getText()));
							Save(lastnametext.getText(),firstnametext.getText()
									,datetext.getText(),timetext.getText()
									,mobiletext.getText(),messagearea.getText());
						}
					}
				}
				);
		
		clearbutton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						lastnametext.setText("");
						firstnametext.setText("");
						datetext.setText("");
						timetext.setText("");
						mobiletext.setText("");
						messagearea.setText("");
					}
				}
				);
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		JMenuItem showbirthday=new JMenuItem("show");
		bar.add(showbirthday);
		
		showbirthday.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(FRIENDNUMBER==0)
						{
							JOptionPane.showMessageDialog(null,"You have to input the birthday");
						}
						for(int i=0;i<FRIENDNUMBER;i++)
						{
							JOptionPane.showMessageDialog(null, 
									String.format(" lastname:%s%n firstname:%s%n date:%s%n time:%s%n mobile:%s%n message:%s%n %n"
												,birthdays.get(i).get(0),birthdays.get(i).get(1)
												,birthdays.get(i).get(2),birthdays.get(i).get(3)
												,birthdays.get(i).get(4),birthdays.get(i).get(5)));
						}
					}
				}
				);
		
		JMenuItem exititem=new JMenuItem("Exit");
		bar.add(exititem);
		exititem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);						
					}
				}
				);
	}
	
	public void Save(String lastname,String firstname,String date,String time,String mobile,String message)
	{
		ArrayList<String> insidebirthday = new ArrayList<String>();
		insidebirthday.add(lastname);
		insidebirthday.add(firstname);
		insidebirthday.add(date);
		insidebirthday.add(time);
		insidebirthday.add(mobile);
		insidebirthday.add(message);
		
		birthdays.add(insidebirthday);
		
		FRIENDNUMBER++;
	}
	
	public Boolean ValidateLastName(String text)
	{
		Pattern p = Pattern.compile("[A-Z][a-z]*");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	public Boolean ValidateFirstName(String text)
	{
		Pattern p = Pattern.compile("[A-Z][a-z]*-*[A-Za-z]*");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	public Boolean ValidateFirstDate(String text)
	{
		Pattern p = Pattern.compile("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/[0-9]{4}");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	public Boolean ValidateTime(String text)
	{
		Pattern p = Pattern.compile("([0-1][0-9]|2[0-3]):[0-5][0-9]");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	public Boolean ValidateMobile(String text)
	{
		Pattern p = Pattern.compile("[0-9]{4}-[0-9]{6}");
		Matcher m = p.matcher(text);
		return m.matches();
	}
}
