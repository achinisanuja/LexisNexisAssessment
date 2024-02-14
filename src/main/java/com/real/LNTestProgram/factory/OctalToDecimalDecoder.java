package com.real.LNTestProgram.factory;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class OctalToDecimalDecoder implements Decoder {

    @Override
    public BigInteger decodeString(String encodedNumber, Integer encodedType) {
        //BigInteger decimalNumber = new BigInteger(encodedNumber,encodedType);
        int i = 0;
        BigInteger decimalNumber = BigInteger.ZERO;
        BigInteger octalNumber = new BigInteger(encodedNumber);
        while (!octalNumber.equals(BigInteger.ZERO)){
            decimalNumber = decimalNumber.add(octalNumber.remainder(BigInteger.TEN).multiply(BigInteger.valueOf(encodedType.intValue()).pow(i)));
            i++;
            octalNumber = octalNumber.divide(BigInteger.TEN);
        }
        return decimalNumber;
    }
}
