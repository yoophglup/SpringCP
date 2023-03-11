package com.SpringCP.SpringCP.services;

import com.SpringCP.SpringCP.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {
    @Autowired
    CoinRepository coinRepository;


}
