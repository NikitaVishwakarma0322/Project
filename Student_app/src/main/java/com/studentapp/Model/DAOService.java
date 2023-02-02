package com.studentapp.Model;

import java.sql.ResultSet;

public interface DAOService {
		
		public void connectionDB();
		
		public boolean verifycredentials(String email , String password);

		public void SaveReg(String name, String city, String email, String mobile);

		public ResultSet listRegistration();

		public void deleteByEmail(String email);

		public void updateReg(String email, String mobile);
		
	
}
