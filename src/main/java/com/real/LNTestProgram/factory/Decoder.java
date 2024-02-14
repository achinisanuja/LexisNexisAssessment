package com.real.LNTestProgram.factory;

import java.math.BigInteger;

public interface Decoder {
    BigInteger decodeString(String encodedNumber, Integer encodedType);
}
