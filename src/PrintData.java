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