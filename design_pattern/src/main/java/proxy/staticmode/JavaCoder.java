package proxy.staticmode;

import proxy.ICoder;

public class JavaCoder  implements ICoder {
    private String name;

    public JavaCoder(String name){
        this.name = name;
    }

    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand:" + demandName + " in JAVA!");
    }
}
