package com.study.project.springstudy2.repository;

import com.study.project.springstudy2.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
