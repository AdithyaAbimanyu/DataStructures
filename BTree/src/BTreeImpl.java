public class BTreeImpl
{
    static BTreeStructure root = null;
    static int size =4;
    public static BTreeStructure insert(int val)
    {
        if(root==null)
        {
            root = new BTreeStructure(size,true);
            root.arrValues[root.size++] = val;
            return root;
        }
        if(root.leafNode)
        {
            root.placeArrayElement(val);
            if(root.size == root.totalSize)
            {
                BTreeStructure tempNode = new BTreeStructure(size,false);
                tempNode.splitNode(0,root);
                root = tempNode ;
            }
        }
        else
        {
            root.insert(val);
            if(root.size == root.totalSize)
            {
                BTreeStructure tempNode = new BTreeStructure(size,false);
                tempNode.splitNode(0,root);
                root = tempNode ;
            }
        }
        return root;
    }
}
