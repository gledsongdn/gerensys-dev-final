package com.gerensys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gerensys.model.Pedido;

@Repository
@Transactional
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
