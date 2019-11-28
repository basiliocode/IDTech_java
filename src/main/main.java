package main;

import Enums.DEVICE_TYPE;
import Estruturas.IDTMSRData;
import com.sun.jna.ptr.IntByReference;
import interfaces.IMSR_callback;

import java.io.UnsupportedEncodingException;

public class main {

    public static void main(String[] args) throws InterruptedException {


        IDT_KioskIII.setAbsoluteLibraryPath("C:\\Users\\thiago.basilio\\IdeaProjects\\IDTech_java\\src\\libs");
        IDT_KioskIII.device_setConfigPath("C:\\Users\\thiago.basilio\\IdeaProjects\\kiok3\\IDTech_java\\libs");

        Test test = new Test();
        test.getSDK();

        test.init();

        test.device_isConnected();

        test.device_isAttached();

        test.config_getSerialNumber();

        test.device_getFirmwareVersion();

        test.icc_getICCReaderStatus();

        IDT_KioskIII.emv_allowFallback(true);

        test.ctls_startTransaction();

        Thread.sleep(5000);;

        test.ctls_cancelTransaction();

        System.out.println(
                "CardDataFlag: " + test.idtmsrData.cardDataFlag +
                "\ncardDataLen: " + test.idtmsrData.cardDataLen +
                "\nctlsApplication: " + test.idtmsrData.ctlsApplication +
                "\nisCtls: " + test.idtmsrData.isCTLS);

                String transaction = new String(test.idtmsrData.unencryptedTagArray[6].value);
                String cardNumber = new String(test.idtmsrData.unencryptedTagArray[11].value);
        System.out.println("unencryptedTagArray: ");
                    System.out.println("\nvalueLen: " + test.idtmsrData.unencryptedTagArray[6].valueLen +
                            "\nTRANSACTION: " + transaction.substring(40,54) + " - " + transaction.substring(68,75) +
                            "\nvalueLen: " + test.idtmsrData.unencryptedTagArray[11].valueLen +
                            "\nCARD NUMBER: " + cardNumber.substring(1,17));;

        System.out.println("unencryptedTagCount: " + test.idtmsrData.unencryptedTagCount);

        //System.out.println("\nfastEMV: " + new String(test.idtmsrData.fastEMV));

    }

}


