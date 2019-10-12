package MazeRunner;

import java.util.ArrayList;
/*
 * Node has methods to find neighbours.
 */
public class Node {
	Node Next;
	int[] pos=new int[2];
	int Value;
	int unique;
	boolean isVisited;
	boolean isVisited2;
	boolean Start;
	boolean Finish;
	public Node()
	{
		pos[0]=0;
		pos[1]=0;
		boolean isVisited=false;
		boolean isVisited2=false;
		boolean Start=false;
		boolean Finish=false;
	}
	public Node hasLeft(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]&& Co[1]==this.pos[1]-1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasRight(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]&& Co[1]==this.pos[1]+1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasAbove(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]-1 && Co[1]==this.pos[1])
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasBelow(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]+1 && Co[1]==this.pos[1])
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasDAL(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]-1 && Co[1]==this.pos[1]-1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasDAR(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]-1 && Co[1]==this.pos[1]+1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasDBL(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]+1 && Co[1]==this.pos[1]-1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
	public Node hasDBR(ArrayList<Node> N)
	{
	 for(int i=0;i<N.size();i++)
	 {
		 int[] Co=N.get(i).pos;
		 if(Co[0]==this.pos[0]+1 && Co[1]==this.pos[1]+1)
		 {
			 return N.get(i);
		 }
	 }
	 return null;
	}
}
