import java.awt.Color;

public class Menu_Color_Functions {

	GUI gui;

	public Menu_Color_Functions(GUI gui) {
		this.gui = gui;

	}

	public void changeColor(String color) {

		switch(color) {

		case "White" :
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;

		case "Red" :
			gui.window.getContentPane().setBackground(Color.red);
			gui.textArea.setBackground(Color.red);
			gui.textArea.setForeground(Color.white);
			break;


		case "Green" :
			gui.window.getContentPane().setBackground(Color.green);
			gui.textArea.setBackground(Color.green);
			gui.textArea.setForeground(Color.black);
			break;

		case "Blue" :
			gui.window.getContentPane().setBackground(Color.blue);
			gui.textArea.setBackground(Color.blue);
			gui.textArea.setForeground(Color.white);
			break;

		case "Yellow" :
			gui.window.getContentPane().setBackground(Color.yellow);
			gui.textArea.setBackground(Color.yellow);
			gui.textArea.setForeground(Color.black);
			break;

		case "Black" :
			gui.window.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.white);
			break;

		case "Gray" :
			gui.window.getContentPane().setBackground(Color.gray);
			gui.textArea.setBackground(Color.gray);
			gui.textArea.setForeground(Color.white);
			break;



		}

	}

	//....end of the Menu Color Functions Class.....
}
