import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.util.*;
import java.sql.*;

public class Screen {
	private JInternalFrame frame;
	public static final javax.swing.filechooser.FileFilter IMAGE_ONLY = new javax.swing.filechooser.FileFilter() {
		public boolean accept(java.io.File f) {
			String ext = "   ";
			if(f.getName().length()>3) { ext = f.getName().substring(f.getName().length()-4,f.getName().length()); }
			else { ext = ".txt"; }
			if(ext.equals(".png")||ext.equals(".gif")||ext.equals("jpeg")||ext.equals(".bmp")||ext.equals(".jpg")) return true;
			else return f.isDirectory();
		}
		
		public String getDescription() {
			return "All Image Files - *.gif,*.png,*.jpg,*.jpeg,*.bmp";
		}
	};
	
	public static class FramingInventory extends Screen {
		private JPanel f_data;
		private JTextField invno;
		private JTextField name;
		private JTextField vendor;
		private JTextField orderno;
		private JTextField color;
		private JTextField material;
		private JTextField price;
		private JLabel perinch;
		private JCheckBox losscontrol;
		private JTextField unit;
		private JLabel largest;
		private JLabel pieces;
		private JButton add;
		private JLabel value;
		private JTabbedPane tabs;
			private JPanel notes;
				private JTextArea notearea;
				private JScrollPane notescroll;
			private JPanel sales;
			private JPanel art;
			private JPanel supplier;
		private JPanel p_data;
		
		FramingInventory(int h,int w,int mode) {
			super("Framing Inventory "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			
			//component initialization
			f_data = new JPanel();
			invno = new JTextField();
			name = new JTextField();
			vendor = new JTextField();
			orderno = new JTextField();
			color = new JTextField();
			material = new JTextField();
			price = new JTextField();
			perinch = new JLabel("$0.00/in.");
			losscontrol = new JCheckBox("Charge Per Unit");
			unit = new JTextField();
			largest = new JLabel("0 in.");
			pieces = new JLabel("0");
			add = new JButton("Add Unit(s)");
			value = new JLabel("0.00");
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				sales = new JPanel();
				art = new JPanel();
				supplier = new JPanel();
			p_data = new JPanel();
			//component initialization
			
			//component configuration
			f_data.setPreferredSize(new Dimension(570,255));
			f_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			invno.setPreferredSize(new Dimension(100,20));
			name.setPreferredSize(new Dimension(100,20));
			vendor.setPreferredSize(new Dimension(100,20));
			orderno.setPreferredSize(new Dimension(100,20));
			color.setPreferredSize(new Dimension(80,20));
			material.setPreferredSize(new Dimension(80,20));
			price.setPreferredSize(new Dimension(80,20));
			perinch.setPreferredSize(new Dimension(60,20));
			losscontrol.setPreferredSize(new Dimension(100,20));
			unit.setPreferredSize(new Dimension(80,20));
			largest.setPreferredSize(new Dimension(40,20));
			pieces.setPreferredSize(new Dimension(40,20));
			add.setPreferredSize(new Dimension(100,20));
			value.setPreferredSize(new Dimension(80,20));
			tabs.setPreferredSize(new Dimension(560,150));			
				notes.setName("Notes");
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				notescroll.setPreferredSize(new Dimension(475,135));
				sales.setName("Sales");
				sales.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				art.setName("Art");
				art.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				supplier.setName("Supplier");
				supplier.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setPreferredSize(new Dimension(150,250));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			//component configuration
			
			//content configuration
			add(f_data);
			f_data.add(new JLabel("Inventory #:"));
			f_data.add(invno);
			f_data.add(new JLabel("Name:"));
			f_data.add(name);
			f_data.add(new JLabel("Color:"));
			f_data.add(color);
			f_data.add(new JLabel("Material:"));
			f_data.add(material);
			f_data.add(new JLabel("Vendor:"));
			f_data.add(vendor);
			f_data.add(new JLabel("Order #:"));
			f_data.add(orderno);
			f_data.add(new JLabel("Price Per Unit:"));
			f_data.add(price);
			f_data.add(new JLabel("                        "));
			f_data.add(new JLabel("Unit Size:"));
			f_data.add(unit);
			f_data.add(new JLabel("Price Per Inch:"));
			f_data.add(perinch);
			f_data.add(losscontrol);
			f_data.add(new JLabel("Largest Unit:"));
			f_data.add(largest);
			f_data.add(new JLabel("Units:"));
			f_data.add(pieces);
			f_data.add(add);
			f_data.add(new JLabel("Value:"));
			f_data.add(value);
			f_data.add(tabs);
				tabs.add(notes);
					notes.add(notescroll);
				tabs.add(sales);
				tabs.add(art);
				tabs.add(supplier);
			add(p_data);
			//content configuration
		}
	}
	
