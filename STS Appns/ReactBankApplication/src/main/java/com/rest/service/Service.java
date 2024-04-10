package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rest.model.Bank1;
import com.rest.model.Bank1.Accountstatus;
import com.rest.repository.BankRepo;

@org.springframework.stereotype.Service

public class Service implements ServiceInterface {
	@Autowired
	private BankRepo repo;
	//====================================SAVE METHOD=================================================================================================================================================================================================================================================
	@Override
	public Bank1 Save(Bank1 bank1) {
		Bank1 bank12  = repo.save(bank1);
		return bank12;
	}
	//===============================BALANCE CHECK METHOD==============================================================================================================================================================================================================================================
	@Override
	public Bank1 Balance(String accountNumber,String name,String password) {

		Bank1 bank12   = repo.findById(accountNumber).get();
		if(bank12.getAccountNumber().equals(accountNumber) &&
				bank12.getName().equals(name) &&
				bank12.getPassword().equals(password)&&
				bank12.getStatus()==Accountstatus.active)

		{
			return bank12;

		}
		else {
			return null;

		}

	}
	//================================DEPOSITE CHECK METHOD==============================================================================================================================================================================================================================================
	@Override
	public Bank1 Deposite(String accountNumber, String name, String password, Double amount) {
		Bank1 data = repo.findById(accountNumber).get();
		double totalAmount=0.0;
		if(data.getAccountNumber().equals(accountNumber)
				&& data.getName().equals(name)
				&& data.getPassword().equals(password)
				&&  data.getStatus()==Accountstatus.active)
		{
			totalAmount =  data.getAmount()+amount;
			data.setAmount(totalAmount);
			repo.save(data);
			return data;
		}
		else {
			return null;
		}
		//==================================WITHDRAW CHECK METHOD===================================================================================================================================================================================================================================================================================
	}
	@Override
	public Bank1 Withdraw(String accountNumber, String name, String password, Double amount) {
		Bank1 data = repo.findById(accountNumber).get();
		double totalAmount=0.0;
		if(data.getAccountNumber().equals(accountNumber)
				&& data.getName().equals(name)
				&& data.getPassword().equals(password)
				&&  data.getStatus()==Accountstatus.active)
		{
			totalAmount =  data.getAmount()-amount;
			data.setAmount(totalAmount);
			repo.save(data);
			return data;
		}
		else {
			return null;
		}

	}
	//=====================================TRANSFER METHOD====================================================================================================================================================================================================================================================================================
	@Override
	public Bank1 Transfer(String accountNumber, String name, String password, Double amount,
			String transferAccountNumber) {
		Bank1 data   = repo.findById(accountNumber).get();
		Bank1 transferdata  = repo.findById(transferAccountNumber).get();
		double withdraw=0.0;
		double AfterWithdraw=0.0;

		if(data.getAccountNumber().equals(accountNumber)&&
				data.getName().equals(name)&&
				data.getPassword().equals(password)&&
				transferdata.getAccountNumber().equals(transferAccountNumber)&&
				amount<data.getAmount()&&
				data.getStatus()==Accountstatus.active&&
				transferdata.getStatus()==Accountstatus.active)
		{
			withdraw=data.getAmount()-amount;
			data.setAmount(withdraw);
			repo.save(data);

			AfterWithdraw =transferdata.getAmount()+amount;
			transferdata.setAmount(AfterWithdraw);
			repo.save(transferdata);
			return data;
		}

		return transferdata;

	}
	//===================================ACCOUNT CLOSE METHOD===================================================================================================================================================================================================================================================================
	@Override
	public Bank1 CloseAcc(String accountNumber, String name, String password) {

		Bank1 data = repo.findById(accountNumber).get();
		if(data.getAccountNumber().equals(accountNumber)&&
				data.getName().equals(name)&&
				data.getPassword().endsWith(password)&&
				data.getStatus()==Accountstatus.active)
		{
			data.setStatus(Accountstatus.inactive);
			repo.save(data);
			return data;
		}
		else {
			return null;
		}
	}
	//=====================================ACCOUNT ACTIVATE METHOD=============================================================================================================================================================================================================================================
	@Override
	public Bank1 ActivateAcc(String accountNumber, String name, String password) {
		Bank1 data   = repo.findById(accountNumber).get();
		System.out.println(data);
		if(data.getAccountNumber().equals(accountNumber)&&
				data.getName().equals(name)&&
				data.getPassword().equals(password)&&
				data.getStatus()==Accountstatus.inactive)
		{
			data.setStatus(Accountstatus.active);
			repo.save(data);
			return data;

		}
		else {

			return null;
		}
	}
	//=====================================GET ALL BANKS RECORDS=========================================================================================================================================================================================
	@Override
	public List<Bank1> GetAllRecords() {
		List<Bank1>data   = repo.findAll();
		return data;
	}
	//=============================================DELETE ACCOUNT========================================================================================================================================================================================================
	@Override
	public Bank1 DeleteAccount(String accountNumber, String name, String password) {
		Bank1  data    = repo.findById(accountNumber).get();

		if(data.getAccountNumber().equals(accountNumber)&&
				data.getName().equals(name)&&data.getPassword().equals(password)&&
				data.getStatus()==Accountstatus.inactive)
		{
			repo.deleteById(accountNumber);
			return data;
		}
		else {
			return null;
		}


	}
	//==================================================GET ONE RECORD=====================================================================================================================================================================================================
	@Override
	public Bank1 getRecord(String accountNumber, String name, String password,long mobile_no) {
		Bank1 data  = repo.findById(accountNumber).get();
		if(data.getAccountNumber().equals(accountNumber)&&
				data.getName().equals(name)&&
				data.getPassword().equals(password)&&
				data.getMobile_no()==mobile_no&&
				data.getStatus()==Accountstatus.active)
		{
			return data;
		}
		else {

			return null;
		}
	}
	//=================================================UPDATE RECORED==============================================================================================================================================================================================================================================
	@Override
	public Bank1 Updaterecord(String accountNumber, String name, String password, String address,long mobile_no) {
		Bank1 data = repo.findById(accountNumber).get();
		if(data.getAccountNumber().equals(accountNumber)&&data.getStatus()==Accountstatus.active)
		{
			data.setName(name);   
			data.setAddress(address);
			data.setMobile_no(mobile_no);
			data.setPassword(password);
			repo.save(data);
			return data;
		}
		else {
			return null;
		}
	}
}











































































































































