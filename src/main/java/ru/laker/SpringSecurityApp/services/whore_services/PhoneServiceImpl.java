package ru.laker.SpringSecurityApp.services.whore_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.laker.SpringSecurityApp.models.whore_models.Phone;
import ru.laker.SpringSecurityApp.repositories.whore_repositories.PhoneRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
