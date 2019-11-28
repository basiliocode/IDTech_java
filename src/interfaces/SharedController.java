package interfaces;

import Estruturas.IDTMSRData;
import com.sun.jna.Library;
import com.sun.jna.ptr.IntByReference;

public interface SharedController extends Library {

    void registerHotplugCallBk(IMessageHotplug iMessageHotplug);

    void emv_registerCallBk(IEMV_callback iEMVf);

    void msr_registerCallBkp(IMSR_callback iMSRf);

    void msr_registerCallBk(IMSR_callback iMSRf);

    //Retorna a versão do SDK
    String SDK_Version();

    //Definir o path para bibliotecas ID TECH
    void setAbsoluteLibraryPath(String absoluteLibraryPath);

    //iniciar o dispositivo pelo USB
    int device_init();

    //fechar o dispositivo
    void device_close();

    //Retona a mensagem de erro do codigo de erro
    String device_getResponseCodeString(int returnCode, byte[] despcrition);

    //Retona a mensagem de erro do codigo de erro
    String device_getIDGStatusCodeString(int returnCode, byte[] despcrition);

    //verifica se o dispositivo esta conectado
    boolean device_isConnected();

    //Retorna a versão do Firmware
    int device_getFirmwareVersion(byte[] firmwareVersion);

    //Não utilizado até o momemto
    int device_getCurrentDeviceType();

    //Envia um comando para o dispositivo
    int device_SendDataCommand(byte[] cmd, int cmdLen, byte[] data, int dataLen, //Entradas
                               byte[] response, IntByReference respLen);         //Saídas

    //Definir o path de onde se encontra o arquivo NEO2_Devices.xml
    void device_setConfigPath(String path);

    //incluir o conteúdo do aquivo NEO2_devices.xml
    int device_setNEO2DevicesConfigs(String configs, int len);

    //iniciar o dispositivo pelo RS232: deviceType 12 = kioskIII/IV, brate(taxa de bits)
    int rs232_device_init(int deviceType, int port_number, int brate);

    //Definir o dispositivo: Enum DEVICE_TYPE
    int device_setCurrentDevice(int deviceType);

    //retorna o serial number do dispositivo
    int config_getSerialNumber(byte[] sNumber);

    //verifica se o dispositivo esta conectado na porta inserida
    boolean device_isAttached(int deviceType);

    //Status do dispositivo
    int icc_getICCReaderStatus(byte[] status);

    //Habilitar FallBack
    void emv_allowFallback( boolean allow);

    //iniciar requisição de transação
    int emv_startTransaction(double amount, double amtOther, int exponent, int type, int timeout,
                                byte[] tags, int tagsLen, boolean forceOnline);


    int ctls_startTransaction(double amount, double amtOther, int type, int timeout,
                              byte[] tags, int tagsLen);

    int ctls_activateTransaction(int timeout, byte[] tags, int tagsLen);

    int ctls_cancelTransaction();

    int emv_authenticateTransaction(byte[] updatedTLV, int updatedTLVLen);

    int msr_startMSRSwipe(int _timeout);

    int msr_getMSRData(byte[] reData, IntByReference reLen);

}
