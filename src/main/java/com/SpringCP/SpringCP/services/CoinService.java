package com.SpringCP.SpringCP.services;

import com.SpringCP.SpringCP.model.PrivateKeyCoin;
import com.SpringCP.SpringCP.model.PrivateKeyCoinDTO;
import com.SpringCP.SpringCP.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class CoinService {
    @Autowired
    CoinRepository coinRepository;



    public PrivateKeyCoin create(PrivateKeyCoin pkc){
        return coinRepository.save(pkc);
    }
    public PrivateKeyCoinDTO generateDTOfromPrivateKey(String privateKey) throws NoSuchAlgorithmException {
        PrivateKeyCoinDTO pkcDTO = new PrivateKeyCoinDTO(privateKey);
        return pkcDTO;
    }
    public PrivateKeyCoin mapper(PrivateKeyCoinDTO dto){
        PrivateKeyCoin pkc= new PrivateKeyCoin();
        pkc.setHashTableId(dto.getHashTableId());
        pkc.setPrivateKey(dto.getPrivateKey());
        pkc.setPrivateInverseKey(dto.getPrivateInverseKey());
        pkc.setHexPrivateKey(dto.getHexPrivateKey());
        pkc.setHexInversePrivateKey(dto.getHexInversePrivateKey());
        pkc.setBinaryPrivateKey(dto.getBinaryPrivateKey());
        pkc.setBinaryInversePrivateKey(dto.getBinaryInversePrivateKey());
        pkc.setPublicKeyX(dto.getPublicKeyX());
        pkc.setPublicKeyY(dto.getPublicKeyY());
        pkc.setPublicKeyInverseY(dto.getPublicKeyInverseY());
        pkc.setHashedAddressCompressed(dto.getHashedAddressCompressed());
        pkc.setHashedAddressUncompressed(dto.getHashedAddressUncompressed());
        pkc.setHashedInverseAddressCompressed(dto.getHashedInverseAddressCompressed());
        pkc.setHashedInverseAddressUncompressed(dto.getHashedInverseAddressUncompressed());
        pkc.setUncompressedHexPublicKey(dto.getUncompressedHexPublicKey());
        pkc.setCompressedHexPublicKey(dto.getCompressedHexPublicKey());
        pkc.setUncompressedInverseHexPublicKey(dto.getUncompressedInverseHexPublicKey());
        pkc.setUncompressedInverseHexPublicKey(dto.getUncompressedInverseHexPublicKey());
        return pkc;
    }

}
