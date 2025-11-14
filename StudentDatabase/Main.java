package com.jdbc.StudentDatabase;

public class Main {
    public static void main(String[] args) {
    	IConnection ConnectionImpl=new ConnectionImpl();
    	IStudent StudentImpl=new StudentImpl();
        IMenu menu = new Menu();
        menu.showMenu();
    }
}
