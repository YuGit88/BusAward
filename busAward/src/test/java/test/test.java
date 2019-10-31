package test;

import com.zz80z.busAward.common.utils.MathUtil;

public class test {
  public static void main(String[] args) {
	  md5Pswd("admin","admin123");
	  System.out.println("!!!!!!!!!!!!!!!!!");
}
   public static  void md5Pswd(String email ,String pswd){
		pswd = String.format("%s#%s", email,pswd);
		System.out.println(pswd);
		pswd = MathUtil.getMD5(pswd);
		System.out.println(pswd);
	}
   
}
