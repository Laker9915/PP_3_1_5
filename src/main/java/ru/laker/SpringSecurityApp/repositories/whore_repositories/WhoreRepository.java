package ru.laker.SpringSecurityApp.repositories.whore_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.laker.SpringSecurityApp.models.whore_models.Whore;

@Repository
public interface WhoreRepository extends JpaRepository<Whore, Integer> {
}
