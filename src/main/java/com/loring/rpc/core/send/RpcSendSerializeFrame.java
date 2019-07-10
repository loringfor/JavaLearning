package com.loring.rpc.core.send;

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
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcSendSerializeFrame implements RpcSerializeFrame {

    @Override
    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline) {
        switch (protocol) {
            case JDKSERIALIZE: {
                //利用LengthFieldPrepender回填补充ObjectDecoder消息报文头
                //考虑到并发性能，采用weakCachingConcurrentResolver缓存策略。一般情况使用:cacheDisabled即可
                pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                pipeline.addLast(new MessageSendHandler());
                pipeline.addLast(new LengthFieldPrepender(MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new ObjectEncoder());
                break;
            }
            case KRYOSERIALIZE: {
                KryoCodecUtil util = new KryoCodecUtil(KryoPoolFactory.getKryoPoolInstance());
                pipeline.addLast(new KryoEncoder(util));
                pipeline.addLast(new KryoDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
            case PROTOSTUFFSERIALIZE: {
                ProtostuffCodecUtil util = new ProtostuffCodecUtil();
                util.setRpcDirect(false);
                pipeline.addLast(new ProtostuffEncoder(util));
                pipeline.addLast(new ProtostuffDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
        }
    }
}
