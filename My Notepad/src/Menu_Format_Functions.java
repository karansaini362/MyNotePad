import java.awt.Font;

public class Menu_Format_Functions {

	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String selectedFont;

	public Menu_Format_Functions(GUI gui) {
		this.gui = gui;
	}

	public void wordWrap() {
		if(!gui.wordWrapOn) {
			gui.wordWrapOn  = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap : ON");
		}
		else if(gui.wordWrapOn) {
			gui.wordWrapOn  = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap : OFF");
		}

		//...end of word wrap method....
	}



	public void createFont(int fontSize) {


		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

		setFont(selectedFont);

		//... end of create Font method....
	}


	public void setFont(String font) {

		selectedFont = font;

		switch(selectedFont) {

		case "Arial" : gui.textArea.setFont(arial);
		break;

		case "Comic Sans MS" : gui.textArea.setFont(comicSansMS);
		break;

		case "Times New Roman" : gui.textArea.setFont(timesNewRoman);
		break;

		}

		//.... end of Set Font method....
	}



	//...end of the Menu Format Function Class....
}
