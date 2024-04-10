package com.rest.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;


import com.rest.model.Bank1;

public interface ServiceInterface {
	public Bank1 Save(Bank1 bank1);
    public Bank1 Balance( String accountNumber ,  String name, String password );
    public Bank1 Deposite( String accountNumber , String name,String password, Double amount );
    public Bank1 Withdraw( String accountNumber , String name, String password,  Double amount );
    public Bank1 Transfer( String accountNumber , String name, String password,  Double amount, String transferAccountNumber  );
    public Bank1 CloseAcc(String accountNumber , String name,  String password );
    public Bank1 ActivateAcc( String accountNumber ,  String name,  String password );
    public List<Bank1>GetAllRecords();
    public Bank1 DeleteAccount(String accountNumber , String name, String password);
    public Bank1 getRecord(String accountNumber ,  String name, String password,long mobile_no);
    public Bank1 Updaterecord(String accountNumber ,  String name, String password,String address,long mobile_no);
}
