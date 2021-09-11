package com.coder.nettyexample.dns.tcp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.dns.*;

import java.util.Random;

/**
 * Created by kougavin on 03/09/2021.
 */
public class TcpDnsServerHandler extends SimpleChannelInboundHandler<DnsQuery> {
    private static final byte[] QUERY_RESULT = new byte[]{(byte) 192, (byte) 168, 1, 2};
    Random random = new Random();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                DnsQuery msg) throws Exception {
        DnsQuestion question = msg.recordAt(DnsSection.QUESTION);
        System.out.println("Query domain: " + question);

        //always return 192.168.1.1
        QUERY_RESULT[3] = (byte) random.nextInt(256);
        ctx.writeAndFlush(newResponse(msg, question, 600, QUERY_RESULT));
    }

    private DefaultDnsResponse newResponse(DnsQuery query,
                                           DnsQuestion question,
                                           long ttl, byte[]... addresses) {
        DefaultDnsResponse response = new DefaultDnsResponse(query.id());
        response.addRecord(DnsSection.QUESTION, question);

        for (byte[] address : addresses) {
            DefaultDnsRawRecord queryAnswer = new DefaultDnsRawRecord(
                    question.name(),
                    DnsRecordType.A, ttl, Unpooled.wrappedBuffer(address));
            response.addRecord(DnsSection.ANSWER, queryAnswer);
        }
        return response;
    }
}
