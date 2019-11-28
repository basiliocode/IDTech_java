package main;

import Enums.DEVICE_TYPE;
import Enums.MSR_callback_type;
import Estruturas.IDTMSRData;
import interfaces.IMSR_callback;
import interfaces.IMessageHotplug;

public class Test implements IMSR_callback, IMessageHotplug {

    private MSR_callback_type type;
    IDTMSRData idtmsrData;
    private int returnCode;
    private byte[] description;
    private byte[] sNumber;
    private byte[] firmwareVersion;
    private byte[] status;
    public Test(){ }

    public void getSDK(){
        System.out.println("Conectado?: " + IDT_KioskIII.device_isConnected());
        System.out.println("Versão do SDK: " + IDT_KioskIII.SDK_Version());
    }

    public void init(){
        description = new byte[130];
        returnCode = IDT_KioskIII.device_init();
        System.out.println("Device init: " + IDT_KioskIII.device_getErrorString(returnCode,description));
    }

    public void device_isConnected(){
        System.out.println("Conectado?: " + IDT_KioskIII.device_isConnected());
    }

    public void device_isAttached(){
        System.out.println("Device KIOSK III?: " + IDT_KioskIII.device_isAttached(DEVICE_TYPE.IDT_DEVICE_KIOSK_III));

    }

    public void config_getSerialNumber(){
        description = new byte[130];
        sNumber = new byte[10];
        returnCode = IDT_KioskIII.config_getSerialNumber(sNumber);
        System.out.println("getSerialNumber " + IDT_KioskIII.device_getErrorString(returnCode,description));
        System.out.println("SN: " + new String(sNumber));
    }

    public void device_getFirmwareVersion(){
        firmwareVersion = new byte[10];
        description = new byte[130];
        returnCode = IDT_KioskIII.device_getFirmwareVersion(firmwareVersion);
        System.out.println("getFirmwareVersion: " + IDT_KioskIII.device_getErrorString(returnCode,description));
        System.out.println("FirmwareVersion: " + new String(firmwareVersion));
    }

    public void icc_getICCReaderStatus(){
        description = new byte[130];
        status = new byte[20];
        System.out.println("getICCReaderStatus: " + IDT_KioskIII.device_getErrorString(IDT_KioskIII.icc_getICCReaderStatus(status),description));
        System.out.println("Estado do leitor: " + new String(status));
    }

    public void ctls_startTransaction(){
        IDT_KioskIII.msr_registerCallBkp((this::applyIMSR));
        int result = IDT_KioskIII.ctls_startTransaction(1.0D,0.0D,0,30, null,0);
        description = new byte[130];
        System.out.println("transação: " + IDT_KioskIII.device_getIDGStatusCodeString(result,description));
    }

    public void ctls_cancelTransaction(){
        returnCode = IDT_KioskIII.ctls_cancelTransaction();
        description = new byte[130];
        System.out.println("canceltransaction: " + IDT_KioskIII.device_getIDGStatusCodeString(returnCode,description));
    }


    @Override
    public void applyIMSR(int type, IDTMSRData idtmsrData) {
        this.idtmsrData = idtmsrData;
        this.type = MSR_callback_type.valueOf(type);
        switch (this.type){
            case ERR:
                System.out.println(("Callback MSR cancelled\n"));
                break;
            case RETURN_CODE:
                System.out.println("Callback MSR data received\n");
                break;
            case TIMEOUT:
                System.out.println(("MSR Callback Timeout\n"));
                break;
            default:
                break;
        }
    }

    @Override
    public void applyHotPlug(int device, int status) {
        if (status == 0)
            System.out.println("Device: " + device + "\nStatus: " + status);
        else
            System.out.println("Não conectado");
    }
}
