package Estruturas;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class IDTTag extends Structure {

    public int tagLen;
    /**
     * The tag name
     */
    public byte [] tag = new byte[10];
    /**
     * The length of the value
     */
    public int valueLen;
    /**
     * The tag value
     */
    public byte [] value = new byte[1024*4];

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "tagLen",
                "tag",
                "valueLen",
                "value");
    }
}
