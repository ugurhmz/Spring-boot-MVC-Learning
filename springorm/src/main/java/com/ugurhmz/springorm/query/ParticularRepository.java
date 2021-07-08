package com.ugurhmz.springorm.query;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;




public interface ParticularRepository extends PagingAndSortingRepository<Supplier, Long> {

	@Query("select s from Supplier s where s.totalDebit >= :totalDebitMin")
	public Page<Supplier> findSupplierTotalDebitMin(
			@Param("totalDebitMin") double totalDebitMin, Pageable pageable);
	
}
