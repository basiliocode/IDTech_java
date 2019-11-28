package interfaces;

import com.sun.jna.Callback;

public interface IMessageHotplug extends Callback {
    void applyHotPlug(int device, int status);
}
