public class BTreeStructure
{
    int totalSize,size;
    BTreeStructure[] bTree;
    int arrValues[];
    boolean leafNode;
    BTreeStructure(int size,boolean leaf)
    {
        this.totalSize =size;
        arrValues = new int[size];
        bTree = new BTreeStructure[size+1];
        this.size = 0;
        leafNode = leaf;
    }

    public void insert(int val)
    {
        int index = findChildNodeIndex(val);
        if(bTree[index].leafNode)
        {
            bTree[index].placeArrayElement(val);
            if(bTree[index].size == bTree[index].totalSize)
            {
                splitNode(index, bTree[index]);
            }
        }
        else
        {
            bTree[index].insert(val);
            if(bTree[index].size==bTree[index].totalSize)
            {
                splitNode(index,bTree[index]);
            }
        }
    }

    private int findChildNodeIndex(int val)
    {
        for (int i=0;i<=size;i++)
        {
            if(val<arrValues[i])
            {
                return i;
            }
        }
        return size;
    }

    public void placeArrayElement(int val)
    {
        int i=0;
        for(i=size-1;i>=0;i--)
        {
            if(arrValues[i]<val)
            {
                break;
            }
            arrValues[i+1] = arrValues[i];
        }
        arrValues[i+1] = val;
        size++;
    }


    public void splitNode(int childNodeCursor, BTreeStructure root)
    {
        BTreeStructure secondNode = new BTreeStructure(root.totalSize,true);
        int middleElement = root.totalSize /2;
        int moveIndex = root.totalSize-middleElement-1;
        for(int i=0;i<moveIndex;i++)
        {
            secondNode.arrValues[i] = root.arrValues[i+middleElement+1];
            secondNode.bTree[i] = root.bTree[i+middleElement+1];
        }
        root.size = middleElement ;
        secondNode.size =  moveIndex;
        placeArrayElement(root.arrValues[middleElement]);

        for(int i=childNodeCursor+1;i<size;i++)
        {
            bTree[i+1] = bTree[i];
        }
        bTree[childNodeCursor] = root;
        bTree[childNodeCursor+1] = secondNode;
    }
}
