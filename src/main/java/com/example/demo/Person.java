package com.example.demo;

import javax.persistence.*;


import java.io.Serializable;
import java.util.List;

@Entity
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String fname;
	@Column(nullable=false)
	private String lname;
	
	@ElementCollection
	List<Integer> listOfAccounts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
/*	public List<Account> getLisOfAccounts() {
        return listOfAccounts;
    }
    public void setLisOfAddresses(ArrayList<Account> lisOfAccounts) {
        this.listOfAccounts = lisOfAccounts;
    }
*/
	public Person(String fname, String lname, List<Integer> listOfAccounts) {
		this.fname = fname;
		this.lname = lname;
		this.listOfAccounts = listOfAccounts;
	}
	public Person() {
		super();
	}
	
}
