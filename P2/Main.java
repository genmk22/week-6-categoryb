class GymMember {
    protected String memberId; protected int monthlyFee; private int sessionsAttended;
    GymMember(String id,int fee){if(id==null||id.trim().isEmpty()||id.length()<4)throw new IllegalArgumentException();if(fee<=0)throw new IllegalArgumentException();memberId=id;monthlyFee=fee;}
    void attendSession(){sessionsAttended++;} int getSessionsAttended(){return sessionsAttended;}
    String displayInfo(){return "Standard Member | Sessions: "+sessionsAttended;}
}
class PremiumMember extends GymMember {
    protected String trainerName; PremiumMember(String id,int fee,String t){super(id,fee);trainerName=t;}
    @Override String displayInfo(){return "Premium Member | Trainer: "+trainerName+" | Sessions: "+getSessionsAttended();}
}
class EliteMember extends PremiumMember {
    private String lockerNumber; EliteMember(String id,int fee,String t,String l){super(id,fee,t);lockerNumber=l;}
    @Override String displayInfo(){return "Elite Member | Trainer: "+trainerName+" | Locker: "+lockerNumber+" | Sessions: "+getSessionsAttended();}
}
class GroupClassMember extends GymMember {
    private String className; GroupClassMember(String id,int fee,String c){super(id,fee);className=c;}
    @Override String displayInfo(){return "Group Class Member | Class: "+className+" | Sessions: "+getSessionsAttended();}
}
public class Main {
 static String classifyGeneration(GymMember m){if(m instanceof EliteMember)return "Multilevel descendant (3 generations deep)";if(m instanceof GroupClassMember)return "Hierarchical sibling (independent branch)";return "Standard/Premium branch";}
 static int getTotalSessionsAttended(GymMember[] ms){int total=0;for(GymMember m:ms)total+=m.getSessionsAttended();return total;}
 public static void main(String[] a){EliteMember e=new EliteMember("MEM3",3000,"Coach Arjun","L12");System.out.println(e.displayInfo());}
}