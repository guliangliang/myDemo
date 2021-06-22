package com.test.myDemo.util;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangliang.gu
 * @date 2021/6/13
 */
public class SnakeFlow {

    private static final int NODE_ID_BITS = 10;

    private static final long maxNodeId = (1L << NODE_ID_BITS) - 1;

    private static long createNodeId() {
        long nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for(byte macPort: mac) {
                        sb.append(String.format("%02X", macPort));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        nodeId = nodeId & maxNodeId;
        return nodeId;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ;i <10 ;i ++) {
            System.out.println(SnakeFlow.createNodeId());
        }
    }
}
