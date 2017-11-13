package app;

import circularList.CircularList;
import node.node;

public class App {

	public static <T> void main(String[] args) {
		
		CircularList<String> names = new CircularList<String>();
		names.AddFirst("Axl");
		names.AddFirst("Slash");
		names.AddFirst("Izzy");
		names.AddFirst("Steve");
		names.AddFirst("Duff");
		
		System.out.println("Buscar");
		System.out.println(names.Search("Izzy"));
		System.out.println("Buscar before");
		System.out.println(names.SearchBefore("Duff"));
		System.out.println("GetLAST");
		System.out.println(names.getLast());
		System.out.println("GetFirst");
		names.GetFirst();
		System.out.println("Remove First");
		names.RemmoveFirst();
		System.out.println("Remove after");
		names.RemmoveAfter("Axl");
		names.Printer();
		System.out.println("Remmove");
		System.out.println(names.Remmove("Duff"));
		System.out.println(names.RemmoveBefore("Steve"));
		System.out.println("Reemplazaar");
		names.Repllace("Izzy", "Avril");
		names.Printer();
		names.indexOf(null);
		System.out.println(names.isEmpty());
		names.clear();
	}
}