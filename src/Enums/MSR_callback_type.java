package Enums;

import java.util.Arrays;
import java.util.Optional;

public enum MSR_callback_type {
    ERR(1),
    RETURN_CODE(2),
    TIMEOUT(3),
    UNKNOWN(-1);
    private int type;

    MSR_callback_type(int type){ this.type = type; }

    private void setType(int type) {
        this.type = type;
    }

    public static MSR_callback_type valueOf(int type) {
        Optional<MSR_callback_type> ret = Arrays.stream(values()).filter(msr_callback_type -> msr_callback_type.type == type).findAny();

        if (ret.isPresent()) {
            return ret.get();
        } else {
            UNKNOWN.setType(type);
            return UNKNOWN;
        }
    }
}
