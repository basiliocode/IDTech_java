package Estruturas;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class EMV_callback extends Structure {
    /**
     * Swipe Timeout

     Timeout value waiting for MSR Swipe
     */
    public int msr_swipeTimeout;

    /**
     * MSR Message

     Message to display during swipe request
     */
    public int msr_displayMessage;

    /**
     * PIN Mode.<br/>
     0- EMV_PIN_MODE_CANCEL: Entry cancel through command. No response required
     1- EMV_PIN_MODE_ONLINE_DUKPT:  PIN_DUKPT_KEY required as response
     2- EMV_PIN_MODE_ONLINE_MKSK:  PIN_SESSION_KEY required as response
     3- EMV_PIN_MODE_OFFLINE: PIN_PAIRING_DUKPT_KEY required as response,
     unless devices does not implement pairing function, then plaintext
     PIN required as response
     */
    public int pin_pinMode;
    /**
     * PIN Entry Start Timeout

     Timeout value waiting for PIN entry to start
     */
    public int pin_entryStartTimeout;

    /**
     * PIN Entry Interval
     Timeout value of interval between input each PIN
     */
    public int pin_entryInterval;

    /**
     * PIN KSN

     Pairing DUKPT KSN
     */
    public byte[] pin_KSN = new byte[50];

    /**
     * PIN KSN Len

     Length of Pairing DUKPT KSN
     */
    public int pin_KSNLen;

    /**
     * Truncated PAN

     Truncated PAN
     */
    public byte[] pin_truncatedPAN = new byte[1024];


    /**
     * Callback Type.<br/>
     1- EMV_CALLBACK_TYPE_LCD: LCD Display Hardware Event
     2- EMV_CALLBACK_TYPE_PINPAD:  Pinpad Hardware Event
     3- EMV_CALLBACK_MSR:  MSR Hardware Event
     */
    public int callbackType;
    /**
     * Display Mode.<br/>
     1- LCD_DISPLAY_MODE_MENU: Menu selection, response required with selected
     menu index #, or 0 to cancel
     2- LCD_DISPLAY_MODE_PROMPT:  Message Prompt, response required 'E' for
     Enter/Accept, or 'C' for cancel
     3- LCD_DISPLAY_MODE_MESSAGE:  Display Message, no response required
     8- LCD_DISPLAY_MODE_LANGUAGE_SELECT: Language selection, response required
     with selected language index #
     16 - LCD_DISPLAY_MODE_CLEAR_SCREEN: Request to clear LCD screen
     of information
     */
    public int lcd_displayMode;

    /**
     * Message Mode for VP8800.<br/>
     1- EMV_LCD_DISPLAY_MODE_MESSAGE: Mode 2 and Mode 3 that LCD messages will be sent to SDK
     2- EMV_LCD_DISPLAY_MODE_PAUSE:  Mode 4 that LCD messages will be sent to SDK and wait for SDK to respond
     */
    public int lcd_messageMode;

    /**
     * Keypad Entry Timeout

     If Normal Display or Menu Display, Total timeout for keypad entry, in
     second default is 30 seconds.
     */
    public int lcd_entryTimeout;


    /**
     * Keypad Entry Timeout Minor

     If Normal Display or Menu Display, minor timeout during each keypad entry,
     in second, little endian, default is 10 seconds.
     Note: Minor timeout will erase all previous keypad entry.

     */
    public int lcd_entryTimeoutMinor;

    /**
     * Message Language

     2 Bytes
     - EN - English (default)
     - ES - Spanish
     - ZH - Chinese
     - FR - French

     */
    public byte[] language = new byte[5];



    /**
     * Display Message

     repeatable combination of [Line][Message][0x1C]
     [Line] - Display line number (1-First Line, n-nth Line), Maximum 16 lines.
     -The lower 7 bits is for line number.
     -The MSB is to indicate following message is a Message String or Message ID.
     -MSB - 0: Message String. (It is valid for "Menu Display"ï¿½ and
     "Language Menu Display")
     -MSB - 1: Message ID. (It is only valid for "Menu Display")
     [Message] - Message String or Message ID.
     Message String:
     "Menu Display"ï¿½ : character in the range of 0x20 - 0x7f,
     Maximum 16 characters
     - "Language Menu Display"ï¿½ : 2 bytes Language ID
     EN - English (default)
     ES - Spanish
     ZH - Chinese
     FR - French

     */
    //        unsigned char lcd_messages[1024];
    public byte[] lcd_messages = new byte[1024*4];

    /**
     * Backlight Timeout

     If Normal Display or Menu Display, Total timeout for keypad entry,
     in second default is 30 seconds.  0x0000 = backlight off, 0xFFFF = backlight
     on
     */
    public short lcd_backlightTimeout;


    /**
     * Mask Entry

     If True, keypad entry should be masked with '*'
     */
    public int maskEntry;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "msr_swipeTimeout",
                "msr_displayMessage",
                "pin_pinMode",
                "pin_entryStartTimeout",
                "pin_entryInterval",
                "pin_KSN",
                "pin_KSNLen",
                "pin_truncatedPAN",
                "callbackType",
                "lcd_displayMode",
                "lcd_messageMode",
                "lcd_entryTimeout",
                "lcd_entryTimeoutMinor",
                "language",
                "lcd_messages",
                "lcd_backlightTimeout",
                "maskEntry");
    }
}
