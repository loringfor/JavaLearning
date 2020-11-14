package com.loring.rpc.serialize.kryo;

import com.loring.rpc.serialize.MessageCodecUtil;
import com.loring.rpc.serialize.MessageDecoder;

/**
 * Kryo解码器
 */
public class KryoDecoder extends MessageDecoder {
    public KryoDecoder(MessageCodecUtil util) {
        super(util);
    }
}
