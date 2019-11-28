package interfaces;
import Estruturas.IDTMSRData;
import com.sun.jna.Callback;

public interface IMSR_callback extends Callback {
    public void applyIMSR(int type, IDTMSRData idtmsrData);
}
