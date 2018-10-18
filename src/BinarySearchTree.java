public class BinarySearchTree
{
    private static BinaryNode root=null;
    public static void main(String args[])
    {
        root= BinaryNode.insert(10,root);
        root= BinaryNode.insert(5,root);
        root= BinaryNode.insert(7,root);
        root= BinaryNode.insert(11,root);
        root= BinaryNode.insert(20,root);
        root= BinaryNode.insert(30,root);
        root= BinaryNode.insert(2,root);
        root= BinaryNode.insert(1,root);
        root= BinaryNode.insert(0,root);
        root= BinaryNode.insert(15,root);
    }
}
