import java.awt.*;

public class Barcode {
	public static void barCreate(Graphics2D g,String code,int x,int y) {
		int parity = 0;
		for(int i=code.length();i>0;i--) {
			if(i%2==0) parity+=Integer.parseInt(code.substring(i-1,i));
			else parity+=Integer.parseInt(code.substring(i-1,i))*3;
		}
		barEAN13(g,code+(Math.abs((parity%10)-10)),x,y);
	}
	
	private static void barEAN13(Graphics2D g,String code,int x,int y) {
		System.out.println("EAN13");
		String sub;
		g.setColor(Color.black);
		g.fillRect(0,0,1,36);
		g.fillRect(2,0,1,36);
		x = 3;
		int o = 0;
		for(int i=2;i<=code.length();i++) {
			sub = code.substring(i-1,i);
			if(i%8==0) {
				System.out.println("Middle Gaurd.");
				g.setColor(Color.black);
				x++;
				g.fillRect(x,0,1,36);
				x+=2;
				g.fillRect(x,0,1,36);
				x+=2;
				o = 1;
			}	
			barDigit(g,Integer.parseInt(sub),o,x,0);
			x+=7;
		}
		g.setColor(Color.black);
		g.fillRect(x,0,1,36);
		g.fillRect(x+2,0,1,36);
		g.drawString(code,5,46);
	}
	
	private static void barDigit(Graphics2D g,int number,int orient,int x,int y) {
		System.out.println("Digit: "+number+" as "+((orient==0)?"left-hand.":"right hand."));
		switch(orient) {
			case 0:
			switch(number) {
				case 0:
				g.setColor(Color.black);
				g.fillRect(x+3,y,2,36);
				g.fillRect(x+6,y,1,36);
				break;
				case 1:
				g.setColor(Color.black);
				g.fillRect(x+2,y,2,36);
				g.fillRect(x+6,y,1,36);
				break;
				case 2:
				g.setColor(Color.black);
				g.fillRect(x+2,y,1,36);
				g.fillRect(x+5,y,2,36);
				break;
				case 3:
				g.setColor(Color.black);
				g.fillRect(x+1,y,4,36);
				g.fillRect(x+6,y,1,36);
				break;
				case 4:
				g.setColor(Color.black);
				g.fillRect(x+1,y,1,36);
				g.fillRect(x+5,y,2,36);
				break;
				case 5:
				g.setColor(Color.black);
				g.fillRect(x+1,y,2,36);
				g.fillRect(x+6,y,1,36);
				break;
				case 6:
				g.setColor(Color.black);
				g.fillRect(x+1,y,1,36);
				g.fillRect(x+3,y,4,36);
				break;
				case 7:
				g.setColor(Color.black);
				g.fillRect(x+1,y,3,36);
				g.fillRect(x+5,y,2,36);
				break;
				case 8:
				g.setColor(Color.black);
				g.fillRect(x+1,y,2,36);
				g.fillRect(x+4,y,3,36);
				break;
				case 9:
				g.setColor(Color.black);
				g.fillRect(x+3,y,1,36);
				g.fillRect(x+5,y,2,36);
				break;
			}
			break;
			case 1:
			switch(number) {
				case 0:
				g.setColor(Color.black);
				g.fillRect(x,y,3,36);
				g.fillRect(x+5,y,1,36);
				break;
				case 1:
				g.setColor(Color.black);
				g.fillRect(x,y,2,36);
				g.fillRect(x+4,y,2,36);
				break;
				case 2:
				g.setColor(Color.black);
				g.fillRect(x,y,2,36);
				g.fillRect(x+3,y,2,36);
				break;
				case 3:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+5,y,1,36);
				break;
				case 4:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+2,y,3,36);
				break;
				case 5:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+3,y,3,36);
				break;
				case 6:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+2,y,1,36);
				break;
				case 7:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+4,y,1,36);
				break;
				case 8:
				g.setColor(Color.black);
				g.fillRect(x,y,1,36);
				g.fillRect(x+3,y,1,36);
				break;
				case 9:
				g.setColor(Color.black);
				g.fillRect(x,y,3,36);
				g.fillRect(x+4,y,1,36);
				break;
			}
			break;
		}
	}
}