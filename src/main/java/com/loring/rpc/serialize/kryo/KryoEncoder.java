package com.loring.rpc.serialize.kryo;

import com.loring.rpc.serialize.MessageCodecUtil;
import com.loring.rpc.serialize.MessageEncoder;

/**
 * Kryo编码器
 */
public class KryoEncoder extends MessageEncoder {
    public KryoEncoder(MessageCodecUtil util) {
        super(util);
    }
}
