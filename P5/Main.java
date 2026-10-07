class GymMember {
 private static int count=0; private final String membershipNumber; private int feesPaid;
 GymMember(int monthlyFee){if(monthlyFee<=0)throw new IllegalArgumentException();membershipNumber="GYM-"+(2001+(count++));}
 void payFee(int amount){if(amount<=0)throw new IllegalArgumentException();feesPaid+=amount;}
 void payFee(int amount,String mode){System.out.println("Payment mode: "+mode);payFee(amount);}
 int getFeesPaid(){return feesPaid;} static boolean isValidReferralCode(String c){if(c==null||c.length()!=4)return false;return c.charAt(0)=='G'&&Character.isDigit(c.charAt(1))&&Character.isDigit(c.charAt(2))&&Character.isUpperCase(c.charAt(3));}
 static int getMembersEnrolled(){return count;} String getMembershipNumber(){return membershipNumber;}
}
class GroupClassMember extends GymMember{private String className;GroupClassMember(int fee,String c){super(fee);className=c;}}
public class Main{
 static String processWeeklyCheckIn(GymMember[] ms){int processed=0,nulls=0,group=0,individual=0;for(GymMember m:ms){if(m==null){nulls++;continue;}processed++;if(m instanceof GroupClassMember)group++;else individual++;}return processed+" processed | "+nulls+" null skipped | "+group+" group | "+individual+" individual";}
 public static void main(String[]a){GymMember m=new GymMember(1000);System.out.println(m.getMembershipNumber());System.out.println(GymMember.isValidReferralCode("G45B"));}
}