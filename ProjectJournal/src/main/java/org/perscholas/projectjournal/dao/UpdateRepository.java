package org.perscholas.projectjournal.dao;

import org.perscholas.projectjournal.models.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Integer> {

    Optional<Update> findByUpdateId(Integer id);

    List<Update> findAllByProjectId(Integer id);
}
