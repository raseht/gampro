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
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GUI implements Runnable{
	//static final mode declarations
	public static final int READONLY = 11602;
	public static final int MODIFY = 20611;
	public static final int SALE = 100;
	public static final int CLIENT = 101;
	public static final int ARTIST = 102;
	public static final int ART = 103;
	public static final int FRAMING = 104;
	public static final int MAT = 105;
	public static final int GENERAL = 106;
	//static final mode declarations
	
	//print declarations
	public static Spooler _printer;
	//print declarations
	
	//frame declarations
	private static JFrame main;
	private static JDesktopPane desktop;
	private static JPanel _status;
		private static JLabel _mem_usage;
		private static JProgressBar _progress_bar;
		private static JLabel _db_type;
	private static GridBagLayout gb;
	private static GridBagConstraints gbc;
	//frame declarations
	
	//menu declarations
	private static JMenuBar _menu; //main menu bar
		private static JMenu _menu_file; //'File' menu
			private static JMenuItem _file_open; //'File'->'Open' menu item
			private static JMenuItem _file_save; //'File'->'Save' menu item
			private static JMenuItem _file_saveas; //'File'->'Save As' menu item
			private static JMenu _file_upload; //'File'->'Upload' menu
				private static JMenuItem _upload_artist; //'Upload'->'Artist Database' menu item
				private static JMenuItem _upload_art; //'Upload'->'Art Database' menu item
				private static JMenuItem _upload_framing; //'Upload'->'Framing Database' menu item
				private static JMenuItem _upload_matting; //'Upload'->'Matting Database' menu item
				private static JMenuItem _upload_all; //'Upload'->'All' menu item
			private static JMenu _file_download; //'File'->'Download' menu
				private static JMenuItem _download_artist; //'Download'->'Artist Database' menu item
				private static JMenuItem _download_art; //'Download'->'Art Database' menu item
				private static JMenuItem _download_framing; //'Download'->'Framing Database' menu item
				private static JMenuItem _download_matting; //'Download'->'Matting Database' menu item
				private static JMenuItem _download_all; //'Download'->'All' menu item
			private static JMenuItem _file_exit; //'File'->'Exit' menu item
		private static JMenu _menu_edit; //'Edit' menu
			private static JMenu _edit_cut; //'Edit'->'Cut' menu
				private static JMenuItem _cut_text; //'Cut'->'Text     Ctrl+X' menu item
				private static JMenuItem _cut_entry; //'Cut'->'Entry     Alt+X' menu item
			private static JMenu _edit_copy; //'Edit'->'Copy' menu
				private static JMenuItem _copy_text; //'Copy'->'Text     Ctrl+C' menu item
				private static JMenuItem _copy_entry; //'Copy'->'Entry     Alt+C' menu item
			private static JMenu _edit_paste; //'Edit'->'Paste' menu
				private static JMenuItem _paste_text; //'Paste'->'Text     Ctrl+V' menu item
				private static JMenuItem _paste_entry; //'Paste'->'Entry     Alt+V' menu item
		private static JMenu _menu_sales; //'Sales' menu
			private static JMenuItem _sales_browse; //'Sales'->'Browse' menu item
			private static JMenuItem _sales_modify; //'Sales'->'Modify/Add' menu item
			private static JMenuItem _sales_entry; //'Sales'->'View All Entries' menu item
			private static JMenuItem _sales_reports; //'Sales'->'Create Reports' menu item
		private static JMenu _menu_client; //'Client' menu
			private static JMenuItem _client_browse; //'Client'->'Browse' menu item
			private static JMenuItem _client_modify; //'Client'->'Modify/Add' menu item
			private static JMenuItem _client_entry; //'Client'->'View All Entries' menu item
			private static JMenuItem _client_reports; //'Client'->'Create Reports' menu item
		private static JMenu _menu_artist; //'Artist' menu
			private static JMenuItem _artist_browse; //'Artist'->'Browse' menu item
			private static JMenuItem _artist_modify; //'Artist'->'Modify/Add' menu item
			private static JMenuItem _artist_entry; //'Artist'->'View All Entries' menu item
			private static JMenuItem _artist_reports; //'Artist'->'Create Reports' menu item
		private static JMenu _menu_inv; //'Inventory' menu
			private static JMenu _inv_art; //'Inventory'->'Art' menu
				private static JMenuItem _art_browse; //'Art'->'Browse' menu item
				private static JMenuItem _art_modify; //'Art'->'Modify/Add' menu item
				private static JMenuItem _art_scan; //'Art'->'Scan' menu item
				private static JMenuItem _art_bar; //'Art'->'Print Barcodes' menu item
				private static JMenuItem _art_card; //'Art'->'Print Price Cards' menu item
				private static JMenuItem _art_entry; //'Art'->'View All Entries' menu item
				private static JMenuItem _art_reports; //'Art'->'Create Reports' menu item
			private static JMenu _inv_framing; //'Inventory'->'Framing' menu
				private static JMenuItem _framing_browse; //'Framing'->'Browse' menu item
				private static JMenuItem _framing_modify; //'Framing'->'Modify/Add' menu item
				private static JMenuItem _framing_scan; //'Framing'->'Scan' menu item
				private static JMenuItem _framing_bar; //'Framing'->'Print Barcodes' menu item
				private static JMenuItem _framing_entry; //'Framing'->'View All Entries' menu item
				private static JMenuItem _framing_reports; //'Framing'->'Create Reports' menu item
			private static JMenu _inv_matting; //'Inventory'->'Matting' menu
				private static JMenuItem _matting_browse; //'Matting'->'Browse' menu item
				private static JMenuItem _matting_modify; //'Matting'->'Modify/Add' menu item;
				private static JMenuItem _matting_scan; //'Matting'->'Scan' menu item
				private static JMenuItem _matting_bar; //'Matting'->'Print Barcodes' menu item
				private static JMenuItem _matting_entry; //'Matting'->'View All Entries' menu item
				private static JMenuItem _matting_reports; //'Matting'->'Create Reports' menu item
			private static JMenu _inv_general; //'Inventory'->'General' menu
				private static JMenuItem _general_browse; //'General'->'Browse' menu item
				private static JMenuItem _general_modify; //'General'->'Modify/Add' menu item
				private static JMenuItem _general_scan; //'General'->'Scan' menu item
				private static JMenuItem _general_bar; //'General'->'Print Barcodes' menu item
				private static JMenuItem _general_entry; //'General'->'View All Entries' menu item
				private static JMenuItem _general_reports; //'General'->'Create Reports' menu item
		private static JMenu _menu_market; //'Marketing' menu
			private static JMenuItem _market_contact; //'Marketing'->'Add Contact' menu item
			private static JMenuItem _market_group; //'Marketing'->'Group Contacts' menu item
			private static JMenuItem _market_promote; //'Marketing'->'Promotions' menu item
			private static JMenuItem _market_mailing; //'Marketing'->'Mailing Lists' menu item
			private static JMenuItem _market_snail; //'Marketing'->'Snail Mail' menu item
			private static JMenuItem _market_email; //'Marketing'->'Electronic Mail' menu item
			private static JMenuItem _market_print; //'Marketing'->'Select To Print' menu
				private static JMenuItem _print_labels; //'Select To Print'->'Mailing Labels' menu item
				private static JMenuItem _print_return; //'Select To Print'->'Return Address Labels' menu item
				private static JMenuItem _print_letterhead; //'Select To Print'->'Letterheads' menu item
				private static JMenuItem _print_flyer; //'Select To Print'->'Flyer' menu item
				private static JMenuItem _print_brochure; //'Select To Print'->'Brochure' menu item
				private static JMenuItem _print_news; //'Select To Print'->'Newsletter' menu item
				private static JMenuItem _print_settings; //'Select To Print'->'Settings' menu item
		private static JMenu _menu_finance; //'Financial' menu
			private static JMenuItem _finance_consumer; //'Financial'->'Consumer Accounts' menu item
			private static JMenuItem _finance_supplier; //'Financial'->'Supplier Accounts' menu item
			private static JMenuItem _finance_reports; //'Financial'->'Create Reports' menu item
			private static JMenuItem _finance_quickbooks; //'Financial'->'Export To Quickbooks' menu item
			private static JMenuItem _finance_money; //'Financial'->'Export To Microsoft Money' menu item
		private static JMenu _menu_forms; //'Forms' menu
			private static JMenu _forms_consign; //'Forms'->'Consignment' menu
				private static JMenuItem _consign_custom; //'Consignment'->'Print Custom' menu item
				private static JMenuItem _consign_pending; //'Consignment'->'Print Pending' menu item
				private static JMenuItem _consign_archive; //'Consignment'->'Print Archived' menu item
				private static JMenuItem _consign_data; //'Consignment'->'Print From Data' menu item
				private static JMenuItem _consign_settings; //'Consignment'->'Settings' menu item
			private static JMenu _forms_bio; //'Forms'->'Biography' menu
				private static JMenuItem _bio_custom; //'Biography'->'Print Custom' menu item
				private static JMenuItem _bio_pending; //'Biography'->'Print Pending' menu item
				private static JMenuItem _bio_archive; //'Biography'->'Print Archived' menu item
				private static JMenuItem _bio_data; //'Biography'->'Print From Data' menu item
				private static JMenuItem _bio_settings; //'Biography'->'Settings' menu item
			private static JMenu _forms_receipt; //'Forms'->'Receipt' menu
				private static JMenuItem _receipt_custom; //'Receipt'->'Print Custom' menu item
				private static JMenuItem _receipt_pending; //'Receipt'->'Print Pending' menu item
				private static JMenuItem _receipt_archive; //'Receipt'->'Print Archived' menu item
				private static JMenuItem _receipt_data; //'Receipt'->'Print From Data' menu item
				private static JMenuItem _receipt_settings; //'Receipt'->'Settings' menu item
			private static JMenu _forms_invoice; //'Forms'->'Invoice' menu
				private static JMenuItem _invoice_custom; //'Invoice'->'Print Custom' menu item
				private static JMenuItem _invoice_pending; //'Invoice'->'Print Pending' menu item
				private static JMenuItem _invoice_archive; //'Invoice'->'Print Archived' menu item
				private static JMenuItem _invoice_data; //'Invoice'->'Print From Data' menu item
				private static JMenuItem _invoice_settings; //'Invoice'->'Settings' menu item
			private static JMenu _forms_statement; //'Forms'->'Statement' menu
				private static JMenuItem _statement_custom; //'Statement'->'Print Custom' menu item
				private static JMenuItem _statement_pending; //'Statement'->'Print Pending' menu item
				private static JMenuItem _statement_archive; //'Statement'->'Print Archived' menu item
				private static JMenuItem _statement_data; //'Statement'->'Print From Data' menu item
				private static JMenuItem _statement_settings; //'Statement'->'Settings' menu item
			private static JMenu _forms_workorder; //'Forms'->'Work Order' menu
				private static JMenuItem _workorder_custom; //'Work Order'->'Print Custom' menu item
				private static JMenuItem _workorder_pending; //'Work Order'->'Print Pending' menu item
				private static JMenuItem _workorder_archive; //'Work Order'->'Print Archived' menu item
				private static JMenuItem _workorder_data; //'Work Order'->'Print From Data' menu item
				private static JMenuItem _workorder_settings; //'Work Order'->'Settings' menu item
			private static JMenu _forms_insurance; //'Forms'->'Insurance Valuation' menu
				private static JMenuItem _insurance_custom; //'Insurance Valuation'->'Print Custom' menu item
				private static JMenuItem _insurance_pending; //'Insurance Valuation'->'Print Pending' menu item
				private static JMenuItem _insurance_archive; //'Insurance Valuation'->'Print Archived' menu item
				private static JMenuItem _insurance_data; //'Insurance Valuation'->'Print From Data' menu item
				private static JMenuItem _insurance_settings; //'Insurance Valuation'->'Settings' menu item
			private static JMenu _forms_authenticity; //'Forms'->'Authenticity Certificate' menu
				private static JMenuItem _authenticity_custom; //'Authenticity Certificate'->'Print Custom' menu item
				private static JMenuItem _authenticity_pending; //'Authenticity Certificate'->'Print Pending' menu item
				private static JMenuItem _authenticity_archive; //'Authenticity Certificate'->'Print Archived' menu item
				private static JMenuItem _authenticity_data; //'Authenticity Certificate'->'Print From Data' menu item
				private static JMenuItem _authenticity_settings; //'Authenticity Certificate'->'Settings' menu item
			private static JMenu _forms_appraisal; //'Forms'->'Appraisal' menu
				private static JMenuItem _appraisal_custom; //'Appraisal'->'Print Custom' menu item
				private static JMenuItem _appraisal_pending; //'Appraisal'->'Print Pending' menu item
				private static JMenuItem _appraisal_archive; //'Appraisal'->'Print Archived' menu item
				private static JMenuItem _appraisal_data; //'Appraisal'->'Print From Data' menu item
				private static JMenuItem _appraisal_settings; //'Appraisal'->'Settings' menu item
			private static JMenuItem _forms_pending; //'Forms'->'Print Pending' menu item
		private static JMenu _menu_tools; //'Tools' menu
			private static JMenuItem _tools_protect; //'Tools'->'Protect' menu item
			private static JMenuItem _tools_scanner; //'Tools'->'Configure Scanner' menu item
			private static JMenuItem _tools_dialer; //'Tools'->'Configure Dialer' menu item
			private static JMenuItem _tools_email; //'Tools'->'Configure Email' menu item
			private static JMenuItem _tools_database; //'Tools'->'Configure Database' menu item
			private static JMenuItem _tools_web; //'Tools'->'Configure For Web' menu item
		private static JMenu _menu_view; //'View' menu
			private static JMenu _view_toolbars; //'View'->'Toolbars' menu
				private static JCheckBoxMenuItem _toolbars_quickie; //'Toolbars'->'Quickie' menu checkbox item
				private static JCheckBoxMenuItem _toolbars_reports; //'Toolbars'->'Reports' menu checkbox item
		private static JMenu _menu_window; //'Window' menu
		private static JMenu _menu_help; //'Help' menu
			private static JMenuItem _help_about; //'Help'->'About' menu item
	//menu declarations
	
	//toolbar declarations
	private static JToolBar _tb_quickie;
	private static JToolBar _tb_reports;
	private static JToolBar _tb_custom;
	//toolbar declarations
	
	//toolbar button declarations
	private static JButton _tb_b_qaddclient;
	private static JButton _tb_b_qaddpiece;
	private static JButton _tb_b_qaddsale;
	private static JButton _tb_b_qaddartist;
	private static JButton _tb_b_qaddframe;
	private static JButton _tb_b_qaddmat;
	private static JButton _tb_b_qaddinv;
	private static JButton _tb_b_qaddcontact;
	private static JButton _tb_b_qupload;
	private static JButton _tb_b_qdownload;
	private static JButton _tb_b_qprint;
	private static JButton _tb_b_qsave;
	//toolbar button declarations
	
	//listener declarations
	private static MenuCommand _menu_command;
	//listener declarations
	
	static {
		try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); }
		catch (ClassNotFoundException cnfe) { System.err.println("Class Not Found: jdbc.odbc.Driver"); }
		//appearance configuration
		try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (InstantiationException ie) { }
		catch (UnsupportedLookAndFeelException ulafe) { }
		catch (ClassNotFoundException cnfe) { }
		catch (IllegalAccessException iae) { }
		//appearance configuration
		
		//print instantiation
