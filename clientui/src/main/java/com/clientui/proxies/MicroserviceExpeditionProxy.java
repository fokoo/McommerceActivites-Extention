package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expedition")
public interface MicroserviceExpeditionProxy {

    @GetMapping(value = "/microservice-expedition/Expeditions")
    public List<ExpeditionBean> listeDesExpeditions();

    @PostMapping(value = "/microservice-expedition/Expedition")
    public ResponseEntity<ExpeditionBean> ajouterExpedition(@RequestBody ExpeditionBean expeditionBean);

    @GetMapping( value = "/microservice-expedition/Expedition/{id}")
    public Optional<ExpeditionBean> etatExpedition(@PathVariable Integer id);

    @PutMapping(value = "/microservice-expedition/Expedition")
    public void updateExpedition(@RequestBody ExpeditionBean expeditionBean);
}
