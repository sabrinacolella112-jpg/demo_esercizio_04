package com.example.demo_esercizio_04;

import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findByModelName(String modelName);
    List<CarEntity> findByModelName(String modelName, Pageable pageable);

    @Query("select b from CarEntity b where b.type = ?1")
    List<CarEntity> findByType(CarType type);
}
