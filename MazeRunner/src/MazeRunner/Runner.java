package MazeRunner;
/*
 * Method Initialize Takes The Input And Prepares The Puzzle Matrix.
 * Method createNodeList Prepares The List Of Nodes That Are Traversable.
 * Method display Displays The Input Matrix.
 * Method Neighbours Gets The Neighbours Of The Given Node.
 * Method Path Finder Finds The Path And Provides The Path Nodes List.
 * Method backTack Finds The Path That Is Optimum.
 * Method Neigbours2 Get The Neigbours For BackTracking.
 * Method finalDisplay Gives The Final Output.
 * Path is Given By 7.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	public static ArrayList<Node> Sl=new ArrayList<Node>();
	public ArrayList<Node> X=new ArrayList<Node>();
	public static int Rows;
	public static int Columns;
	public static int[][] Puzz=new int[Rows][Columns];
ArrayList<Node> NodeList=new ArrayList<Node>();
public void initialize(int a,int b)
	 {	 
		Rows=a;
		Columns=b;	
		 int[][] Puzzle=new int[a][b];
		
		 for(int i=0;i<a;i++)
		 {
			 for(int j=0;j<b;j++)
			 {
				 System.out.println("Input the"+"("+i+","+j+")"+"element");
				 Scanner sd=new Scanner(System.in);
				 int element=sd.nextInt();
				 Puzzle[i][j]=element;
			 }
		 }
		 Puzz=Puzzle;
	 }
public ArrayList<Node> createNodeList()
{	int Count=0;
	for(int i=0;i<Rows;i++)
	{
		for(int j=0;j<Columns;j++)
		{	
			int element=Puzz[i][j];
			 if(element==0)
			 {
				 Node New=new Node();
				 New.pos[0]=i;
				 New.pos[1]=j;
				 New.Value=element;
				 New.unique=Count;
				 Count++;
				 NodeList.add(New);
			 }
			 else if(element==2)
			 {
				 Node New=new Node();
				 New.pos[0]=i;
				 New.pos[1]=j;
				 New.Value=element;
				 New.Start=true;
				 New.unique=Count;
				 Count++;
				 NodeList.add(New);
				 
			 }
			 else if(element==3)
			 {
				 Node New=new Node();
				 New.pos[0]=i;
				 New.pos[1]=j;
				 New.Value=element;
				 New.Finish=true;
				 New.unique=Count;
				 Count++;
				 NodeList.add(New);
			 }
			 else
			 {
				 continue;
			 }
		}
	}
	this.display();
	return NodeList;
}
public void display()
{ System.out.println("----");
	for(int i=0;i<Rows;i++)
	{
		for(int j=0;j<Columns;j++)
		{	if(Puzz[i][j]==5)
		{
			Puzz[i][j]=0;
		}
			System.out.print(Puzz[i][j]);
		}
		System.out.print("\n");
	}
}
public ArrayList<Node> Neighbours(ArrayList<Node> List,Node N)
{
	ArrayList<Node> Neighbours=new ArrayList<Node>();
	if(N.hasAbove(List)!=null && N.hasAbove(List).isVisited==false)
	{	
		Neighbours.add(N.hasAbove(List));
	}
	if(N.hasBelow(List)!=null && N.hasBelow(List).isVisited==false)
	{
		Neighbours.add(N.hasBelow(List));
	}
	if(N.hasDAL(List)!=null && N.hasDAL(List).isVisited==false)
	{
		Neighbours.add(N.hasDAL(List));
	}
	if(N.hasDAR(List)!=null && N.hasDAR(List).isVisited==false)
	{
		Neighbours.add(N.hasDAR(List));
	}
	if(N.hasDBL(List)!=null && N.hasDBL(List).isVisited==false)
	{
		Neighbours.add(N.hasDBL(List));
	}
	if(N.hasDBR(List)!=null && N.hasDBR(List).isVisited==false)
	{
		Neighbours.add(N.hasDBR(List));
	}
	if(N.hasLeft(List)!=null && N.hasLeft(List).isVisited==false)
	{
		Neighbours.add(N.hasLeft(List));
	}
	if(N.hasRight(List)!=null && N.hasRight(List).isVisited==false)
	{
		Neighbours.add(N.hasRight(List));
	}
	return Neighbours;
}
public ArrayList<Node> Neighbours2(ArrayList<Node> List,Node N)
{		
	ArrayList<Node> Neighbours=new ArrayList<Node>();
	if(N.hasAbove(List)!=null && N.hasAbove(List).isVisited2==false)
	{	
		Neighbours.add(N.hasAbove(List));
	}
	if(N.hasBelow(List)!=null && N.hasBelow(List).isVisited2==false)
	{
		Neighbours.add(N.hasBelow(List));
	}
	if(N.hasDAL(List)!=null && N.hasDAL(List).isVisited2==false)
	{
		Neighbours.add(N.hasDAL(List));
	}
	if(N.hasDAR(List)!=null && N.hasDAR(List).isVisited2==false)
	{
		Neighbours.add(N.hasDAR(List));
	}
	if(N.hasDBL(List)!=null && N.hasDBL(List).isVisited2==false)
	{
		Neighbours.add(N.hasDBL(List));
	}
	if(N.hasDBR(List)!=null && N.hasDBR(List).isVisited2==false)
	{
		Neighbours.add(N.hasDBR(List));
	}
	if(N.hasLeft(List)!=null && N.hasLeft(List).isVisited2==false)
	{
		Neighbours.add(N.hasLeft(List));
	}
	if(N.hasRight(List)!=null && N.hasRight(List).isVisited2==false)
	{
		Neighbours.add(N.hasRight(List));
	}
	return Neighbours;
}
public ArrayList<Node> pathFinder(ArrayList<Node> NL)
{
PriQueue Que=new PriQueue();
Node Next=new Node();
Node Start=new Node();
Node Finish=new Node();
ArrayList<Node> Path=new ArrayList<Node>();
for(int i=0;i<NL.size();i++)
{
	if(NL.get(i).Value==2)
	{
		Start=NL.get(i);
	}
	else if(NL.get(i).Value==3)
	{
		Finish=NL.get(i);
	}
}
Que.enqueue(Start);
Next=Que.First();
while(!Que.isEmpty())
{
	if(Que.First()==Finish)
	{	
		Path.add(Que.First());
		System.out.println("Path Found");
		break;
	}
	else
	{
		ArrayList<Node> Nei=this.Neighbours(NL,Next);
		if(Nei.size()!=0)
		{	
			if(Next.Value!=2 )
			{Next.Value=5;}
			else if(Next.Value==3)
			{
				Next.Value=3;
			}
			Path.add(Next);
			for(int i=0;i<Nei.size();i++)
			{
				Que.enqueue(Nei.get(i));
			}	
		}
		Que.dequeue();
		Next=Que.First();
	}
}
Sl=Path;
return Path;
}
public void backTrack(Node N)
{		
	Node next1=null;
	Node next2=null;
	Node next3=null;
	ArrayList<Node> J=this.Neighbours2(Sl,N);
	for(int i=0;i<J.size();i++)
	{
		if(J.get(i).Value==2)
		{
			next1=J.get(i);
			break;
		}
		else if(J.get(i).Value==5)
		{	
			next2=J.get(i);
		}
	}
			if(next1!=null)
		{	next1.isVisited2=true;
			X.add(next1);
			this.finalDisplay();
		}
		else if(next2!=null && next1==null)
		{	next2.isVisited2=true;
			X.add(next2);
			this.backTrack(next2);
		}
}
public void finalDisplay()
{
	for(int i=0;i<X.size();i++)
	{
		int[] Co=X.get(i).pos;
		if(X.get(i).Value==5)
			{
			Puzz[Co[0]][Co[1]]=7;
			System.out.println();
			}
	}
	this.display();	
} 
public static void main(String[] args)
		{	
		
			System.out.println("input no.s of rows and columns of the puzzle");
			Scanner sc=new Scanner(System.in);
			int rows=sc.nextInt();
			int columns=sc.nextInt();
			Runner w=new Runner();
			w.initialize(rows,columns);
			ArrayList<Node> AllNodes=w.createNodeList();
			ArrayList<Node> Solutions=w.pathFinder(AllNodes);
			Node nal=new Node();
			for(int i=0;i<Solutions.size();i++)
			{
				if(Solutions.get(i).Value==3)
				{
					nal=Solutions.get(i);
				}
			}
			w.backTrack(nal);
		}
}
