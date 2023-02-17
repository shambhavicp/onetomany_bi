package com.ty.one_many_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_many_bi.dao.EmployeeDao;
import com.ty.one_many_bi.dto.Company;
import com.ty.one_many_bi.dto.Employee;

public class CompanyEmployeeMain {
	public static void main(String[] args) {
		
		Employee employee1=new Employee();
		employee1.setId(1005);
		employee1.setName("ram");
		employee1.setPhone(1244567);
		
		Employee employee2=new Employee();
		employee2.setId(2005);
		employee2.setName("ranjitha");
		employee2.setPhone(133234527);
		
		Employee employee3=new Employee();
		employee3.setId(3005);
		employee3.setName("dhanish");
		employee3.setPhone(12345638);
	
		Company company=new Company();
		company.setId(3);
		company.setName("TY");
		company.setGst("XY345");
		
		
		List<Employee> list=new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);

		employee1.setCompany(company);
		employee2.setCompany(company);
		employee3.setCompany(company);
		
		company.setList(list);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(company);
//		entityManager.persist(employee1);
//		entityManager.persist(employee1);
//		entityManager.persist(employee1);
//		entityTransaction.commit();
		EmployeeDao employeeDao=new EmployeeDao();
		
		
		employeeDao.saveEmployee(list);
		
		
		
		
	}
	
	
	
}
