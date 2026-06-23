package fr.eni.ludotheque.bll.impl;
import fr.eni.ludotheque.bll.LocationService;
import fr.eni.ludotheque.bo.Facture;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.dal.LocationRepository;
import fr.eni.ludotheque.dto.LocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository ;

    public LocationServiceImpl(LocationRepository locationRepository) {
            this.locationRepository = locationRepository;
    }
    @Override
    public Location exemplaireLoue(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location ajouterLocation(LocationDTO locationDto) {
        return null;
    }

    @Override
    public Facture retourExemplaires(List<String> codebarres) {
        return null;
    }

    @Override
    public Facture payerFacture(Integer noFacture) {
        return null;
    }

    @Override
    public void trouverLocationParExemplaireCodebarre(String codebarre) {

    }
}

