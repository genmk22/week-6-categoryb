class GymMember {
 protected int sessions; GymMember(String id,int fee){if(id==null||id.trim().isEmpty()||id.length()<4)throw new IllegalArgumentException();}
 void attendSession(){sessions++;} int getSessionsAttended(){return sessions;}
 String displayInfo(){return "Standard | Sessions: "+sessions;}
}
class PremiumMember extends GymMember {
 private String trainerName; PremiumMember(String id,int fee,String t){super(id,fee);trainerName=t;}
 String getTrainerName(){return trainerName;}
 @Override String displayInfo(){return "Premium | Trainer: "+trainerName+" | Sessions: "+sessions;}
}
public class Main{
 static String batchPrint(GymMember[] ms){StringBuilder sb=new StringBuilder();for(GymMember m:ms){sb.append(m.displayInfo());if(m instanceof PremiumMember){PremiumMember p=(PremiumMember)m;sb.append(" [Trainer via downcast: ").append(p.getTrainerName()).append("]");}sb.append(" | ");}return sb.toString();}
 public static void main(String[]a){System.out.println(batchPrint(new GymMember[]{new GymMember("MEM6",1000),new PremiumMember("MEM7",2000,"Coach Riya")}));}
}