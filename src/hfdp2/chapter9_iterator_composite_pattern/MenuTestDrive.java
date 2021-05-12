package hfdp2.chapter9_iterator_composite_pattern;

public class MenuTestDrive {
    public static void main(String[] args) {
        // part 1
//        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        DinerMenu dinerMenu = new DinerMenu();
//
//        WaitressPart1 waitress = new WaitressPart1(pancakeHouseMenu, dinerMenu);
//        waitress.printMenu();

        // part 2
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Desset of course!");
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combines");

        pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfest",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfest",
                "Pancakes with fried eggs, sausage",
                false,
                2.99));
        allMenus.add(pancakeHouseMenu);

        dinerMenu.add(new MenuItem("Vegetarian BTL",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99));
        dinerMenu.add(new MenuItem("BTL",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99));
        dinerMenu.add(new MenuItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29));
        allMenus.add(dinerMenu);

        allMenus.add(cafeMenu);

        dessertMenu.add(new MenuItem("Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true,
                1.59));
        allMenus.add(dessertMenu);

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
