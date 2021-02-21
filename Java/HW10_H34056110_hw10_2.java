package hw10_2;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class H34056110_hw10_2 
{
	public static void main(String[] args)
	{
		EncryptionandDecryption EncryptionandDecryption=new EncryptionandDecryption();
		EncryptionandDecryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EncryptionandDecryption.setSize(550,450);
		EncryptionandDecryption.setLayout(null);
		EncryptionandDecryption.setVisible(true);
	}
}
	
	class EncryptionandDecryption extends JFrame
	{		
		private final JLabel input;
		private final JLabel output;
		private final JLabel key;
		private final JTextField title;
		private final JTextField inputtext;
		private final JTextField outputtext;
		private final JTextField keytext;
		
		public EncryptionandDecryption()
		{
			super("File Encryption and Decryption");
			setLayout(new FlowLayout());
			
			title=new JTextField("File Encryption and Decryption");
			title.setBackground(new Color(11,97,164));
			title.setForeground(Color.white);
			title.setHorizontalAlignment(title.CENTER);
			title.setEditable(false);
			title.setBounds(0, 0,550,25);
			add(title);
			
			input=new JLabel(String.format("INPUT MESSAGE :"));
			input.setHorizontalTextPosition(SwingConstants.LEFT);
			input.setBounds(20,60,100,30);
			add(input);
			
			inputtext=new JTextField(70);
			inputtext.setBounds(20, 90, 500, 20);
			add(inputtext);
			
			key=new JLabel(String.format("KEY:"));
			key.setHorizontalTextPosition(SwingConstants.LEFT);
			key.setBounds(20,120,100,30);
			add(key);
			
			keytext=new JTextField(70);
			keytext.setBounds(20,150,500,20);
			add(keytext);
			
			output=new JLabel(String.format("OUTPUT MESSAGE :"));
			output.setHorizontalTextPosition(SwingConstants.LEFT);
			output.setBounds(20,180,200,30);
			add(output);
			
			outputtext=new JTextField(70);
			outputtext.setBounds(20, 210, 500, 20);
			outputtext.setEditable(false);
			add(outputtext);
						
			JButton readbutton=new JButton("Read file");
			readbutton.setBounds(40, 300, 100, 20);
			add(readbutton);
								
			JButton encryptbutton=new JButton("Encrypt");
			encryptbutton.setBounds(215, 300, 100, 20);
			add(encryptbutton);
			
			JButton decryptbutton=new JButton("Decrypt");
			decryptbutton.setBounds(390, 300, 100, 20);
			add(decryptbutton);
			
			encryptbutton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							if(inputtext.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null,"You need to input the message");
							}
							else if(keytext.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null,"You need to input the key");
							}
							else if(!ValidateInput(inputtext.getText()))
							{
								JOptionPane.showMessageDialog(null,"You need to input the lowercase letters");
							}
							else if(!ValidateKey(keytext.getText()))
							{
								JOptionPane.showMessageDialog(null,"The key value must be an integer");
							}
							else 
							{
								char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
							            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
							            'w', 'x', 'y', 'z'};
								
								String input=inputtext.getText();
								int key=Integer.parseInt(keytext.getText()); //強制轉型，將key資料型態轉成integer
								key=key%26; //以免輸入的key值超出26
								
								char[] inputarray = input.toCharArray(); //將string轉換成char的array
								
								for(int i=0;i<inputarray.length;i++)
								{
									for(int j=0;j<26;j++)
									{
										if(inputarray[i]==letters[j]) 
										{
											int index;
											index=(j+key)%26; //避免超出array範圍
											inputarray[i]=letters[index]; //加密字母
											break;
										}
									}
								}
								outputtext.setText(String.valueOf(inputarray)); //將結果顯示在output欄
								try 
								{
									FileWriter fw=new FileWriter("Encrypted.txt"); //建立檔案
									fw.write(String.format("INPUT MESSAGE : %s%nENCRYPTED MESSAGE : %s%n"
											, inputtext.getText(),String.valueOf(inputarray)));
									fw.close();
								} 
								catch (IOException e) 
								{
									JOptionPane.showMessageDialog(null,"Can not creat the file");
								}
							}
						}
					}
					);
			
			decryptbutton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							if(inputtext.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null,"You need to input the message");
							}
							else if(keytext.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null,"You need to input the key");
							}
							else if(!ValidateInput(inputtext.getText()))
							{
								JOptionPane.showMessageDialog(null,"You need to input the lowercase letters");
							}
							else if(!ValidateKey(keytext.getText()))
							{
								JOptionPane.showMessageDialog(null,"The key value must be an integer");
							}
							else 
							{
								char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
							            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
							            'w', 'x', 'y', 'z'};
								
								String input=inputtext.getText();
								int key=Integer.parseInt(keytext.getText()); //強制轉型，將key資料型態轉成integer
								key=key%26; //以免輸入的key值超出26
								
								char[] inputarray = input.toCharArray(); //將string轉換成char的array
								
								for(int i=0;i<inputarray.length;i++)
								{
									for(int j=0;j<26;j++)
									{
										if(inputarray[i]==letters[j])
										{
											int index;
											index=((j-key)+26)%26; //避免超出array範圍
											inputarray[i]=letters[index]; //解密字母
											break;
										}
									}
								}
								outputtext.setText(String.valueOf(inputarray)); //將結果顯示在output欄
								try 
								{
									FileWriter fw=new FileWriter("Decrypted.txt"); //建立檔案
									fw.write(String.format("INPUT MESSAGE : %s%nDECRYPTED MESSAGE : %s%n"
											, inputtext.getText(),String.valueOf(inputarray)));
									fw.close();
								} 
								catch (IOException e) 
								{
									JOptionPane.showMessageDialog(null,"Can not creat the file");
								}
							}
						}
					}
					);
			
			readbutton.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							FileReader Reader;
					        try 
					        {
					            Reader = new FileReader("read_file.txt");
					            BufferedReader bufferedReader = new BufferedReader(Reader);
					            if (bufferedReader.ready())
					            {
					               inputtext.setText(bufferedReader.readLine()) ;
					            }
					            Reader.close();
					        } 
					        catch (Exception exception) 
					        {
					        	JOptionPane.showMessageDialog(null,"Can not open the file");
					        }
						}
					}
					);
		}
		public Boolean ValidateInput(String text)
		{
			Pattern p = Pattern.compile("[a-z]*");
			Matcher m = p.matcher(text);
			return m.matches();
		}
		
		public Boolean ValidateKey(String text)
		{
			Pattern p = Pattern.compile("[0-9]*");
			Matcher m = p.matcher(text);
			return m.matches();
		}
	}
	












