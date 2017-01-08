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


import java.util.*;
import java.awt.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class Spooler {
	public static PrintService[] printer;
	public String jobname;
	private static PrintService pdefault;
	private HashMap<String,SimpleDoc> pnd;
	private HashMap<String,SimpleDoc> arc;
	private static final Paper A4 = new Paper();
	private static final Paper LEGAL = new Paper();
	private static final double INCH = 72d;
	private static final double HALFINCH = 36d;
	private static final double QINCH = 18d;
	private static final double EINCH = 9d;
	private static final double SINCH = 4.5d;
	private static final double T2INCH = 2.25d;
	private static final double S4INCH = 1.125d;
	private static final double O28INCH = 0.5625;
	
	static {
		A4.setSize(INCH*8+HALFINCH,INCH*11);
		A4.setImageableArea(0,0,INCH*8+HALFINCH,INCH*11);
		LEGAL.setSize(INCH*8+HALFINCH,INCH*14);
		LEGAL.setImageableArea(0,0,INCH*8+HALFINCH,INCH*11);
		printer = PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE,null);
		if(Spooler.pdefault==null) Spooler.pdefault = printer[0];
	}
	
	private static class PrintBarcode implements Printable {
		public PrintData data;
		PrintBarcode(String jobname,PrintData data) {
			this.data = data;
			HashPrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(new JobName(jobname,null));
			Doc doc = new SimpleDoc(this,DocFlavor.SERVICE_FORMATTED.PRINTABLE,null);
			DocPrintJob job = Spooler.showDialog(aset);
			try { job.print(doc,aset); }
			catch (PrintException pe) { pe.printStackTrace(); }
		}
		
		public int print(Graphics g,PageFormat pf,int pageIndex) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.black);
			//pf.setPaper(Spooler.A4);
			if(pageIndex==0) {
				for(int i=0;i<this.data.strings.length;i++) {
					Barcode.barCreate(g2,this.data.strings[i].string,(int)this.data.strings[i].x,(int)this.data.strings[i].y);
				}
				return PAGE_EXISTS;
			}
			else return Printable.NO_SUCH_PAGE;
		}	
	}
	
//	private static class PriceTag implements Printable {
//	}
	
	public static DocPrintJob showDialog(HashPrintRequestAttributeSet aset) { //default printer setup
		Spooler.pdefault = ServiceUI.printDialog(null,20,20,Spooler.printer,Spooler.pdefault,DocFlavor.SERVICE_FORMATTED.PRINTABLE,aset);
		return pdefault.createPrintJob();
	}
	
	public void setupPrinter() { //program-specific printer setup
	}
	
/*	public void print(boolean pend,String code,SimpleDoc doc,String name) {
		if(pend) { pnd.put("PND_"+code,doc); }
		else { 
			arc.put("ARC_"+code,doc);
			try { printer.createPrintJob().print(doc,new HashPrintRequestAttributeSet(new JobName(name,Locale.ENGLISH))); }
			catch (PrintException pe) { System.err.println("Failed to print: ARC_"+code+", \""+name+".\" "+((pe instanceof FlavorException)?"DocFlavor Error":"Attribute Error"));
										DocFlavor[] a = printer.getSupportedDocFlavors();
										for(int x=0;x<a.length;x++) { System.err.println(a[x]); } }
		}
	}*/
	
	Spooler(String jobname,int doctype,PrintData printdata) {
		switch(doctype) {
			case 1:
			new Spooler.PrintBarcode(jobname,printdata);
		}
		pnd = new HashMap<String,SimpleDoc>(67);
		arc = new HashMap<String,SimpleDoc>(67);
	}
}