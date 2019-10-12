package MazeRunner;
import java.util.*;
public class PriQueue {
private ArrayList<Node> Priqueue=new ArrayList<Node>();
public void enqueue(Node A)
{
	Priqueue.add(A);
	A.isVisited=true;
	//System.out.println(A.unique+"Added");
}
public void dequeue()
{
	Node A=Priqueue.get(0);
	Priqueue.remove(0);
	//System.out.println(A.unique+"Removed");
	
}
public Node First()
{
	Node A=Priqueue.get(0);
	return A;
}
public boolean isEmpty()
{
	if(Priqueue.size()==0)
	{
		return true;
	}
return false;
}
}
