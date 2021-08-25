package org.perscholas.projectjournal.dao;

import org.perscholas.projectjournal.models.Updates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpdatesRepository extends JpaRepository<Updates, Integer> {

    Optional<Updates> findByUpdateId(Integer id);

    List<Updates> findAllByProjectId(Integer id);
}
