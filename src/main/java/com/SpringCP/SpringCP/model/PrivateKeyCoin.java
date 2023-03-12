package com.SpringCP.SpringCP.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PrivateKeyCoin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String hashTableId;
    private String privateKey;
    private String privateInverseKey;
    private String hexPrivateKey;
    private String hexInversePrivateKey;
    @Lob
    private String binaryPrivateKey;
    @Lob
    private String binaryInversePrivateKey;

    private String publicKeyX;
    private String publicKeyY;
    private String publicKeyInverseY;
    private String hashedAddressCompressed;
    private String hashedAddressUncompressed;
    private String hashedInverseAddressCompressed;
    private String hashedInverseAddressUncompressed;
    private String uncompressedHexPublicKey;
    private String compressedHexPublicKey;
    private String compressedInverseHexPublicKey;
    private String uncompressedInverseHexPublicKey;


}
