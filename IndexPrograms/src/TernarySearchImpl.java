public class TernarySearchImpl
{
    public static TernarySearch root = null;

    public static boolean add(String word)
    {
        try
        {
            root=TernarySearch.add(root,word,0);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public static void getAllWord()
    {
        root.crawlTernaryTree(root,"");
    }

    public static void getWordList(String str)
    {
        TernarySearch.getAllWords(root,str,str,0);
    }

    public static void setRoot(TernarySearch r)
    {
        root = r;
    }

    public static TernarySearch getRoot()
    {
        return root;
    }
}
