package com.ugurhmz.springorm.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class ParticularController {

	@Autowired
	private ParticularRepository particularRepository;
	
	
	// PAGE 
	@GetMapping("/supplier/page")
	@ResponseBody
	public String findAllSuppliers() {
		Page<Supplier> suppliers = particularRepository.findAll(PageRequest.of(3, 15));
		
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
	
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
		
	}
	
	// SORT
	@GetMapping("/supplier/sort")
	@ResponseBody
	public String findSortedSuppliers() {
		
		Iterable<Supplier> suppliers = particularRepository.findAll(Sort.by("supplierName").descending());
		
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
	
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
		
	}
	
	
	
	// PAGE & SORT
	@GetMapping("/supplier/pagesort")
	@ResponseBody
	public String findPageSortedSuppliers() {
		Page<Supplier> suppliers = particularRepository.findAll(
				PageRequest.of(3, 15,Sort.by("supplierName").descending()));
		
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
	
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
		
	}
	
	
	@GetMapping("/supplier/pagebydebit/{debit}")
	@ResponseBody
	public String findPageByDebitSuppliers(@PathVariable(name="debit") double totalDebitMin) {
		Page<Supplier> suppliers = particularRepository.findSupplierTotalDebitMin(
				totalDebitMin, PageRequest.of(3, 15,Sort.by("supplierName").descending()));
		int count=0;
		double sumDebit=0;
		
		for(Supplier supplier : suppliers) {
			System.out.println(supplier.getSupplierName());
			sumDebit += supplier.getTotalDebit();
			count++;		
		}
	
		return "Bulunan Toplam Satıcı Sayısı : "+count+" Toplam Borç : "+sumDebit;
	}
	
	
	
	
	
	
}
