public class BinaryNode
{
    int val;
    BinaryNode right;
    BinaryNode left;

    public BinaryNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }

    public static BinaryNode insert(int insertVal,BinaryNode root)
    {
        if(root==null)
        {
            root = new BinaryNode(insertVal);
            return root;
        }
        if(root.val < insertVal)
        {
            root.right = insert(insertVal,root.right);
        }
        else
        {
            root.left = insert(insertVal,root.left);
        }
        return root;
    }
}
