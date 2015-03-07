package Assignment1;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Scanner;

/**This class is the driver which initialises all the other classes and provides the user interface for this test*/
public class MapManager {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter map width");
		int widthC = keyboard.nextInt();
		System.out.println("Please enter map height");
		int heightC = keyboard.nextInt();
		
		JFrame frame = new JFrame();
		Map customMap= new Map("customMap", widthC, heightC);
		MapDesigner customC= new MapDesigner(customMap);
		
		customC.createPath();
		customC.addTower();
		
			
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Display board = new Display(customMap);
		frame.add(board);
		frame.setSize(customMap.getWidth()*75, customMap.getHeight()*75);
		frame.setVisible(true);		
			
	}
		
}
