package main;

import Enums.DEVICE_TYPE;
import Estruturas.IDTMSRData;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import interfaces.IEMV_callback;
import interfaces.IMSR_callback;
import interfaces.IMessageHotplug;
import interfaces.SharedController;

public class IDT_KioskIII {

    private static SharedController sharedController = Native.loadLibrary(
            "C:\\Users\\thiago.basilio\\IdeaProjects\\kiosk3\\src\\libs\\libIDTechSDK.dll.1.0.22",SharedController.class);

    static void registerHotplugCallBk(IMessageHotplug iMessageHotplug){
        sharedController.registerHotplugCallBk(iMessageHotplug);
    }

    static void emv_registerCallBk(IEMV_callback iEMV_callback){
        sharedController.emv_registerCallBk(iEMV_callback);
    }

    static void msr_registerCallBkp(IMSR_callback iMSR_callback ){
        sharedController.msr_registerCallBkp(iMSR_callback);
     }

    static void msr_registerCallBk(IMSR_callback iMSR_callback ){
        sharedController.msr_registerCallBk(iMSR_callback);
    }

    static void setAbsoluteLibraryPath(String path){ sharedController.setAbsoluteLibraryPath(path); }

    static void device_setConfigPath(String NEO2_Devices){ sharedController.device_setConfigPath(NEO2_Devices);}

    static int device_init(){ return sharedController.device_init(); }

    static int device_setCurrentDevice(DEVICE_TYPE device_type){
        return sharedController.device_setCurrentDevice(device_type.getDeviceType());
    }

    static void device_close(){ sharedController.device_close(); }

    static int config_getSerialNumber(byte[] sNumber){ return sharedController.config_getSerialNumber(sNumber); }

    static boolean device_isConnected(){ return sharedController.device_isConnected(); }

    static int device_getFirmwareVersion(byte[] firmwareVersion){
        return sharedController.device_getFirmwareVersion(firmwareVersion);
    }

    static int device_getCurrentDeviceType(){ return sharedController.device_getCurrentDeviceType(); }

    static int device_SendDataCommand(byte[] cmd, int cmdLen, byte[] data, int dataLen, //Entradas
                               byte[] response, IntByReference respLen){
        return sharedController.device_SendDataCommand(cmd, cmdLen, data, dataLen, response, respLen);
    }

    static boolean device_isAttached(DEVICE_TYPE devicetype){
        return sharedController.device_isAttached(devicetype.getDeviceType()); }

    static String SDK_Version(){ return sharedController.SDK_Version(); }

    static String device_getErrorString(int returnCode, byte[] despcrition){
        return sharedController.device_getResponseCodeString(returnCode, despcrition);
    }
    static String device_getIDGStatusCodeString(int returnCode, byte[] despcrition){
        return sharedController.device_getResponseCodeString(returnCode, despcrition);
    }

    static int icc_getICCReaderStatus(byte[] status){
        return sharedController.icc_getICCReaderStatus(status);
    }

    static void emv_allowFallback(boolean allow){
        sharedController.emv_allowFallback(allow);
    }

    static int emv_startTransaction(double amount, double amtOther, int exponent, int type, int timeout, byte[] tags,
                                       int tagsLen, boolean forceOnline){
        return sharedController.emv_startTransaction(amount, amtOther, exponent,type, timeout, tags, tagsLen, forceOnline);
    }


    static int ctls_startTransaction(double amount, double amtOther, int type, int timeout, byte[] tags,
                                    int tagsLen){
        return sharedController.ctls_startTransaction(amount, amtOther,type, timeout, tags, tagsLen);
    }

    static int ctls_activateTransaction(int timeout, byte[] tags, int tagsLen){
        return sharedController.ctls_activateTransaction(timeout, tags, tagsLen);
    }

    static int ctls_cancelTransaction(){
        return sharedController.ctls_cancelTransaction();
    }

    static int emv_authenticateTransaction(byte[] updatedTLV, int updatedTLVLen) {
        return sharedController.emv_authenticateTransaction(updatedTLV, updatedTLVLen);
    }

    static int msr_startMSRSwipe(int timeout) {
        return sharedController.msr_startMSRSwipe(timeout);
    }

    static int msr_getMSRData(byte[] reData, IntByReference reLen) {
        return sharedController.msr_getMSRData(reData, reLen);
    }

}
