# 하나금융티아이 20180824

## 상속

- 상속 / 추가(확장) / 재정의(수정)

- UML에서는 상속이란 표현을 안쓰고 일반화라고 말함!

- 상속은 parent 먼저 개발하고 child 개발 / 분석은 반대! 그래서 일반화라고 함

- Child c = new Child(); 라고 선언하면 Child c 가 1, new Child() 가 2, = 가 3

- 변수도 오버라이딩 가능(많이 쓰이지는 않음)

- **final** : 종결자

  -  (변수 앞에 붙을 때) 상수처리
  - (class 앞에 붙을 때) public **기타제한자(final)** class String : 상속금지
  - (method 앞에 붙을 때) 오버라이딩 금지 / 자식이 재정의 불가능

- 접근제한자 

  - public / protected / 생략 / private
  - **protected**
    - 생략할 경우에는 같은 패키지에서는 쓰고 다른 패키지에서 못쓰는데 protected는 같은 패키지에서도 쓰고 다른 패키지에서는  부모자식간이면 사용 가능! (public은 다 open)
    - 추상클래스에서 많이 씀

- ---------> 의존관계(dependency) : 쓰고 싶을 때 쓰고~

- **오버로딩과 오버라이딩 규칙 차이 (시험)**

  ``` java
  /**
   * 모든 도형의 공통적인 속성과 기능 정의
   * 
   * @author 조희진
   *
   */
  public class Shape {
  
  	private double x, y;
  
  	public Shape() {
  		this(0.0, 0.0);
  	}
  
  	public Shape(double x, double y) {
  		this.x = x;
  		this.y = y;
  	}
  
  	public double getX() {
  		return x;
  	}
  
  	public void setX(double x) {
  		this.x = x;
  	}
  
  	public double getY() {
  		return y;
  	}
  
  	public void setY(double y) {
  		this.y = y;
  	}
  
  	public void draw() {
  		System.out.println(x + "," + y + "의 도형입니다.");
  	}
  	
  	public double getLength() {
  		return 0.0;
  	}
  	
  	public double getArea() {
  		return 0.0;
  	}
  	
  
  }
  ```

  ``` java
  /**
   * 원의 속성과 기능 정의
   * @author 조희진
   *
   */
  
  public class Circle extends Shape {
  
  	private double radian;
  
  	public Circle() {
  		this(0.0, 0.0, 0.0);
  	}
  
  	public Circle(double x, double y, double radian) {
  		super(x, y);
  		this.radian = radian;
  	}
  
  	public double getRadian() {
  		return radian;
  	}
  
  	public void setRadian(double radian) {
  		this.radian = radian;
  	}
  
  	@Override
  	public void draw() {
  		System.out.println(getX() + "," + getY() + "," + getRadian() + "의 원 입니다.");
  	}
  
  	@Override
  	public double getLength() {
  		return 2 * Math.PI * radian;
  	}
  
  	@Override
  	public double getArea() {
  		return Math.PI * Math.pow(radian, 2);
  	}
  
  }
  ```

  ``` java
  /**
   * 직사각형의 속성과 기능 정의
   * @author 조희진
   *
   */
  public class Rectangle extends Shape {
  
  	private double width, height;
  
  	public Rectangle() {
  		this(0.0, 0.0, 0.0, 0.0);
  	}
  
  	public Rectangle(double x, double y, double width, double height) {
  		super(x, y);
  		this.width = width;
  		this.height = height;
  	}
  
  	@Override
  	public void draw() {
  		System.out.println(getX() + "," + getY() + "," + width + "," + height + "인 직사각형입니다.");
  	}
  
  	@Override
  	public double getLength() {
  		return 2 * (width + height);
  	}
  
  	@Override
  	public double getArea() {
  		return width * height;
  	}
  
  }
  ```

  ``` java
  public class ShapeApp {
  
  	public static void main(String[] args) {
  		Shape shape = new Shape(12.5, 35.7);
  		shape.draw();
  
  		Circle circle = new Circle(15.0, 15.0, 30);
  		circle.draw();
  		System.out.println("원의 둘레 : " + circle.getLength());
  		System.out.println("원의 넓이 : " + circle.getArea());
  
  		Rectangle rectangle = new Rectangle(14.0, 13.0, 12.0, 15.0);
  		rectangle.draw();
  		System.out.println("사각형의 둘레 : " + rectangle.getLength());
  		System.out.println("사각형의 넓이 : " + rectangle.getArea());
  
  	}
  
  }
  
  
  /*출력
  12.5,35.7의 도형입니다.
  15.0,15.0,30.0의 원 입니다.
  원의 둘레 : 188.49555921538757
  원의 넓이 : 2827.4333882308138
  14.0,13.0,12.0,15.0인 직사각형입니다.
  54.0
  180.0*/
  ```

