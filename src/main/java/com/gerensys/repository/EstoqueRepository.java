package com.gerensys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gerensys.model.Estoque;

@Repository
@Transactional
public interface EstoqueRepository extends CrudRepository<Estoque, Long>{

}
