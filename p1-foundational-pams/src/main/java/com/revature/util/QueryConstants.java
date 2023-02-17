package com.revature.util;

public class QueryConstants {
	public static final String INSERT_USER = "INSERT INTO `pams`.`registration`(login_id,password,role) VALUES(?,?,?)";
	public static final String UPDATE_USER = "UPDATE `pams`.`registration` SET LOGIN_ID=?,PASSWORD=?,USERNAME=?,EMAIL=?,PHONE_NO=?,DATE_OF_BIRTH=?,AGE=?,physical_disability=?,IDENTITY_PROOF=?,ADRESS=? WHERE  LOGIN_ID=?";	
	public static final String DELETE_USER = "DELETE FROM `pams`.`registration` WHERE LOGIN_ID=?";
	public static final String SELECT_USER = "SELECT * FROM `pams`.`registration` WHERE LOGIN_ID=? AND PASSWORD=?";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM `pams`.`registration` WHERE LOGIN_ID=?";
	public static final String SELECT_ALL_USER = "SELECT * FROM `pams`.`registration` ORDER BY ROLE";
	public static final String SELECT_USERS_BY_ID_PATTERN = "SELECT * FROM `pams`.`registration` WHERE LOGIN_ID LIKE ?";

}

//SELECT * FROM GD_ACCOUNT;
//
//DROP TABLE GD_LOGIN;
//CREATE TABLE GD_LOGIN
//(
//  LOGIN_ID VARCHAR(200),
//  PASSWORD VARCHAR(200),
//  ROLE VARCHAR2(20)
//);
//
//INSERT INTO GD_LOGIN VALUES('N001','123','normal');
//INSERT INTO GD_LOGIN VALUES('N002','123','normal');
//INSERT INTO GD_LOGIN VALUES('N003','123','normal');
//INSERT INTO GD_LOGIN VALUES('N004','123','normal');
//INSERT INTO GD_LOGIN VALUES('N005','123','normal');
//
//INSERT INTO GD_LOGIN VALUES('A001','123','admin');
//INSERT INTO GD_LOGIN VALUES('A002','123','admin');
//INSERT INTO GD_LOGIN VALUES('A003','123','admin');
//INSERT INTO GD_LOGIN VALUES('A004','123','admin');
//INSERT INTO GD_LOGIN VALUES('A005','123','admin');
//
//COMMIT;
//SELECT * FROM GD_Login;