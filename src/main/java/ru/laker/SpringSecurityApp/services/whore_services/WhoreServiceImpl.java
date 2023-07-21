package ru.laker.SpringSecurityApp.services.whore_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.laker.SpringSecurityApp.models.whore_models.Whore;
import ru.laker.SpringSecurityApp.repositories.whore_repositories.WhoreRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WhoreServiceImpl implements WhoreService {

    private final WhoreRepository whoreRepository;

    @Autowired
    public WhoreServiceImpl(WhoreRepository whoreRepository) {
        this.whoreRepository = whoreRepository;
    }

    @Override
    public List<Whore> findAll() {
        return whoreRepository.findAll();
    }
}
