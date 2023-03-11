package com.SpringCP.SpringCP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.modecp.CoinUtils;
import org.modecp.ECC;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

@Getter
@Entity
public class PrivateKeyCoin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String hashTableId;
    private String privateKey;
    private String hexPrivateKey;
    private String binaryPrivateKey;
    private String publicKeyX;
    private String publicKeyY;
    private String publicKeyInverseY;
    private String hashedAddressCompressed;
    private String hashedAddressUncompressed;
    private String hashedInverseAddressCompressed;
    private String hashedInverseAddressUncompressed;
    private String uncompressedHexPublicKey;
    private String compressedHexPublicKey;
    private String uncompressedInverseHexPublicKey;
    private String getUncompressedInverseHexPublicKey;

    public void PrivateKeyCoin(String privateKeyAsString) throws NoSuchAlgorithmException {
        BigInteger[] point=ECC.G(privateKeyAsString);
        BigInteger[] inversePoint=new BigInteger[]{point[0],ECC.N.subtract(point[1]).mod(ECC.N)};
        BigInteger bigIntegerPrivateKey=new BigInteger(privateKeyAsString);
        this.privateKey=privateKeyAsString;
        this.hexPrivateKey="0x"+bigIntegerPrivateKey.toString(16);
        this.binaryPrivateKey="0b"+bigIntegerPrivateKey.toString(2);
        this.hashTableId=point[0].toString().substring(0,4);
        this.publicKeyX= point[0].toString();
        this.publicKeyY= point[1].toString();
        this.publicKeyInverseY=ECC.N.subtract(point[1]).mod(ECC.N).toString();
        this.hashedAddressCompressed= CoinUtils.MakeCoinfromPointCompressed(point);
        this.hashedAddressUncompressed= CoinUtils.MakeCoinfromPointUncompressed(point);
        this.hashedInverseAddressCompressed= CoinUtils.MakeCoinfromPointCompressed(inversePoint);
        this.hashedInverseAddressUncompressed= CoinUtils.MakeCoinfromPointUncompressed(inversePoint);
        this.compressedHexPublicKey=CoinUtils.PointtoCompressedPubkey(point);
        this.uncompressedHexPublicKey=CoinUtils.PointtoUncompressedPubkey(point);
        this.hashedInverseAddressCompressed=CoinUtils.PointtoCompressedPubkey(inversePoint);
        this.hashedInverseAddressUncompressed=CoinUtils.PointtoUncompressedPubkey(inversePoint);

    }
}