	public static class MattingInventory extends Screen {
		private JPanel m_data;
		private JTextField invno;
		private JTextField name;
		private JTextField vendor;
		private JTextField orderno;
		private JTextField color;
		private JTextField material;
		private JTextField thickness;
		private JTextField price;
		private JLabel perinch;
		private JCheckBox losscontrol;
		private JTextField unitx;
		private JTextField unity;
		private JLabel largestx;
		private JLabel largesty;
		private JLabel pieces;
		private JButton add;
		private JLabel value;
		private JTabbedPane tabs;
			private JPanel notes;
				private JTextArea notearea;
				private JScrollPane notescroll;
			private JPanel sales;
			private JPanel art;
			private JPanel supplier;
		private JPanel p_data;
		
		MattingInventory(int h,int w,int mode) {
			super("Matting Inventory "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			
			//component initialization
			m_data = new JPanel();
			invno = new JTextField();
			name = new JTextField();
			vendor = new JTextField();
			orderno = new JTextField();
			color = new JTextField();
			material = new JTextField();
			thickness = new JTextField();
			price = new JTextField();
			perinch = new JLabel("$0.00/in.");
			losscontrol = new JCheckBox("Charge Per Unit");
			unitx = new JTextField();
			unity = new JTextField();
			largestx = new JLabel("0 in.");
			largesty = new JLabel("0 in.");
			pieces = new JLabel("0");
			add = new JButton("Add Unit(s)");
			value = new JLabel("0.00");
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				sales = new JPanel();
				art = new JPanel();
				supplier = new JPanel();
			p_data = new JPanel();
			//component initialization
			
			//component configuration
			m_data.setPreferredSize(new Dimension(570,280));
			m_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			invno.setPreferredSize(new Dimension(100,20));
			name.setPreferredSize(new Dimension(100,20));
			vendor.setPreferredSize(new Dimension(100,20));
			orderno.setPreferredSize(new Dimension(100,20));
			color.setPreferredSize(new Dimension(80,20));
			material.setPreferredSize(new Dimension(80,20));
			thickness.setPreferredSize(new Dimension(40,20));
			price.setPreferredSize(new Dimension(80,20));
			perinch.setPreferredSize(new Dimension(60,20));
			losscontrol.setPreferredSize(new Dimension(100,20));
			unitx.setPreferredSize(new Dimension(80,20));
			unity.setPreferredSize(new Dimension(80,20));
			largestx.setPreferredSize(new Dimension(40,20));
			largesty.setPreferredSize(new Dimension(40,20));
			pieces.setPreferredSize(new Dimension(40,20));
			add.setPreferredSize(new Dimension(100,20));
			value.setPreferredSize(new Dimension(80,20));
			tabs.setPreferredSize(new Dimension(560,150));			
				notes.setName("Notes");
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				notescroll.setPreferredSize(new Dimension(475,135));
				sales.setName("Sales");
				sales.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				art.setName("Art");
				art.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				supplier.setName("Supplier");
				supplier.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setPreferredSize(new Dimension(150,280));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			//component configuration
			
			//content configuration
			add(m_data);
			m_data.add(new JLabel("Inventory #:"));
			m_data.add(invno);
			m_data.add(new JLabel("Name:"));
			m_data.add(name);
			m_data.add(new JLabel("Color:"));
			m_data.add(color);
			m_data.add(new JLabel("Material:"));
			m_data.add(material);
			m_data.add(new JLabel("Thickness:"));
			m_data.add(thickness);
			m_data.add(new JLabel("in."));
			m_data.add(new JLabel("Vendor:"));
			m_data.add(vendor);
			m_data.add(new JLabel("Order #:"));
			m_data.add(orderno);
			m_data.add(new JLabel("                              "));
			m_data.add(new JLabel("Price Per Unit:"));
			m_data.add(price);
			m_data.add(new JLabel("                        "));
			m_data.add(new JLabel("Unit Size:"));
			m_data.add(unitx);
			m_data.add(new JLabel("in. x"));
			m_data.add(unity);
			m_data.add(new JLabel("in."));
			m_data.add(new JLabel("Price Per Cubic Inch:"));
			m_data.add(perinch);
			m_data.add(losscontrol);
			m_data.add(new JLabel("Largest Unit:"));
			m_data.add(largestx);
			m_data.add(new JLabel("x"));
			m_data.add(largesty);
			m_data.add(new JLabel("Units:"));
			m_data.add(pieces);
			m_data.add(add);
			m_data.add(new JLabel("Value:"));
			m_data.add(value);
			m_data.add(tabs);
				tabs.add(notes);
					notes.add(notescroll);
				tabs.add(sales);
				tabs.add(art);
				tabs.add(supplier);
			add(p_data);
			//content configuration
		}
	}
	
