package hfdp2.chapter9_iterator_composite_pattern;

import java.util.Iterator;

public class WaitressPart1 {
    MenuInterface pancakeHouseMenuInterface;
    MenuInterface dinerMenuInterface;

    public WaitressPart1(MenuInterface pancakeHouseMenuInterface, MenuInterface dinerMenuInterface) {
        this.pancakeHouseMenuInterface = pancakeHouseMenuInterface;
        this.dinerMenuInterface = dinerMenuInterface;
    }

    public void printMenu() {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenuInterface.createIterator();
        Iterator<MenuItem> dinerIterator = dinerMenuInterface.createIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }
}
