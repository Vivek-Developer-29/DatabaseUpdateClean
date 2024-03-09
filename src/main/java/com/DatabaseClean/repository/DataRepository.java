package com.DatabaseClean.repository;

import com.DatabaseClean.entity.DataTable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DataRepository extends JpaRepository<DataTable, Long> {

    @Transactional
    void deleteByCreatedAtBefore(Date cutoffDate);
}
