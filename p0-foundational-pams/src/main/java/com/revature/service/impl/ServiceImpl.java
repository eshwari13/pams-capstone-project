package com.revature.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.config.DatabaseConnection;
import com.revature.constants.Constant;
import com.revature.dao.PatientDao;
import com.revature.dao.impl.PatientDaoImpl;
import com.revature.model.Patient;
import com.revature.service.Service;

public class ServiceImpl implements Service {
	private static final Logger logger = Logger.getLogger(ServiceImpl.class);
	PatientDao patient = new PatientDaoImpl();
	Scanner scan = new Scanner(System.in);
	Connection con = null;

	public static void main(String[] args) {
		ServiceImpl service = new ServiceImpl();
		service.Menu();
	}

	@Override
	public void Menu() {
		try {

			do{
				logger.info(Constant.welcomeUserMessage + Constant.signIn + Constant.signUp + Constant.exit);

				int choice = scan.nextInt();
				scan.nextLine();
				switch (choice) {
				case 1:
					authentication();
					break;
				case 2:
					signUp();
					break;
				case 3:
					exit();
					break;
				default:
					logger.info("\t\t\tWrong option selected!");
			}
			}while (true);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void authentication() throws SQLException {

		do {

			logger.info("\n======= ENTER LOGIN DETAILS ======= " + "\nEnter your USERNAME  :-");
			String id = scan.next();

			logger.info("\nEnter your PASSWORD :-");
			String pass = scan.next();
			boolean flag = false;
			for (Patient i : patient.getPatients()) {

				if (i.getLoginId().equals(id) && i.getPassword().equals(pass)) {

					signIn(id);
					flag = true;
					break;
				}
			}
			if (flag != true) {
				logger.info("\n\n======Please enter correct details=======\n");
				Menu();
			}

		} while (true);

	}

	@Override
	public void signIn(String loginId) {
		try {
			do {
				logger.info("\n=====Select from below options for further process=====\n" + "1.Update Patient Details\n"
						+ "2.Dispaly Patient Details\n" + "3.Delete Patient Details\n" + "4.Exit"
						+ "5.\nEnter your choice\n");
				int choice = scan.nextInt();
				scan.nextLine();

				switch (choice) {

				case 1:
					for (Patient i : patient.getPatients()) {
						if (i.getLoginId().equals(loginId)) {
							patient.update(i);
							break;
						}
					}
					break;
				case 2:
					logger.info(patient.getPatientDetails(loginId));
					break;
				case 3:
					patient.delete(loginId);
					logger.info("\nYour's LoginId Deleted Successfully");
					break;

				case 4:
					logger.info(Constant.exitMessage);
					Menu();
					break;

				default:
					logger.info("\nEnter between 1 and 4 only");
					break;

				}
			} while (true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void exit() {
		logger.info(Constant.exitMessage);
	}

	@Override
	public void signUp() throws SQLException {
		patient.add();

	}

}

/*
 * Predicate<PatientDao> isPatient = patient ->
 * {(patient.getPatients().equals(id) && patient.getPatients().equals(pass)); };
 * 
 * PatientDao patient1 = new PatientDaoImpl(); if (isPatient.test(patient1)) {
 * signIn(id);
 * 
 */
