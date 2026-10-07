class GymMember {
    protected String memberId; protected int monthlyFee; private int sessionsAttended;
    GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4)
            throw new IllegalArgumentException("Invalid member ID");
        if (monthlyFee <= 0) throw new IllegalArgumentException("Invalid fee");
        this.memberId = memberId; this.monthlyFee = monthlyFee;
    }
    void attendSession(){ sessionsAttended++; }
    int getSessionsAttended(){ return sessionsAttended; }
}
class PremiumMember extends GymMember {
    private String trainerName;
    PremiumMember(String memberId,int monthlyFee,String trainerName){ super(memberId,monthlyFee); this.trainerName=trainerName; }
}
public class Main {
    static String signUpBatch(String[] ids,int fee){
        int ok=0,bad=0; for(String id:ids) try{ new GymMember(id,fee); ok++; }catch(IllegalArgumentException e){bad++;}
        return "Signed Up: "+ok+" | Rejected: "+bad;
    }
    public static void main(String[] args){ System.out.println(signUpBatch(new String[]{"MEM1","GM1","MEM2"," ","MEM3"},1000)); }
}