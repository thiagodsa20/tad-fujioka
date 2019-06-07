package com.iau.vrau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFilme extends JpaRepository<Filme, Long>{

}
