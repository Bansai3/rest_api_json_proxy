package com.vfedotov.dao_layer.dao;

import com.vfedotov.dao_layer.entity.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long> {
}
