package com.ty.one_many_bi.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_many_bi.dto.Company;
import com.ty.one_many_bi.dto.Employee;


public class EmployeeDao {


	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		
	}

//	public void saveEmployee(Employee employee,int companyId) {
//		
//		EntityTransaction entityTransaction=getEntityManager().getTransaction();
//		
//		Company company=getEntityManager().find(Company.class, companyId);
//		
//		
//			employee.setCompany(company);
//			entityTransaction.begin();
//			
//			getEntityManager().persist(employee);
//			getEntityManager().persist(employee.getCompany());
//			entityTransaction.commit();
//		
//	}
	
	public void saveEmployee(List<Employee> employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		entityTransaction.begin();
		
		for(Employee employee1:employee) {
			entityManager.persist(employee1);
		}
		
		entityTransaction.commit();
		System.out.println("Inserted ");
		
		
	}
	
	public void updateEmployee(int id, Employee employee) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee1=entityManager.find(Employee.class, id);
		
		if(employee1!=null) {
			
			employee.setId(id);
			employee.setCompany(employee.getCompany());
			
			entityTransaction.begin();
			
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		else {
			System.out.println("this employee is not present");
		}
	
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class,id);
		
		if(employee!=null) {
			employee.setId(id);
			
			entityTransaction.begin();
			entityManager.remove(employee);

			entityTransaction.commit();
			
		}
		else {
			System.out.println("Deleted successfully");
		}
			
	}
	
	public Employee getEmployeeById(int id) {
		EntityManager entityManager=getEntityManager();
		
		
		Employee employee=entityManager.find(Employee.class,id);
		return employee;
		
	}

	public List<Employee> getAllEmployee() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> list=query.getResultList();
		return list;
	
	}
	

	
	
}
