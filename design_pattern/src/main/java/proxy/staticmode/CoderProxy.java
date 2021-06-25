package proxy.staticmode;

import proxy.ICoder;

public class CoderProxy implements ICoder {
    private ICoder coder;

    public CoderProxy(ICoder coder){
        this.coder = coder;
    }

    public void implDemands(String demandName) {
        coder.implDemands(demandName);
    }
}