- **toString**

  - 웬만하면 toString() 오버라이딩 하기!

    ``` java
    		System.out.println(shape); // object에 있는 toString을 자동호출한 것
    		System.out.println(shape.toString());
    //shape에 toString()을 오버라이딩 안하면 주소값이 출력됨
    
    		String str = "Java Programming";
    		System.out.println(str); //얘도 자동호출 됐는데 주소값이 안나옴(오버라이딩 된 것)
    
    ```





## 다형성(Polymorphism)

- 자바언어는 다형성을 지원하기 위해 클래스 형변환을 지원한다.

-  A클래스와 B클래스가 부모, 자식관계일 경우 데이터타입은 부모클래스(A)로 선언하고 인스턴스 생성은 자식으로 가능한 것

- 형변환이 되기위한 기본 조건 : 부모자식간이어야 함 / 절대 다른 것 끼리는 안됨

- Upcasting : 타입은 부모로 선언하고 실제 생성은 자식으로 생성

  - A a = new B();
  - 제약사항 : 새롭게 추가된 method는 안됨

- 추가된 속성이나 메소드를 접근하기 위해 Down Casting 필요

- instanceOf 연산자는 반환값이 boolean

  ``` java
  		for (Account account2 : list) {
  			if (account2 instanceof MinusAccount) {
  				System.out.println(account2.toString());
  			}
  
  		}
  //account2 instanceof Account 라고 하면 MinusAccount까지 다 출력됨! 
  ```

  

## 추상클래스와 인터페이스

### 추상(Abstract)클래스

- UML에서 클래스가 *Unit* 이렇게 기울어져 있으면 추상클래스로 만들어라

  ![그림1](https://github.com/h22j2n/hanati-day7/blob/master/img/%EA%B7%B8%EB%A6%BC1.png)

![그림2](https://github.com/h22j2n/hanati-day7/blob/master/img/%EA%B7%B8%EB%A6%BC2.png)

- Shape가 추상클래스 (실체가 없으니)

- 추상클래스는 객체생성이 목표가 아니다. => 생성자 없음 / getter setter 없어도 됨

  ``` java
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
  ```

  ``` java
  public class Dog extends Animal {
  	
  	private boolean loyalty;
  
  	public Dog(String name, int age, boolean loyalty) {
  		this.name = name;
  		this.age = age;
  		this.loyalty = loyalty;
  	}
  	
  	
  
  	public Dog() {
  		this(null, 0, false);
  	}
  
  
  	@Override
  	public void sleep() {
  		System.out.println("강아지가 주무십니다.");
  	}
  
  	@Override
  	public void eat() {
  		System.out.println("강아지가 먹습니다.");
  	}
  	
  	
  	public static void main(String[] args) {
  		Animal animal = null;
  		animal = new Dog("루니",2,false);
  		animal.printInfo();
  		animal.eat();
  		animal.sleep();
  	}
  
  }
  ```

  

### 인터페이스

- 추상클래스는 **수직적**(부모자식) 인터페이스는 **수평적**(서로 다른 클래스)

- 서로 다른 클래스 간에 원활한 소통을 위한 표준 규약

- ![그림3](https://github.com/h22j2n/hanati-day7/blob/master/img/%EA%B7%B8%EB%A6%BC3.png)

- 실현(realization) 관계 : -----▷

- **컴파일 시 자동으로 추가되는 것 : default 생성자 / extends object /super / interface의 method의 public / interface에서 int WEIGHT = 10;  //public static final 이 앞에 자동으로 붙어서 상수처리 됨(시험)** 

  ``` java
  public class Gun implements Weapon, A, B {
  //다중구현
  ```

- 인터페이스의 목적 : 수평적 규약 / 일관된 메소드를 호출하기 위함

- 다중상속도 된다

**클래스의 구성요소 8가지(시험)**

**UML 표기법 (시험)**

