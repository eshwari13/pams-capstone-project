package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Patient;
@FunctionalInterface
public interface PatientDao {
	 default int add() throws SQLException{ return 0;};

	 default int delete(String loginId) throws SQLException{return 0;};

	 default Patient getPatientDetails(String loginId) throws SQLException{
		return null;};

	public List<Patient> getPatients() throws SQLException;

	default int update(Patient patient) throws SQLException{
		return 0;};

}
