import java.util.*;
import java.io.*;
//Parser-recursive decent(C5ªºCFG)
public class RD5
{
    public static  String[][] cfg;
    public static String[] nonterminal;

    static int count=0;
    static String[] input=new String[1000];
    static int input_len;
    static int rule;
    static void S()
    {
    	if(input[count].equals("a")||input[count].equals("b")||input[count].equals("q")||input[count].equals("c")||input[count].equals("$"))
    	{
    		System.out.print(" 1");
    		rule=1;
    		A();
    		C();
    		MATCH(input[count],"$");
    	}
    	else{
            rule=1;
            ERROR1(input[count]);
    	}
    }
    static void C()
    {
    	if(input[count].equals("c"))
    	{
    		System.out.print(" 2");
    		rule=2;
    		MATCH(input[count],"c");
    	}
    	else if(input[count].equals("d")||input[count].equals("$"))
    	{
    		System.out.print(" 3");
    		rule=3;
    		return;
    	}
    	else{
            rule=2;
            ERROR1(input[count]);
    	}
    }
    static void A()
    {
    	if(input[count].equals("a"))
    	{
    		System.out.print(" 4");
    		rule=4;
    		MATCH(input[count],"a");
    		B();
    		C();
    		MATCH(input[count],"d");
    	}
    	else if(input[count].equals("b")||input[count].equals("q")||input[count].equals("c")||input[count].equals("$"))
    	{
    		System.out.print(" 5");
    		rule=5;
    		B();
    		Q();
    	}
    	else{
            rule=4;
            ERROR1(input[count]);
    	}
    }
    static void B()
    {
    	if(input[count].equals("b"))
    	{
    		System.out.print(" 6");
    		rule=6;
    		MATCH(input[count],"b");
    		B();
    	}
    	else if(input[count].equals("q")||input[count].equals("c")||input[count].equals("d")||input[count].equals("$"))
    	{
    		System.out.print(" 7");
    		rule=7;
    		return;
    	}
    	else{
            rule=6;
            ERROR1(input[count]);
    	}
    }
    static void Q()
    {
    	if(input[count].equals("q"))
    	{
    		System.out.print(" 8");
    		rule=8;
    		MATCH(input[count],"q");
    	}
    	else if(input[count].equals("c")||input[count].equals("$"))
    	{
    		System.out.print(" 9");
    		rule=9;
    		return;
    	}
    	else{
            rule=8;
            ERROR1(input[count]);
    	}
    }
    static void MATCH(String ts,String token)
    {
    	if(ts.equals(token))
    	{
    		count++;
    	}
    	else
    	{
    		int len=0;
    		for(int k=1;k<cfg[rule].length;k++)
    		{
    			if(!cfg[rule][k].equals(""))
    				len++;
    		}
    		if(len>1)
    		{
    			for(int i=2;;i++)
				{
    				//Error(Non-terminal vs. Terminal)
					if(cfg[rule][i].charAt(0)>='A' && cfg[rule][i].charAt(0)<='Z')
					{
						System.out.println(" Error("+cfg[rule][i]+" vs. "+ts+")");
						break;
					}
					//Error(Terminal vs. Terminal)
					else{
                        System.out.println(" Error(Expected "+token+")");
                        break;
					}
				}
    		}
    		else
    		{
    			//Error(Non-terminal vs. Terminal)
    			if(cfg[rule][1].charAt(0)>='A' && cfg[rule][1].charAt(0)<='Z') 
				{
					System.out.println(" Error("+cfg[rule][1]+" vs. "+ts+")");
				}
				else //Error(Expected token) 
				{
					System.out.println(" Error(Expected "+token+")");
				}
    		}
    		System.exit(0);
    	}
    }
    
    static void ERROR1(String ts)
    {
        System.out.println(" Error("+cfg[rule][0]+" vs. "+ts+")");
        System.exit(0);
    }
    
//---------------------------------------------------
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        String f = sc.nextLine();

        ReadFile(f);
       
        //input
        int i;
        for(i=0;;i++)
        {
        	input[i]=sc.next();
        	if(input[i].equals("$"))
        		break;
        }
        input_len=i+1;
        S();
        if(input_len==count)
        	System.out.print(" Accept");
        
        sc.close();
    }
}
