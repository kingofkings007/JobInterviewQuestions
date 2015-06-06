import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;




public class SocialNetwork {
	int N;
	WeightedQuickUnionUF wqu;
	int root;
	public SocialNetwork(int N)
	{
		this.N=N;
	   this.wqu=new WeightedQuickUnionUF(this.N);
	this.root=this.N;
		
		
		
	}
	
	public  boolean areAllMembersConnected()
	{
	     return this.root==1;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		SocialNetwork facebook=new SocialNetwork(10000000);
		PrintWriter bw = new PrintWriter("out1.txt", "UTF-8");
		Timestamp time=null;
		while(!facebook.areAllMembersConnected())
		{
			int person1=StdRandom.uniform(facebook.N);
			int person2=StdRandom.uniform(facebook.N);
			if(!facebook.wqu.connected(person1,person2))
			{
				 facebook.wqu.union(person1, person2);
				 facebook.root--;
				 java.util.Date date= new java.util.Date();
				 time=new Timestamp(date.getTime());
				 bw.println("("+person1+","+person2+")"+" "+new Timestamp(date.getTime()));
				 
			}
			
		}
		
		bw.close();
		System.out.println(time);
	}
	

}
