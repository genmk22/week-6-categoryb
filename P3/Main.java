class GymMember {
    private int[] lateFeeHistory=new int[10]; private int feeCount;
    GymMember(String id,int fee){if(id==null||id.trim().isEmpty()||id.length()<4)throw new IllegalArgumentException();}
    protected void chargeLateFee(int amount){if(feeCount==lateFeeHistory.length)throw new IllegalStateException("History full");lateFeeHistory[feeCount++]=amount;}
    int[] getLateFeeHistory(){int[] c=new int[feeCount];System.arraycopy(lateFeeHistory,0,c,0,feeCount);return c;}
    int getTotalLateFees(){int s=0;for(int i=0;i<feeCount;i++)s+=lateFeeHistory[i];return s;}
}
class PremiumMember extends GymMember {
    PremiumMember(String id,int fee,String trainer){super(id,fee);}
    @Override protected void chargeLateFee(int amount){super.chargeLateFee(amount/2);}
}
public class Main{public static void main(String[]a){PremiumMember p=new PremiumMember("MEM5",2000,"Coach Riya");p.chargeLateFee(200);System.out.println(p.getTotalLateFees());}}