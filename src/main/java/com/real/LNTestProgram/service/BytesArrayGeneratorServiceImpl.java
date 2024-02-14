package com.real.LNTestProgram.service;

import com.real.LNTestProgram.factory.Decoder;
import com.real.LNTestProgram.factory.DecoderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Service
public class BytesArrayGeneratorServiceImpl implements BytesArrayGeneratorService {

    Logger logger = LoggerFactory.getLogger(BytesArrayGeneratorServiceImpl.class);

    @Value("#{'${supported.encoded.types}'.split(',')}")
    private List<Integer> supportedEncodedTypes;

    @Autowired
    DecoderFactory decoderFactory;

    public byte[] generateBytesArray(String encodedNumber, int encodedType) throws Exception {

        logger.info("Starting BytesArrayGeneratorServiceImpl[generateBytesArray]");
        try {
            Decoder decoder = decoderFactory.getDecoder(encodedType);
            BigInteger decimalNumber = decoder.decodeString(encodedNumber, encodedType);
            logger.info("Decimal Number: " + decimalNumber);
            byte[] byteArr = decimalNumber.toByteArray();
            logger.info("Final Byte Array: " + Arrays.toString(byteArr));
            return byteArr;
        } catch (Exception ex) {
            logger.error("Encoded type not supported : " + encodedType);
            throw new Exception("Validation Error. Encoded type not supported");
        }
    }
}
