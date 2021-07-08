package com.ugurhmz.springorm.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;



@Repository
public class SpecialRepositoryImpl implements SpecialRepository  {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin) {
		String jpql = "select s from Supplier s where s.totalDebit >= : totalDebitMin";
		TypedQuery<Supplier> query = entityManager.createQuery(jpql, Supplier.class);
		query.setParameter("totalDebitMin", totalDebitMin);
		
		return query.getResultList();
	}

}
