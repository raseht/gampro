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

	public class Sale extends Screen {
		private JPanel s_data;
		private JTextField invoiceno;
		private JTextField pymtno;
		private JFormattedTextField date;
		private JLabel blanker1;
		private JRadioButton purchase;
		private JRadioButton framing;
		private JRadioButton purfram;
		private JTextField invno;
		private JButton additem;
		private JScrollPane itemscroll;
			private JTable items;
				private final String[][] ITEMSDATA = {{"No Data","No Data","No Data","No Data"}};
				private final String[] ITEMFIELDS = {"Invoice#","Title","Artist","Frame"};
		private JScrollPane previewscroll;
			private JPanel previewframe;
				private ImageIcon preview;
		private JSeparator frameblock;
		private JPanel frameglass;
			private JTextField frameno;
			private JLabel frameprice;
			private JTextField framedc;
			private ButtonGroup framedcbuttons;
			private JRadioButton framedcper;
			private JRadioButton framedcval;
			private JTextField glassno;
			private JLabel glassprice;
			private JTextField glassdc;
			private ButtonGroup glassdcbuttons;
			private JRadioButton glassdcper;
			private JRadioButton glassdcval;
		private JTabbedPane mats;
			private JPanel mat1;
				private JTextField mat1no;
				private JLabel mat1price;
				private JTextField mat1dc;
				private ButtonGroup mat1dcbuttons;
				private JRadioButton mat1dcper;
				private JRadioButton mat1dcval;
				private JTextField mat1odimx;
				private JTextField mat1odimy;
				private JTextField mat1idimx;
				private JTextField mat1idimy;
			private JPanel mat2;
				private JTextField mat2no;
				private JLabel mat2price;
				private JTextField mat2dc;
				private ButtonGroup mat2dcbuttons;
				private JRadioButton mat2dcper;
				private JRadioButton mat2dcval;
				private JTextField mat2odimx;
				private JTextField mat2odimy;
				private JTextField mat2idimx;
				private JTextField mat2idimy;
			private JPanel mat3;
				private JTextField mat3no;
				private JLabel mat3price;
				private JTextField mat3dc;
				private ButtonGroup mat3dcbuttons;
				private JRadioButton mat3dcper;
				private JRadioButton mat3dcval;
				private JTextField mat3odimx;
				private JTextField mat3odimy;
				private JTextField mat3idimx;
				private JTextField mat3idimy;
			private JPanel mat4;
				private JTextField mat4no;
				private JLabel mat4price;
				private JTextField mat4dc;
				private ButtonGroup mat4dcbuttons;
				private JRadioButton mat4dcper;
				private JRadioButton mat4dcval;
				private JTextField mat4odimx;
				private JTextField mat4odimy;
				private JTextField mat4idimx;
				private JTextField mat4idimy;
			private JPanel mat5;
				private JTextField mat5no;
				private JLabel mat5price;
				private JTextField mat5dc;
				private ButtonGroup mat5dcbuttons;
				private JRadioButton mat5dcper;
				private JRadioButton mat5dcval;
				private JTextField mat5odimx;
				private JTextField mat5odimy;
				private JTextField mat5idimx;
				private JTextField mat5idimy;
			private JPanel mat6;
				private JTextField mat6no;
				private JLabel mat6price;
				private JTextField mat6dc;
				private ButtonGroup mat6dcbuttons;
				private JRadioButton mat6dcper;
				private JRadioButton mat6dcval;
				private JTextField mat6odimx;
				private JTextField mat6odimy;
				private JTextField mat6idimx;
				private JTextField mat6idimy;
		private JSeparator payblock;
		private JTabbedPane tabs;
			private JPanel payment;
				private JComboBox paytype;
					private final String[] TYPES = {"CASH","CHECK","DEBIT","CREDIT","LAYAWAY","HOLD"};
				private JCheckBox autoadd;
				private JTextField fname;
				private JTextField lname;
				private JTextField mi;
				private JLabel subtotal;
				private JLabel tax;
				private JTextField adjustment;
				private JCheckBox exempt;
				private JLabel total;
				private JButton process;
			private JPanel notes;
				private JScrollPane notescroll;
				private JTextArea notearea;
			private JPanel finance;
			private JPanel account;
		private JPanel p_data;
		
		Sale(int h,int w,int mode) {
 			//sales frame configuration
			super("Sale Window "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			//sales frame configuration
			
			
			Compute.initialize("Just Lookin","Access");
			GUI.setTask("Drawing Sale Window"); //task start
			
			//component initialization
			s_data = new JPanel();
			invoiceno = new JTextField();
			pymtno = new JTextField();
			date = new JFormattedTextField(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT));
			blanker1 = new JLabel("");
			purchase = new JRadioButton("Purchase");
			framing = new JRadioButton("Framing");
			purfram = new JRadioButton("Buy/Frame");
			invno = new JTextField();
			additem = new JButton("Add Item");
			items = new JTable(ITEMSDATA,ITEMFIELDS);
			itemscroll = new JScrollPane(items);	
			preview = new ImageIcon();
			previewframe = new JPanel();
			previewscroll = new JScrollPane(previewframe);
			frameblock = new JSeparator(SwingConstants.HORIZONTAL);
			frameglass = new JPanel();
				frameno = new JTextField();
				frameprice = new JLabel("$0.00");
				framedc = new JTextField("0");
				framedcper = new JRadioButton("%");
				framedcval = new JRadioButton("Value");
				framedcbuttons = new ButtonGroup();
				framedcbuttons.add(framedcper); framedcbuttons.add(framedcval);
				glassno = new JTextField();
				glassprice = new JLabel("$0.00");
				glassdc = new JTextField("0");
				glassdcper = new JRadioButton("%");
				glassdcval = new JRadioButton("Value");
				glassdcbuttons = new ButtonGroup();
				glassdcbuttons.add(glassdcper); glassdcbuttons.add(glassdcval);
			mats = new JTabbedPane(JTabbedPane.TOP);
				mat1 = new JPanel();
					mat1no = new JTextField();
					mat1price = new JLabel("$0.00");
					mat1dc = new JTextField("0");
					mat1dcper = new JRadioButton("%");
					mat1dcval = new JRadioButton("Value");
					mat1dcbuttons = new ButtonGroup();
					mat1dcbuttons.add(mat1dcper); mat1dcbuttons.add(mat1dcval);
					mat1odimx = new JTextField();
					mat1odimy = new JTextField();
					mat1idimx = new JTextField();
					mat1idimy = new JTextField();
				mat2 = new JPanel();
					mat2no = new JTextField();
					mat2price = new JLabel("$0.00");
					mat2dc = new JTextField("0");
					mat2dcper = new JRadioButton("%");
					mat2dcval = new JRadioButton("Value");
					mat2dcbuttons = new ButtonGroup();
					mat2dcbuttons.add(mat2dcper); mat2dcbuttons.add(mat2dcval);
					mat2odimx = new JTextField();
					mat2odimy = new JTextField();
					mat2idimx = new JTextField();
					mat2idimy = new JTextField();
				mat3 = new JPanel();
					mat3no = new JTextField();
					mat3price = new JLabel("$0.00");
					mat3dc = new JTextField("0");
					mat3dcper = new JRadioButton("%");
					mat3dcval = new JRadioButton("Value");
					mat3dcbuttons = new ButtonGroup();
					mat3dcbuttons.add(mat3dcper); mat3dcbuttons.add(mat3dcval);
					mat3odimx = new JTextField();
					mat3odimy = new JTextField();
					mat3idimx = new JTextField();
					mat3idimy = new JTextField();
				mat4 = new JPanel();
					mat4no = new JTextField();
					mat4price = new JLabel("$0.00");
					mat4dc = new JTextField("0");
					mat4dcper = new JRadioButton("%");
					mat4dcval = new JRadioButton("Value");
					mat4dcbuttons = new ButtonGroup();
					mat4dcbuttons.add(mat4dcper); mat4dcbuttons.add(mat4dcval);
					mat4odimx = new JTextField();
					mat4odimy = new JTextField();
					mat4idimx = new JTextField();
					mat4idimy = new JTextField();
				mat5 = new JPanel();
					mat5no = new JTextField();
					mat5price = new JLabel("$0.00");
					mat5dc = new JTextField("0");
					mat5dcper = new JRadioButton("%");
					mat5dcval = new JRadioButton("Value");
					mat5dcbuttons = new ButtonGroup();
					mat5dcbuttons.add(mat5dcper); mat5dcbuttons.add(mat5dcval);
					mat5odimx = new JTextField();
					mat5odimy = new JTextField();
					mat5idimx = new JTextField();
					mat5idimy = new JTextField();
				mat6 = new JPanel();
					mat6no = new JTextField();
					mat6price = new JLabel("$0.00");
					mat6dc = new JTextField("0");
					mat6dcper = new JRadioButton("%");
					mat6dcval = new JRadioButton("Value");
					mat6dcbuttons = new ButtonGroup();
					mat6dcbuttons.add(mat6dcper); mat6dcbuttons.add(mat6dcval);
					mat6odimx = new JTextField();
					mat6odimy = new JTextField();
					mat6idimx = new JTextField();
					mat6idimy = new JTextField();
			payblock = new JSeparator(SwingConstants.HORIZONTAL);
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				payment = new JPanel();
					paytype = new JComboBox(TYPES);
					autoadd = new JCheckBox("Auto-Add Client");
					fname = new JTextField();
					lname = new JTextField();
					mi = new JTextField();
					subtotal = new JLabel("$0.00");
					tax = new JLabel("$0.00");
					adjustment = new JTextField();
					total = new JLabel("$0.00");
					process = new JButton("Process Payment");
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				finance = new JPanel();
				account = new JPanel();
			p_data = new JPanel();
			//component initialization
			
			//component configuration
			s_data.setPreferredSize(new Dimension(570,470));
			s_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			invoiceno.setPreferredSize(new Dimension(80,20));
			pymtno.setPreferredSize(new Dimension(50,20));
			date.setPreferredSize(new Dimension(80,20));
			blanker1.setPreferredSize(new Dimension(100,20));
			purchase.setPreferredSize(new Dimension(80,20));
			framing.setPreferredSize(new Dimension(80,20));
			purfram.setPreferredSize(new Dimension(80,20));
			invno.setPreferredSize(new Dimension(80,20));
			additem.setPreferredSize(new Dimension(80,20));
			itemscroll.setPreferredSize(new Dimension(400,100));
			previewscroll.setPreferredSize(new Dimension(120,100));
			frameblock.setPreferredSize(new Dimension(560,5));
			frameglass.setPreferredSize(new Dimension(250,130));
			frameglass.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				frameno.setPreferredSize(new Dimension(80,20));
				frameprice.setPreferredSize(new Dimension(50,20));
				framedc.setPreferredSize(new Dimension(80,20));
				framedcper.setPreferredSize(new Dimension(40,20));
				framedcval.setPreferredSize(new Dimension(60,20));
				glassno.setPreferredSize(new Dimension(80,20));
				glassprice.setPreferredSize(new Dimension(50,20));
				glassdc.setPreferredSize(new Dimension(80,20));
				glassdcper.setPreferredSize(new Dimension(40,20));
				glassdcval.setPreferredSize(new Dimension(60,20));
			mats.setPreferredSize(new Dimension(310,130));
				mat1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat1.setName("Mat 1");
					mat1no.setPreferredSize(new Dimension(80,20));
					mat1price.setPreferredSize(new Dimension(50,20));
					mat1dc.setPreferredSize(new Dimension(80,20));
					mat1dcper.setPreferredSize(new Dimension(40,20));
					mat1dcval.setPreferredSize(new Dimension(60,20));
					mat1odimx.setPreferredSize(new Dimension(60,20));
					mat1odimy.setPreferredSize(new Dimension(60,20));
					mat1idimx.setPreferredSize(new Dimension(60,20));
					mat1idimy.setPreferredSize(new Dimension(60,20));
				mat2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat2.setName("Mat 2");
					mat2no.setPreferredSize(new Dimension(80,20));
					mat2price.setPreferredSize(new Dimension(50,20));
					mat2dc.setPreferredSize(new Dimension(80,20));
					mat2dcper.setPreferredSize(new Dimension(40,20));
					mat2dcval.setPreferredSize(new Dimension(60,20));
					mat2odimx.setPreferredSize(new Dimension(60,20));
					mat2odimy.setPreferredSize(new Dimension(60,20));
					mat2idimx.setPreferredSize(new Dimension(60,20));
					mat2idimy.setPreferredSize(new Dimension(60,20));
				mat3.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat3.setName("Mat 3");
					mat3no.setPreferredSize(new Dimension(80,20));
					mat3price.setPreferredSize(new Dimension(50,20));
					mat3dc.setPreferredSize(new Dimension(80,20));
					mat3dcper.setPreferredSize(new Dimension(40,20));
					mat3dcval.setPreferredSize(new Dimension(60,20));
					mat3odimx.setPreferredSize(new Dimension(60,20));
					mat3odimy.setPreferredSize(new Dimension(60,20));
					mat3idimx.setPreferredSize(new Dimension(60,20));
					mat3idimy.setPreferredSize(new Dimension(60,20));
				mat4.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat4.setName("Mat 4");
					mat4no.setPreferredSize(new Dimension(80,20));
					mat4price.setPreferredSize(new Dimension(50,20));
					mat4dc.setPreferredSize(new Dimension(80,20));
					mat4dcper.setPreferredSize(new Dimension(40,20));
					mat4dcval.setPreferredSize(new Dimension(60,20));
					mat4odimx.setPreferredSize(new Dimension(60,20));
					mat4odimy.setPreferredSize(new Dimension(60,20));
					mat4idimx.setPreferredSize(new Dimension(60,20));
					mat4idimy.setPreferredSize(new Dimension(60,20));
				mat5.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat5.setName("Mat 5");
					mat5no.setPreferredSize(new Dimension(80,20));
					mat5price.setPreferredSize(new Dimension(50,20));
					mat5dc.setPreferredSize(new Dimension(80,20));
					mat5dcper.setPreferredSize(new Dimension(40,20));
					mat5dcval.setPreferredSize(new Dimension(60,20));
					mat5odimx.setPreferredSize(new Dimension(60,20));
					mat5odimy.setPreferredSize(new Dimension(60,20));
					mat5idimx.setPreferredSize(new Dimension(60,20));
					mat5idimy.setPreferredSize(new Dimension(60,20));
				mat6.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				mat6.setName("Mat 6");
					mat6no.setPreferredSize(new Dimension(80,20));
					mat6price.setPreferredSize(new Dimension(50,20));
					mat6dc.setPreferredSize(new Dimension(80,20));
					mat6dcper.setPreferredSize(new Dimension(40,20));
					mat6dcval.setPreferredSize(new Dimension(60,20));
					mat6odimx.setPreferredSize(new Dimension(60,20));
					mat6odimy.setPreferredSize(new Dimension(60,20));
					mat6idimx.setPreferredSize(new Dimension(60,20));
					mat6idimy.setPreferredSize(new Dimension(60,20));
			payblock.setPreferredSize(new Dimension(560,5));
			tabs.setPreferredSize(new Dimension(560,150));
				payment.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				payment.setName("Payment");
					paytype.setPreferredSize(new Dimension(100,20));
					autoadd.setPreferredSize(new Dimension(120,20));
					fname.setPreferredSize(new Dimension(100,20));
					lname.setPreferredSize(new Dimension(100,20));
					mi.setPreferredSize(new Dimension(40,20));
					subtotal.setPreferredSize(new Dimension(100,20));
					tax.setPreferredSize(new Dimension(100,20));
					adjustment.setPreferredSize(new Dimension(100,20));
					total.setPreferredSize(new Dimension(100,20));
					process.setPreferredSize(new Dimension(150,20));
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				notes.setName("Notes");
					notescroll.setPreferredSize(new Dimension(475,105));
				finance.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				finance.setName("Financial");
				account.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				account.setName("Account");
			p_data.setPreferredSize(new Dimension(150,470));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			//component configuration
			
			//content configuration
			{GridBagConstraints gbc = new GridBagConstraints(); 
			gbc.insets = new Insets(3,3,3,3); gbc.anchor = GridBagConstraints.WEST;
			
				//row 1
				add(s_data);
				s_data.add(new JLabel("Invoice #:"));
				s_data.add(invoiceno);
				s_data.add(new JLabel("Payment #:")); 
				s_data.add(pymtno); 
				s_data.add(new JLabel("Date:"));
				s_data.add(date); 
				s_data.add(new JLabel("MM/DD/YY"));
				s_data.add(blanker1);
				s_data.add(new JLabel("Art Inventory #:"));
				s_data.add(invno);
				s_data.add(additem);
				s_data.add(purchase);
				s_data.add(framing);
				s_data.add(purfram);
				s_data.add(itemscroll);
				s_data.add(previewscroll);
				s_data.add(frameblock);
				s_data.add(frameglass);
					frameglass.add(new JLabel("Molding #:"));
					frameglass.add(frameno);
					frameglass.add(new JLabel("Price"));
					frameglass.add(frameprice);
					frameglass.add(new JLabel("Discount:"));
					frameglass.add(framedc);
					frameglass.add(framedcper);
					frameglass.add(framedcval);
					frameglass.add(new JLabel("                                                                         "));
					frameglass.add(new JLabel("Glass #:"));
					frameglass.add(glassno);
					frameglass.add(new JLabel("Price"));
					frameglass.add(glassprice);
					frameglass.add(new JLabel("Discount:"));
					frameglass.add(glassdc);
					frameglass.add(glassdcper);
					frameglass.add(glassdcval);
				s_data.add(mats);
					mats.add(mat1);
						mat1.add(new JLabel("Matting or Fillet #:"));
						mat1.add(mat1no);
						mat1.add(new JLabel("Price: "));
						mat1.add(mat1price);
						mat1.add(new JLabel("Discount:"));
						mat1.add(mat1dc);
						mat1.add(mat1dcper);
						mat1.add(mat1dcval);
						mat1.add(new JLabel("Outer Dimensions:"));
						mat1.add(mat1odimx);
						mat1.add(new JLabel("in. x"));
						mat1.add(mat1odimy);
						mat1.add(new JLabel("in."));
						mat1.add(new JLabel("Inner Dimensions:"));
						mat1.add(mat1idimx);
						mat1.add(new JLabel("in. x"));
						mat1.add(mat1idimy);
						mat1.add(new JLabel("in."));
					mats.add(mat2);
						mat2.add(new JLabel("Matting or Fillet #:"));
						mat2.add(mat2no);
						mat2.add(new JLabel("Price: "));
						mat2.add(mat2price);
						mat2.add(new JLabel("Discount:"));
						mat2.add(mat2dc);
						mat2.add(mat2dcper);
						mat2.add(mat2dcval);
						mat2.add(new JLabel("Outer Dimensions:"));
						mat2.add(mat2odimx);
						mat2.add(new JLabel("in. x"));
						mat2.add(mat2odimy);
						mat2.add(new JLabel("in."));
						mat2.add(new JLabel("Inner Dimensions:"));
						mat2.add(mat2idimx);
						mat2.add(new JLabel("in. x"));
						mat2.add(mat2idimy);
						mat2.add(new JLabel("in."));
					mats.add(mat3);
						mat3.add(new JLabel("Matting or Fillet #:"));
						mat3.add(mat3no);
						mat3.add(new JLabel("Price: "));
						mat3.add(mat3price);
						mat3.add(new JLabel("Discount:"));
						mat3.add(mat3dc);
						mat3.add(mat3dcper);
						mat3.add(mat3dcval);
						mat3.add(new JLabel("Outer Dimensions:"));
						mat3.add(mat3odimx);
						mat3.add(new JLabel("in. x"));
						mat3.add(mat3odimy);
						mat3.add(new JLabel("in."));
						mat3.add(new JLabel("Inner Dimensions:"));
						mat3.add(mat3idimx);
						mat3.add(new JLabel("in. x"));
						mat3.add(mat3idimy);
						mat3.add(new JLabel("in."));
					mats.add(mat4);
						mat4.add(new JLabel("Matting or Fillet #:"));
						mat4.add(mat4no);
						mat4.add(new JLabel("Price: "));
						mat4.add(mat4price);
						mat4.add(new JLabel("Discount:"));
						mat4.add(mat4dc);
						mat4.add(mat4dcper);
						mat4.add(mat4dcval);
						mat4.add(new JLabel("Outer Dimensions:"));
						mat4.add(mat4odimx);
						mat4.add(new JLabel("in. x"));
						mat4.add(mat4odimy);
						mat4.add(new JLabel("in."));
						mat4.add(new JLabel("Inner Dimensions:"));
						mat4.add(mat4idimx);
						mat4.add(new JLabel("in. x"));
						mat4.add(mat4idimy);
						mat4.add(new JLabel("in."));
					mats.add(mat5);
						mat5.add(new JLabel("Matting or Fillet #:"));
						mat5.add(mat5no);
						mat5.add(new JLabel("Price: "));
						mat5.add(mat5price);
						mat5.add(new JLabel("Discount:"));
						mat5.add(mat5dc);
						mat5.add(mat5dcper);
						mat5.add(mat5dcval);
						mat5.add(new JLabel("Outer Dimensions:"));
						mat5.add(mat5odimx);
						mat5.add(new JLabel("in. x"));
						mat5.add(mat5odimy);
						mat5.add(new JLabel("in."));
						mat5.add(new JLabel("Inner Dimensions:"));
						mat5.add(mat5idimx);
						mat5.add(new JLabel("in. x"));
						mat5.add(mat5idimy);
						mat5.add(new JLabel("in."));
					mats.add(mat6);
						mat6.add(new JLabel("Matting or Fillet #:"));
						mat6.add(mat6no);
						mat6.add(new JLabel("Price: "));
						mat6.add(mat6price);
						mat6.add(new JLabel("Discount:"));
						mat6.add(mat6dc);
						mat6.add(mat6dcper);
						mat6.add(mat6dcval);
						mat6.add(new JLabel("Outer Dimensions:"));
						mat6.add(mat6odimx);
						mat6.add(new JLabel("in. x"));
						mat6.add(mat6odimy);
						mat6.add(new JLabel("in."));
						mat6.add(new JLabel("Inner Dimensions:"));
						mat6.add(mat6idimx);
						mat6.add(new JLabel("in. x"));
						mat6.add(mat6idimy);
						mat6.add(new JLabel("in."));
				s_data.add(payblock);
				s_data.add(tabs);
					tabs.add(payment);
						payment.add(new JLabel("Payment Type:"));
						payment.add(paytype);
						payment.add(autoadd);
						payment.add(new JLabel("                                            "));
						payment.add(new JLabel("Client First Name:"));
						payment.add(fname);
						payment.add(new JLabel("Last Name:"));
						payment.add(lname);
						payment.add(new JLabel("M.I."));
						payment.add(mi);
						payment.add(new JLabel("                   "));
						payment.add(new JLabel("Subtotal:"));
						payment.add(subtotal);
						payment.add(new JLabel("Tax:"));
						payment.add(tax);
						payment.add(new JLabel("Adjustments:"));
						payment.add(adjustment);
						payment.add(new JLabel("      "));
						payment.add(new JLabel("Total:"));
						payment.add(total);
						payment.add(process);
					tabs.add(notes);
						notes.add(new JLabel("Notes:"));
						notes.add(notescroll);
					tabs.add(finance);
					tabs.add(account);
				add(p_data);
				//row 1
				
				//row 2
				//row 2
			}
			//content configuration
			
			GUI.endTask(); //task end
		}
	}
	