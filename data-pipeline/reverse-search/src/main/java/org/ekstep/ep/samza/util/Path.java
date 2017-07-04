package org.ekstep.ep.samza.util;

public class Path {
    public String loc(){
        return "edata.eks.loc";
    }

    public String checksum(){
        return "metadata.checksum";
    }

    public String metadata(){
        return "metadata";
    }

    public String channelId(){
        return "channelid";
    }

    public String flags(){
        return "flags";
    }

    public String did(){
        return "dimensions.did";
    }

    public String ets(){
        return "ets";
    }

    public String ts(){
        return "ts";
    }

    public String mid(){
        return "mid";
    }

    public String ldata(){
        return "ldata";
    }
}