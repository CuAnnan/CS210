package Lab7;

public class Student
{
	private String name;
	private int age;
	private String degree;
	private int yearOfStudy;
	
	public Student()
	{
		
	}
	
	public Student(String name, int age, String degree, int yearOfStudy)
	{
		this.name = name;
		this.age = age;
		this.degree = degree;
		this.yearOfStudy = yearOfStudy;
	}

	public String getName()
	{
		return name;
	}

	public Student setName(String name)
	{
		this.name = name;
		return this;
	}

	public int getAge()
	{
		return age;
	}

	public Student setAge(int age)
	{
		this.age = age;
		return this;
	}

	public String getDegree()
	{
		return degree;
	}

	public Student setDegree(String degree)
	{
		this.degree = degree;
		return this;
	}

	public int getYearOfStudy()
	{
		return yearOfStudy;
	}

	public Student setYearOfStudy(int yearOfStudy)
	{
		this.yearOfStudy = yearOfStudy;
		return this;
	}
	
	public String toString()
	{
		return String.format("%s, %d, %s, %d", this.name, this.age ,this.degree, this.yearOfStudy);
	}
}
