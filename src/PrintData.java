import java.awt.*;
import java.awt.font.*;

public final class PrintData {
	public double mar_paper_left;
	public double mar_paper_top;
	public double mar_paper_mid;
	public double col_paper;
	public double row_paper;
	public double mar_in_left;
	public double mar_in_top;
	public PrintData.String[] strings;
	public PrintData.Image[] images;
	
	public static final class String {
		public Color color;
		public Font font;
		public java.lang.String string;
		public double x;
		public double y;
		
		String(Color color,Font font,java.lang.String string,double x,double y) {
			this.color = color;
			this.font = font;
			this.string = string;
			this.x = x;
			this.y = y;
		}
	}
	
	public static final class Image {
		public double x;
		public double y;
		
		Image(double x,double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public boolean pageSetup(Graphics2D g) {
		return true;
	}
	
	PrintData(double mar_paper_left,double mar_paper_top,double mar_paper_mid,double col_paper,double row_paper,double mar_in_left,double mar_in_top,PrintData.String[] strings,PrintData.Image[] images) {
		this.mar_paper_left = mar_paper_left;
		this.mar_paper_top = mar_paper_top;
		this.mar_paper_mid = mar_paper_mid;
		this.col_paper = col_paper;
		this.row_paper = row_paper;
		this.mar_in_left = mar_in_left;
		this.mar_in_top = mar_in_top;
		this.strings = strings;
		this.images = images;
	}
}