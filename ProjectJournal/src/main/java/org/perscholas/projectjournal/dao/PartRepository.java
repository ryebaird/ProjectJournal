package org.perscholas.projectjournal.dao;

import org.perscholas.projectjournal.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

    Optional<Part> findByPartId(Integer id);
}
