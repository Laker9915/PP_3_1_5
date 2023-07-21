package ru.laker.SpringSecurityApp.services.whore_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.laker.SpringSecurityApp.models.whore_models.Salon;
import ru.laker.SpringSecurityApp.repositories.whore_repositories.SalonRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Autowired
    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public List<Salon> findAll() {
        return salonRepository.findAll();
    }
}
