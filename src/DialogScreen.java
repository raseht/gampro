import javax.swing.*;
import java.awt.*;

public class DialogScreen {
	private JDialog dialog;
	
	public static class ConfigProtect extends DialogScreen {
		ConfigProtect() {
			super("Password Protection");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public static class ConfigScanner extends DialogScreen {
		ConfigScanner() {
			super("Congure Scanner");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public static class ConfigDialer extends DialogScreen {
		ConfigDialer() {
			super("Configure Dialer");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public static class ConfigEmail extends DialogScreen {
		ConfigEmail() {
			super("Configure Email");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public static class ConfigDatabase extends DialogScreen {
		private JRadioButton access;
		private JRadioButton oracle;
		private JRadioButton mysql;
		private JRadioButton informix;
		private ButtonGroup dbbuttons;
		
		ConfigDatabase() {
			super("Configure Database");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(300,300);
			
			//component initialization
			access = new JRadioButton("Access");
			oracle = new JRadioButton("Oracle");
			mysql = new JRadioButton("MySQL");
			informix = new JRadioButton("Informix SQL");
			dbbuttons = new ButtonGroup();
			//component initialization
			
			//component configuration
			dbbuttons.add(access); dbbuttons.add(oracle); dbbuttons.add(mysql); dbbuttons.add(informix);
			//component configuration
			
			//content configuration
			add(new JLabel("Please select your database format:                      "));
			add(access);
			add(new JLabel("                                                         "));
			add(oracle);
			add(new JLabel("                                                         "));
			add(mysql);
			add(new JLabel("                                                         "));
			add(informix);
			//content configuration
		}
	}
	
	public static class ConfigWeb extends DialogScreen {
		ConfigWeb() {
			super("Configure For Web");
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public static class PrintRecord extends DialogScreen {
		PrintRecord(String type,String doc) {
			super("Print "+((type.equals("PEND")?"Pending":"Archived")+doc));
			setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			setSize(200,200);
		}
	}
	
	public void add(JComponent c) {
		dialog.getContentPane().add(c);
	}
	
	public void setLayout(LayoutManager l) {
		dialog.getContentPane().setLayout(l);
	}
	
	public JDialog getDialog() {
		return dialog;
	}
	
	public void setSize(int x,int y) {
		dialog.setSize(x,y);
	}
	
	public void setVisible(boolean v) {
		dialog.setVisible(v);
	}
	
	DialogScreen(String title) {
		dialog = new JDialog(GUI.getFrame(),title,true);
	}
}