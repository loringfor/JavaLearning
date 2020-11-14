package com.loring.rpc.core.recv;

import com.loring.rpc.serialize.MessageCodecUtil;
import com.loring.rpc.serialize.RpcSerializeFrame;
import com.loring.rpc.serialize.RpcSerializeProtocol;
import com.loring.rpc.serialize.kryo.KryoCodecUtil;
import com.loring.rpc.serialize.kryo.KryoDecoder;
import com.loring.rpc.serialize.kryo.KryoEncoder;
import com.loring.rpc.serialize.kryo.KryoPoolFactory;
import com.loring.rpc.serialize.protostuff.ProtostuffCodecUtil;
import com.loring.rpc.serialize.protostuff.ProtostuffDecoder;
import com.loring.rpc.serialize.protostuff.ProtostuffEncoder;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.Map;

public class RpcRecvSerializeFrame implements RpcSerializeFrame {
    private Map<String,Object> concurrentMap = null;

    public RpcRecvSerializeFrame(Map<String, Object> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    @Override
    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline) {
        switch (protocol) {
            case JDKSERIALIZE: {
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, MessageCodecUtil.MESSAGE_LENGTH, 0, MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new LengthFieldPrepender(MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new ObjectEncoder());
                pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                pipeline.addLast(new MessageRecvHandler(concurrentMap));
                break;
            }
            case KRYOSERIALIZE: {
                KryoCodecUtil util = new KryoCodecUtil(KryoPoolFactory.getKryoPoolInstance());
                pipeline.addLast(new KryoEncoder(util));
                pipeline.addLast(new KryoDecoder(util));
                pipeline.addLast(new MessageRecvHandler(concurrentMap));
                break;
            }
            case PROTOSTUFFSERIALIZE: {
                ProtostuffCodecUtil util = new ProtostuffCodecUtil();
                util.setRpcDirect(true);
                pipeline.addLast(new ProtostuffEncoder(util));
                pipeline.addLast(new ProtostuffDecoder(util));
                pipeline.addLast(new MessageRecvHandler(concurrentMap));
                break;
            }
        }
    }
}
