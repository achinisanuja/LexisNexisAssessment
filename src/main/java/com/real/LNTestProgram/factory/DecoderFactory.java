package com.real.LNTestProgram.factory;

import org.springframework.stereotype.Component;

@Component
public class DecoderFactory {

    public Decoder getDecoder(int decodeType){

        switch(decodeType){
            case 8:
                return new OctalToDecimalDecoder();
            default:return null;
        }
    }
}
