
public abstract class Animal {
	protected String name;
	protected int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public void printInfo() {
		System.out.println("이름은 " + name + " 나이는 " + age);
	}

	public abstract void sleep();
	public abstract void eat();

}
