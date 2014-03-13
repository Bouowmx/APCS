public class Person implements Comparable<Person> {
	private int age;
	private String name;
	
	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(Person o) {
		if (age < o.getAge()) {return -1;}
		if (age > o.getAge()) {return 1;}
		return 0;
	}
	//public int compareTo(Person o) {return name.compareTo(o.getName());}
	
	public int getAge() {return age;}
	public String getName() {return name;}
	
	public void setAge(int age) {this.age = age;}
	public void setName(String name) {this.name = name;}
	
	public String toString() {return name + ": " + age;}
}
