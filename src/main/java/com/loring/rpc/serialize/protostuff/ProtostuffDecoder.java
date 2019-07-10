package com.loring.rpc.serialize.protostuff;

import com.loring.rpc.serialize.MessageCodecUtil;
import com.loring.rpc.serialize.MessageDecoder;

public class ProtostuffDecoder extends MessageDecoder {
    public ProtostuffDecoder(MessageCodecUtil util) {
        super(util);
    }
}
