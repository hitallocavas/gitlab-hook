package br.ufpe.cin.hcs3.opencartapi.v1.domain.repository;

import br.ufpe.cin.hcs3.opencartapi.v1.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
