import java.util.*;
import java.io.*;
//First最終版
public class FIRST
{
    public static  String[][] cfg;
    public static String[] nonterminal;

    static String ans=""; //First完的最終答案(用空格區隔，且第一個是空格)
    static int tag=0; //有無L(1是有)
  
	public static String First(String[] s)//傳入字串陣列
	{
		if(s[1].equals("L"))
			return ans;
		
		for(int i=1;i<s.length && s[i]!="";i++)
		{
			if(s[i].equals(s[0])) //如果LHS==RHS
				continue;
			//第一個字串是大寫且沒有L(沒有derive L)
			if(i>1 && s[i-1].charAt(0)>='A' && s[i-1].charAt(0)<='Z' && tag==0)
				break;
			if(s[i].charAt(0)>='A' && s[i].charAt(0)<='Z')
			{
				token(s[i]);
			}
			else //小寫
			{
				token(s[i]);
				break;
			}
		}
		return ans;
	}
	public static String token(String t)//傳入字串陣列中的其中一個字串
	{
		if(t.equals("L"))
			return ans;
		if(t.charAt(0)>='A' && t.charAt(0)<='Z')
		{
			for(int i=1;i<cfg.length && t!="";i++) //找LHS在幾號跟幾號
			{
				if(t.equals(cfg[i][0])) //RHS==LHS (不同編號)
				{
					if(cfg[i][1].equals("L"))//有L
						tag=1;
					First(cfg[i]);
				}
			}
		}
		else //小寫
		{
			String temp=ans;
			ans=ans+" "+t;
			String[] s=temp.split(" ");
			for(int k=0;k<s.length;k++) //檢查是否有重複
			{
				if(t.equals(s[k]))
				{
					ans=temp;
				}
			}
			tag=0;//做完就把tag歸0
		}
		
		return ans;
	}
//---------------------------------------------------
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        String f = sc.nextLine();

        ReadFile(f);
       
        //test
        for(int i=1;i<cfg.length;i++)
        {
        	for(int j=0;j<cfg[i].length && cfg[i][j]!="";j++)
        		System.out.print(cfg[i][j]);
        	System.out.println();
        	First(cfg[i]);
        	System.out.println(ans);
        	ans="";
        	tag=0;
        }
        
        sc.close();
    }
}
