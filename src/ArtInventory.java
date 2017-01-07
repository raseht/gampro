import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.util.*;
import java.sql.*;

	public class ArtInventory extends Screen {
		private JPanel a_data;
		private JTextField invno;
		private JTextField title;
		private JTextField media;
		private JTextField fname;
		private JTextField lname;
		private JTextField mi;
		private JCheckBox original;
		private JTextField subject;
		private JTextField style;
		private JTextField zone;
		private JTextField price;
		private JTextField valuation;
		private JTextField appraisal;
		private JCheckBox consigned;
		private JTextField terms;
		private JTextField dimx;
		private JTextField dimy;
		private JScrollPane viewpane1;
			private ImageIcon view1;
			private JPanel viewframe1;
		private JScrollPane viewpane2;
			private ImageIcon view2;
			private JPanel viewframe2;
		private JScrollPane viewpane3;
			private ImageIcon view3;
			private JPanel viewframe3;
		private JScrollPane viewpane4;
			private ImageIcon view4;
			private JPanel viewframe4;
		private JButton remove;
		private JSeparator frameblock;
		private JPanel frameglass;
			private JTextField frameno;
			private JLabel frameprice;
			private JTextField framedc;
			private ButtonGroup framedcbuttons;
			private JRadioButton framedcper;
			private JRadioButton framedcval;
			private JTextField framedy;
			private JTextField framedx;
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
		private JSeparator noteblock;
		private JTabbedPane tabs;
		private JPanel notes;
			private JTextArea notearea;
			private JScrollPane notescroll;
		private JPanel artist;
		private JPanel sales;
		private JPanel p_data;
		
		ArtInventory(int h,int w,int mode) {
			super("Art Inventory "+((mode==11602)?"(Read-Only)":"(Modify/Add)"));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(h,w);
			
			//component initialization
			a_data = new JPanel();
			p_data = new JPanel();
			invno = new JTextField();
			title = new JTextField();
			media = new JTextField();
			fname = new JTextField();
			lname = new JTextField();
			mi = new JTextField();
			original = new JCheckBox("Print?");
			subject = new JTextField();
			style = new JTextField();
			zone = new JTextField();
			price = new JTextField();
			valuation = new JTextField();
			appraisal = new JTextField();
			consigned = new JCheckBox("Consignment");
			terms = new JTextField();
			dimx = new JTextField();
			dimy = new JTextField();
			view1 = new ImageIcon();
			viewframe1 = new JPanel();
			viewpane1 = new JScrollPane(viewframe1);
			view2 = new ImageIcon();
			viewframe2 = new JPanel();
			viewpane2 = new JScrollPane(viewframe2);
			view3 = new ImageIcon();
			viewframe3 = new JPanel();
			viewpane3 = new JScrollPane(viewframe3);
			view4 = new ImageIcon();
			viewframe4 = new JPanel();
			viewpane4 = new JScrollPane(viewframe4);
			remove = new JButton("Remove Item");
			frameblock = new JSeparator(SwingConstants.HORIZONTAL);
			frameglass = new JPanel();
				frameno = new JTextField();
				frameprice = new JLabel("$0.00");
				framedc = new JTextField("0");
				framedcper = new JRadioButton("%");
				framedcval = new JRadioButton("Value");
				framedcbuttons = new ButtonGroup();
				framedcbuttons.add(framedcper); framedcbuttons.add(framedcval);
				framedy = new JTextField();
				framedx = new JTextField();
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
			noteblock = new JSeparator(SwingConstants.HORIZONTAL);
			tabs = new JTabbedPane(JTabbedPane.RIGHT);
				notes = new JPanel();
					notearea = new JTextArea(100,55);
					notescroll = new JScrollPane(notearea);
				artist = new JPanel();
				sales = new JPanel();
			//component initialization
			
			//component configuration
			a_data.setPreferredSize(new Dimension(570,470));
			a_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			invno.setPreferredSize(new Dimension(80,20));
			title.setPreferredSize(new Dimension(180,20));
			media.setPreferredSize(new Dimension(150,20));
			fname.setPreferredSize(new Dimension(120,20));
			lname.setPreferredSize(new Dimension(120,20));
			mi.setPreferredSize(new Dimension(20,20));
			original.setPreferredSize(new Dimension(90,20));
			subject.setPreferredSize(new Dimension(80,20));
			style.setPreferredSize(new Dimension(80,20));
			zone.setPreferredSize(new Dimension(80,20));
			price.setPreferredSize(new Dimension(50,20));
			valuation.setPreferredSize(new Dimension(50,20));
			appraisal.setPreferredSize(new Dimension(50,20));
			consigned.setPreferredSize(new Dimension(110,20));
			terms.setPreferredSize(new Dimension(100,20));
			dimx.setPreferredSize(new Dimension(70,20));
			dimy.setPreferredSize(new Dimension(70,20));
			viewpane1.setPreferredSize(new Dimension(100,100));
			viewpane2.setPreferredSize(new Dimension(100,100));
			viewpane3.setPreferredSize(new Dimension(100,100));
			viewpane4.setPreferredSize(new Dimension(100,100));
			remove.setPreferredSize(new Dimension(110,40));
			frameblock.setPreferredSize(new Dimension(560,5));
			frameglass.setPreferredSize(new Dimension(250,130));
			frameglass.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				frameno.setPreferredSize(new Dimension(80,20));
				frameprice.setPreferredSize(new Dimension(50,20));
				framedc.setPreferredSize(new Dimension(80,20));
				framedcper.setPreferredSize(new Dimension(40,20));
				framedcval.setPreferredSize(new Dimension(60,20));
				framedy.setPreferredSize(new Dimension(60,20));
				framedx.setPreferredSize(new Dimension(60,20));
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
			noteblock.setPreferredSize(new Dimension(560,5));
			tabs.setPreferredSize(new Dimension(560,100));
				notes.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				notes.setName("Notes");
				notescroll.setPreferredSize(new Dimension(475,85));
				artist.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				artist.setName("Artist");
				sales.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
				sales.setName("Sales");
			p_data.setPreferredSize(new Dimension(150,470));
			p_data.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			p_data.setBorder(BorderFactory.createTitledBorder("Print and Process"));
			//component configuration
			
			//content configuration
			add(a_data);
			a_data.add(new JLabel("Inventory #:"));
			a_data.add(invno);
			a_data.add(new JLabel("Title:"));
			a_data.add(title);
			a_data.add(original);
			a_data.add(new JLabel("                  "));
			a_data.add(new JLabel("Artist First Name:"));
			a_data.add(fname);
			a_data.add(new JLabel("Last Name:"));
			a_data.add(lname);
			a_data.add(new JLabel("M.I."));
			a_data.add(mi);
			a_data.add(new JLabel("                                      "));
			a_data.add(new JLabel("Medium:"));
			a_data.add(media);
			a_data.add(new JLabel("Subject:"));
			a_data.add(subject);
			a_data.add(new JLabel("Style:"));
			a_data.add(style);
			a_data.add(new JLabel("Zone:"));
			a_data.add(zone);
			a_data.add(new JLabel("Price:"));
			a_data.add(price);
			a_data.add(new JLabel("Valuation:"));
			a_data.add(valuation);
			a_data.add(new JLabel("Appraisal:"));
			a_data.add(appraisal);
		//	a_data.add(consigned); move to artist pane
		//	a_data.add(new JLabel("Terms:"));
		//	a_data.add(terms);
			a_data.add(new JLabel("Dimensions:"));
			a_data.add(dimx);
			a_data.add(new JLabel("in. x"));
			a_data.add(dimy);
			a_data.add(new JLabel("in."));
			a_data.add(viewpane1);
			a_data.add(viewpane2);
			a_data.add(viewpane3);
			a_data.add(viewpane4);
			a_data.add(remove);
			a_data.add(frameblock);
				a_data.add(frameglass);
					frameglass.add(new JLabel("Molding #:"));
					frameglass.add(frameno);
					frameglass.add(new JLabel("Price"));
					frameglass.add(frameprice);
					frameglass.add(new JLabel("Discount:"));
					frameglass.add(framedc);
					frameglass.add(framedcper);
					frameglass.add(framedcval);
					frameglass.add(new JLabel("Framed:"));
					frameglass.add(framedy);
					frameglass.add(new JLabel("in. x "));
					frameglass.add(framedx);
					frameglass.add(new JLabel("in."));
					//frameglass.add(new JLabel("                "));
					frameglass.add(new JLabel("Glass #:"));
					frameglass.add(glassno);
					frameglass.add(new JLabel("Price"));
					frameglass.add(glassprice);
					frameglass.add(new JLabel("Discount:"));
					frameglass.add(glassdc);
					frameglass.add(glassdcper);
					frameglass.add(glassdcval);
				a_data.add(mats);
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
			a_data.add(noteblock);
			a_data.add(tabs);
				tabs.add(notes);
					notes.add(notescroll);
				tabs.add(artist);
				tabs.add(sales);
			add(p_data);
			//content configuration
		}
	}
	