package OOP_Assignment4_Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<Menu> menuList = new ArrayList<Menu>();			//this list contains the menu items list which itself can be menu
	String menuName;										//name of the menu
	
	public Menu() {						//default constructor sets the menu name to main	
		menuName = "Main";
	}	
	
	public Menu(String name) {			//parameterized constructor to set the name of the menu
		menuName = name;
	}
	
	public List<Menu> getMenu() {		//this method gives the list of the menu
		return menuList;
	}
	
	public void setMenu(Menu menu) {	//this method sets the name of the menu
		menuList.add(menu);
	}
	
	public void remove(Menu menu) {		//this method removes a menu from the list
		menuList.remove(menu);
	}
}
