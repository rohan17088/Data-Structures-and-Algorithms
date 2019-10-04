class Node
{
	Node left;
	Node right;
	int data;
	int height;
}
class AvlTree
{
	Node root=null;
	Node insertUtil(int data,Node cur)
	{	


		if(cur==null)
		{
			cur=new Node();
			cur.data=data;

		}
		else if(cur.data>=data)
		{
			cur.left=insertUtil(data,cur.left);
			// cur.left.height+=1;
		}
		else
		{
			cur.right=insertUtil(data,cur.right);
			//cur.right.height+=1;
		}
		int hright=0;
		int hleft=0;
		if(cur.right!=null){hright=cur.right.height;}
		if(cur.left!=null){hleft=cur.left.height;}
		cur.height=Math.max(hright,hleft)+1;
		if(hright==hleft || Math.abs(hright-hleft)==1) 
		{  //System.out.println(cur.data);
			return cur;
		}
		
		if(hleft>hright)
		{	
			
		
			if(cur.left.left!=null)
			{
				hleft=cur.left.left.height;

			}
			if(cur.left.right!=null)
			{
				hright=cur.left.right.height;

			}
			if(hleft>=hright)
			{
				return rightRotation(cur);
				
			}
			else
			{
				
				cur.left=leftRotation(cur.left);
				return rightRotation(cur);

			}


		}
		else
		{
			
			if(cur.right.left!=null)
			{
				hleft=cur.right.left.height;

			}
			if(cur.right.right!=null)
			{
				hright=cur.right.right.height;

			}
			if(hleft<=hright)
			{
				return leftRotation(cur);
				
				
			}
			else
			{
				cur.right=rightRotation(cur.right);
				return leftRotation(cur);

			}	

		}
		

	}
	int height(Node cur)
	{
		if(cur==null){return 0;}
		return cur.height;
	}
	Node leftRotation(Node x)
	{
		Node y = x.right; 
        Node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y;		
	}
	Node rightRotation(Node y)
	{
		 Node x = y.left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
	}
	void insert(int data){root=insertUtil(data,root);}
	void print(Node cur)
	{
		if(cur==null){return;}
		print(cur.left);
		System.out.println(cur.data);
		print(cur.right);
	}
	

	public static void main(String args[])
	{
		AvlTree tree=new AvlTree();
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(2);
		tree.insert(1);
		tree.print(tree.root);
		System.out.println(tree.root.height);
		
	}
}