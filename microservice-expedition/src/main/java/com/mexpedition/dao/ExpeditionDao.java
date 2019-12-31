package com.mexpedition.dao;

import com.mexpedition.model.Expedition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionDao extends CrudRepository<Expedition, Integer> {
}
