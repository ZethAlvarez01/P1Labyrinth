/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SG
 */
public class Tree< T extends Comparable < T >>
{
    private TreeNode< T > root;
    
    public Tree()
    {
        root = null;
    }
    //Asignar valor a la raiz
    public void insertNode(T valor)
    {
        if(root == null)
            root = new TreeNode<  >(valor);
        else
            root.insert(valor);
    }
    
    public void postordenTrayecto()
    {
        postordenAux(root);
    }
    
    private void postordenAux(TreeNode< T > node)
    {
        if(node == null)
            return;
        
        postordenAux( node.leftNode);
        postordenAux( node.rightNode);
        System.out.printf("%s ",node.data);
    }
}
