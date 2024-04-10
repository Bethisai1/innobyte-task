package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Bank1;
import com.rest.service.ServiceInterface;

@RestController
@CrossOrigin(origins = {"*"})
public class BankController {
@Autowired
private ServiceInterface service;
//=================================SAVE======================================================================================================================================================================================================================================================================================================================================
@PostMapping("/save")
public Bank1 Save(@RequestBody Bank1 bank1) 
{
		 Bank1 data      = service.Save(bank1);
		 if(data!=null)
		 {
			return data; 
		 }
		 else {
			 return null;	 
		 }	
}
//==================================BALANCE=================================================================================================================================================================================================================================================================================================================================	
@GetMapping("balance/{accountNumber}/{name}/{password}")
public Bank1 CheckBalance(@PathVariable String accountNumber,@PathVariable  String name, @PathVariable String password )
{
	        Bank1 bank12  =service.Balance(accountNumber,name,password);
	        if(bank12!=null)
	        {
	        return bank12;
	        }
	        
	        else {
	        return null;
	 
	        }
}
//================================DEPOSIT====================================================================================================================================================================================================================================================================================================================================
@GetMapping("deposit/{accountNumber}/{name}/{password}/{amount}")
public Bank1 deposit(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password,@PathVariable Double amount)
{
	Bank1 data	 = service.Deposite(accountNumber, name, password, amount);
	if(data!=null)
	{
		return data;
	}
	else {
		return null;
	}
}
//===================================WITHDRAW===============================================================================================================================================================================================================================================================================================================================
	@GetMapping("withdraw/{accountNumber}/{name}/{password}/{amount}")
	public Bank1 withdraw(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password,@PathVariable Double amount)
	{
	Bank1 data	 = service.Withdraw(accountNumber, name, password, amount);
	
	if(data!=null)
	{
		return data;
	}
	else {
		return null;
	}
}
//=================================TRANSFER=================================================================================================================================================================================================================================================================================================================================
	
@GetMapping("transfer/{accountNumber}/{name}/{password}/{amount}/{transferAccountNumber}")
public Bank1 transfer(@PathVariable String  accountNumber,@PathVariable String name,@PathVariable String password,@PathVariable Double amount,@PathVariable String transferAccountNumber )
{
	Bank1 data = service.Transfer(accountNumber, name, password, amount, transferAccountNumber);
	if(data!=null)
	{
		return data;
	}
	else {
	 return null;
	
	}
}
//================================CLOSE ACCOUNT=============================================================================================================================================================================================================================================================================================================================
@GetMapping("/close/{accountNumber}/{name}/{password}")
public Bank1 Close(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password)
{         Bank1 data=service.CloseAcc(accountNumber, name, password);
              String msg=null;
              if(data!=null)
              {
            	  return data;
              }
              else {
            	  return null;
              }
}
//===============================ACTIVATE ACCOUNT===========================================================================================================================================================================================================================================================================================================================
@GetMapping("/Active/{accountNumber}/{name}/{password}")
public Bank1 ActivateAcc(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password)
{
              Bank1 data=service.ActivateAcc(accountNumber, name, password);
              String msg=null;
              if(data!=null)
              {
            	  return data;
              }
              else {
            	  return null;
              }
 }

//===============================GETALL RECORDS=============================================================================================================================================================================================================================================================================================================================
@GetMapping("/getall")
public List<Bank1> GetAll()
{
	 List<Bank1>data = service.GetAllRecords();
	 if(data!=null)
	 {
	    return data;	 
	 }
	 else 
	 {
		 return null;
	 }
	
}

//======================================DELETE===============================================================================================================================================================================================================================================================================================================================
@DeleteMapping("/delete/{accountNumber}/{name}/{password}")
public String deleteAccount(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password)
{
           Bank1 data  = service.DeleteAccount(accountNumber, name, password);
           String message=null;
           if(data==null)
           {
        	   message = "your account not deleted";
           }
           else {
        	   message="your account is  deleted because it is inactive status";
           }
           return message;

}
//==================================CHECK YOUR ACCOUNT IS PRESENT OR NOT=======================================================================================================================================================================================================================================================================================================
@GetMapping("/getone/{accountNumber}/{name}/{password}/{mobile_no}")
public Bank1 getOne(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password,@PathVariable long mobile_no)
{
	
               Bank1 data= service.getRecord(accountNumber, name, password,mobile_no);
         if(data!=null)
         {
        	 return data;
         }
         else {
        	 return null;
         }
}



//==================================UPDATE=====================================================================================================================================================================================================================================================================================================================================
@PutMapping("/update/{accountNumber}/{name}/{password}/{address}/{mobile_no}")
public Bank1 updateAccount(@PathVariable String accountNumber,@PathVariable String name,@PathVariable String password,@PathVariable long mobile_no,@PathVariable String address)
{
            Bank1 data = service.Updaterecord(accountNumber, name, password,address,mobile_no);
	
            if(data!=null)
            {
            	return data;
            }
            else {
            	return null;
            }		
}
}









































































