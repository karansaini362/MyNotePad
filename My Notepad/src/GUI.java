import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {
    
	// JFrame Window
	JFrame window;
	// TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	// TOP MENU
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	// FILE MENU
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

	// EDIT MENU

	JMenuItem iUndo, iRedo;

	// FORMAT MENU
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR,
	iFontSize8, iFontSize12, iFontSize14, iFontSize16, iFontSize18,
	iFontSize24, iFontSize32, iFontSize36, iFontSize42, iFontSize48;

	JMenu menuFont, menuFontSize;

	// COLOR MENU
	JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5, iColor6, iColor7;




	Menu_File_Functions M_F_File = new Menu_File_Functions(this);
	Menu_Format_Functions M_F_Format = new Menu_Format_Functions(this);
	Menu_Color_Functions M_F_Color = new Menu_Color_Functions(this);
	Menu_Edit_Functions M_F_Edit = new Menu_Edit_Functions(this);

	UndoManager um = new UndoManager();
	
	Keyboard_Shortcuts keyboardShortcuts = new Keyboard_Shortcuts(this) ;

    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("notepad.png"));
	
	public GUI(){

		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();

		M_F_Format.selectedFont = "Arial";
		M_F_Format.createFont(16);
		M_F_Format.wordWrap();

		M_F_Color.changeColor("White");


		window.setVisible(true);
	}

	public static void main(String[] args) {

		new GUI();

	}

	public void createWindow() {
		window = new JFrame("MyNotepad");
		window.setSize(800,600);
		window.setIconImage(logo.getImage());
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setFont(M_F_Format.arial);
		textArea.addKeyListener(keyboardShortcuts);
		

		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				}
				);

		 scrollPane = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 scrollPane.setBorder(BorderFactory.createEmptyBorder());
		 window.add(scrollPane);

	}


	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);

		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}

	public void createFileMenu() {
		iNew = new JMenuItem("New / (Clt + N)");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);

		iOpen = new JMenuItem("Open / (Clt + O)");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);

		iSave = new JMenuItem("Save / (Clt + S)");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);

		iSaveAs = new JMenuItem("Save As / (Clt + Shift + S)");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);

		iExit = new JMenuItem("Exit / (Clt + X)");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);

		//....end of File Menu
	}


	public void createEditMenu() {

		iUndo = new JMenuItem("Undo / (Clt+Z)");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);

		iRedo = new JMenuItem("Redo / (Clt+Y)");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);



		//... end of Edit Menu.....
	}

	public void createFormatMenu() {

		iWrap = new JMenuItem("Word Wrap : OFF");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word_Wrap");
		menuFormat.add(iWrap);

		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);


		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);


		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size8");
		menuFontSize.add(iFontSize8);

		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Size12");
		menuFontSize.add(iFontSize12);

		iFontSize14 = new JMenuItem("14");
		iFontSize14.addActionListener(this);
		iFontSize14.setActionCommand("Size14");
		menuFontSize.add(iFontSize14);

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size16");
		menuFontSize.add(iFontSize16);

		iFontSize18 = new JMenuItem("18");
		iFontSize18.addActionListener(this);
		iFontSize18.setActionCommand("Size18");
		menuFontSize.add(iFontSize18);

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size24");
		menuFontSize.add(iFontSize24);

		iFontSize32 = new JMenuItem("32");
		iFontSize32.addActionListener(this);
		iFontSize32.setActionCommand("Size32");
		menuFontSize.add(iFontSize32);

		iFontSize36 = new JMenuItem("36");
		iFontSize36.addActionListener(this);
		iFontSize36.setActionCommand("Size36");
		menuFontSize.add(iFontSize36);

		iFontSize42 = new JMenuItem("42");
		iFontSize42.addActionListener(this);
		iFontSize42.setActionCommand("Size42");
		menuFontSize.add(iFontSize42);

		iFontSize48 = new JMenuItem("48");
		iFontSize48.addActionListener(this);
		iFontSize48.setActionCommand("Size48");
		menuFontSize.add(iFontSize48);


		//..end of Format Menu
	}


	public void createColorMenu() {

		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);

		iColor2 = new JMenuItem("Red");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Red");
		menuColor.add(iColor2);

		iColor3 = new JMenuItem("Green");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Green");
		menuColor.add(iColor3);

		iColor4 = new JMenuItem("Blue");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Blue");
		menuColor.add(iColor4);

		iColor5 = new JMenuItem("Yellow");
		iColor5.addActionListener(this);
		iColor5.setActionCommand("Yellow");
		menuColor.add(iColor5);


		iColor6 = new JMenuItem("Black");
		iColor6.addActionListener(this);
		iColor6.setActionCommand("Black");
		menuColor.add(iColor6);

		iColor7 = new JMenuItem("Gray");
		iColor7.addActionListener(this);
		iColor7.setActionCommand("Gray");
		menuColor.add(iColor7);


		//... end of Create Color Menu method....
	}




	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		switch(command)
		{
		case "New": M_F_File.newFile(); break;
		case "Open": M_F_File.open(); break;
		case "Save": M_F_File.save(); break;
		case "SaveAs": M_F_File.saveAs(); break;
		case "Exit": M_F_File.exit(); break;
		case "Undo" : M_F_Edit.undo();break;
		case "Redo" : M_F_Edit.redo();break;
		case "Word_Wrap": M_F_Format.wordWrap(); break;
		case "Arial" : M_F_Format.setFont(command);break;
		case "Comic Sans MS" : M_F_Format.setFont(command);break;
		case "Times New Roman" : M_F_Format.setFont(command);break;
		case "Size8": M_F_Format.createFont(8); break;
		case "Size12": M_F_Format.createFont(12); break;
		case "Size14": M_F_Format.createFont(14); break;
		case "Size16": M_F_Format.createFont(16); break;
		case "Size18": M_F_Format.createFont(18); break;
		case "Size24": M_F_Format.createFont(24); break;
		case "Size32": M_F_Format.createFont(32); break;
		case "Size36": M_F_Format.createFont(36); break;
		case "Size42": M_F_Format.createFont(42); break;
		case "Size48": M_F_Format.createFont(48); break;
		case "White": M_F_Color.changeColor(command); break;
		case "Red": M_F_Color.changeColor(command); break;
		case "Green": M_F_Color.changeColor(command); break;
		case "Blue": M_F_Color.changeColor(command); break;
		case "Yellow": M_F_Color.changeColor(command); break;
		case "Black": M_F_Color.changeColor(command); break;
		case "Gray": M_F_Color.changeColor(command); break;



		}
	}



	// end of GUI Class
}
