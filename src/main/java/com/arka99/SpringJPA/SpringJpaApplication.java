package com.arka99.SpringJPA;

import com.arka99.SpringJPA.dao.EmployeeRepository;
import com.arka99.SpringJPA.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private  EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	public static void takeInput(EmployeeRepository employeeRepository) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
//		System.out.println();
		System.out.print("Enter email: ");
		String email = sc.nextLine();
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		addEmployee(name,email,address,employeeRepository);
	}
	public static void addEmployee(String name, String email, String address,EmployeeRepository employeeRepository) {
		List<Employee> employeeList = employeeRepository.findAll();
		Employee temp = new Employee(name,email,address);
		if(employeeList.contains(temp)) {
			System.out.println("Cannot add the record, it already exists.");
		}
		else {
			employeeRepository.save(new Employee(name,email,address));
			System.out.println("Employee added.");
		}

	}
	public static void readRecord(EmployeeRepository employeeRepository) {
		List<Employee> employeeList = employeeRepository.findAll();
		employeeList.forEach(s -> System.out.println(s));
	}

	public static void findRecords(EmployeeRepository employeeRepository) {
		Scanner sc = new Scanner(System.in);
		boolean state = true;
		while(state) {
			System.out.println("Press 1 to find record by name, Press 2 to find record by email, Press 3 to find record by address or Press 0 to quit to main menu");
			int option = sc.nextInt();
			if(option==1) {
				System.out.print("Enter the name to find the record: ");
				Scanner s = new Scanner(System.in);
				String name = s.nextLine();
				List<Employee> employeeList = employeeRepository.findEmployeeByNameIgnoreCase(name);
				if(employeeList!=null) {
					System.out.println("Found match");
					employeeList.forEach(employee->System.out.println(employee));
				}
				else {
					System.out.println("No record matches with this name.");
				}
			}
			else if(option==2) {
				System.out.print("Enter the email to find the record: ");
				Scanner s = new Scanner(System.in);
				String email = s.nextLine();
				List<Employee> employeeList = employeeRepository.findEmployeeByEmail(email);
				if(employeeList!=null) {
					System.out.println("Found match");
					employeeList.forEach(employee->System.out.println(employee));
				}
				else {
					System.out.println("No record matches with this email.");
				}

			}
			else if(option==3) {
				System.out.print("Enter the address to find the record: ");
				Scanner s = new Scanner(System.in);
				String address = s.nextLine();
				List<Employee> employeeList = employeeRepository.findEmployeeByAddressIgnoreCase(address);
				if(employeeList!=null) {
					System.out.println("Found match");
					employeeList.forEach(employee->System.out.println(employee));
				}
				else {
					System.out.println("No record matches with this address.");
				}

			}
			else {
				System.out.println("Exiting the find menu");
				state = false;

			}
		}

	}

	@Override
	public void run(String... args) throws Exception {
//		takeInput();
		findRecords(employeeRepository);
		readRecord(employeeRepository);

	}
}
