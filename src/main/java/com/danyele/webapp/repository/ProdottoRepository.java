package com.danyele.webapp.repository;

import com.danyele.webapp.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {


}