//		_printer = new Spooler();
		//print instantiation
		
		//frame instantiation
		main = new JFrame("Gallery Management Program");
		desktop = new JDesktopPane();
		_status = new JPanel();
			_mem_usage = new JLabel((Runtime.getRuntime().freeMemory()/1024l)+"KB Free");
			_progress_bar = new JProgressBar();
			_db_type = new JLabel("MS Access");
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		//frame instantiation
	
		//menu instantiation
		_menu = new JMenuBar();
			_menu_file = new JMenu("File");
				_file_open = new JMenuItem("Open");
				_file_save = new JMenuItem("Save");
				_file_saveas = new JMenuItem("Save As");
				_file_upload = new JMenu("Upload");
					_upload_artist = new JMenuItem("Artist Database");
					_upload_art = new JMenuItem("Art Database");
					_upload_framing = new JMenuItem("Framing Database");
					_upload_matting = new JMenuItem("Matting Database");
					_upload_all = new JMenuItem("All");
				_file_download = new JMenu("Download");
					_download_artist = new JMenuItem("Artist Database");
					_download_art = new JMenuItem("Art Database");
					_download_framing = new JMenuItem("Framing Database");
					_download_matting = new JMenuItem("Matting Database");
					_download_all = new JMenuItem("All");
				_file_exit = new JMenuItem("Exit");
			_menu_edit = new JMenu("Edit");
				_edit_cut = new JMenu("Cut");
					_cut_text = new JMenuItem("Text     Ctrl+X");
					_cut_entry = new JMenuItem("Entry     Alt+X");
				_edit_copy = new JMenu("Copy");
					_copy_text = new JMenuItem("Text     Ctrl+C");
					_copy_entry = new JMenuItem("Entry     Alt+C");
				_edit_paste = new JMenu("Paste");
					_paste_text = new JMenuItem("Text     Ctrl+V");
					_paste_entry = new JMenuItem("Entry     Alt+V");
			_menu_sales = new JMenu("Sales");
				_sales_browse = new JMenuItem("Browse");
				_sales_modify = new JMenuItem("Modify/Add");
				_sales_entry = new JMenuItem("View All Entries");
				_sales_reports = new JMenuItem("Create Reports");
			_menu_client = new JMenu("Client");
				_client_browse = new JMenuItem("Browse");
				_client_modify = new JMenuItem("Modify/Add");
				_client_entry = new JMenuItem("View All Entries");
				_client_reports = new JMenuItem("Create Reports");
			_menu_artist = new JMenu("Artist");
				_artist_browse = new JMenuItem("Browse");
				_artist_modify = new JMenuItem("Modify/Add");
				_artist_entry = new JMenuItem("View All Entries");
				_artist_reports = new JMenuItem("Create Reports");
			_menu_inv = new JMenu("Inventory");
				_inv_art = new JMenu("Art");
					_art_browse = new JMenuItem("Browse");
					_art_modify = new JMenuItem("Modify/Add");
					_art_scan = new JMenuItem("Scan");
					_art_bar = new JMenuItem("Print Barcodes");
					_art_card = new JMenuItem("Print Price Cards");
					_art_entry = new JMenuItem("View All Entries");
					_art_reports = new JMenuItem("Create Reports");
				_inv_framing = new JMenu("Framing");
					_framing_browse = new JMenuItem("Browse");
					_framing_modify = new JMenuItem("Modify/Add");
					_framing_scan = new JMenuItem("Scan");
					_framing_bar = new JMenuItem("Print Barcodes");
					_framing_entry = new JMenuItem("View All Entries");
					_framing_reports = new JMenuItem("Create Reports");
				_inv_matting = new JMenu("Matting");
					_matting_browse = new JMenuItem("Browse");
					_matting_modify = new JMenuItem("Modify/Add");
					_matting_scan = new JMenuItem("Scan");
					_matting_bar = new JMenuItem("Print Barcodes");
					_matting_entry = new JMenuItem("View All Entries");
					_matting_reports = new JMenuItem("Create Reports");
				_inv_general = new JMenu("General");
					_general_browse = new JMenuItem("Browse");
					_general_modify = new JMenuItem("Modify/Add");
					_general_scan = new JMenuItem("Scan");
					_general_bar = new JMenuItem("Print Barcodes");
					_general_entry = new JMenuItem("View All Entries");
					_general_reports = new JMenuItem("Create Reports");
			_menu_market = new JMenu("Marketing");
				_market_contact = new JMenuItem("Add Contact");
				_market_group = new JMenuItem("Group Contacts");
				_market_promote = new JMenuItem("Promotions");
				_market_mailing = new JMenuItem("Mailing Lists");
				_market_snail = new JMenuItem("Snail Mail");
				_market_email = new JMenuItem("Electronic Mail");
				_market_print = new JMenu("Select To Print");
					_print_labels = new JMenuItem("Mailing Labels");
					_print_return = new JMenuItem("Return Address Labels");
					_print_letterhead = new JMenuItem("Letterheads");
					_print_flyer = new JMenuItem("Flyer");
					_print_brochure = new JMenuItem("Brochure");
					_print_news = new JMenuItem("Newsletter");
					_print_settings = new JMenuItem("Settings");
			_menu_forms = new JMenu("Forms");
				_forms_consign = new JMenu("Consignment");
					_consign_custom = new JMenuItem("Print Custom");
					_consign_pending = new JMenuItem("Print Pending");
					_consign_archive = new JMenuItem("Print Archived");
					_consign_data = new JMenuItem("Print From Data");
					_consign_settings = new JMenuItem("Settings");
				_forms_bio = new JMenu("Biography");
					_bio_custom = new JMenuItem("Print Custom");
					_bio_pending = new JMenuItem("Print Pending");
					_bio_archive = new JMenuItem("Print Archived");
					_bio_data = new JMenuItem("Print From Data");
					_bio_settings = new JMenuItem("Settings");
				_forms_invoice = new JMenu("Invoice");
					_invoice_custom = new JMenuItem("Print Custom");
					_invoice_pending = new JMenuItem("Print Pending");
					_invoice_archive = new JMenuItem("Print Archived");
					_invoice_data = new JMenuItem("Print From Data");
					_invoice_settings = new JMenuItem("Settings");
				_forms_receipt = new JMenu("Receipt");
					_receipt_custom = new JMenuItem("Print Custom");
					_receipt_pending = new JMenuItem("Print Pending");
					_receipt_archive = new JMenuItem("Print Archived");
					_receipt_data = new JMenuItem("Print From Data");
					_receipt_settings = new JMenuItem("Settings");
				_forms_statement = new JMenu("Statement");
					_statement_custom = new JMenuItem("Print Custom");
					_statement_pending = new JMenuItem("Print Pending");
					_statement_archive = new JMenuItem("Print Archived");
					_statement_data = new JMenuItem("Print From Data");
					_statement_settings = new JMenuItem("Settings");
				_forms_workorder = new JMenu("Work Order");
					_workorder_custom = new JMenuItem("Print Custom");
					_workorder_pending = new JMenuItem("Print Pending");
					_workorder_archive = new JMenuItem("Print Archived");
					_workorder_data = new JMenuItem("Print From Data");
					_workorder_settings = new JMenuItem("Settings");
				_forms_insurance = new JMenu("Insurance Valuation");
					_insurance_custom = new JMenuItem("Print Custom");
					_insurance_pending = new JMenuItem("Print Pending");
					_insurance_archive = new JMenuItem("Print Archived");
					_insurance_data = new JMenuItem("Print From Data");
					_insurance_settings = new JMenuItem("Settings");
				_forms_authenticity = new JMenu("Authenticity Certificate");
					_authenticity_custom = new JMenuItem("Print Custom");
					_authenticity_pending = new JMenuItem("Print Pending");
					_authenticity_archive = new JMenuItem("Print Archived");
					_authenticity_data = new JMenuItem("Print From Data");
					_authenticity_settings = new JMenuItem("Settings");
				_forms_appraisal = new JMenu("Appraisal");
					_appraisal_custom = new JMenuItem("Print Custom");
					_appraisal_pending = new JMenuItem("Print Pending");
					_appraisal_archive = new JMenuItem("Print Archived");
					_appraisal_data = new JMenuItem("Print From Data");
					_appraisal_settings = new JMenuItem("Settings");
				_forms_pending = new JMenuItem("Print Pending");
			_menu_finance = new JMenu("Financial");
				_finance_consumer = new JMenuItem("Consumer Accounts");
				_finance_supplier = new JMenuItem("Supplier Accounts");
				_finance_reports = new JMenuItem("Create Reports");
				_finance_quickbooks = new JMenuItem("Export To Quickbooks");
				_finance_money = new JMenuItem("Export To Microsoft Money");
			_menu_tools = new JMenu("Tools");
				_tools_protect = new JMenuItem("Password Protection");
				_tools_scanner = new JMenuItem("Configure Scanner");
				_tools_dialer = new JMenuItem("Configure Dialer");
				_tools_email = new JMenuItem("Configure Email");
				_tools_database = new JMenuItem("Configure Database");
				_tools_web = new JMenuItem("Configure For Web");
			_menu_view = new JMenu("View");
				_view_toolbars = new JMenu("Toolbars");
					_toolbars_quickie = new JCheckBoxMenuItem("Quickie",true);
					_toolbars_reports = new JCheckBoxMenuItem("Reports",false);
			_menu_help = new JMenu("Help");
				_help_about = new JMenuItem("About");
		//menu instantiation
		
		//toolbar instantiation\
		_tb_quickie = new JToolBar("Quickie Toolbar",JToolBar.VERTICAL);
		_tb_reports = new JToolBar("Reports Toolbar",JToolBar.HORIZONTAL);
		_tb_custom = new JToolBar("Custom Toolbar",JToolBar.VERTICAL);
		//toolbar instantiation
		
		//toolbar button instantiation
		_tb_b_qaddclient = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addclient.jpg")));
		_tb_b_qaddpiece = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addpiece.jpg")));
		_tb_b_qaddsale = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addsale.jpg")));
		_tb_b_qaddartist = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addartist.jpg")));
		_tb_b_qaddframe = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addframe.jpg")));
		_tb_b_qaddmat = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addmatting.jpg")));
		_tb_b_qaddinv = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addinv.jpg")));
		_tb_b_qaddcontact = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/addcontact.jpg")));
		_tb_b_qupload = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/uploadall.jpg")));
		_tb_b_qdownload = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/downloadall.jpg")));
		_tb_b_qprint = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/printpending.jpg")));
		_tb_b_qsave = new JButton(new ImageIcon(Object.class.getResource("/com/raseht/gampro/images/save.jpg")));
		//toolbar button instantiation
		
		//listener instantiation
		_menu_command = new MenuCommand();
		//listener instantiation
		
		//menu hierarchy configuration
		_menu.add(_menu_file);
			_menu_file.add(_file_open);
			_file_open.setActionCommand("FILE_OPEN");
			_file_open.addActionListener(_menu_command);
			_menu_file.add(_file_save);
			_file_save.setActionCommand("FILE_SAVE");
			_file_save.addActionListener(_menu_command);
			_menu_file.add(_file_saveas);
			_file_saveas.setActionCommand("FILE_SAVEAS");
			_file_saveas.addActionListener(_menu_command);
			_menu_file.add(_file_upload);
				_file_upload.add(_upload_artist);
				_upload_artist.setActionCommand("UPLOAD_ARTIST");
				_upload_artist.addActionListener(_menu_command);
				_file_upload.add(_upload_art);
				_upload_art.setActionCommand("UPLOAD_ART");
				_upload_art.addActionListener(_menu_command);
				_file_upload.add(_upload_framing);
				_upload_framing.setActionCommand("UPLOAD_FRAMING");
				_upload_framing.addActionListener(_menu_command);
				_file_upload.add(_upload_matting);
				_upload_matting.setActionCommand("UPLOAD_MATTING");
				_upload_matting.addActionListener(_menu_command);
				_file_upload.add(_upload_all);
				_upload_all.setActionCommand("UPLOAD_ALL");
				_upload_all.addActionListener(_menu_command);
			_menu_file.add(_file_download);
				_file_download.add(_download_artist);
				_download_artist.setActionCommand("DOWNLOAD_ARTIST");
				_download_artist.addActionListener(_menu_command);
				_file_download.add(_download_art);
				_download_art.setActionCommand("DOWNLOAD_ART");
				_download_art.addActionListener(_menu_command);
				_file_download.add(_download_framing);
				_download_framing.setActionCommand("DOWNLOAD_FRAMING");
				_download_framing.addActionListener(_menu_command);
				_file_download.add(_download_matting);
				_download_matting.setActionCommand("DOWNLOAD_MATTING");
				_download_matting.addActionListener(_menu_command);
				_file_download.add(_download_all);
				_download_all.setActionCommand("DOWNLOAD_ALL");
				_download_all.addActionListener(_menu_command);
			_menu_file.add(_file_exit);
			_file_exit.setActionCommand("FILE_EXIT");
			_file_exit.addActionListener(_menu_command);
		_menu.add(_menu_edit);
			_menu_edit.add(_edit_cut);
				_edit_cut.add(_cut_text);
				_cut_text.setActionCommand("CUT_TEXT");
				_cut_text.addActionListener(_menu_command);
				_edit_cut.add(_cut_entry);
				_cut_entry.setActionCommand("CUT_ENTRY");
				_cut_entry.addActionListener(_menu_command);
			_menu_edit.add(_edit_copy);
				_edit_copy.add(_copy_text);
				_copy_text.setActionCommand("COPY_TEXT");
				_copy_text.addActionListener(_menu_command);
				_edit_copy.add(_copy_entry);
				_copy_entry.setActionCommand("COPY_ENTRY");
				_copy_entry.addActionListener(_menu_command);
			_menu_edit.add(_edit_paste);
				_edit_paste.add(_paste_text);
				_paste_text.setActionCommand("PASTE_TEXT");
				_paste_text.addActionListener(_menu_command);
				_edit_paste.add(_paste_entry);
				_paste_entry.setActionCommand("PASTE_ENTRY");
				_paste_entry.addActionListener(_menu_command);
		_menu.add(_menu_sales);
			_menu_sales.add(_sales_browse);
			_sales_browse.setActionCommand("SALES_BROWSE");
			_sales_browse.addActionListener(_menu_command);
			_menu_sales.add(_sales_modify);
			_sales_modify.setActionCommand("SALES_MODIFY");
			_sales_modify.addActionListener(_menu_command);
			_menu_sales.add(_sales_entry);
			_sales_entry.setActionCommand("SALES_ENTRY");
			_sales_entry.addActionListener(_menu_command);
			_menu_sales.add(_sales_reports);
			_sales_reports.setActionCommand("SALES_REPORTS");
			_sales_reports.addActionListener(_menu_command);
		_menu.add(_menu_client);
			_menu_client.add(_client_browse);
			_client_browse.setActionCommand("CLIENT_BROWSE");
			_client_browse.addActionListener(_menu_command);
			_menu_client.add(_client_modify);
			_client_modify.setActionCommand("CLIENT_MODIFY");
			_client_modify.addActionListener(_menu_command);
			_menu_client.add(_client_entry);
			_client_entry.setActionCommand("CLIENT_ENTRY");
			_client_entry.addActionListener(_menu_command);
			_menu_client.add(_client_reports);
			_client_reports.setActionCommand("CLIENT_REPORTS");
			_client_reports.addActionListener(_menu_command);
		_menu.add(_menu_artist);
			_menu_artist.add(_artist_browse);
			_artist_browse.setActionCommand("ARTIST_BROWSE");
			_artist_browse.addActionListener(_menu_command);
			_menu_artist.add(_artist_modify);
			_artist_modify.setActionCommand("ARTIST_MODIFY");
			_artist_modify.addActionListener(_menu_command);
			_menu_artist.add(_artist_entry);
			_artist_entry.setActionCommand("ARTIST_ENTRY");
			_artist_entry.addActionListener(_menu_command);
			_menu_artist.add(_artist_reports);
			_artist_reports.setActionCommand("ARTIST_REPORTS");
			_artist_reports.addActionListener(_menu_command);
		_menu.add(_menu_inv);
			_menu_inv.add(_inv_art);
				_inv_art.add(_art_browse);
				_art_browse.setActionCommand("ART_BROWSE");
				_art_browse.addActionListener(_menu_command);
				_inv_art.add(_art_modify);
				_art_modify.setActionCommand("ART_MODIFY");
				_art_modify.addActionListener(_menu_command);
				_inv_art.add(_art_scan);
				_art_scan.setActionCommand("ART_SCAN");
				_art_scan.addActionListener(_menu_command);
				_inv_art.add(_art_bar);
				_art_bar.setActionCommand("ART_BARCODE");
				_art_bar.addActionListener(_menu_command);
				_inv_art.add(_art_card);
				_art_card.setActionCommand("ART_CARD");
				_art_card.addActionListener(_menu_command);
				_inv_art.add(_art_entry);
				_art_entry.setActionCommand("ART_ENTRY");
				_art_entry.addActionListener(_menu_command);
				_inv_art.add(_art_reports);
				_art_reports.setActionCommand("ART_REPORTS");
				_art_reports.addActionListener(_menu_command);
			_menu_inv.add(_inv_framing);
				_inv_framing.add(_framing_browse);
				_framing_browse.setActionCommand("FRAMING_BROWSE");
				_framing_browse.addActionListener(_menu_command);
				_inv_framing.add(_framing_modify);
				_framing_modify.setActionCommand("FRAMING_MODIFY");
				_framing_modify.addActionListener(_menu_command);
				_inv_framing.add(_framing_scan);
				_framing_scan.setActionCommand("FRAMING_SCAN");
				_framing_scan.addActionListener(_menu_command);
				_inv_framing.add(_framing_bar);
				_framing_bar.setActionCommand("FRAMING_BARCODE");
				_framing_bar.addActionListener(_menu_command);
				_inv_framing.add(_framing_entry);
				_framing_entry.setActionCommand("FRAMING_ENTRY");
				_framing_entry.addActionListener(_menu_command);
				_inv_framing.add(_framing_reports);
				_framing_reports.setActionCommand("FRAMING_REPORTS");
				_framing_reports.addActionListener(_menu_command);
			_menu_inv.add(_inv_matting);
				_inv_matting.add(_matting_browse);
				_matting_browse.setActionCommand("MATTING_BROWSE");
				_matting_browse.addActionListener(_menu_command);
				_inv_matting.add(_matting_modify);
				_matting_modify.setActionCommand("MATTING_MODIFY");
				_matting_modify.addActionListener(_menu_command);
				_inv_matting.add(_matting_scan);
				_matting_scan.setActionCommand("MATTING_SCAN");
				_matting_scan.addActionListener(_menu_command);
				_inv_matting.add(_matting_bar);
				_matting_scan.setActionCommand("MATTING_BARCODE");
				_matting_scan.addActionListener(_menu_command);
				_inv_matting.add(_matting_entry);
				_matting_entry.setActionCommand("MATTING_ENTRY");
				_matting_entry.addActionListener(_menu_command);
				_inv_matting.add(_matting_reports);
				_matting_reports.setActionCommand("MATTING_REPORTS");
				_matting_reports.addActionListener(_menu_command);
			_menu_inv.add(_inv_general);
				_inv_general.add(_general_browse);
				_general_browse.setActionCommand("GENERAL_BROWSE");
				_general_browse.addActionListener(_menu_command);
				_inv_general.add(_general_modify);
				_general_modify.setActionCommand("GENERAL_MODIFY");
				_general_modify.addActionListener(_menu_command);
				_inv_general.add(_general_scan);
				_general_scan.setActionCommand("GENERAL_SCAN");
				_general_scan.addActionListener(_menu_command);
				_inv_general.add(_general_bar);
				_general_bar.setActionCommand("GENERAL_BARCODE");
				_general_bar.addActionListener(_menu_command);
				_inv_general.add(_general_entry);
				_general_entry.setActionCommand("GENERAL_ENTRY");
				_general_entry.addActionListener(_menu_command);
				_inv_general.add(_general_reports);
				_general_reports.setActionCommand("GENERAL_REPORTS");
				_general_reports.addActionListener(_menu_command);
		_menu.add(_menu_market);
			_menu_market.add(_market_contact);
			_market_contact.setActionCommand("MARKET_CONTACT");
			_market_contact.addActionListener(_menu_command);
			_menu_market.add(_market_group);
			_market_group.setActionCommand("MARKET_GROUP");
			_market_group.addActionListener(_menu_command);
			_menu_market.add(_market_promote);
			_market_promote.setActionCommand("MARKET_PROMOTE");
			_market_promote.addActionListener(_menu_command);
			_menu_market.add(_market_mailing);
			_market_mailing.setActionCommand("MARKET_MAILING");
			_market_mailing.addActionListener(_menu_command);
			_menu_market.add(_market_snail);
			_market_snail.setActionCommand("MARKET_SNAIL");
			_market_snail.addActionListener(_menu_command);
			_menu_market.add(_market_email);
			_market_email.setActionCommand("MARKET_EMAIL");
			_market_email.addActionListener(_menu_command);
			_menu_market.add(_market_print);
				_market_print.add(_print_labels);
				_print_labels.setActionCommand("PRINT_LABELS");
				_print_labels.addActionListener(_menu_command);
				_market_print.add(_print_return);
				_print_return.setActionCommand("PRINT_RETURN");
				_print_return.addActionListener(_menu_command);
				_market_print.add(_print_letterhead);
				_print_letterhead.setActionCommand("PRINT_LETTERHEAD");
				_print_letterhead.addActionListener(_menu_command);
				_market_print.add(_print_flyer);
				_print_flyer.setActionCommand("PRINT_FLYER");
				_print_flyer.addActionListener(_menu_command);
				_market_print.add(_print_brochure);
				_print_brochure.setActionCommand("PRINT_BROCHURE");
				_print_brochure.addActionListener(_menu_command);
				_market_print.add(_print_news);
				_print_news.setActionCommand("PRINT_NEWSLETTER");
				_print_news.addActionListener(_menu_command);
				_market_print.add(_print_settings);
				_print_settings.setActionCommand("PRINT_SETTINGS");
				_print_settings.addActionListener(_menu_command);
		_menu.add(_menu_forms);
			_menu_forms.add(_forms_consign);
				_forms_consign.add(_consign_custom);
				_consign_custom.setActionCommand("CONSIGN_CUSTOM");
				_consign_custom.addActionListener(_menu_command);
				_forms_consign.add(_consign_pending);
				_consign_pending.setActionCommand("CONSIGN_PENDING");
				_consign_pending.addActionListener(_menu_command);
				_forms_consign.add(_consign_archive);
				_consign_archive.setActionCommand("CONSIGN_ARCHIVE");
				_consign_archive.addActionListener(_menu_command);
				_forms_consign.add(_consign_data);
				_consign_data.setActionCommand("CONSIGN_DATA");
				_consign_data.addActionListener(_menu_command);
				_forms_consign.add(_consign_settings);
				_consign_settings.setActionCommand("CONSIGN_SETTINGS");
				_consign_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_bio);
				_forms_bio.add(_bio_custom);
				_bio_custom.setActionCommand("BIO_CUSTOM");
				_bio_custom.addActionListener(_menu_command);
				_forms_bio.add(_bio_pending);
				_bio_pending.setActionCommand("BIO_PENDING");
				_bio_pending.addActionListener(_menu_command);
				_forms_bio.add(_bio_archive);
				_bio_archive.setActionCommand("BIO_ARCHIVE");
				_bio_archive.addActionListener(_menu_command);
				_forms_bio.add(_bio_data);
				_bio_data.setActionCommand("BIO_DATA");
				_bio_data.addActionListener(_menu_command);
				_forms_bio.add(_bio_settings);
				_bio_settings.setActionCommand("BIO_SETTINGS");
				_bio_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_invoice);
				_forms_invoice.add(_invoice_custom);
				_invoice_custom.setActionCommand("INVOICE_CUSTOM");
				_invoice_custom.addActionListener(_menu_command);
				_forms_invoice.add(_invoice_pending);
				_invoice_pending.setActionCommand("INVOICE_PENDING");
				_invoice_pending.addActionListener(_menu_command);
				_forms_invoice.add(_invoice_archive);
				_invoice_archive.setActionCommand("INVOICE_ARCHIVE");
				_invoice_archive.addActionListener(_menu_command);
				_forms_invoice.add(_invoice_data);
				_invoice_data.setActionCommand("INVOICE_DATA");
				_invoice_data.addActionListener(_menu_command);
				_forms_invoice.add(_invoice_settings);
				_invoice_settings.setActionCommand("INVOICE_SETTINGS");
				_invoice_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_receipt);
				_forms_receipt.add(_receipt_custom);
				_receipt_custom.setActionCommand("RECEIPT_CUSTOM");
				_receipt_custom.addActionListener(_menu_command);
				_forms_receipt.add(_receipt_pending);
				_receipt_pending.setActionCommand("RECEIPT_PENDING");
				_receipt_pending.addActionListener(_menu_command);
				_forms_receipt.add(_receipt_archive);
				_receipt_archive.setActionCommand("RECEIPT_ARCHIVE");
				_receipt_archive.addActionListener(_menu_command);
				_forms_receipt.add(_receipt_data);
				_receipt_data.setActionCommand("RECEIPT_DATA");
				_receipt_data.addActionListener(_menu_command);
				_forms_receipt.add(_receipt_settings);
				_receipt_settings.setActionCommand("RECEIPT_SETTINGS");
				_receipt_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_statement);
				_forms_statement.add(_statement_custom);
				_statement_custom.setActionCommand("STATEMENT_CUSTOM");
				_statement_custom.addActionListener(_menu_command);
				_forms_statement.add(_statement_pending);
				_statement_pending.setActionCommand("STATEMENT_PENDING");
				_statement_pending.addActionListener(_menu_command);
				_forms_statement.add(_statement_archive);
				_statement_archive.setActionCommand("STATEMENT_ARCHIVE");
				_statement_archive.addActionListener(_menu_command);
				_forms_statement.add(_statement_data);
				_statement_data.setActionCommand("STATEMENT_DATA");
				_statement_data.addActionListener(_menu_command);
				_forms_statement.add(_statement_settings);
				_statement_settings.setActionCommand("STATEMENT_SETTINGS");
				_statement_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_workorder);
				_forms_workorder.add(_workorder_custom);
				_workorder_custom.setActionCommand("WORKORDER_CUSTOM");
				_workorder_custom.addActionListener(_menu_command);
				_forms_workorder.add(_workorder_pending);
				_workorder_pending.setActionCommand("WORKORDER_PENDING");
				_workorder_pending.addActionListener(_menu_command);
				_forms_workorder.add(_workorder_archive);
				_workorder_archive.setActionCommand("WORKORDER_ARCHIVE");
				_workorder_archive.addActionListener(_menu_command);
				_forms_workorder.add(_workorder_data);
				_workorder_data.setActionCommand("WORKORDER_DATA");
				_workorder_data.addActionListener(_menu_command);
				_forms_workorder.add(_workorder_settings);
				_workorder_settings.setActionCommand("WORKORDER_SETTINGS");
				_workorder_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_insurance);
				_forms_insurance.add(_insurance_custom);
				_insurance_custom.setActionCommand("INSURANCE_CUSTOM");
				_insurance_custom.addActionListener(_menu_command);
				_forms_insurance.add(_insurance_pending);
				_insurance_pending.setActionCommand("INSURANCE_PENDING");
				_insurance_pending.addActionListener(_menu_command);
				_forms_insurance.add(_insurance_archive);
				_insurance_archive.setActionCommand("INSURANCE_ARCHIVE");
				_insurance_archive.addActionListener(_menu_command);
				_forms_insurance.add(_insurance_data);
				_insurance_data.setActionCommand("INSURANCE_DATA");
				_insurance_data.addActionListener(_menu_command);
				_forms_insurance.add(_insurance_settings);
				_insurance_settings.setActionCommand("INSURANCE_SETTINGS");
				_insurance_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_authenticity);
				_forms_authenticity.add(_authenticity_custom);
				_authenticity_custom.setActionCommand("AUTHENTICITY_CUSTOM");
				_authenticity_custom.addActionListener(_menu_command);
				_forms_authenticity.add(_authenticity_pending);
				_authenticity_pending.setActionCommand("AUTHENTICITY_PENDING");
				_authenticity_pending.addActionListener(_menu_command);
				_forms_authenticity.add(_authenticity_archive);
				_authenticity_archive.setActionCommand("AUTHENTICITY_ARCHIVE");
				_authenticity_archive.addActionListener(_menu_command);
				_forms_authenticity.add(_authenticity_data);
				_authenticity_data.setActionCommand("AUTHENTICITY_DATA");
				_authenticity_data.addActionListener(_menu_command);
				_forms_authenticity.add(_authenticity_settings);
				_authenticity_settings.setActionCommand("AUTHENTICITY_SETTINGS");
				_authenticity_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_appraisal);
				_forms_appraisal.add(_appraisal_custom);
				_appraisal_custom.setActionCommand("APPRAISAL_CUSTOM");
				_appraisal_custom.addActionListener(_menu_command);
				_forms_appraisal.add(_appraisal_pending);
				_appraisal_pending.setActionCommand("APPRAISAL_PENDING");
				_appraisal_pending.addActionListener(_menu_command);
				_forms_appraisal.add(_appraisal_archive);
				_appraisal_archive.setActionCommand("APPRAISAL_ARCHIVE");
				_appraisal_archive.addActionListener(_menu_command);
				_forms_appraisal.add(_appraisal_data);
				_appraisal_data.setActionCommand("APPRAISAL_DATA");
				_appraisal_data.addActionListener(_menu_command);
				_forms_appraisal.add(_appraisal_settings);
				_appraisal_settings.setActionCommand("APPRAISAL_SETTINGS");
				_appraisal_settings.addActionListener(_menu_command);
			_menu_forms.add(_forms_pending);
			_forms_pending.setActionCommand("FORMS_PENDING");
			_forms_pending.addActionListener(_menu_command);
		_menu.add(_menu_finance);
			_menu_finance.add(_finance_consumer);
			_finance_consumer.setActionCommand("FINANCE_CONSUMER");
			_finance_consumer.addActionListener(_menu_command);
			_menu_finance.add(_finance_supplier);
			_finance_supplier.setActionCommand("FINANCE_SUPPLIER");
			_finance_supplier.addActionListener(_menu_command);
			_menu_finance.add(_finance_reports);
			_finance_reports.setActionCommand("FINANCE_REPORTS");
			_finance_reports.addActionListener(_menu_command);
			_menu_finance.add(_finance_quickbooks);
			_finance_quickbooks.setActionCommand("FINANCE_QUICKBOOKS");
			_finance_quickbooks.addActionListener(_menu_command);
			_menu_finance.add(_finance_money);
			_finance_money.setActionCommand("FINANCE_MONEY");
			_finance_money.addActionListener(_menu_command);
		_menu.add(_menu_tools);
			_menu_tools.add(_tools_protect);
			_tools_protect.setActionCommand("TOOLS_PROTECT");
			_tools_protect.addActionListener(_menu_command);
			_menu_tools.add(_tools_scanner);
			_tools_scanner.setActionCommand("TOOLS_SCANNER");
			_tools_scanner.addActionListener(_menu_command);
			_menu_tools.add(_tools_dialer);
			_tools_dialer.setActionCommand("TOOLS_DIALER");
			_tools_dialer.addActionListener(_menu_command);
			_menu_tools.add(_tools_email);
			_tools_email.setActionCommand("TOOLS_EMAIL");
			_tools_email.addActionListener(_menu_command);
			_menu_tools.add(_tools_database);
			_tools_database.setActionCommand("TOOLS_DATABASE");
			_tools_database.addActionListener(_menu_command);
			_menu_tools.add(_tools_web);
			_tools_web.setActionCommand("TOOLS_WEB");
			_tools_web.addActionListener(_menu_command);
		_menu.add(_menu_view);
			_menu_view.add(_view_toolbars);
				_view_toolbars.add(_toolbars_quickie);
				_toolbars_quickie.setActionCommand("TOOLBARS_QUICKIE");
				_toolbars_quickie.addActionListener(_menu_command);
				_view_toolbars.add(_toolbars_reports);
				_toolbars_reports.setActionCommand("TOOLBARS_REPORTS");
				_toolbars_reports.addActionListener(_menu_command);
		_menu.add(_menu_help);
			_menu_help.add(_help_about);
			_help_about.setActionCommand("HELP_ABOUT");
			_help_about.addActionListener(_menu_command);
		//menu hierarchy configuration
		
		//toolbar button configuration
		_tb_b_qaddclient.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddclient.setBorderPainted(false);
		_tb_b_qaddclient.setToolTipText("Quick Add Client");
		_tb_b_qaddclient.setActionCommand("CLIENT_MODIFY");
		_tb_b_qaddclient.addActionListener(_menu_command);
		_tb_b_qaddpiece.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddpiece.setBorderPainted(false);
		_tb_b_qaddpiece.setToolTipText("Quick Add Piece");
		_tb_b_qaddpiece.setActionCommand("ART_MODIFY");
		_tb_b_qaddpiece.addActionListener(_menu_command);
		_tb_b_qaddsale.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddsale.setBorderPainted(false);
		_tb_b_qaddsale.setToolTipText("Quick Add Sale");
		_tb_b_qaddsale.setActionCommand("SALES_MODIFY");
		_tb_b_qaddsale.addActionListener(_menu_command);
		_tb_b_qaddartist.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddartist.setBorderPainted(false);
		_tb_b_qaddartist.setToolTipText("Quick Add Artist");
		_tb_b_qaddartist.setActionCommand("ARTIST_MODIFY");
		_tb_b_qaddartist.addActionListener(_menu_command);
		_tb_b_qaddframe.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddframe.setBorderPainted(false);
		_tb_b_qaddframe.setToolTipText("Quick Add Frame");
		_tb_b_qaddframe.setActionCommand("FRAMING_MODIFY");
		_tb_b_qaddframe.addActionListener(_menu_command);
		_tb_b_qaddmat.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddmat.setBorderPainted(false);
		_tb_b_qaddmat.setToolTipText("Quick Add Mat");
		_tb_b_qaddmat.setActionCommand("MATTING_MODIFY");
		_tb_b_qaddmat.addActionListener(_menu_command);
		_tb_b_qaddinv.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddinv.setBorderPainted(false);
		_tb_b_qaddinv.setToolTipText("Quick Add Inventory");
		_tb_b_qaddinv.setActionCommand("GENERAL_MODIFY");
		_tb_b_qaddinv.addActionListener(_menu_command);
		_tb_b_qaddcontact.setPreferredSize(new Dimension(32,32));
		_tb_b_qaddcontact.setBorderPainted(false);
		_tb_b_qaddcontact.setToolTipText("Quick Add Contact");
		_tb_b_qaddcontact.setActionCommand("MARKET_CONTACT");
		_tb_b_qaddcontact.addActionListener(_menu_command);
		_tb_b_qupload.setPreferredSize(new Dimension(32,32));
		_tb_b_qupload.setBorderPainted(false);
		_tb_b_qupload.setToolTipText("Quick Upload All");
		_tb_b_qupload.setActionCommand("UPLOAD_ALL");
		_tb_b_qupload.addActionListener(_menu_command);
		_tb_b_qdownload.setPreferredSize(new Dimension(32,32));
		_tb_b_qdownload.setBorderPainted(false);
		_tb_b_qdownload.setToolTipText("Quick Download All");
		_tb_b_qdownload.setActionCommand("DOWNLOAD_ALL");
		_tb_b_qdownload.addActionListener(_menu_command);
		_tb_b_qprint.setPreferredSize(new Dimension(32,32));
		_tb_b_qprint.setBorderPainted(false);
		_tb_b_qprint.setToolTipText("Quick Print Pending");
		_tb_b_qprint.setActionCommand("FORMS_PENDING");
		_tb_b_qprint.addActionListener(_menu_command);
		_tb_b_qsave.setPreferredSize(new Dimension(32,32));
		_tb_b_qsave.setBorderPainted(false);
		_tb_b_qsave.setToolTipText("Quick Save");
		_tb_b_qsave.setActionCommand("FILE_SAVE");
		_tb_b_qsave.addActionListener(_menu_command);
		//toolbar button configuration
		
		//toolbar configuration
		_tb_quickie.add(_tb_b_qaddclient);
		_tb_quickie.add(_tb_b_qaddpiece);
		_tb_quickie.add(_tb_b_qaddsale);
		_tb_quickie.add(_tb_b_qaddartist);
		_tb_quickie.add(_tb_b_qaddframe);
		_tb_quickie.add(_tb_b_qaddmat);
		_tb_quickie.add(_tb_b_qaddinv);
		_tb_quickie.add(_tb_b_qaddcontact);
		_tb_quickie.add(_tb_b_qupload);
		_tb_quickie.add(_tb_b_qdownload);
		_tb_quickie.add(_tb_b_qprint);
		_tb_quickie.add(_tb_b_qsave);
		_tb_quickie.setVisible(true);
		_tb_reports.setPreferredSize(new Dimension(32,32));
		_tb_reports.setVisible(false);
		_tb_custom.setPreferredSize(new Dimension(32,32));
		_tb_custom.setVisible(false);
		//toolbar configuration
		
		
		
		//content configuration
		BorderLayout bl = new BorderLayout();
		main.getContentPane().setLayout(bl);
		_status.setPreferredSize(new Dimension(800,30));
			_mem_usage.setPreferredSize(new Dimension(200,20));
			_status.add(_mem_usage);
			_progress_bar.setPreferredSize(new Dimension(200,20));
			_progress_bar.setStringPainted(true);
			_progress_bar.setString("Idle");
			_status.add(_progress_bar);
			_db_type.setPreferredSize(new Dimension(200,20));
			_status.add(_db_type);
		main.getContentPane().add(_status,bl.SOUTH);
		main.getContentPane().add(_tb_quickie,bl.WEST);
		main.getContentPane().add(_tb_reports,bl.NORTH);
		main.getContentPane().add(_tb_custom,bl.EAST);
		main.getContentPane().add(desktop,bl.CENTER);
		//content configuration
		
		//frame configuration
		main.setJMenuBar(_menu);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(800,600);
		//frame configuration
	}
	
	public void run() {
		System.out.println(System.getProperty("jdbc.drivers"));
		main.setVisible(true);
		while(true) {
			try { Thread.sleep(1000); }
			catch (InterruptedException ie) { }
			GUI._mem_usage.setText((Runtime.getRuntime().freeMemory()/1024l)+"KB Free");
		}
	}
	
	public static void setTask(String name) {
		_progress_bar.setIndeterminate(true);
		_progress_bar.setString(name);
		_progress_bar.setStringPainted(true);
	}
	
	public static void endTask() {
		_progress_bar.setString("Idle");
		_progress_bar.setIndeterminate(false);
	}
	
	public static Spooler getSpooler() {
		return _printer;
	}
	
	public GUI() {
	}
	
	public static JFrame getFrame() {
		return main;
	}
	
	public static class Taskette implements Runnable {
		static String task = "";
		static boolean b = true;
		
		public static void setTask(String t) {
			task = t;
			b = true;
		}
		
		public void run() {
			_progress_bar.setIndeterminate(true);
			_progress_bar.setString(Taskette.task);
			_progress_bar.setStringPainted(true);
			while(Taskette.b) { }
		}
		
		public static void endTask() {
			task = "";
			b = false;
		}
	}
	private static class MenuCommand implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String command = ae.getActionCommand();
			if (command.equals("FILE_OPEN")) { }
			else if (command.equals("FILE_SAVE")) { }
			else if (command.equals("FILE_SAVEAS")) { }
			//	else if (command.equals("UPLOAD_ARTIST")) { }
			//	else if (command.equals("UPLOAD_ART")) { }
			//	else if (command.equals("UPLOAD_FRAMING")) { }
			//	else if (command.equals("UPLOAD_MATTING")) { }
				else if (command.equals("UPLOAD_ALL")) { }
			//	else if (command.equals("DOWNLOAD_ARTIST")) { }
			//	else if (command.equals("DOWNLOAD_ART")) { }
			//	else if (command.equals("DOWNLOAD_FRAMING")) { }
			//	else if (command.equals("DOWNLOAD_MATTING")) { }
				else if (command.equals("DOWNLOAD_ALL")) { }
			else if (command.equals("FILE_EXIT")) { }
				else if (command.equals("CUT_TEXT")) { }
				else if (command.equals("CUT_ENTRY")) { }
				else if (command.equals("COPY_TEXT")) { }
				else if (command.equals("COPY_ENTRY")) { }
				else if (command.equals("PASTE_TEXT")) { }
				else if (command.equals("PASTE_ENTRY")) { }
			else if (command.equals("SALES_BROWSE")) { Sale sale = new Sale(750,520,READONLY); desktop.add(sale.getFrame()); sale.setVisible(true); }
			else if (command.equals("SALES_MODIFY")) { Sale sale = new Sale(750,520,MODIFY); desktop.add(sale.getFrame()); sale.setVisible(true); }
			else if (command.equals("SALES_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,SALE); desktop.add(ew.getFrame()); ew.setVisible(true); }
			else if (command.equals("SALES_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,SALE); desktop.add(rw.getFrame()); rw.setVisible(true); }
			else if (command.equals("CLIENT_BROWSE")) { Client client = new Client(750,520,READONLY); desktop.add(client.getFrame()); client.setVisible(true); }
			else if (command.equals("CLIENT_MODIFY")) { Client client = new Client(750,520,MODIFY); desktop.add(client.getFrame()); client.setVisible(true); }
			else if (command.equals("CLIENT_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,CLIENT); desktop.add(ew.getFrame()); ew.setVisible(true); }
			else if (command.equals("CLIENT_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,CLIENT); desktop.add(rw.getFrame()); rw.setVisible(true); }
			else if (command.equals("ARTIST_BROWSE")) { Artist artist = new Artist(750,520,READONLY); desktop.add(artist.getFrame()); artist.setVisible(true); }
			else if (command.equals("ARTIST_MODIFY")) { Artist artist = new Artist(750,520,MODIFY); desktop.add(artist.getFrame()); artist.setVisible(true); }
			else if (command.equals("ARTIST_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,ARTIST); desktop.add(ew.getFrame()); ew.setVisible(true); }
			else if (command.equals("ARTIST_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,ARTIST); desktop.add(rw.getFrame()); rw.setVisible(true); }
				else if (command.equals("ART_BROWSE")) { ArtInventory art = new ArtInventory(750,520,READONLY); desktop.add(art.getFrame()); art.setVisible(true); }
				else if (command.equals("ART_MODIFY")) { ArtInventory art = new ArtInventory(750,520,MODIFY); desktop.add(art.getFrame()); art.setVisible(true); }
				else if (command.equals("ART_SCAN")) { }
				else if (command.equals("ART_BARCODE")) { }
				else if (command.equals("ART_CARD")) { }
				else if (command.equals("ART_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,ART); desktop.add(ew.getFrame()); ew.setVisible(true); }
				else if (command.equals("ART_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,ART); desktop.add(rw.getFrame()); rw.setVisible(true); }
				else if (command.equals("FRAMING_BROWSE")) { Screen.FramingInventory framing = new Screen.FramingInventory(750,300,READONLY); desktop.add(framing.getFrame()); framing.setVisible(true); }
				else if (command.equals("FRAMING_MODIFY")) { Screen.FramingInventory framing = new Screen.FramingInventory(750,300,MODIFY); desktop.add(framing.getFrame()); framing.setVisible(true); }
				else if (command.equals("FRAMING_SCAN")) { }
				else if (command.equals("FRAMING_BARCODE")) { }
				else if (command.equals("FRAMING_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,FRAMING); desktop.add(ew.getFrame()); ew.setVisible(true); }
				else if (command.equals("FRAMING_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,FRAMING); desktop.add(rw.getFrame()); rw.setVisible(true); }
				else if (command.equals("MATTING_BROWSE")) { Screen.MattingInventory matting = new Screen.MattingInventory(750,320,READONLY); desktop.add(matting.getFrame()); matting.setVisible(true); }
				else if (command.equals("MATTING_MODIFY")) { Screen.MattingInventory matting = new Screen.MattingInventory(750,320,MODIFY); desktop.add(matting.getFrame()); matting.setVisible(true); }
				else if (command.equals("MATTING_SCAN")) { }
				else if (command.equals("MATTING_BARCODE")) { }
				else if (command.equals("MATTING_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,MAT); desktop.add(ew.getFrame()); ew.setVisible(true); }
				else if (command.equals("MATTING_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,MAT); desktop.add(rw.getFrame()); rw.setVisible(true); }
				else if (command.equals("GENERAL_BROWSE")) { Screen.GeneralInventory general = new Screen.GeneralInventory(750,275,READONLY); desktop.add(general.getFrame()); general.setVisible(true); }
				else if (command.equals("GENERAL_MODIFY")) { Screen.GeneralInventory general = new Screen.GeneralInventory(750,275,MODIFY); desktop.add(general.getFrame()); general.setVisible(true); }
				else if (command.equals("GENERAL_SCAN")) { }
				else if (command.equals("GENERAL_BARCODE")) { }
				else if (command.equals("GENERAL_ENTRY")) { Screen.EntriesWindow ew = new Screen.EntriesWindow(650,425,GENERAL); desktop.add(ew.getFrame()); ew.setVisible(true); }
				else if (command.equals("GENERAL_REPORTS")) { Screen.ReportsWindow rw = new Screen.ReportsWindow(650,425,GENERAL); desktop.add(rw.getFrame()); rw.setVisible(true); }
			else if (command.equals("MARKETING_CONTACT")) { }
			else if (command.equals("MARKETING_GROUP")) { }
			else if (command.equals("MARKETING_PROMOTE")) { }
			else if (command.equals("MARKETING_MAILING")) { }
			else if (command.equals("MARKETING_SNAIL")) { }
			else if (command.equals("MARKETING_EMAIL")) { }
				else if (command.equals("PRINT_LABELS")) { }
				else if (command.equals("PRINT_RETURN")) { }
				else if (command.equals("PRINT_LETTERHEAD")) { }
				else if (command.equals("PRINT_FLYER")) { }
				else if (command.equals("PRINT_BROCHURE")) { }
				else if (command.equals("PRINT_NEWSLETTER")) { }
				else if (command.equals("PRINT_SETTINGS")) { }
				else if (command.equals("CONSIGN_CUSTOM")) { }
				else if (command.equals("CONSIGN_PENDING")) { }
				else if (command.equals("CONSIGN_ARCHIVE")) { }
				else if (command.equals("CONSIGN_DATA")) { }
				else if (command.equals("CONSIGN_SETTINGS")) { }
				else if (command.equals("BIO_CUSTOM")) { }
				else if (command.equals("BIO_PENDING")) { }
				else if (command.equals("BIO_ARCHIVE")) { }
				else if (command.equals("BIO_DATA")) { }
				else if (command.equals("BIO_SETTINGS")) { }
				else if (command.equals("INVOICE_CUSTOM")) { }
				else if (command.equals("INVOICE_PENDING")) { }
				else if (command.equals("INVOICE_ARCHIVE")) { }
				else if (command.equals("INVOICE_DATA")) { }
				else if (command.equals("INVOICE_SETTINGS")) { }
				else if (command.equals("RECEIPT_CUSTOM")) { }
				else if (command.equals("RECEIPT_PENDING")) { }
				else if (command.equals("RECEIPT_ARCHIVE")) { }
				else if (command.equals("RECEIPT_DATA")) { }
				else if (command.equals("RECEIPT_SETTINGS")) { }
				else if (command.equals("STATEMENT_CUSTOM")) { }
				else if (command.equals("STATEMENT_PENDING")) { }
				else if (command.equals("STATEMENT_ARCHIVE")) { }
				else if (command.equals("STATEMENT_DATA")) { }
				else if (command.equals("STATEMENT_SETTINGS")) { }
				else if (command.equals("WORKORDER_CUSTOM")) { }
				else if (command.equals("WORKORDER_PENDING")) { }
				else if (command.equals("WORKORDER_ARCHIVE")) { }
				else if (command.equals("WORKORDER_DATA")) { }
				else if (command.equals("WORKORDER_SETTINGS")) { }
				else if (command.equals("INSURANCE_CUSTOM")) { }
				else if (command.equals("INSURANCE_PENDING")) { }
				else if (command.equals("INSURANCE_ARCHIVE")) { }
				else if (command.equals("INSURANCE_DATA")) { }
				else if (command.equals("INSURANCE_SETTINGS")) { }
				else if (command.equals("AUTHENTICITY_CUSTOM")) { }
				else if (command.equals("AUTHENTICITY_PENDING")) { }
				else if (command.equals("AUTHENTICITY_ARCHIVE")) { }
				else if (command.equals("AUTHENTICITY_DATA")) { }
				else if (command.equals("AUTHENTICITY_SETTINGS")) { }
				else if (command.equals("APPRAISAL_CUSTOM")) { }
				else if (command.equals("APPRAISAL_PENDING")) { }
				else if (command.equals("APPRAISAL_ARCHIVE")) { }
				else if (command.equals("APPRAISAL_DATA")) { }
				else if (command.equals("APPRAISAL_SETTINGS")) { }
			else if (command.equals("FORMS_PENDING")) { Screen.PrintPending pp = new Screen.PrintPending();}
			else if (command.equals("FINANCE_CONSUMER")) { }
			else if (command.equals("FINANCE_SUPPLIER")) { }
			else if (command.equals("FINANCE_REPORTS")) { }
			else if (command.equals("FINANCE_QUICKBOOKS")) { }
			else if (command.equals("FINANCE_MONEY")) { }
			else if (command.equals("TOOLS_PROTECT")) { }
			else if (command.equals("TOOLS_SCANNER")) { }
			else if (command.equals("TOOLS_DIALER")) { }
			else if (command.equals("TOOLS_EMAIL")) { }
			else if (command.equals("TOOLS_DATABASE")) { DialogScreen.ConfigDatabase db = new DialogScreen.ConfigDatabase(); db.setVisible(true); }
			else if (command.equals("TOOLS_WEB")) { }
				else if (command.equals("TOOLBARS_QUICKIE")) { _tb_quickie.setVisible((!_tb_quickie.isVisible())); }
				else if (command.equals("TOOLBARS_REPORTS")) { _tb_reports.setVisible((!_tb_reports.isVisible())); }
			else if (command.equals("HELP_ABOUT")) { }
		}
		
		MenuCommand() {
		}
	}
}