package Enums;

public enum CTLS_APPLICATION {
    CTLS_APPLICATION_NONE(0),
    CTLS_APPLICATION_MASTERCARD(1),
    CTLS_APPLICATION_VISA(2),
    CTLS_APPLICATION_AMEX(3),
    CTLS_APPLICATION_DISCOVER(4),
    CTLS_APPLICATION_SPEEDPASS(5),
    CTLS_APPLICATION_GIFT_CARD(6),
    CTLS_APPLICATION_DINERS_CLUB(7),
    CTLS_APPLICATION_EN_ROUTE(8),
    CTLS_APPLICATION_JCB(9),
    CTLS_APPLICATION_VIVO_DIAGNOSTIC(10),
    CTLS_APPLICATION_HID(11),
    CTLS_APPLICATION_MSR_SWIPE(12),
    CTLS_APPLICATION_RESERVED(13),
    CTLS_APPLICATION_DES_FIRE_TRACK_DATA(14),
    CTLS_APPLICATION_DES_FIRE_RAW_DATA(15),
    CTLS_APPLICATION_RBS(17),
    CTLS_APPLICATION_VIVO_COMM(20);

    private int numVal;

    private CTLS_APPLICATION(int var3) {
        this.numVal = var3;
    }

    public int getNumVal() {
        return this.numVal;
    }
}
