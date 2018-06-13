package com.dubbo.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.dubbo.service.DemoService;
import junit.framework.TestCase;
import org.junit.Test;

public class RpcFilterTest extends TestCase {
    private Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    private ProxyFactory proxy = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

    @Test
    public void testRpcFilter() throws Throwable {
        DemoService service = new DemoServiceImpl();
        URL url = URL.valueOf("dubbo://192.168.5.1:20889/com.dubbo.service.DemoService?accesslog=true&anyhost=true&application=demo-provider&default.service.filter=-exception,-accesslog,accesslog2,apiexception,echo");
        protocol.export(proxy.getInvoker(service, DemoService.class, url));
        service = proxy.getProxy(protocol.refer(DemoService.class, url));
//        service.sayHello("myex", new RuntimeException("RuntimeException"));
        service.sayHello("myex", new IllegalArgumentException("RuntimeException"));

        // cast to EchoService
//        EchoService echo = proxy.getProxy(protocol.refer(EchoService.class, url));
//        assertEquals(echo.$echo("test"), "test");
//        assertEquals(echo.$echo("abcdefg"), "abcdefg");
//        assertEquals(echo.$echo(1234), 1234);
    }

}