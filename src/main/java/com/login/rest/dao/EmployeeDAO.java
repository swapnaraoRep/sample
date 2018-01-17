package com.login.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.login.rest.beans.Employee;


@Repository
public class EmployeeDAO implements EmployeeIDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void saveEmployee(Employee employee) {
		System.out.println("EMPLOYEE DAO");
		// sessionFactory.getCurrentSession().saveOrUpdate(employee);
		sessionFactory.getCurrentSession().save(employee);
		
		
	}


	public List<Employee> getAllEmployees() {
		//sessionFactory.getCurrentSession().createQuery(arg0)
		//System.out.println("in DAO");
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
		
	}
public Employee getEmployeeById(int eid)
{
	System.out.println("in services GET EMPLOYEE"+eid);
	return (Employee)sessionFactory.getCurrentSession().get(
            Employee.class, eid);
	
	
}


public Employee getEmployee(String name, String password) {
	// TODO Auto-generated method stub
	System.out.println("in DAOIMPL GET EMPLOYEE"+name);
	/* Session session = this.sessionFactory.getCurrentSession();
	 Employee country = (Employee) session.load(Employee.class, name);
	  return country;*/
	//return (Employee)sessionFactory.getCurrentSession().load(name, password);
return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where name="+name+" password="+password+" ");
}


@Override
public void deleteEmployee(int employeeId) {
	// TODO Auto-generated method stub
	Session session = this.sessionFactory.getCurrentSession();
	Employee e=(Employee) session.load(Employee.class, employeeId);
	System.out.println(e.getName());
			if(e!=null)
				session.delete(e);
	
}


@Override
public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	Session session = this.sessionFactory.getCurrentSession();
	 session.update(employee);
}

	

}
