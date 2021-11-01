package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeDAO;
import domain.Employee;

public class TestEmployeeDAO {
		public static void main(String[] args) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			EntityManager entityManager=emf.createEntityManager();
			//main
			EmployeeDAO empDAO=new EmployeeDAO(entityManager);
			
			Employee employee=new Employee(1,"kadir","harman",5000);
			Employee employee1=new Employee(2,"tugba","oncel",6000);
			empDAO.saveEmployee(employee);
			empDAO.saveEmployee(employee1);
			
			Employee foundEmp=empDAO.findEmployeeById(2);
			System.out.println(foundEmp);
			
			//empDAO.removeEmployeeId(2);
			
			List<Employee> all=empDAO.getAll();
			
			for(Employee e:all) {
				System.out.println(e.getName());
			}
			
			Employee employee2=new Employee(3,"tugba","harman",500);
			empDAO.saveEmployee(employee2);
			empDAO.updateSalary(3, 1000);
			Employee tugba=empDAO.findEmployeeById(3);
			System.out.println(tugba.getSalary());
			
		}
	
}
