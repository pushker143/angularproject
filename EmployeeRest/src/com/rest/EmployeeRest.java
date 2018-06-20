package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


import com.bean.Employee;
import com.service.EmployeeService;

@Path("employee")
public class EmployeeRest {
	static final String api_version = "2.01A rev.18729";
	static Logger logger = Logger.getLogger(EmployeeRest.class);
	static String xmlString = null;
	EmployeeService es=new EmployeeService();
	
	@Path("/version") 
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version: " + api_version + "</p>";
	}

	@GET
	@Path("/findAll")
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Employee> findAll(){
		List<Employee> result=new ArrayList<>();
		System.out.println("Getting all Employees...");
		
		result=es.listEmployees();
		return result;
		/*return Response.ok().entity(new GenericEntity<List<Employee>>(result) {})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
				.build();*/
	}
	
	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee deleteEmployeeById(@PathParam("id") String id) {
	  System.out.println("Deleting employee with ID: " + id);
	  int emp=Integer.parseInt(id);
		Employee result=es.deleteEmployee(emp);
		
	  if (result != null) {
		logger.info("Inside deleteEmployeeById, returned: " + result.toString());
	  } else {
		logger.info("Inside deleteEmployeeById, ID: " + id + ", NOT FOUND!");
	  }
	  return result;
	}
	
	
	@Path("/add")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee addEmployee(Employee emp) {
	  System.out.println("Adding Employee ");
	  
	  if (emp != null) {
		System.out.println("Inside addEmployee, returned: " + emp.toString());
		es.insertEmployee(emp);
	  }
//	  } else {
//		System.out.println("Inside addEmployee, Unable to add Employee...");
//	  } 
	  return emp;
	}
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployeeById(@PathParam("id") String id) {
		System.out.println("Getting Employee by ID: " + id);
		int employeeId=Integer.parseInt(id);
		Employee e=es.fetchEmployee(employeeId);
	  if (e != null) {
		logger.info("Inside getEmployeeById, returned: " + e.toString());
	  } else {
		logger.info("Inside getEmployeeById, ID: " + id + ", NOT FOUND!");
	  }
	  return e;
	  /*return Response.ok().entity(new GenericEntity<Employee>(e) {})
			  .header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
				.build();*/
	}
	
	@Path("/update")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee updateEmployee(Employee emp) {

	  
	  System.out.println("updateEmployee with ID: " + emp.getEmployeeId());

	  if (emp != null) {
		  es.updateEmployee(emp);
		logger.info("Inside updateEmployee, returned: " + emp.toString());
	  } 
//	  else {
//		logger.info("Inside updateEmployee, ID: " + emp.getEmployeeId() + ", NOT FOUND!");
//	  }
	  return emp;
	  /*return Response.ok().entity(new GenericEntity<Employee>(emp) {})
			  .header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build(); */
	}
	
}
