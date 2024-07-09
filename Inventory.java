package A2;

public class Inventory{


    private String name;
    private String desc;
    private Double price;
    private Integer qty;
    private Double invalue;
    private Integer rlevel;
    private Integer rtime;
    private Integer rqty;

    public Inventory() {
    }

    public Inventory(String n, String d, Double p, Integer q, Double i, Integer rl, Integer rt, Integer rq){ // Constructor
        name = n;
        desc = d;
        price = p;
        qty = q;
        invalue = i;
        rlevel = rl;
        rtime = rt;
        rqty = rq;

    }
    //get functions below
    public String n(){
        return name;
    }
    public String d(){
        return desc;
    }
    public Double p(){
        return price;
    }
    public Integer q(){
        return qty;
    }
    public Double i(){
        return invalue;
    }
    public Integer rl(){
        return rlevel;
    }
    public Integer rt() {
        return rtime;
    }
    public Integer rq(){
        return rqty;
    }


    //set functions below
    public void setN(String n){ this.name = n;}
    public void setD(String d){ this.desc = d;}
    public void setP(Double p){ this.price = p;}
    public void setQ(Integer q){ this.qty = q;}
    public void setI(Double i){ this.invalue = i;}
    public void setRL(Integer rl){ this.rlevel = rl;}
    public void setRT(Integer rt){ this.rtime = rt;}
    public void setRQ(Integer rq){ this.rqty = rq;}




    public double totalValue()
    {
       return 0.0;
    }
}
