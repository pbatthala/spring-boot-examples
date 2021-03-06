package com.example.thrift;

import com.example.thrift.config.ServiceConfigurationConstants;
import com.example.thrift.hello.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NiftyClientTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int PORT = ServiceConfigurationConstants.MAP_CONST.get("nifty");

    @Test
    public void client() {
        try {
            // 设置调用的服务地址为本地，端口为 7911
            TTransport transport = new TSocket("localhost", PORT);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            // 调用服务的 helloVoid 方法
            client.helloVoid();
            String echo = client.helloString("HELLO NIFTY ......");
            logger.debug(echo);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

}