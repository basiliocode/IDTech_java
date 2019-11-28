package interfaces;

import Estruturas.EMV_callback;
import Estruturas.IDTTransactionData;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface IEMV_callback extends Callback {
    void apply(int int1, int int2, Pointer charPtr1, int int3, IDTTransactionData IDTTransactionDataPtr1, EMV_callback EMV_CallbackPtr1, int int4);
};