	public static class GeneralInventory extends Screen {
		private JPanel g_data;
		private JTextField invno;
		private JTextField name;
		private JTextField vendor;
		private JTextField orderno;
		private JTextField price;
		private JLabel pieces;
		private JButton add;
		private JLabel value;
		private JTabbedPane tabs;
			private JPanel notes;
				private JTextArea notearea;
				private JScrollPane notescroll;
		private JPanel p_data;
		
		GeneralInventory(int h,int w,int mode) {
			super("General Inventory "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			
			//component initialization
			g_data = new JPanel();
			invno = new JTextField();
			name = new JTextField();
			vendor = new JTextField();
			orderno = new JTextField();
			price = new JTextField();
			pieces = new JLabel("0");
			add = new JButton("Add Unit(s)");
			value = new JLabel("0.00");
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
			p_data = new JPanel();
			//component initialization
			
			//component configuration
			g_data.setPreferredSize(new Dimension(570,230));
			g_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			invno.setPreferredSize(new Dimension(100,20));
			name.setPreferredSize(new Dimension(100,20));
			vendor.setPreferredSize(new Dimension(100,20));
			orderno.setPreferredSize(new Dimension(100,20));
			price.setPreferredSize(new Dimension(80,20));
			pieces.setPreferredSize(new Dimension(40,20));
			add.setPreferredSize(new Dimension(100,20));
			value.setPreferredSize(new Dimension(80,20));
			tabs.setPreferredSize(new Dimension(560,150));			
				notes.setName("Notes");
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				notescroll.setPreferredSize(new Dimension(475,135));
			p_data.setPreferredSize(new Dimension(150,225));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			//component configuration
			
			//content configuration
			add(g_data);
			g_data.add(new JLabel("Inventory #:"));
			g_data.add(invno);
			g_data.add(new JLabel("Name:"));
			g_data.add(name);
			g_data.add(new JLabel("                                                                             "));
			g_data.add(new JLabel("Vendor:"));
			g_data.add(vendor);
			g_data.add(new JLabel("Order #:"));
			g_data.add(orderno);
			g_data.add(new JLabel("                                                                           "));
			g_data.add(new JLabel("Price Per Unit:"));
			g_data.add(price);
			g_data.add(new JLabel("Units:"));
			g_data.add(pieces);
			g_data.add(add);
			g_data.add(new JLabel("Value:"));
			g_data.add(value);
			g_data.add(tabs);
				tabs.add(notes);
					notes.add(notescroll);
			add(p_data);
			//content configuration
		}
	}
	
