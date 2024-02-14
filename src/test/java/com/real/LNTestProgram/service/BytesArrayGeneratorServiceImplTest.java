package com.real.LNTestProgram.service;

import com.real.LNTestProgram.factory.Decoder;
import com.real.LNTestProgram.factory.DecoderFactory;
import com.real.LNTestProgram.factory.OctalToDecimalDecoder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
//@TestPropertySource(properties = {"supported.encoded.types=8,16,32",})
public class BytesArrayGeneratorServiceImplTest {

    @InjectMocks
    BytesArrayGeneratorServiceImpl bytesArrayGeneratorService;

    @Mock
    DecoderFactory decoderFactory;

    @Test
    public void testGenerateBytesArrayForSampleInput1() throws Exception {
        String testEncodedNumber = "31646541";
        int testEncodedType = 8;
        byte[] expectedResult = {103, 77, 97};
        Decoder testDecoder = new OctalToDecimalDecoder();
        Mockito.when(decoderFactory.getDecoder(testEncodedType)).thenReturn(testDecoder);
        byte[] resultByteArr = bytesArrayGeneratorService.generateBytesArray(testEncodedNumber,testEncodedType);
        Assert.assertArrayEquals(expectedResult,resultByteArr);
    }

    @Test
    public void testGenerateBytesArrayForSampleInput2() throws Exception {
        String testEncodedNumber = "2277114742311135167021343424004141432061264036716605455350700124251451433665154627042711115720106717127670062717046577704333460730170473602176263254671507630065771335415265546676604140271654231111113150576147605265000452421616177052165224543311475436547416173670422136456436313334657533062163564254163664432653550166600433332675642447003252221104064117622317044717471111";
        int testEncodedType = 8;
        byte[] expectedResult = {18, -4, -103, -30, 100, -105, 78, -31, 23, 28, 80, 8, 97, -115, 12, 86, -127, -18, 118, 22, 90, -24, -32, 21, 21, 50, -104, -34, -44, -39, -105, 17, 114, 73, -67, 2, 55, 60, -81, -72, 25, 115, -60, -41, -2, 35, 110, 97, -40, 60, 78, -16, 71, -27, -102, -77, 115, 71, -52, 13, 127, 45, -40, 106, -42, -51, -66, -62, 24, 23, 58, -60, -55, 36, -106, 104, -65, 25, -16, -85, 80, 4, -86, 35, -114, 63, -118, -114, -87, 75, 27, 38, 123, 30, -77, -61, -113, 123, -120, -111, 122, 93, 30, 101, -73, 53, -11, -79, -111, -50, -24, -84, 57, -19, 35, 90, -69, 65, -37, 1, 27, 109, 111, 116, 82, 112, 26, -87, 34, 68, 26, 19, -14, 76, -15, 39, 62, 114, 73};
        Decoder testDecoder = new OctalToDecimalDecoder();
        Mockito.when(decoderFactory.getDecoder(testEncodedType)).thenReturn(testDecoder);
        byte[] resultByteArr = bytesArrayGeneratorService.generateBytesArray(testEncodedNumber,testEncodedType);
        Assert.assertArrayEquals(expectedResult,resultByteArr);
    }
}
