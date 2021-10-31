package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Employee;

public class EmployeeDAO {

		private EntityManager entityManager;
		
		public EmployeeDAO(EntityManager entityManager) {
			this.entityManager=entityManager;
		}

		public void saveEmployee(Employee employee) {
			EntityTransaction transtaction=entityManager.getTransaction();
			transtaction.begin();
			entityManager.persist(employee);
			transtaction.commit();
		}
		
		public Employee findEmployeeById(int id) {
			return entityManager.find(Employee.class, id);
		}
		
		public void removeEmployeeId(int id) {
			EntityTransaction t=entityManager.getTransaction();
			t.begin();
			entityManager.remove(findEmployeeById(id));
			t.commit();
		}
		public List<Employee> getAll(){
			Query query =entityManager.createQuery("select e from Employee e");
			return query.getResultList();
		}
		
		public Employee updateSalary(int id,int salary) {
			EntityTransaction t=entityManager.getTransaction();
			t.begin();
			Employee founded=findEmployeeById(id);
			if(founded!=null) {
				founded.setSalary(founded.getSalary()+salary);
			}
			t.commit();
			return founded;
		}
}