	public static class EntriesWindow extends Screen {
		private JPanel selection;
			private JRadioButton sales;
			private JRadioButton client;
			private JRadioButton artist;
			private JRadioButton art;
			private JRadioButton frame;
			private JRadioButton mat;
			private JRadioButton general;
			private ButtonGroup entrygroup;
		private JPanel entries;
			private JTable entrytable;
				private final String[][] ENTRYDATA = {{"No Data","No Data","No Data","No Data"}};
				private final String[] ENTRYFIELDS = {"ID#","Local ID","Name","Description"};
			private JScrollPane entryscroll;
			private EntryListener entry_command;
			
		EntriesWindow(int h,int w,int mode) {
 			//entry frame configuration
			super("Entry Window (Read-Only)");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			//entry frame configuration
			
			//delete this code, testing only
			PrintData.String[] strings = {new PrintData.String(Color.black,Font.getFont("Arial"),"020000000001",0d,0d)};
			PrintData.Image[] images = null;
			PrintData printdata = new PrintData(0d,0d,0d,0d,0d,0d,0d,strings,images);
			new Spooler("Barcodes",1,printdata);
			
			//component initialization
			selection = new JPanel();
				sales = new JRadioButton("Sales Entries");
				client = new JRadioButton("Client Entries");
				artist = new JRadioButton("Artist Entries");
				art = new JRadioButton("Art Entries");
				frame = new JRadioButton("Frame Entries");
				mat = new JRadioButton("Matting Entries");
				general = new JRadioButton("Inventory Entries");
				entrygroup = new ButtonGroup();
			entries = new JPanel();
				entrytable = new JTable(ENTRYDATA,ENTRYFIELDS);
				entryscroll = new JScrollPane(entrytable);
				entry_command = new EntryListener();
			//component initialization
			
			//component configuration
			selection.setPreferredSize(new Dimension(125,400));
				sales.setPreferredSize(new Dimension(120,20));
				client.setPreferredSize(new Dimension(120,20));
				client.setActionCommand("CLIENTS");
				client.addActionListener(entry_command);
				artist.setPreferredSize(new Dimension(120,20));
				art.setPreferredSize(new Dimension(120,20));
				frame.setPreferredSize(new Dimension(120,20));
				mat.setPreferredSize(new Dimension(120,20));
				general.setPreferredSize(new Dimension(120,20));
				entrygroup.add(sales); entrygroup.add(client);
				entrygroup.add(artist); entrygroup.add(art);
				entrygroup.add(frame); entrygroup.add(mat);
				entrygroup.add(general);
			entries.setPreferredSize(new Dimension(470,400));
				entryscroll.setPreferredSize(new Dimension(460,380));
			//component configuration
			
			//content configuration
			add(selection);
				selection.add(sales);
				selection.add(client);
				selection.add(artist);
				selection.add(art);
				selection.add(frame);
				selection.add(mat);
				selection.add(general);
			add(entries);
				entries.add(entryscroll);
			switch(mode) {
				case 100:
				sales.setSelected(true);
				break;
				case 101:
				client.setSelected(true);
				break;
				case 102:
				artist.setSelected(true);
				break;
				case 103:
				art.setSelected(true);
				break;
				case 104:
				frame.setSelected(true);
				break;
				case 105:
				mat.setSelected(true);
				break;
				case 106:
				general.setSelected(true);
				break;
			}
			//content configuration
		}
		
		public static class EntryListener implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
				ResultSet rs = null;
			}
		}
	}
	
	public static class ReportsWindow extends Screen {
		private JPanel selection;
			private JRadioButton sales;
			private JRadioButton client;
			private JRadioButton artist;
			private JRadioButton art;
			private JRadioButton frame;
			private JRadioButton mat;
			private JRadioButton general;
			private ButtonGroup reportgroup;
		private JPanel reports;
			private JTextField number;
			private JTextField name;
			private JFormattedTextField date;
			private JCheckBox range;
			private JTextField endnumber;
			private JTextField endname;
			private JFormattedTextField enddate;
			private JTree reporttree;
			private JScrollPane reportscroll;
			private JButton custom;
			private JButton generate;
		
