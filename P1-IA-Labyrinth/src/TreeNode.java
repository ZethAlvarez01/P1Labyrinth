/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SG
 */
public class TreeNode< T extends Comparable<T>> {
    T data;
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;
    //TreeNode<T> upNode;
    
    public TreeNode(T nodeData)
    {
        data = nodeData;
        leftNode = rightNode = null;
    }
    
    public void insert( T insertValue)
    {
        if( insertValue.compareTo(data) < 0)
        {
            if(leftNode == null)
                leftNode = new TreeNode<  >(insertValue);
            else
                leftNode.insert(insertValue);
        }
        
        else if ( insertValue.compareTo(data) > 0)
        {
            if ( rightNode == null)
                rightNode = new TreeNode< >(insertValue);
            else
                rightNode.insert(insertValue);
        }
    }
    
}


