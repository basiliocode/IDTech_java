package Estruturas;

import com.sun.jna.PointerType;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class IDTMSRData extends Structure {

    /**
     * MSR type,please see EVENT_MSR_Types for more information.<br/>
     */
    public byte cardDataFlag;

    /**
     * Get the swiped card data.<br/>
     * Containing complete unparsed swipe data as received from MSR.<br/>
     * NOTE: <br/>
     * Just refer to this item cardData if the card data is the clear data.<br/>
     *
     */
    public byte[] cardData = new byte[1024*4];
    /**
     * Get the length of cardData
     */
    public int cardDataLen;

    /**
     * CTLS Application
     */
    public int ctlsApplication;

    /**
     * Track data was captured via CTLS interface
     */
    public boolean isCTLS;

    /**
     * Card Track 1 decode status
     */
    public byte t1DecodeStatus;
    /**
     * Card Track 2 decode status
     */
    public byte t2DecodeStatus;
    /**
     * Card Track 3 decode status
     */
    public byte t3DecodeStatus;

    /**
     * Get the swiped card Track1 encrypted data.<br/>
     * A byte array containing Track1 encrypted data.
     */
    public byte [] encTrack1 = new byte[1024*4];
    /**
     * Get the length of encTrack1
     */
    public int encTrack1Len;

    /**
     * Get the swiped card Track2 encrypted data.<br/>
     * A byte array containing Track2 encrypted data.
     */
    public byte [] encTrack2 = new byte[1024*4];
    /**
     * Get the length of encTrack2
     */
    public int encTrack2Len;

    /**
     * Get the swiped card Track3 encrypted data.<br/>
     * A byte array containing Track3 encrypted data.
     */
    public byte [] encTrack3 = new byte[1024*4];
    /**
     * Get the length of encTrack3
     */
    public int encTrack3Len;

    /**
     * Get the swiped card Track1 data.<br/>
     * A string containing Track1 masked data expressed as hex characters.
     */
    public byte[] track1 = new byte[1024*4];

    /**
     * Get the swiped card Track2 data.<br/>
     * A string containing Track2 masked data expressed as hex characters.
     */
    public byte [] track2 = new byte[1024*4];

    /**
     * Get the swiped card Track3 data.<br/>
     * A string containing Track3 masked data expressed as hex characters.
     */
    public byte [] track3 = new byte[1024*4];

    /**
     * Get the Reader Serial Number.<br/>
     */
    public byte [] serialNumber = new byte[10];
    /**
     * Get the length of serialNumber
     */
    public int serialNumberLen;
    /**
     * Get the swiped card KSN (Key Serial Number).<br/>
     * A byte array containing up to 11 bytes.
     */
    public byte[] KSN = new byte[11];
    /**
     * Get the length of KSN
     */
    public int KSNLen;

    /**
     * Get the swiped card length of Track1 data.
     */
    public int track1Length;

    /**
     * Get the swiped card length of Track2 data.
     */
    public int track2Length;

    /**
     * Get the swiped card length of Track3 data.
     */
    public int track3Length;

    /**
     * Determines if ICC is present in card (service code starts with "2" or "6").
     */
    public int iccPresent;
    /**
     * Get the swiped card type,please see CAPTURE_ENCODE_TYPE for more
     * information.<br/>
     * MSR card type:<br/>
     *      CAPTURE_ENCODE_TYPE_ISOABA:ISO/ABA format<br/>
     *      CAPTURE_ENCODE_TYPE_AAMVA:AAMVA format<br/>
     *      CAPTURE_ENCODE_TYPE_Other:Other<br/>
     *      CAPTURE_ENCODE_TYPE_Raw:Raw; undecoded format<br/>
     *      CAPTURE_ENCODE_TYPE_JisI_II:JIS I or JIS II
     *
     */
    public byte cardType;


    /**
     * Get the swiped card decoded status.<br/>
     *          0x00:decoded data success;<br/>
     *              Bit0:1-track1 data error;<br/>
     *              Bit1:1-track2 data error;<br/>
     *              Bit2:1-track3 data error;<br/>
     *              Bit3:1-track1 encrypted data error;<br/>
     *              Bit4:1-track2 encrypted data error;<br/>
     *              Bit5:1-track3 encrypted data error;<br/>
     *              Bit6:1-KSN error;<br/>
     *
     */
    public byte captureEncodeStatus;


    /**
     * Get the swiped card encrypted type,please see CAPTURE_ENCRYPT_TYPE
     * for more information.<br/>
     *          CAPTURE_ENCRYPT_TYPE_TDES:TDES;<br/>
     *                    CAPTURE_ENCRYPT_TYPE_AES:AES;
     *
     */
    public byte captureEncryptType;

    /**
     * The flag to indicate the availability of the swiped card
     * Clearing Record data.
     */
    public byte hasDE055;

    /**
     * Get the swiped card length of Clearing Record data.
     */
    public int DE055Len;

    /**
     * Get the swiped card of DE055 data.
     */
    public byte [] DE055Data = new byte[1024*2];

    /**
     * Get the swiped card length of TLV data.
     */
    public int TLVLen;

    /**
     * Get the swiped card TLV data.
     */
    public byte [] TLVData = new byte[1024*4];

    /**
     * Get the length of optional bytes.
     */
    public int optionalBytesLen;

    /**
     * Get optional bytes of the swiped card data.
     */
    public byte [] optionalBytes = new byte[1024*4];
    /**
     * TRUE = Data Variant key used<br/>
     * FALSE = PIN Variant key used
     */
    public int isDataVariant;
    /**
     * Get the length of sessionID.
     */
    public int sessionIDLen;

    /**
     * Get optional bytes of the session ID.
     */
    public byte [] sessionID = new byte[1024*4];
    /**
     * Get the length of track 1 hash.
     */
    public int track1HashLen;

    /**
     * Get optional bytes of the track 1 hash.
     */
    public byte [] track1Hash = new byte[1024*4];
    /**
     * Get the length of track 2 hash.
     */
    public int track2HashLen;

    /**
     * Get optional bytes of the track 2 hash.
     */
    public byte [] track2Hash = new byte[1024*4];
    /**
     * Get the length of track 3 hash.
     */
    public int track3HashLen;

    /**
     * Get optional bytes of the track 3 hash.
     */
    public byte [] track3Hash = new byte[1024*4];

    /**
     * Get unencrypted tags.
     */
    public IDTTag  [] unencryptedTagArray = new IDTTag[100];
    /**
     * Get the count of unencrypted tags.
     */
    public int unencryptedTagCount;
    /**
     * Get masked tags.
     */
    public IDTTag [] maskedTagArray = new IDTTag[100];
    /**
     * Get the count of masked tags.
     */
    public int maskedTagCount;
    /**
     * Get encrypted tags.
     */
    public IDTTag [] encryptedTagArray = new IDTTag[100];
    /**
     * Get the count of encrypted tags.
     */
    public int encryptedTagCount;
    /**
     * Get the length of raw track data.
     */
    public int rawTrackDataLen;
    /**
     * Get the raw track data.
     */
    public byte [] rawTrackData = new byte[1024*4];

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
    public byte [] macKSN = new byte[10];
    /**
     * Get the length of macKSN.
     */
    public int macKSNLen;

    /**
     * Error code from the tag DFEE25 if available
     */
    public int errorCode;

    /**
     * Fast EMV string.
     */
    public byte [] fastEMV = new byte[1024*4];

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "cardDataFlag",
                "cardData",
                "cardDataLen",
                "ctlsApplication",
                "isCTLS",
                "t1DecodeStatus",
                "t2DecodeStatus",
                "t3DecodeStatus",
                "encTrack1",
                "encTrack1Len",
                "encTrack2",
                "encTrack2Len",
                "encTrack3",
                "encTrack3Len",
                "track1",
                "track2",
                "track3",
                "serialNumber",
                "serialNumberLen",
                "KSN",
                "KSNLen",
                "track1Length",
                "track2Length",
                "track3Length",
                "iccPresent",
                "cardType",
                "captureEncodeStatus",
                "captureEncryptType",
                "hasDE055",
                "DE055Len",
                "DE055Data",
                "TLVLen",
                "TLVData",
                "optionalBytesLen",
                "optionalBytes",
                "isDataVariant",
                "sessionIDLen",
                "sessionID",
                "track1HashLen",
                "track1Hash",
                "track2HashLen",
                "track2Hash",
                "track3HashLen",
                "track3Hash",
                "unencryptedTagArray",
                "unencryptedTagCount",
                "maskedTagArray",
                "maskedTagCount",
                "encryptedTagArray",
                "encryptedTagCount",
                "rawTrackDataLen",
                "rawTrackData",
                "mac",
                "macLen",
                "macKSN",
                "macKSNLen",
                "errorCode",
                "fastEMV");

    }
}
