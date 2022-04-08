package br.com.meli.qatestingproject.repository;

import br.com.meli.qatestingproject.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
