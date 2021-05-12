package hfdp2.chapter11_proxy_pattern;

import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            System.out.println(service.sayHello());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
