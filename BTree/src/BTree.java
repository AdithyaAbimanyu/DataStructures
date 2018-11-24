public class BTree
{
    public static void main(String args[])
    {
        BTreeStructure root=BTreeImpl.insert(6);
        root=BTreeImpl.insert(8);
        root=BTreeImpl.insert(4);
        root=BTreeImpl.insert(2);
        root=BTreeImpl.insert(10);
        root=BTreeImpl.insert(15);
        root=BTreeImpl.insert(14);
        root=BTreeImpl.insert(12);
        root=BTreeImpl.insert(13);
        root=BTreeImpl.insert(9);
        root=BTreeImpl.insert(11);
    }
}
