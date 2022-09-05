package controller;

import bean.EmployeeBean;
import service.EmployeeService;

public class Controller {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		try {
			String id ="09090";
			String password ="admin";
			EmployeeService employeeService = new EmployeeService();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean = employeeService.search(id, password);
			String name = employeeBean.getName();
			String comment = employeeBean.getComment();
			String time = employeeBean.getLogin_Time();
			System.out.print(name + comment + time);
		}catch (Exception e) {
			 e.printStackTrace();
		 } 
	}

}