		ReportsWindow(int h,int w,int mode) {
 			//report frame configuration
			super("Reports Window");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			//report frame configuration
			
			Compute.initialize("Just Lookin","Access");
			
			//component initialization
			selection = new JPanel();
				sales = new JRadioButton("Sales Entries");
				client = new JRadioButton("Client Entries");
				artist = new JRadioButton("Artist Entries");
				art = new JRadioButton("Art Entries");
				frame = new JRadioButton("Frame Entries");
				mat = new JRadioButton("Matting Entries");
				general = new JRadioButton("Inventory Entries");
				reportgroup = new ButtonGroup();
			reports = new JPanel();
				number = new JTextField();
				name = new JTextField();
				date = new JFormattedTextField(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT));
				range = new JCheckBox("Use Range");
				endnumber = new JTextField();
				endname = new JTextField();
				enddate = new JFormattedTextField(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT));
				Hashtable<String,String> reps = new Hashtable<String,String>();
				reps.put("All","SELECT * FROM CLIENTS");
				reps.put("Due","SELECT * FROM CLIENTS WHERE due > DATE()");
				reporttree = new JTree(reps);
				reportscroll = new JScrollPane(reporttree);
				custom = new JButton("Custom Report");
				generate = new JButton("Generate Report");
			//component initialization
			
			//component configuration
			selection.setPreferredSize(new Dimension(125,400));
				sales.setPreferredSize(new Dimension(120,20));
				client.setPreferredSize(new Dimension(120,20));
				artist.setPreferredSize(new Dimension(120,20));
				art.setPreferredSize(new Dimension(120,20));
				frame.setPreferredSize(new Dimension(120,20));
				mat.setPreferredSize(new Dimension(120,20));
				general.setPreferredSize(new Dimension(120,20));
				reportgroup.add(sales); reportgroup.add(client);
				reportgroup.add(artist); reportgroup.add(art);
				reportgroup.add(frame); reportgroup.add(mat);
				reportgroup.add(general);
			reports.setPreferredSize(new Dimension(470,400));
				reportscroll.setPreferredSize(new Dimension(250,200));
				((javax.swing.tree.DefaultTreeCellRenderer)reporttree.getCellRenderer()).setLeafIcon(new ImageIcon("leaficon.jpg"));
			//component configuration
			
			//content configuration
			add(selection);
				selection.add(sales);
				selection.add(client);
				selection.add(artist);
				selection.add(art);
				selection.add(frame);
				selection.add(mat);
				selection.add(general);
			add(reports);
				reports.add(reportscroll);
			switch(mode) {
				case 100:
				sales.setSelected(true);
				break;
				case 101:
				client.setSelected(true);
				break;
				case 102:
				artist.setSelected(true);
				break;
				case 103:
				art.setSelected(true);
				break;
				case 104:
				frame.setSelected(true);
				break;
				case 105:
				mat.setSelected(true);
				break;
				case 106:
				general.setSelected(true);
				break;
			}
			//content configuration
		}
	}
	
	public static class PrintPending extends Screen {
		PrintPending() {
			super("Print Pending");
		//	try { GUI.getSpooler().print(false,"CONS",new SimpleDoc(new java.io.File("Test Print.txt").toURL(),DocFlavor.URL.AUTOSENSE,null),"E. Wexler"); }
		//	catch (java.net.MalformedURLException mue) { }
		}
	} 
	
	public JInternalFrame getFrame() {
		return frame;
	}
	
	public void add(Component c) {
		frame.getContentPane().add(c);
	}
	
	public void add(Component c,long l) {
		frame.getContentPane().add(c,l);
	}
	
	public void add(Component c,GridBagConstraints g) {
		frame.getContentPane().add(c,g);
	}
	
	public void add(String objdir,Component obj,String traildir) {
		((SpringLayout) frame.getLayout()).putConstraint(objdir,obj,5,traildir,frame.getContentPane());
	}
	
	public void add(String objdir,Component obj,String traildir,Component trail) {
		((SpringLayout) frame.getLayout()).putConstraint(objdir,obj,5,traildir,trail);
	}
	
	public void setLayout(LayoutManager lm) {
		frame.getContentPane().setLayout(lm);
	}
	
	public void setSize(int h,int w) {
		frame.setSize(h,w);
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	Screen(String title) {
		frame = new JInternalFrame(title,false,true,false,true);
	}
}