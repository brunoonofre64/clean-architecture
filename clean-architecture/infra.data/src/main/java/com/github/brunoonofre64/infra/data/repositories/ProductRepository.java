package com.github.brunoonofre64.infra.data.repositories;

import com.github.brunoonofre64.infra.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<ProductEntity> findByUuid(String uuid);
    void deleteByUuid(String uuid);
    @Query("SELECT p FROM ProductEntity p JOIN p.category c WHERE c.uuid = :uuid")
    List<ProductEntity> findProductsByCategoryUuid(@Param("uuid") String uuid);
}
