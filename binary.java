import java.io.*;
import java.util.*;

public class binary 
{
	static int randomn;
	public String getstring() throws IOException
	{
	FileReader fr= new FileReader("check.java");
	BufferedReader br=new BufferedReader(fr);
	String str,filestr="";
	
	while((str=br.readLine())!=null)
	{
		filestr=filestr.concat(str);
     }
	System.out.println("ORIGINAL TEXT : "+filestr);
	fr.close();
	return filestr;
	}
	public int[] ascii(String s)
	{
		String b=s;
		int ascii[]=new int[s.length()];
	char []ch = b.toCharArray();
	for(int i=0;i<ch.length;i++)
	{
		ascii[i]=(int)ch[i];
		
	}
	return ascii;
	}
	public int[] tobinary(int x)
	{
		int reminder,i=0;
		int arr[] = new int[8];
		int binary[]=new int[8];
		while(x!=0)
		{
			reminder=x%2;
			x=x/2;
			arr[i]=reminder;
		    i=i+1;
			
	}
		
		int j;
		for(j=0;j<=7;j++)
		{
		    binary[j]=arr[7-j];
		   	}
	return binary;
	}
	public void singlecrossover(int[]a,int[]b)
	{
		for(int i=0;i<3;i++)
		{
			int temp;
			temp = a[i];
			a[i]=b[i];
			b[i]=temp;
		}
	}
	public void twocrossover(int[]a,int[]b)
	{
		for(int i=0;i<3;i++)
		{
			int temp;
			temp=a[i];
			a[i]=b[i];
			b[i]=temp;
		    int temp2;
			temp2=a[7-i];
			a[7-i]=b[7-i];
			b[7-i]=temp2;
		}
	}
	public void multicrossover(int[]a,int[]b)
	{
		for(int i=0;i<2;i++)
		{
			int temp;
			int temp2;
			temp=a[i];
			a[i]=b[i];
			b[i]=temp;
			temp2=a[i+4];
			a[i+4]=b[i+4];
			b[i+4]=temp2;
		}
	}
	public int[] mutation(int []a)
	{
		for(int i=0;i<8;i++)
		{
		if(a[i]==0)
		{
			a[i]=a[i]+1;
		}
		else
		{
			a[i]=a[i]*0;
		}
	}
		return a;
	}
	public int toascii(int[]a)
	{
		int sum=0;
	for(int i=0;i<8;i++)
	{
		sum=(int)sum+(int)(Math.pow(2,i)*a[7-i]);
	}
	return sum;
	}
	public String convertetostring(int[]a)
	{
		char []ch=new char[a.length];
		for(int i=0;i<a.length;i++)
		{
			ch[i]=(char)a[i];
		}
		String encry=new String(ch);
		return encry;
	}
public static void main(String args[]) throws IOException
{
	binary a=new binary();
	ArrayList<int[]> b=new ArrayList<int[]>();
	ArrayList<int[]> d=new ArrayList<int[]>();
	int [] val=a.ascii(a.getstring());
	
	for(int i=0;i<val.length;i++)
	{     
		b.add(a.tobinary(val[i]));
	}
	minor1.random2(val[val.length-1],val.length);
	for(int j=0;j<b.size();j=j+2)
	{int cont[]=new int[8];
	int cont2[]=new int[8];
	int random=minor1.randomf.get(j);
	int n=random%3;
	if(b.size()%2==1)
	{
		if(j==b.size()-1)
		{
			int c[]={0,0,0,0,0,0,0,0};
			cont=b.get(j);
			cont2=c;
		}
		else{
		cont=b.get(j);
		cont2=b.get(j+1);
	}
	}
	else{
		cont=b.get(j);
		cont2=b.get(j+1);
	}

	if(n==0){	a.singlecrossover(cont,cont2);
	}
	if(n==1)
	{
		a.twocrossover(cont,cont2);
		
	}
	if(n==2)
	{
		a.multicrossover(cont,cont2);
	}
			d.add(a.mutation(cont));
			d.add(a.mutation(cont2));
		
		}

	int ascii[]=new int[d.size()]; 
	for(int l=0;l<d.size();l++)
	{
		ascii[l]=a.toascii(d.get(l));
	}
	String encrypted=a.convertetostring(ascii);
	System.out.println("Encrypted TEXT : "+encrypted);
	int []dval=a.ascii(encrypted);
	ArrayList<int[]> e=new ArrayList<int[]>();
	
	for(int k=0;k<dval.length;k++)
	{
		e.add(a.tobinary(dval[k]));
	}
	ArrayList<int[]> f=new ArrayList<int[]>();
	for(int j=0;j<e.size()-1;j=j+2)
	{
		int[]temp=e.get(j);
		int[]temp2=e.get(j+1);
		int random=minor1.randomf.get(j);
		int n=random%3;
		
	if(n==0){	
		a.singlecrossover(a.mutation(temp),a.mutation(temp2));
	}
	if(n==1)
	{
		a.twocrossover(a.mutation(temp),a.mutation(temp2));
	}
	if(n==2)
	{
		a.multicrossover(a.mutation(temp),a.mutation(temp2));
	}
		f.add(temp);
		f.add(temp2);
	}
	if(b.size()%2==1){
	f.remove(f.size()-1);
	}
	int dascii[]=new int[f.size()];
	for(int k=0;k<f.size();k++)
	{
		dascii[k]=a.toascii(f.get(k));
	}
	String decrypted=a.convertetostring(dascii);
	System.out.println("DECRYPTED TEXT : "+decrypted);
}
}
