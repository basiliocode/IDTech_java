package Enums;

public enum EVENT_MSR_Types {

    EVENT_MSR_UNKNOWN(0),
    EVENT_MSR_CARD_DATA(1),
    EVENT_MSR_CANCEL_KEY(3),
    EVENT_MSR_BACKSPACE_KEY(4),
    EVENT_MSR_ENTER_KEY(5),
    EVENT_MSR_DATA_ERROR(6);

    private int value;
    private EVENT_MSR_Types(int value) {
        this.value = value;
    }
}
