package com.SpringCP.SpringCP.controller;

import com.SpringCP.SpringCP.model.PrivateKeyCoin;
import com.SpringCP.SpringCP.model.PrivateKeyCoinDTO;
import com.SpringCP.SpringCP.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class CoinController {
    @Autowired
    CoinService coinService;

    @RequestMapping(method= RequestMethod.GET, value="/generate/{privateKey}")
        public PrivateKeyCoin PrivateKeyCoin(@PathVariable String privateKey) throws NoSuchAlgorithmException {
        PrivateKeyCoinDTO dto = coinService.generateDTOfromPrivateKey(privateKey);
        PrivateKeyCoin pkc= coinService.mapper(dto);
        PrivateKeyCoin privateKeyCoin = coinService.create(pkc);
        return privateKeyCoin;
    }


}
