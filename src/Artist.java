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

	public class Artist extends Screen {
		private int id = 0;
		private JPanel a_data;
		private JTextField lname;
		private JTextField fname;
		private JTextField mi;
		private JComboBox title;
			private final String[] TITLES = {"None","Mr.","Mrs.","Ms.","Dr."};
		private JTextField suffix;
		private JSeparator addblock;
		private JComboBox attnco;
			private final String[] ALERTS = {"None","attn:","c/o","(p/o)"};
		private JComboBox addressopt;
			private final String[] ADDIES = {"Mailing","Physical"};
		private JButton addaddress;
		private JTextField addressname;;
		private JTextField company;
		private JTextField address1;
		private JTextField address2;
		private JTextField city;
		private JComboBox state;
			private final String[] STATES = {"AL - Alabama","AK","AS","AZ - Arizona","AR","CA - California","CO - Colorado","CT - Connecticut","DE - Delaware","DC","FM","FL - Florida","GA Georgia","GU","HI","ID - Idaho","IL - Illinois","IN","IA","KS","KY","LA","ME","MH","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","MP","OH","OK","OR","PW","PA","PR","RI","SC","SD","TN","TX","UT","VT","VI","VA","WA","WV","WI","WY","AE","AA","AP"};
		private JTextField zip;
		private JTextField plus4;
		private JSeparator contactblock;
		private JComboBox contactopt;
			private final String[] CONTACTS = {"Home Phone","Business Phone","Fax","Mobile","Pager","Home Email","Business Email","Instant Messenger"};
		private JButton addcontact;
		private JTextField contactname;
		private JRadioButton phone;
		private JRadioButton email;
		private JRadioButton special;
		private JTextField contact;
		private JButton usecontact;
		private JSeparator tabblock;
		private JTabbedPane tabs;
			private JPanel notes;
				private JScrollPane notescroll;
				private JTextArea notearea;
			private JPanel bio;
				private JScrollPane portraitscroll;
				private JPanel portraitframe;
				private ImageIcon portrait;
				private JScrollPane bioscroll;
				private JEditorPane bioeditor;
				private JButton importportrait;
			private JPanel art;
				//private JScrollPane artscroll;
			private JPanel consign;
				//private JScrollPane consignscroll;
			private JPanel sales;
				//private JScrollPane salescroll;
		private JPanel p_data;
			private JCheckBox pendunprint;
			private JCheckBox artistconsign;
			private JButton process;
			private JButton cancel;
		
		Artist(int h,int w,int mode) {
			super("Artist "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			
			GUI.setTask("Drawing Client Window"); //task start
			
			a_data = new JPanel();
			lname = new JTextField();
			fname = new JTextField();
			mi = new JTextField();
			title = new JComboBox(TITLES);
			suffix = new JTextField();
			addblock = new JSeparator(SwingConstants.HORIZONTAL);
			addressopt = new JComboBox(ADDIES);
			addaddress = new JButton("Add...");
			addressname = new JTextField();
			JLabel blanker1 = new JLabel("");
			attnco = new JComboBox(ALERTS);
			company = new JTextField();
			JLabel blanker2 = new JLabel("");
			address1 = new JTextField();
			JLabel blanker3 = new JLabel("");
			address2 = new JTextField();
			city = new JTextField();
			state = new JComboBox(STATES);
			zip = new JTextField();
			plus4 = new JTextField();
			contactblock = new JSeparator(SwingConstants.HORIZONTAL);
			contactopt = new JComboBox(CONTACTS);
			addcontact = new JButton("Add...");
			contactname = new JTextField();
			phone = new JRadioButton("Phone");
			email = new JRadioButton("Email");
			special = new JRadioButton("IM/Other");
			contact = new JTextField();
			usecontact = new JButton("Dial");
			tabblock = new JSeparator(SwingConstants.HORIZONTAL);
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				bio = new JPanel();
					portrait = new ImageIcon();
					portraitframe = new JPanel();
					portraitscroll = new JScrollPane(portraitframe);
					bioeditor = new JEditorPane();
					bioscroll = new JScrollPane(bioeditor);
					importportrait = new JButton("Import Portrait");
				art = new JPanel();
				consign = new JPanel();
				sales = new JPanel();
			p_data = new JPanel();
				pendunprint = new JCheckBox("Pend Unprinted Docs");
				artistconsign = new JCheckBox("Term Consignment");
				process = new JButton("Query/Update");
				cancel = new JButton("Clear/Cancel");
			
			a_data.setPreferredSize(new Dimension(570,470));
			a_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			lname.setPreferredSize(new Dimension(90,20));
			fname.setPreferredSize(new Dimension(90,20));
			mi.setPreferredSize(new Dimension(20,20));
			title.setPreferredSize(new Dimension(50,20));
			suffix.setPreferredSize(new Dimension(40,20));
			addblock.setPreferredSize(new Dimension(560,5));
			addressopt.setPreferredSize(new Dimension(100,20));
			addaddress.setPreferredSize(new Dimension(80,20));
			addressname.setPreferredSize(new Dimension(100,20));
			blanker1.setPreferredSize(new Dimension(50,20));
			attnco.setPreferredSize(new Dimension(60,20));
			company.setPreferredSize(new Dimension(130,20));
			blanker2.setPreferredSize(new Dimension(200,20));
			address1.setPreferredSize(new Dimension(470,20));
			blanker3.setPreferredSize(new Dimension(120,20));
			address2.setPreferredSize(new Dimension(470,20));
			city.setPreferredSize(new Dimension(150,20));
			state.setPreferredSize(new Dimension(150,20));
			zip.setPreferredSize(new Dimension(50,20));
			plus4.setPreferredSize(new Dimension(40,20));
			contactblock.setPreferredSize(new Dimension(560,5));
			contactopt.setPreferredSize(new Dimension(120,20));
			addcontact.setPreferredSize(new Dimension(80,20));
			contactname.setPreferredSize(new Dimension(100,20));
			phone.setPreferredSize(new Dimension(75,20));
			email.setPreferredSize(new Dimension(75,20));
			special.setPreferredSize(new Dimension(75,20));
			contact.setPreferredSize(new Dimension(250,20));
			usecontact.setPreferredSize(new Dimension(70,20));
			tabblock.setPreferredSize(new Dimension(560,5));
			tabs.setPreferredSize(new Dimension(560,225));
				notes.setName("Notes");
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
					notescroll.setPreferredSize(new Dimension(475,180));
					notearea.setPreferredSize(new Dimension(455,170));
				bio.setName("Bio");
				bio.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
					portraitscroll.setPreferredSize(new Dimension(150,180));
					bioscroll.setPreferredSize(new Dimension(315,180));
					bioeditor.setPreferredSize(new Dimension(295,170));
					importportrait.setPreferredSize(new Dimension(100,20));
				art.setName("Artwork");
				art.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				consign.setName("Consignment");
				consign.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				sales.setName("Sales");
				sales.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setPreferredSize(new Dimension(150,470));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			pendunprint.setSelected(true);
			if(mode==11602) {
				addaddress.setEnabled(false);
				addressname.setEnabled(false);
				addcontact.setEnabled(false);
				contactname.setEnabled(false);
				phone.setEnabled(false);
				email.setEnabled(false);
				special.setEnabled(false);
			}
			
			add(a_data);
			a_data.add(new JLabel("Last Name:"));
			a_data.add(lname);
			a_data.add(new JLabel("First Name:"));
			a_data.add(fname);
			a_data.add(new JLabel("M.I.:"));
			a_data.add(mi);
			a_data.add(new JLabel("Title:"));
			a_data.add(title);
			a_data.add(new JLabel("Suffix:"));
			a_data.add(suffix);
			a_data.add(addblock);
			a_data.add(new JLabel("Address Information:"));
			a_data.add(addressopt);
			a_data.add(addaddress);
			a_data.add(new JLabel("Address Name:"));
			a_data.add(addressname);
			a_data.add(blanker1);
			a_data.add(new JLabel("attn..."));
			a_data.add(attnco);
			a_data.add(new JLabel("Group Name:"));
			a_data.add(company);
			a_data.add(blanker2);
			a_data.add(new JLabel("Address Line 1:"));
			a_data.add(address1);
			//a_data.add(blanker3);
			a_data.add(new JLabel("Address Line 2:"));
			a_data.add(address2);
			a_data.add(new JLabel("City:"));
			a_data.add(city);
			a_data.add(new JLabel("State:"));
			a_data.add(state);
			a_data.add(new JLabel("ZIP:"));
			a_data.add(zip);
			a_data.add(new JLabel("Plus 4:"));
			a_data.add(plus4);
			a_data.add(contactblock);
			a_data.add(contactopt);
			a_data.add(addcontact);
			a_data.add(contactname);
			a_data.add(phone);
			a_data.add(email);
			a_data.add(special);
			a_data.add(contact);
			a_data.add(usecontact);
			a_data.add(tabblock);
			a_data.add(tabs);
				tabs.add(notes);
					notes.add(new JLabel("Artist Notes:"));
					notes.add(notescroll);
				tabs.add(bio);
					bio.add(portraitscroll);
					bio.add(bioscroll);
					bio.add(importportrait);
					//
					importportrait.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							JFileChooser a = new JFileChooser();
							a.setFileFilter(Screen.IMAGE_ONLY);
							a.showOpenDialog(getFrame());
						}
					});
					//
				tabs.add(art);
				tabs.add(consign);
				tabs.add(sales);
			add(p_data);
				p_data.add(pendunprint);
				p_data.add(new JLabel("---Documents---"));
				p_data.add(artistconsign);
				p_data.add(new JLabel("----Reports----"));
				p_data.add(process);
				p_data.add(cancel);
				
			GUI.endTask(); //task end
		}
	}
	