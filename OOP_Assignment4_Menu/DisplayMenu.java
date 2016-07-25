package OOP_Assignment4_Menu;

public class DisplayMenu {

	//this methods prints the menu items
	public int print(Menu menu) {
		
		if(menu.menuList.size() > 0) {				//checks if there is a menu item associated with a menu or not
			for(int index=0 ; index<menu.menuList.size() ; index++) {
				System.out.println(menu.menuList.get(index).menuName);		//if there are menu items prints them and return 1
			}
			return 1;
		} else {
			return 0;		//if there are no menu items it returns 0
		}
	}
}