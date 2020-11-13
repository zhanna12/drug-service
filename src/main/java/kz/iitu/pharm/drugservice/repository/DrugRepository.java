package kz.iitu.pharm.drugservice.repository;
import kz.iitu.pharm.drugservice.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {
    Drug findByName(String name);
    Drug getDrugById(Long drugId);

    @Override
    List<Drug> findAll();

    @Override
    Optional<Drug> findById(Long drugId);
}
