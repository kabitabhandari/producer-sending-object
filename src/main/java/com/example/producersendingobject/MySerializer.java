package com.example.producersendingobject;


import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;


/**
 * converts Object to Byte array
 */
public class MySerializer implements Serializer<MessageSupplier> {
    private final String encoding = "UTF8";
    // private final String encoding = "UTF8";


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //nothing to configure
    }

    @Override
    public byte[] serialize(String topic, MessageSupplier message) {
        byte[] serializedName;
        byte[] serializedDescription;
        byte[] serializedDate;
        int lengthOfName;
        int lengthOfDate;
        int lengthOfDescription;
        try {
            if (message == null)
                return null;
            String name = message.getName();
            serializedName = name.getBytes(encoding);
            serializedDescription = message.getDescription().getBytes(encoding);
            serializedDate = message.getDate().toString().getBytes(encoding);
            lengthOfName = serializedName.length;
            lengthOfDate = serializedDate.length;
            lengthOfDescription = serializedDescription.length;

             ByteBuffer buf = ByteBuffer.allocate( 4 + 4 + lengthOfName + 4 + lengthOfDate + 4 + lengthOfDescription);
            buf.putInt(message.getId());
            buf.put(serializedName);
            buf.put(serializedDescription);
            buf.put(serializedDate);
            buf.putInt(lengthOfName);
            buf.putInt(lengthOfDate);

            return buf.array();

        } catch (Exception ex) {

            throw new SerializationException("Error while serializing SupplierMessage to byte[]");

        }
    }

    @Override
    public void close() {
        //nothing to configure
    }
}


