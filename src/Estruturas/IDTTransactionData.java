package Estruturas;

import com.sun.jna.Structure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class IDTTransactionData extends Structure {
    /**
     * Transaction Data type,please see EVENT_TRANSACTION_DATA_Types
     * for more information.<br/>
     */
    public int event;

    /**
     * Event Notification type,please see EVENT_NOTIFICATION_Types
     * for more information.<br/>
     */
    public int Notification;

    /**
     * Get the card data raw data.<br/>
     * Containing complete unparsed transaction data as received from device.
     */
    public byte[] msr_rawData = new byte[1024*4];
    /**
     * Get the length of msr_rawData.
     */
    public int msr_rawDataLen;

    /**
     * Get the swiped card Track1 encrypted data.<br/>
     * A byte array containing Track1 encrypted data.
     */
    public byte[] msr_encTrack1 = new byte[1024*4];
    /**
     * Get the length of msr_encTrack1.
     */
    public int msr_encTrack1Len;

    /**
     * Get the swiped card Track2 encrypted data.<br/>
     * A byte array containing Track2 encrypted data.
     */
    public byte[] msr_encTrack2 = new byte[1024*4];
    /**
     * Get the length of msr_encTrack2.
     */
    public int msr_encTrack2Len;

    /**
     * Get the swiped card Track3 encrypted data.<br/>
     * A byte array containing Track3 encrypted data.
     */
    public byte[] msr_encTrack3 = new byte[1024*4];
    /**
     * Get the length of msr_encTrack3Len.
     */
    public int msr_encTrack3Len;

    /**
     * Get the swiped card Track1 data.<br/>
     * A string containing Track1 masked data expressed as hex characters.
     */
    public byte[] msr_track1 = new byte[1024*4];

    /**
     * Get the swiped card Track2 data.<br/>
     * A string containing Track2 masked data expressed as hex characters.
     */
    public byte[] msr_track2 = new byte[1024*4];

    /**
     * Get the swiped card Track3 data.<br/>
     * A string containing Track3 masked data expressed as hex characters.
     */
    public byte[] msr_track3 = new byte[1024*4];

    /**
     * Get the Reader Serial Number.<br/>
     */
    public byte[] device_RSN = new byte[10];
    /**
     * Get the length of device_RSNLen.
     */
    public int device_RSNLen;
    /**
     * Get the swiped card KSN (Key Serial Number).<br/>
     * A byte array containing 10 bytes.
     */
    public byte[] msr_KSN = new byte[10];
    /**
     * Get the length of msr_KSN.
     */
    public int msr_KSNLen;

    /**
     * Get the swiped card length of Track1 data.
     */
    public int msr_track1Length;

    /**
     * Get the swiped card length of Track2 data.
     */
    public int msr_track2Length;

    /**
     * Get the swiped card length of Track3 data.
     */
    public int msr_track3Length;


    /**
     * Get the swiped card type,please see CAPTURE_ENCODE_TYPE for
     * more information.<br/>
     * MSR card type:<br/>
     *                   CAPTURE_ENCODE_TYPE_ISOABA:ISO/ABA format<br/>
     *                   CAPTURE_ENCODE_TYPE_AAMVA:AAMVA format<br/>
     *                   CAPTURE_ENCODE_TYPE_Other:Other<br/>
     *                   CAPTURE_ENCODE_TYPE_Raw:Raw; undecoded format<br/>
     *                   CAPTURE_ENCODE_TYPE_JisI_II:JIS I or JIS II
     *
     */
    public int msr_cardType;


    /**
     * Get the swiped card decoded status.<br/>
     *          0x00:decoded data success;<br/>
     *                    Bit0:1-track1 data error;<br/>
     *                    Bit1:1-track2 data error;<br/>
     *                    Bit2:1-track3 data error;<br/>
     *                    Bit3:1-track1 encrypted data error;<br/>
     *                    Bit4:1-track2 encrypted data error;<br/>
     *                    Bit5:1-track3 encrypted data error;<br/>
     *                    Bit6:1-KSN error;<br/>
     *
     */
    public byte msr_captureEncodeStatus;


    /**
     * Get the swiped card encrypted type,please see CAPTURE_ENCRYPT_TYPE
     * for more information.<br/>
     *          CAPTURE_ENCRYPT_TYPE_TDES:TDES;<br/>
     *                    CAPTURE_ENCRYPT_TYPE_AES:AES;
     *
     */
    public int msr_captureEncryptType;

    /**
     * Contains error code when data is not returned
     */
    public int msr_errorCode;
    /**
     * For some Error Codes, the RF State Code indicates the exact Reader-Card
     command that failed. This helps determine the exact place where
     the failure occurred.
     */
    public int emv_rfStateCode;
    /**
     * Get the swiped card ICC Status.<br/>
     * A flag to determine if ICC is present on card.
     */
    public int iccPresent;
    /**
     * Get the swiped card Session ID.<br/>
     * A byte array to get session ID, if exists.
     */
    public byte[] msr_sessionID = new byte[1024];
    /**
     * Get the length of msr_sessionID.
     */
    public int msr_sessionIDLen;
    /**
     * TRUE = Data Variant key used<br/>
     * FALSE = PIN Variant key used
     */
    public int msr_isDataVariant;
    /**
     * Get the swiped card Track1 hash data.<br/>
     * A byte array containing Track1 hash data.
     */
    public byte[] msr_hashTrack1 = new byte[1024*4];
    /**
     * Get the length of msr_hashTrack1.
     */
    public int msr_hashTrack1Len;
    /**
     * Get the swiped card Track2 hash data.<br/>
     * A byte array containing Track2 hash data.
     */
    public byte[] msr_hashTrack2 = new byte[1024*4];
    /**
     * Get the length of msr_hashTrack2Len.
     */
    public int msr_hashTrack2Len;
    /**
     * Get the swiped card Track3 hash data.<br/>
     * A byte array containing Track3 hash data.
     */
    public byte[] msr_hashTrack3 = new byte[1024*4];
    /**
     * Get the length of msr_hashTrack3.
     */
    public int msr_hashTrack3Len;
    /**
     * Track data was captured via CTLS interface
     */
    public int isCTLS;
    /**
     * CTLS Application
     */
    public int ctlsApplication;
    /**
     *  clearing record TLV
     */
    public byte[] emv_clearingRecord = new byte[1024*4];
    /**
     * Get the length of emv_clearingRecord.
     */
    public int emv_clearingRecordLen;
    /**
     *  Encrypted Tags TLV
     */
    public byte[] emv_encryptedTags = new byte[1024*4];
    /**
     * Get the length of emv_encryptedTags.
     */
    public int emv_encryptedTagsLen;
    /**
     *  Unencrypted Tags TLV
     */
    public byte[] emv_unencryptedTags = new byte[1024*4];
    /**
     * Get the length of emv_unencryptedTags.
     */
    public int emv_unencryptedTagsLen;
    /**
     *  EMV Result Code
     */
    public int emv_resultCode;
    /**
     *  EMV Encryption Mode
     */
    public int emv_encryptionMode;
    /**
     *  Masked Tags TLV
     */
    public byte[] emv_maskedTags = new byte[1024*4];
    /**
     * Get the length of emv_maskedTags.
     */
    public int emv_maskedTagsLen;
    /**
     *  Advise
     */
    public int emv_hasAdvise;
    /**
     *  Reversal
     */
    public int emv_hasReversal;
    /**
     *  PIN block from PINPAD
     */
    public byte[] pin_pinblock = new byte[1024];
    /**
     * Get the length of pin_pinblock.
     */
    public int pin_pinblockLen;
    /**
     *  KSN for Pinblock
     */
    public byte[] pin_KSN = new byte[10];
    /**
     * Get the length of pin_KSN.
     */
    public int pin_KSNLen;
    /**
     *  KSN for Pinblock
     */
    public byte[] pin_KeyEntry = new byte[1024];
    /**
     * Get the length of pin_KeyEntry.
     */
    public int pin_KeyEntryLen;

    /**
     * SW1
     */
    public char SW1;
    /**
     * SW2
     */
    public char SW2;
    /**
     *  Message Authentication Code
     */
    public byte[] mac = new byte[1024];
    /**
     * Get the length of mac.
     */
    public int macLen;
    /**
     *  Message Authentication Code Key Serial Number
     */
    public byte[] macKSN = new byte[10];
    /**
     * Get the length of macKSN.
     */
    public int macKSNLen;

    /**
     * Fast EMV string.
     */
    public byte[] fastEMV = new byte[1024*4];

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "event",
                "Notification",
                "msr_rawData",
                "msr_rawDataLen",
                "msr_encTrack1",
                "msr_encTrack1Len",
                "msr_encTrack2",
                "msr_encTrack2Len",
                "msr_encTrack3",
                "msr_encTrack3Len",
                "msr_track1",
                "msr_track2",
                "msr_track3",
                "device_RSN",
                "device_RSNLen",
                "msr_KSN",
                "msr_KSNLen",
                "msr_track1Length",
                "msr_track2Length",
                "msr_track3Length",
                "msr_cardType",
                "msr_captureEncodeStatus",
                "msr_captureEncryptType",
                "msr_errorCode",
                "emv_rfStateCode",
                "iccPresent",
                "msr_sessionID",
                "msr_sessionIDLen",
                "msr_isDataVariant",
                "msr_hashTrack1",
                "msr_hashTrack1Len",
                "msr_hashTrack2",
                "msr_hashTrack2Len",
                "msr_hashTrack3",
                "msr_hashTrack3Len",
                "isCTLS",
                "ctlsApplication",
                "emv_clearingRecord",
                "emv_clearingRecordLen",
                "emv_encryptedTags",
                "emv_encryptedTagsLen",
                "emv_unencryptedTags",
                "emv_unencryptedTagsLen",
                "emv_resultCode",
                "emv_encryptionMode",
                "emv_maskedTags",
                "emv_maskedTagsLen",
                "emv_hasAdvise",
                "emv_hasReversal",
                "pin_pinblock",
                "pin_pinblockLen",
                "pin_KSN",
                "pin_KSNLen",
                "pin_KeyEntry",
                "pin_KeyEntryLen",
                "SW1",
                "SW2",
                "mac",
                "macLen",
                "macKSN",
                "macKSNLen",
                "fastEMV");
    }
}
