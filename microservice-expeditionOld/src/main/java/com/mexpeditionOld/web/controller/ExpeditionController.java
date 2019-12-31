package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.model.Expedition;
import com.mexpedition.web.exceptions.ExpeditionNotFoundException;
import com.mexpedition.web.exceptions.ImpossibleAjouterExpeditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping (value = "/Expedition")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition Expedition){

        Expedition nouvelleExpedition = expeditionDao.save(Expedition);

        if(nouvelleExpedition == null) throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter cette Expedition");

        return new ResponseEntity<Expedition>(Expedition, HttpStatus.CREATED);
    }

    @GetMapping(value = "/Expedition/{id}")
    public Optional<Expedition> recupererUneExpedition(@PathVariable int id){

        Optional<Expedition> Expedition = expeditionDao.findById(id);

        if(!Expedition.isPresent()) throw new ExpeditionNotFoundException("Cette Expedition n'existe pas");

        return Expedition;
    }

    /*
    * Permet de mettre à jour une Expedition existante.
    * save() mettra à jours uniquement les champs renseignés dans l'objet Expedition reçu.
    **/
    @PutMapping(value = "/Expedition")
    public void updateExpedition(@RequestBody Expedition Expedition) {

        expeditionDao.save(Expedition);
    }
}
