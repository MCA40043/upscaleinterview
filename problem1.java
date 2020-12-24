class node  
{ 
    int data; 
    node l, r; 
   
    node(int item)  
    { 
        data = item; 
        l = r = null; 
    } 
} 
   
class problem1  
{ 
    node root; 
 
    void prtDwn(node node, int k)  
    { 
      
        if (node == null || k < 0) 
            return; 
   
        if (k == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
   
        prtDwn(node.l, k - 1); 
        prtDwn(node.r, k - 1); 
    } 
   

    int prtDistNode(node node, node trgt, int k)  
    { 

        if (node == null) 
            return -1; 
  
        if (node == trgt)  
        { 
            prtDwn(node, k); 
            return 0; 
        } 
   
        int dl = prtDistNode(node.l, trgt, k); 
   
        if (dl != -1)  
        { 
               
            if (dl + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            } 
                
            else
                prtDwn(node.r, k - dl - 2); 
   
            return 1 + dl; 
        } 
   
       
        int dr = prtDistNode(node.r, trgt, k); 
        if (dr != -1)  
        { 
            if (dr + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                prtDwn(node.l, k - dr - 2); 
            return 1 + dr; 
        } 
   
    
        return -1; 
    } 
  
public static void main(String args[])  
    { 
        problem1 tr = new problem1(); 
   
        tr.root = new node(20); 
        tr.root.l = new node(8); 
        tr.root.r = new node(22); 
        tr.root.l.l = new node(4); 
        tr.root.l.r = new node(12); 
        tr.root.l.r.l = new node(10); 
        tr.root.l.r.r = new node(14); 
        node trgt = tr.root.l.r; 
        tr.prtDistNode(tr.root, trgt, 2); 
    } 
} 
  
