package com.ugurhmz.springorm.query;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//@Autowired
	//private SpecialRepository specialRepository;
	
	
	
	@GetMapping("/supplier/generate")
	@ResponseBody
	public String generateSuppliers() {
		
		for(int i=0 ; i < 100; i++) {
			Supplier supplier = new Supplier(0,"Satıcı "+(i+1),200+50*i);
			supplierRepository.save(supplier);
		}
			
		return "100 Satıcı eklendi...";
	}
	
	
	
	@GetMapping("/supplier/getall")
	@ResponseBody
	public String findAllSuppliers() {
		Iterable<Supplier> suppliers = supplierRepository.findAll();
		
		int count=0;
		double sumDebit=0;
		
		
		for(Supplier supplier : suppliers) {
			sumDebit += supplier.getTotalDebit();
			count++;
			
		}
	
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
	}
	
	
	
	@GetMapping("/supplier/findbyname/{name}")
	@ResponseBody
	public String findSuppliersByName(
			@PathVariable(name="name") String supplierName) 
	{
		Iterable<Supplier> suppliers = supplierRepository.findSuppliersByName(supplierName);
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
		
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
	}
	
	
	@GetMapping("/supplier/findbymindebit/{debit}")
	@ResponseBody
	public String findSuppliersByTotalDebitMin(
			@PathVariable(name="debit") double totalDebitMin) 
	{
		
		//Iterable<Supplier> suppliers = specialRepository.findSupplierTotalDebitMin(totalDebitMin);
		Iterable<Supplier> suppliers = supplierRepository.findSupplierTotalDebitMin(totalDebitMin);
		
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
		
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
	}		
}











