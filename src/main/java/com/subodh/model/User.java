package com.subodh.model;

import java.rmi.server.UID;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import lombok.Data;
@Data
public class User {
	private int uId;
	private String firstName;
	private String lastName;
	private String email;
	private String country;

    private String gender;
    private List<String> userSkills;
}
