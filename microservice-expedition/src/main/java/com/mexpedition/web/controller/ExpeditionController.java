package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.model.Expedition;
import com.mexpedition.web.exceptions.ExpeditionNotFoundException;
import com.mexpedition.web.exceptions.ImpossibleAjouterExpeditionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    Logger log = LoggerFactory.getLogger(this.getClass());
  

    // Affiche la liste de tous les Expeditions
    @GetMapping(value = "/Expeditions")
    public List<Expedition> listeDesExpeditions(){

        List<Expedition> expeditions = (List<Expedition>) expeditionDao.findAll();

        if(expeditions.isEmpty()) throw new ExpeditionNotFoundException("Aucunes Expedition en cours actuelement");
        
        log.info("Récupération de la liste des expeditions");

        return expeditions;
    }

    @PostMapping (value = "/Expedition")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition) throws ImpossibleAjouterExpeditionException {

        if(expedition.getId() instanceof Integer && expeditionDao.existsById(expedition.getId())) {
            throw new ImpossibleAjouterExpeditionException("Expedition deja existante, vous pouvez actualisez (avec PUT)");
        }else {
            Expedition nouvelleExpedition = expeditionDao.save(expedition);
            if (nouvelleExpedition == null)
                throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter cette Expedition");
            return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
        }
    }

    //Récuperer un Expedition par son id
    @GetMapping( value = "/Expedition/{id}")
    public Optional<Expedition> etatExpedition(@PathVariable Integer id) {

        Optional<Expedition> expedition = expeditionDao.findById(id);

        if(! expedition.isPresent()) throw new ExpeditionNotFoundException("Le Expedition correspondant à l'id " + id + " existe pas");

        return expedition;
    }

    /*
     * Permet de mettre à jour une Expedition existante.
     * save() mettra à jours uniquement les champs renseignés dans l'objet Expedition reçu. 
     **/
    @PutMapping(value = "/Expedition")
    public void updateExpedition(@RequestBody Expedition expedition) {

        expeditionDao.save(expedition);
    }
}
