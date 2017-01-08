/*
MIT License

Copyright (c) 2017 Beau Hahn

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.util.*;
import java.sql.*;

	public class Client extends Screen {
		private int mode;
		private int id = 0;
		private JPanel c_data;
		private JTextField lname;
		private JTextField fname;
		private JTextField mi;
		private JComboBox title;
			private final String[] TITLES = {"None","Mr.","Mrs.","Ms.","Dr."};
		private JTextField suffix;
		private JSeparator addblock;
		private JTextField address1;
		private JTextField address2;
		private JTextField city;
		private JComboBox state;
			private final String[] STATES = {"","AL","AK","AS","AZ","AR","CA","CO","CT","DE - Delaware","DC","FM","FL - Florida","GA Georgia","GU","HI","ID - Idaho","IL - Illinois","IN","IA","KS","KY","LA","ME","MH","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","MP","OH","OK","OR","PW","PA","PR","RI","SC","SD","TN","TX","UT","VT","VI","VA","WA","WV","WI","WY","AE","AA","AP"};
		private JTextField zip;
		private JTextField plus4;
		private JSeparator contactblock;
		private JComboBox contactopt;
			private final String[] CONTACTS = {"Home","Work","Fax","Mobile","Email","Alternate"};
		private JTextField contact;
		private JButton usecontact;
		private String[] contactbuffer = {"","","","","",""};
		private JSeparator tabblock;
		private JTabbedPane tabs;
			private JPanel notes;
				private JScrollPane notescroll;
				private JTextArea notearea;
			private JPanel sales;
				private JScrollPane salescroll;
				private JTable histsales;
					private String[][] SALEFIELDS = {{"No Data","No Data","No Data","No Data","No Data"}};
					private final String[] SALEFIELDNAMES = {"Invoice#","Date","Amount","Payment Type","Status"};
					private JButton editsale;
					private JLabel totalsale;
					private JLabel totalsamount;
					private JLabel avgsamount;
			private JPanel account;
				private JPanel crl;
				private JPanel cr;
					private JTextField maxline;
					private JLabel balance;
					private JLabel available;
					private JLabel status;
					private JLabel plan;
					private JLabel due;
				private JPanel fil;
				private JPanel fi;
					private JTextField card;
					private JTextField cvv2;
					private JLabel blanker4;
					private JTextField aba;
					private JTextField acct;
					private JButton payment;
					private JButton statement;
			private JPanel art;
			private JPanel marketing;
		private JPanel p_data;
			private JCheckBox pendunprint;
			private JCheckBox p_statement;
			private JButton process;
			private JButton cancel;
		private ScreenCommand s_command;
		private AutoFill auto_fill;
		private ContactListener contact_listen;
		private ContactOptListener conopt_listen;
		
		public String getUpdateString() /*this method creates an update string for the Client window*/ {
			String rval = "";
			if(validate()&&id==0)
			rval += "(title,fname,mi,lname,suffix,address1,address2,city,state,zip,plusfour,homephone,altphone,fax,mobile,email,altcon,notes) "+
					"VALUES ('"+title.getSelectedItem()+"',"+
					"'"+fname.getText()+"',"+
					"'"+mi.getText()+"',"+
					"'"+lname.getText()+"',"+
					"'"+suffix.getText()+"',"+
					"'"+address1.getText()+"',"+
					"'"+address2.getText()+"',"+
					"'"+city.getText()+"',"+
					"'"+state.getSelectedItem()+"',"+
					"'"+zip.getText()+"',"+
					"'"+plus4.getText()+"',"+
					"'"+contactbuffer[0]+"',"+
					"'"+contactbuffer[1]+"',"+
					"'"+contactbuffer[2]+"',"+
					"'"+contactbuffer[3]+"',"+
					"'"+contactbuffer[4]+"',"+
					"'"+contactbuffer[5]+"',"+
					"'"+notearea.getText()+"')";
			else if(validate()&&id!=0)
				rval += "SET title = '"+title.getSelectedItem()+"',"+
						"fname = '"+fname.getText()+"',"+
						"mi = '"+mi.getText()+"',"+
						"lname = '"+lname.getText()+"',"+
						"suffix = '"+suffix.getText()+"',"+
						"address1 = '"+address1.getText()+"',"+
						"address2 = '"+address2.getText()+"',"+
						"city = '"+city.getText()+"',"+
						"state = '"+state.getSelectedItem()+"',"+
						"zip = '"+zip.getText()+"',"+
						"plusfour = '"+plus4.getText()+"',"+
						"homephone = '"+contactbuffer[0]+"',"+
						"altphone = '"+contactbuffer[1]+"',"+
						"fax = '"+contactbuffer[2]+"',"+
						"mobile = '"+contactbuffer[3]+"',"+
						"email = '"+contactbuffer[4]+"',"+
						"altcon = '"+contactbuffer[5]+"',"+
						"notes = '"+notearea.getText()+"' WHERE id = "+id;				
			else return rval;		
			return rval;
		}
		
		public String getQueryString() /*this method creates a query string for the Client widnow*/ {
			String rval = "";
			rval += "WHERE "+(title.getSelectedItem().equals("None")?"":"title = '"+(String)title.getSelectedItem()+"' AND ")+
					(fname.getText().equals("")?"":"fname = '"+fname.getText()+"' AND ")+
					(mi.getText().equals("")?"":"mi = '"+mi.getText()+"' AND ")+
					(lname.getText().equals("")?"":"lname = '"+lname.getText()+"' AND ")+
					(suffix.getText().equals("")?"":"suffix = '"+suffix.getText()+"' AND ")+
					(address1.getText().equals("")?"":"address1 = '"+address1.getText()+"' AND ")+
					(address2.getText().equals("")?"":"address2 = '"+address2.getText()+"' AND ")+
					(city.getText().equals("")?"":"city = '"+city.getText()+"' AND ")+
					(state.getSelectedItem().equals("")?"":"state = '"+state.getSelectedItem()+"' AND ")+
					(zip.getText().equals("")?"":"zip = '"+zip.getText()+"' AND ")+
					(plus4.getText().equals("")?"":"plus4 = '"+plus4.getText()+"' AND ")+
					(contactbuffer[0].equals("")?"":"homephone = '"+contactbuffer[0]+"' AND ")+
					(contactbuffer[1].equals("")?"":"altphone = '"+contactbuffer[1]+"' AND ")+
					(contactbuffer[2].equals("")?"":"fax = '"+contactbuffer[2]+"' AND ")+
					(contactbuffer[3].equals("")?"":"mobile = '"+contactbuffer[3]+"' AND ")+
					(contactbuffer[4].equals("")?"":"email = '"+contactbuffer[4]+"' AND ")+
					(contactbuffer[5].equals("")?"":"altcon = '"+contactbuffer[5]+"' AND ")+
					"notes LIKE '%"+notearea.getText()+"%'";
			return (rval.equals("WHERE "))?"":rval;
		}
		
		public boolean validate() /*this methods validates primary key fields for data*/ {
			//if(title.equals("None")||fname.equals("")||lname.equals("")||address1.equals("")||city.equals("")||state.equals("")||zip.equals("")||contactbuffer[0].equals("")) return false;
			return true;
		}
		
		Client(int h,int w,int mode) {
			//client frame configuration
			super("Client "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			//client frame configuration
			
			//GUI.Taskette.setTask("Drawing Client Window"); new GUI.Taskette().run(); //task start
			
		//a	Compute.initialize("Just Lookin","Access");
			Compute.setup("Just Lookin","Access");
			this.mode = mode;
			
			//component initialization
			c_data = new JPanel();
			lname = new JTextField();
			fname = new JTextField();
			mi = new JTextField();
			title = new JComboBox(TITLES);
			suffix = new JTextField();
			addblock = new JSeparator(SwingConstants.HORIZONTAL);
			address1 = new JTextField();
			address2 = new JTextField();
			city = new JTextField();
			state = new JComboBox(STATES);
			zip = new JTextField();
			plus4 = new JTextField();
			contactblock = new JSeparator(SwingConstants.HORIZONTAL);
			contactopt = new JComboBox(CONTACTS);
			contact = new JTextField();
			usecontact = new JButton("Dial");
			tabblock = new JSeparator(SwingConstants.HORIZONTAL);
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				sales = new JPanel();
					histsales = new JTable(SALEFIELDS,SALEFIELDNAMES);
					salescroll = new JScrollPane(histsales);
					editsale = new JButton("Edit Sale");
					totalsale = new JLabel("0 Sales");
					totalsamount = new JLabel("$0.00 Total");
					avgsamount = new JLabel("$0.00 Average");
				account = new JPanel();
					crl = new JPanel();
					cr = new JPanel();
					maxline = new JTextField();
					balance = new JLabel("$0.00");
					available = new JLabel("0.00");
					status = new JLabel("N/A");
					plan = new JLabel("No Plan");
					fil = new JPanel();
					fi = new JPanel();
					due = new JLabel("00/00/00");
					card = new JTextField();
					cvv2 = new JTextField();
					blanker4 = new JLabel();
					aba = new JTextField();
					acct = new JTextField();
					payment = new JButton("Make Payment");
					statement = new JButton("Prepare Statement");
				art = new JPanel();
				marketing = new JPanel();
			p_data = new JPanel();
				pendunprint = new JCheckBox("Pend Unprinted Docs");
				p_statement = new JCheckBox("Account Statement");
				process = new JButton((mode==11602)?" Query ":"Update/Next");
				cancel = new JButton("Clear/Cancel");
			s_command = new ScreenCommand();
			auto_fill = new AutoFill();
			contact_listen = new ContactListener();
			conopt_listen = new ContactOptListener();
			//component initialization
			
			//component configuration
			c_data.setPreferredSize(new Dimension(570,470));
			c_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			lname.setPreferredSize(new Dimension(90,20));
			lname.setName("lname");
			lname.addKeyListener(auto_fill);
			fname.setPreferredSize(new Dimension(90,20));
			fname.setName("fname");
			fname.addKeyListener(auto_fill);
			mi.setPreferredSize(new Dimension(20,20));
			mi.setName("mi");
			mi.addKeyListener(auto_fill);
			title.setPreferredSize(new Dimension(50,20));
			suffix.setPreferredSize(new Dimension(40,20));
			suffix.setName("suffix");
			suffix.addKeyListener(auto_fill);
			addblock.setPreferredSize(new Dimension(560,5));
			address1.setPreferredSize(new Dimension(470,20));
			address1.setName("address1");
			address1.addKeyListener(auto_fill);
			address2.setPreferredSize(new Dimension(470,20));
			address2.setName("address2");
			address2.addKeyListener(auto_fill);
			city.setPreferredSize(new Dimension(150,20));
			city.setName("city");
			city.addKeyListener(auto_fill);
			state.setPreferredSize(new Dimension(150,20));
			state.setName("state");
			zip.setPreferredSize(new Dimension(50,20));
			zip.setName("zip");
			zip.addKeyListener(auto_fill);
			plus4.setPreferredSize(new Dimension(40,20));
			plus4.setName("plusfour");
			plus4.addKeyListener(auto_fill);
			contactblock.setPreferredSize(new Dimension(560,5));
			contactopt.setPreferredSize(new Dimension(120,20));
			contactopt.addFocusListener(conopt_listen);
			contact.setPreferredSize(new Dimension(250,20));
			contact.setName("homephone");
			contact.addKeyListener(auto_fill);
			contact.addFocusListener(contact_listen);
			usecontact.setPreferredSize(new Dimension(70,20));
			tabblock.setPreferredSize(new Dimension(560,5));
			tabs.setPreferredSize(new Dimension(560,225));
				notes.setName("Notes");
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
					notescroll.setPreferredSize(new Dimension(475,180));
					notearea.setPreferredSize(new Dimension(455,170));
					notearea.setName("notes");
				sales.setName("Sales");
				sales.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
					salescroll.setPreferredSize(new Dimension(475,180));
					histsales.setPreferredSize(new Dimension(455,170));
					histsales.setEnabled(false);
					editsale.setPreferredSize(new Dimension(100,20));
					totalsale.setPreferredSize(new Dimension(100,20));
					totalsamount.setPreferredSize(new Dimension(100,20));
					avgsamount.setPreferredSize(new Dimension(100,20));
				account.setName("Account");
				account.setLayout(new GridBagLayout());
					//crl.setPreferredSize(new Dimension(60,180));
					//crl.setLayout(new FlowLayout(FlowLayout.RIGHT,5,9));
					//cr.setPreferredSize(new Dimension(125,180));
					//cr.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
						maxline.setPreferredSize(new Dimension(100,20));
						balance.setPreferredSize(new Dimension(100,20));
						available.setPreferredSize(new Dimension(100,20));
						status.setPreferredSize(new Dimension(100,20));
						plan.setPreferredSize(new Dimension(100,20));
						due.setPreferredSize(new Dimension(100,20));
					//fil.setPreferredSize(new Dimension(90,180));
					//fil.setLayout(new FlowLayout(FlowLayout.RIGHT,5,9));
					//fi.setPreferredSize(new Dimension(175,180));
					//fi.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
						card.setPreferredSize(new Dimension(125,20));
						cvv2.setPreferredSize(new Dimension(50,20));
						blanker4.setPreferredSize(new Dimension(30,20));
						aba.setPreferredSize(new Dimension(100,20));
						acct.setPreferredSize(new Dimension(100,20));
						payment.setPreferredSize(new Dimension(120,20));
						statement.setPreferredSize(new Dimension(140,20));
				art.setName("Art");
				art.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				marketing.setName("Marketing");
				marketing.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setPreferredSize(new Dimension(150,470));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			pendunprint.setSelected(true);
			process.addActionListener(s_command);
			process.setActionCommand("CLIENTS");
			cancel.addActionListener(s_command);
			cancel.setActionCommand("");
			//component configuration
			
			//content configuration
			add(c_data);
			c_data.add(new JLabel("Last Name:"));
			c_data.add(lname);
			c_data.add(new JLabel("First Name:"));
			c_data.add(fname);
			c_data.add(new JLabel("M.I.:"));
			c_data.add(mi);
			c_data.add(new JLabel("Title:"));
			c_data.add(title);
			c_data.add(new JLabel("Suffix:"));
			c_data.add(suffix);
			c_data.add(addblock);
			c_data.add(new JLabel("Mailing Address                                                                                                                                            "));
			c_data.add(new JLabel("Address Line 1:"));
			c_data.add(address1);
			c_data.add(new JLabel("Address Line 2:"));
			c_data.add(address2);
			c_data.add(new JLabel("City:"));
			c_data.add(city);
			c_data.add(new JLabel("State:"));
			c_data.add(state);
			c_data.add(new JLabel("ZIP:"));
			c_data.add(zip);
			c_data.add(new JLabel("Plus 4:"));
			c_data.add(plus4);
			c_data.add(contactblock);
			c_data.add(contactopt);
			c_data.add(contact);
			c_data.add(usecontact);
			c_data.add(tabblock);
			c_data.add(tabs);
				tabs.add(notes);
					notes.add(new JLabel("Client Notes:"));
					notes.add(notescroll);
				tabs.add(sales);
					sales.add(salescroll);
					sales.add(editsale);
					sales.add(totalsale);
					sales.add(totalsamount);
					sales.add(avgsamount);
				tabs.add(account);
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.ipadx = 5; //gbc.ipady = 5;
				//	account.add(crl);
				//	account.add(cr);
					account.add(new JLabel("Credit Line:"),gbc);
					account.add(maxline,gbc); gbc.gridy = 1;
					account.add(new JLabel("Balance:"),gbc);
					account.add(balance,gbc);
				//	account.add(fil);
				//	account.add(fi);
					//fil.add(blanker4);
				//	fil.add(new JLabel("Card No.:"));
				//	fi.add(card);
				//	fil.add(new JLabel("CVV2:"));
				//	fi.add(cvv2);;
				//	fil.add(new JLabel("Routing Number:"));
				//	fi.add(aba);
				//	fil.add(new JLabel("Account Number:"));
				//	fi.add(acct);
				//	fi.add(payment);
				//	fi.add(statement);
				tabs.add(art);
				tabs.add(marketing);
			add(p_data);
				p_data.add(pendunprint);
				p_data.add(new JLabel("---Documents---"));
				p_data.add(p_statement);
				p_data.add(new JLabel("----Reports----"));
				p_data.add(process);
				p_data.add(cancel);
			//content configuration
			
			GUI.endTask(); //task end
		}		
		
		public class ScreenCommand implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
				JComponent source = (JComponent)ae.getSource();
				if(!ae.getActionCommand().equals("")) 
				if(id==0) Compute.insert(ae.getActionCommand(),getUpdateString());
				else Compute.update(ae.getActionCommand(),getUpdateString());
				else { }
				id = 0;
				title.setSelectedItem("None");
				fname.setText("");
				mi.setText("");
				lname.setText("");
				suffix.setText("");
				address1.setText("");
				address2.setText("");
				city.setText("");
				state.setSelectedItem("");
				zip.setText("");
				plus4.setText("");
				contactbuffer[0] = "";
				contactbuffer[1] = "";
				contactbuffer[2] = "";
				contactbuffer[3] = "";
				contactbuffer[4] = "";
				contactbuffer[5] = "";
				contact.setText("");
				contactopt.setSelectedIndex(0);
				notearea.setText("");
			}
		}
		
		public class AutoFill implements KeyListener {
			public void keyPressed(KeyEvent ke) {
			}
			public void keyReleased(KeyEvent ke) {
				JTextField source = (JTextField)ke.getSource();
				String col = source.getName();
				int key = ke.getKeyCode();
				switch(key) {
					case KeyEvent.VK_ENTER:
					try {
						ResultSet rs = Compute.query("*","CLIENTS",getQueryString());
						if(rs.next()) {
							id = rs.getInt("id");
							title.setSelectedItem(rs.getString("title"));
							fname.setText(rs.getString("fname"));
							mi.setText(rs.getString("mi"));
							lname.setText(rs.getString("lname"));
							suffix.setText(rs.getString("suffix"));
							address1.setText(rs.getString("address1"));
							address2.setText(rs.getString("address2"));
							city.setText(rs.getString("city"));
							state.setSelectedItem(rs.getString("state"));
							zip.setText(rs.getString("zip"));
							plus4.setText(rs.getString("plusfour"));
							contactbuffer[0] = rs.getString("homephone");
							contactbuffer[1] = rs.getString("altphone");
							contactbuffer[2] = rs.getString("fax");
							contactbuffer[3] = rs.getString("mobile");
							contactbuffer[4] = rs.getString("email");
							contactbuffer[5] = rs.getString("altcon");
							contact.setText(contactbuffer[contactopt.getSelectedIndex()]);
							notearea.setText(rs.getString("notes"));
						}
						else {
							id = 0;
							title.setSelectedItem("None");
							fname.setText("");
							mi.setText("");
							lname.setText("");
							suffix.setText("");
						address1.setText("");
						address2.setText("");
						city.setText("");
						state.setSelectedItem("");
						zip.setText("");
						plus4.setText("");
						contactbuffer[0] = "";
						contactbuffer[1] = "";
						contactbuffer[2] = "";
						contactbuffer[3] = "";
						contactbuffer[4] = "";
						contactbuffer[5] = "";
						contact.setText("");
						contactopt.setSelectedIndex(0);
						notearea.setText("");
						}
					}
					catch (SQLException sqle) { sqle.printStackTrace(); }
					break;
					case KeyEvent.VK_SHIFT:
					break;
					default:
					int caret = source.getCaretPosition();
					try {	
						ResultSet rs = Compute.query(col,"CLIENTS",getQueryString()+" OR "+col+" LIKE '"+source.getText().substring(0,caret)+"%'");
						if(rs.next()&&!source.getText().equals("")&&caret!=0) {
							String string = rs.getString(col);
							System.out.println(string);
							if(string.equals("")) break;
							source.setText(string);
							source.setCaretPosition(caret);
						}
						else source.setText(source.getText().substring(0,caret));
					}
					catch (SQLException sqle) { sqle.printStackTrace(); }
					break;
				}
			}
			public void keyTyped(KeyEvent ke) {
			}
		}
		
		public class ContactListener implements FocusListener {
			public void focusGained(FocusEvent fe) {
			}
			
			public void focusLost(FocusEvent fe) {
				contactbuffer[contactopt.getSelectedIndex()] = contact.getText();					
			}
		}
	
		public class ContactOptListener implements FocusListener {
			public void focusGained(FocusEvent fe) {
			}
			
			public void focusLost(FocusEvent fe) {
				contact.setText(contactbuffer[contactopt.getSelectedIndex()]);
				switch(contactopt.getSelectedIndex()) {
					case 0:
					contact.setName("homephone");
					break;
					case 1:
					contact.setName("altphone");
					break;
					case 2:
					contact.setName("fax");
					break;
					case 3:
					contact.setName("mobile");
					break;
					case 4:
					contact.setName("email");
					break;
					case 5:
					contact.setName("altcon");
					break;
				}
			}
		}
	}
	