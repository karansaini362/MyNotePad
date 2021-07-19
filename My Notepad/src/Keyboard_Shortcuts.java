import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
public class Keyboard_Shortcuts implements KeyListener{

	GUI gui;
	public Keyboard_Shortcuts(GUI gui) {
		this.gui = gui;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// Clt + N for New File
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			gui.M_F_File.newFile();
			
		}
		
		// Clt + O for Open a File
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.M_F_File.open();
					
		}
		
		// Clt + S for Save
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.M_F_File.save();
			
		}
		
		// Clt + Shift + S for Save As
		if(e.isShiftDown() &&  e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.M_F_File.saveAs();
			
		}
		
		// Clt + O for Exit
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_X) {
			gui.M_F_File.exit();
							
		}
		
		// Alt + F for Selecting Menu
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
			gui.menuFile.doClick();
			
		}
		
		
		// Clt + Z for Undo
		 if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) {
				gui.M_F_Edit.undo();
					
		}
		 
		 
		// Clt + Z for Redo
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y) {
		   gui.M_F_Edit.redo();
							
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
  