package com.nabendu;
import java.util.Scanner;

//base class
class Person{
	protected String name;
	protected String address;
	protected String PhoneNo;
	protected String EmailId;
	
	//constructor
	public Person(String name,String address, String phoneNo, String emailId) {
		this.name = name;
		this.address = address;
		this.PhoneNo = phoneNo;
		this.EmailId = emailId;
	}
	
	public void showDetails() {
		System.out.println("Name : "+this.name);
		System.out.println("Address : "+this.address);
		System.out.println("Phone No. : "+this.PhoneNo);
		System.out.println("Email Id : "+this.EmailId);
	}
}

//base interfaces
interface Staff_Op{
	float Calculate_Salary(float salary);
}

interface Student_Op{
	float Calculate_Fees(float fees);
}

//inherited classes
class Student extends Person implements Student_Op {
	private String USN;
	private String Branch;
	private float Fees;
	Student(String name, String address, String phoneNo, String emailId, String usn, String branch){
		super(name,address,phoneNo,emailId);
		this.USN = usn;
		this.Branch = branch;
	}
	public float Calculate_Fees(float fee) {
		this.Fees = fee;
		return this.Fees;
	}
	public void showDetails() {
		super.showDetails();
		System.out.println("USN : "+this.USN);
		System.out.println("Branch : "+this.Branch);
		System.out.println("Fees : Rs. "+ this.Fees);
	}
}

class Staff extends Person implements Staff_Op{
	private String company;
	private int EmpId;
	private String Designation;
	private float Salary;
	
	Staff(String name, String address, String phoneNo, String emailId, String company, int empId, String desg){
		super(name, address, phoneNo, emailId);
		this.company = company;
		this.EmpId = empId;
		this.Designation = desg;
	}
	
	public void showDetails() {
		super.showDetails();
		System.out.println("Company Name : "+this.company);
		System.out.println("Employee Id : "+this.EmpId);
		System.out.println("Designation : "+this.Designation);
		System.out.println("Salary : "+this.Salary);
	}
	public float Calculate_Salary(float salary) {
		this.Salary = salary*1.2f;
		return this.Salary;
	}
}

//main class
public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		Staff stf1 = new Staff(
				"ChandraSekhar",
				"Bangalore",
				"1234567890",
				"chandrasekhar@rvce.edu.in",
				"R.V College of Engineering",
				1234,
				"Professor"
				);
		Student std1 = new Student(
				"Nabendu Das",
				"West Bengal",
				"9876543218",
				"nabendudas.mca22@rvce.edu.in",
				"1RV22MC053",
				"RVCE-MCA"
				);
		
		System.out.print("Enter Student Tution Fees : ");
		std1.Calculate_Fees(sc.nextFloat());
		System.out.println("The Student Details are - ");
		std1.showDetails();
		System.out.println();
		System.out.print("Enter Staff Salary : ");
		stf1.Calculate_Salary(sc.nextFloat());
		System.out.println("The Staff Details are - ");
		stf1.showDetails();
				
	}
}
