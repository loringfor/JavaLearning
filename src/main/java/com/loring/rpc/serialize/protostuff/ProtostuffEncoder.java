package com.loring.rpc.serialize.protostuff;

import com.loring.rpc.serialize.MessageCodecUtil;
import com.loring.rpc.serialize.MessageEncoder;

public class ProtostuffEncoder extends MessageEncoder {
    public ProtostuffEncoder(MessageCodecUtil util) {
        super(util);
    }
}
