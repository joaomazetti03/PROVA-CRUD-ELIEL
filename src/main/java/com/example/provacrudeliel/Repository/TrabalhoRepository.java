package com.example.provacrudeliel.Repository;

import com.example.provacrudeliel.Model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}
