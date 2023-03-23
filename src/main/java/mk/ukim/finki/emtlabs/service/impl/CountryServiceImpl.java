package mk.ukim.finki.emtlabs.service.impl;

import mk.ukim.finki.emtlabs.model.Country;
import mk.ukim.finki.emtlabs.repository.CountryRepository;
import mk.ukim.finki.emtlabs.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    public List<Country> listAll()
    {
        return countryRepository.findAll();
    };
}
