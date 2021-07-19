
public class Menu_Edit_Functions {

	GUI gui;

	public Menu_Edit_Functions(GUI gui) {
		this.gui = gui;
	}

	public void undo() {

		gui.um.undo();
		//....end of the undo method.....
	}

   public void redo() {
		gui.um.redo();

		//....end of the redo method.....
	}



	//....end of the Menu Edit Functions class.......
}
