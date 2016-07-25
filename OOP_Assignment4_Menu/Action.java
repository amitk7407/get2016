package OOP_Assignment4_Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Action {

	//this methods takes the input from the user and provides the respective menu items
	public void action(Menu menu, Scanner sc) throws InputMismatchException {
		
		System.out.println("This is the "+menu.menuName+" menu. Please select an item:");
		DisplayMenu display = new DisplayMenu();		
		int isMenu = display.print(menu);			//here the display method is called which return integer according to further menu items present or not
		
		if(isMenu == 0) {
			System.out.println();
			System.out.println("There is no other menu item.");
		} else {
			System.out.println();
			System.out.println("Choose a menu:");
			String menuInput = sc.next();			//takes input from user if there are menu items
			int flag = 0;
			for(int index=0 ; index<menu.menuList.size() ; index++) {
				if(menuInput.equalsIgnoreCase(menu.menuList.get(index).menuName)) {		//checks if the input given by user is correct or not
					action(menu.menuList.get(index), sc);
					flag = 1;
					break;
				}
			}
			if(flag == 0) {		//if input is wrong then ask for re input
				System.out.println("Please select from the given menu items.");
				action(menu, sc);
			}
		}
	}
}