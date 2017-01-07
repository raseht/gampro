public class GAMPRO {
	public static void main(String[] args) {
		GUI gui = new GUI();
		Thread g = new Thread(gui);
		g.start();
	}
}