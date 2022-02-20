package code.main.app.offheap.check;

import java.nio.ByteBuffer;

public class SimpleOffHeapExample {

    public static void main(String[] args) {

        System.out.println("Simple Off Heap example..");

        byte[] data = new byte[16]; // contains 16 bytes ( i byte = 8 bits)
        ByteBuffer buf = ByteBuffer.wrap(data);

        buf.putShort(0, (short) 0x1234);  // offset = 0; 12 makes 1 byte and 34 another 1 byte
        buf.putInt(2, 0x12345678); // offset = 2
        buf.putLong(8, 0x1122334455667788L);    // offset = 8; so indices 6 and 7 will be empt

        for (int ii = 0; ii < data.length; ii++) {
            System.out.printf("index %2d = %02x\n", ii, data[ii]);
        }
    }

    private class SimpleDataObject {

    }
}
