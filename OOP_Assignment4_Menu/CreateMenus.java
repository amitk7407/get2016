package OOP_Assignment4_Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateMenus {

	public static void main(String[] args) {
		
		//Create the menu with the given names
		Menu main = new Menu("Main");
		Menu file = new Menu("File");
		Menu New = new Menu("New");
		Menu java = new Menu("Java");
		Menu c = new Menu("C");
		Menu cpp = new Menu("C++");
		Menu open = new Menu("Open");
		Menu save = new Menu("Save");
		Menu saveAs = new Menu("SaveAs");
		Menu edit = new Menu("Edit");
		Menu cut = new Menu("Cut");
		Menu copy = new Menu("Copy");
		Menu paste = new Menu("Paste");
		Menu format = new Menu("Format");
		Menu wordWrap = new Menu("Word Wrap");
		Menu font = new Menu("Font");
	
		//this links the menu items with the menus
		main.setMenu(file);
		main.setMenu(edit);
		main.setMenu(format);
	
		file.setMenu(New);
			New.setMenu(java);
			New.setMenu(c);
			New.setMenu(cpp);
		file.setMenu(open);
		file.setMenu(save);
		file.setMenu(saveAs);
	
		edit.setMenu(cut);
		edit.setMenu(copy);
		edit.setMenu(paste);
	
		format.setMenu(wordWrap);
		format.setMenu(font);
		
		Scanner sc =new Scanner(System.in);
		Action actionObject = new Action();		
		try {
			actionObject.action(main, sc);		//this calls the action method
		} catch(InputMismatchException exp) {
			System.out.println("Please enter from the menu items list.");
		} finally {
			sc.close();
		}
	}
}