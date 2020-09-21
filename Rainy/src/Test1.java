import java.util.Arrays;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test1 {
	public static void main(String[] args) {
		Fruits[] fruits = {
				new Fruits("Apple", 30),
				new Fruits("Orange", 50),
				new Fruits("Apple", 30),
				new Fruits("Apple", 30),
				new Fruits("Mango", 45),
				new Fruits("Orange", 50),
				new Fruits("Mango", 45),
		};
		
		for(Fruits fruit : fruits) 
			if(fruit.getPrice() >= 45)
				System.out.println(fruit);
		
		System.out.println("=================");
		
		Arrays.stream(fruits).parallel().filter((Fruits e) -> e.getName().equals("Apple")).forEach(System.out::println);
		
		System.out.println(
			Arrays.stream(fruits)
			.collect(Collectors.groupingBy(Fruits::getName, Collectors.counting()))
			.entrySet()
			.stream()
			.collect(Collectors.groupingBy(Entry::getValue, Collectors.mapping(Entry::getKey, Collectors.toSet())))
		);
	}
}

class Fruits {
	String name;
	int price;

	public Fruits(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Fruits [name=" + name + ", price=" + price + "]";
	}
	
}