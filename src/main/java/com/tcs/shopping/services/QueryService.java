package com.tcs.shopping.services;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.shopping.dtos.OrderDetails;

@Service
public class QueryService implements IQueryService {

    //@Autowired
   // StudentRepository studentrepository;

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<OrderDetails> JPQLQuery()
    {
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin( );

        Query query = em.createQuery("");
        @SuppressWarnings("unchecked")
        List<OrderDetails> list =(List<OrderDetails>)query.getResultList();
        System.out.println("Student Name :");
        em.close();

        return list;

    }

	/*
	 * public List<StudentEntity> studentAllData() { return
	 * studentrepository.findAll(); }
	 */

}